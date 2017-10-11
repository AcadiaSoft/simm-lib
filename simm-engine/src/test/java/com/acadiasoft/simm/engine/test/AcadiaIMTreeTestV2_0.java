package com.acadiasoft.simm.engine.test;

import com.acadiasoft.simm.engine.SIMM;
import com.acadiasoft.simm.model.sensitivity.Sensitivity;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class AcadiaIMTreeTestV2_0 extends AbstractAcadiaUnitTestV2_0 {

  private final SIMM simm = new SIMM();

  @Test
  public void testIMTree1() {
    List<Sensitivity> s = Arrays.asList(CM1, CM2, CM3, CM4, CM5, CM6, CM7, CM8, CM9, CM10, CM11,
        CQ1, CQ2, CQ3, CQ4, CQ5, CQ6, CQ7, CQ8, CQ9, CQ10, CQ11, CQ12, CQ13, CQ14, CQ15,
        BC1, BC2, BC3, BC4,
        CNQ1, CNQ2, CNQ3, CNQ4, CNQ5, CNQ6, CNQ7, CNQ8,
        EQ1, EQ2, EQ3, EQ4, EQ5, EQ6, EQ7, EQ8, EQ9, EQ10, EQ11,
        IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9,
        FX1, FX2, FX3, FX4,
        CMV1, CMV2, CMV3, CMV4, CMV5, CMV6,
        CQV1, CQV2, CQV3, CQV4, CQV5,
        CNQV1, CNQV2, CNQV3, CNQV4, CNQV5,
        EQV1, EQV2, EQV3, EQV4, EQV5, EQV6, EQV7, EQV8, EQV9, EQV10,
        FXV1, FXV2, FXV3, FXV4, FXV5,
        IRV1, IRV2, IRV3, IRV4, IRV5, IRV6, IRV7);

    System.out.println(simm.calculateStandardIMTree(s));
  }

  @Test
  public void testIMTree2() {
    List<Sensitivity> s = Arrays.asList(IR1, IR2, IR3, IR4, IR5, IR6, IR7, IR8, IR9);
    System.out.println(simm.calculateStandardIMTree(s));
  }

}
