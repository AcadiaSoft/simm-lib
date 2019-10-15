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

package com.acadiasoft.im.simm.model.imtree.identifiers;

import com.acadiasoft.im.base.imtree.identifiers.MarginIdentifier;

public class AddOnSubClass implements MarginIdentifier {

  private final AddOnSubType type;
  private final String name;

  private AddOnSubClass(AddOnSubType type, String name) {
    this.type = type;
    this.name = name;
  }

  @Override
  public String getLabel() {
    return name;
  }

  public AddOnSubType getType() {
    return type;
  }

  public String getName() {
    return name;
  }

  public static AddOnSubClass determineAddOnSubClass(AddOnSubType type, String name) {
    return new AddOnSubClass(type, name);
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof AddOnSubClass)) return false;
    AddOnSubClass other = (AddOnSubClass) obj;
    return type.equals(other.getType()) && name.equalsIgnoreCase(other.getName());
  }

  @Override
  public int hashCode() {
    return type.hashCode() + 7 * name.hashCode();
  }

}
