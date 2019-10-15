/*
 * Copyright (c) 2019 AcadiaSoft, Inc.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

package com.acadiasoft.im.simmple.csv;

import com.acadiasoft.im.base.fx.FxRate;
import com.acadiasoft.im.base.util.BigDecimalUtils;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;
import org.apache.commons.lang3.NotImplementedException;

import java.io.*;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alec.stewart
 */
public class GenerateRatesFromCsvFx implements FxRate {

  private final Map<String, Map<String, BigDecimal>> rates = new HashMap<>();
  private final Map<String, BridgeRate> bridgeRates = new HashMap<>();

  /**
   * creates a map of fx values from csv with header which contains: from_currency, to_currency, rate.
   * the class tries to populate every combination of rates to make a completely filled in 'matrix' over the currencies.
   * the class does not accept different days worth of rates currently, though an expansion of the class with some other
   *  easily could following this pattern.
   *
   * @param filePath path to the file
   */
  public GenerateRatesFromCsvFx(String filePath) {
    try (Reader reader = new InputStreamReader(new BOMInputStream(new FileInputStream(new File(filePath))), StandardCharsets.UTF_8)) {
      for (CSVRecord record : new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader())) {
        String from = record.get("from_currency");
        String to = record.get("to_currency");
        BigDecimal rate = new BigDecimal(record.get("rate"));

        // put the (from -> to) rate in rates
        if (rates.containsKey(from)) {
          rates.get(from).put(to, rate);
        } else {
          rates.put(from, new HashMap<>());
          rates.get(from).put(to, rate);
        }

        // save a bridge rate so that we can get from the to currency to the from currency
        bridgeRates.put(to, new BridgeRate(from, BigDecimalUtils.divideWithPrecision(BigDecimal.ONE, rate)));
      }

      // explicitly add conversion of one for each currency in top map
      for (String currency : rates.keySet()) {
        rates.get(currency).put(currency, BigDecimal.ONE);
      }
    } catch (IOException e) {
      throw new RuntimeException(e.getMessage());
    }
  }

  public BigDecimal getRate(String from, String to) {
    if (rates.containsKey(from)) {
      if (rates.get(from).containsKey(to)) {
        return rates.get(from).get(to);
      } else {
        throw new NotImplementedException("the conversion " + from + " -> " + to + " has not been implemented");
      }
    } else if (bridgeRates.containsKey(from)) {
      BridgeRate bridge = bridgeRates.get(from);
      return bridge.getRate().multiply(rates.get(bridge.getCurrency()).get(to));
    } else {
      throw new NotImplementedException("the conversion " + from + " -> " + to + " has not been implemented");
    }
  }

  @Override
  public BigDecimal convert(BigDecimal amount, String from, String to) {
    return amount.multiply(getRate(from, to));
  }

  private class BridgeRate {

    private final String currency;
    private final BigDecimal rate;

    public BridgeRate(String currency, BigDecimal rate) {
      this.currency = currency;
      this.rate = rate;
    }

    public BigDecimal getRate() {
      return rate;
    }

    public String getCurrency() {
      return currency;
    }
  }

}
