/*
 * Copyright (c) 2022 Acadia, Inc.
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

package com.acadiasoft.im.simm.model.utils;

import com.acadiasoft.im.base.model.imtree.ImTree;
import com.acadiasoft.im.base.model.imtree.MarginIdentifier;

import java.math.BigDecimal;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

/**
 * @author joe.peterson
 *
 */
public class MarginUtils {

  @SuppressWarnings({ "unchecked", "rawtypes" })
  public static <E extends MarginIdentifier, T extends ImTree> BigDecimal sumCorrelated(List<T> margins, Function<T, BigDecimal> getMargin,
      BiFunction<E, E, BigDecimal> correlate) {
    return margins.stream() //
        .map(one -> margins.stream() //
            .filter(other -> !other.getMarginIdentifier().equals(one.getMarginIdentifier())) //
            .map(other -> correlate.apply((E) one.getMarginIdentifier(), (E) other.getMarginIdentifier()) //
                .multiply(getMargin.apply(one)) //
                .multiply(getMargin.apply(other)))
            .reduce(BigDecimal.ZERO, BigDecimal::add) //
        ).reduce(BigDecimal.ZERO, BigDecimal::add);
  }
}
