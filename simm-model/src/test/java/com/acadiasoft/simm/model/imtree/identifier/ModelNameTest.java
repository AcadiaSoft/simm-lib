package com.acadiasoft.simm.model.imtree.identifier;

import com.acadiasoft.simm.model.object.imtree.identifiers.ImModelClass;
import org.junit.Assert;
import org.junit.Test;

public class ModelNameTest {

  @Test
  public void testNames() {
    Assert.assertEquals(ImModelClass.SIMM, ImModelClass.determineModelClass("Simm"));
    Assert.assertEquals(ImModelClass.SIMM, ImModelClass.determineModelClass("SIMM-P"));
    Assert.assertNotEquals(ImModelClass.SCHEDULE, ImModelClass.determineModelClass("simm-p"));
    Assert.assertEquals(ImModelClass.SCHEDULE, ImModelClass.determineModelClass("Schedule"));
  }

}
