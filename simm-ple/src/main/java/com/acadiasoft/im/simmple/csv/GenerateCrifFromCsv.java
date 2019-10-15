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

import com.acadiasoft.im.simmple.model.Crif;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.io.input.BOMInputStream;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import static org.apache.commons.lang3.StringUtils.defaultString;

/**
 *
 * Converts an input CSV file with snake case headers below into Crif objects from this library.
 * Really this method is just for quick testing and avoiding some tedium when working with already populated CSVs.
 *
 * @author alec.stewart
 */
public class GenerateCrifFromCsv {

  private final List<Crif> crifs = new ArrayList<>();

  public GenerateCrifFromCsv(String fileName) {
    try (Reader reader = new InputStreamReader(new BOMInputStream(new FileInputStream(new File(fileName))), StandardCharsets.UTF_8)) {
      for (CSVRecord record: new CSVParser(reader, CSVFormat.EXCEL.withFirstRecordAsHeader())) {
        crifs.add(new Crif(get(record, "trade_id"), get(record,"valuation_date"), get(record, "end_date"), get(record, "notional"), get(record, "trade_currency"),
            get(record, "im_model"), get(record, "product_class"), get(record, "risk_type"), get(record, "qualifier"), get(record, "bucket"),
            get(record, "label1"), get(record, "label2"), get(record, "amount"), get(record, "amount_currency"), get(record, "amount_usd"),
            get(record, "post_regulations"), get(record, "collect_regulations")));
      }
    } catch (IOException ioe) {
      throw new RuntimeException(ioe.getMessage());
    }
  }

  private String get(CSVRecord record, String string) {
    if (record.isMapped(string)) return defaultString(record.get(string));
    return "";
  }

  public List<Crif> getCrifs() {
    return crifs;
  }

  public String getUnitTestString() {
    String test = "List<Crif> crifs = Arrays.asList(\n";
    for (Crif crif: crifs) {
      test += "  new Crif(" + crif.toTestString() + "),\n";
    }

    test = test.substring(0, test.length() - 2); // remove , and \n
    test += "\n);";
    return test;
  }
}
