package com.acadiasoft.simm.model.object.imtree;

import com.acadiasoft.simm.model.object.imtree.identifiers.TotalClass;
import org.apache.commons.lang3.StringUtils;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public interface ImTree extends Serializable {

  public static int TOTAL_COMMAS = 7;
  public static String COMMA = ",";
  public static String END_LINE = "\n";
  public static String FLAT_CSV_HEADER = "Level,Im Model,Silo,RiskClass,SensitivityType,Bucket,WeightedSensitivity,ExposureAmount";

  public static String parseToFlatCsv(ImTree tree) {
    List<String> csv = internalFlatCsvBuilder(new ArrayList<>(), tree);
    csv.add(0, FLAT_CSV_HEADER);
    return String.join(END_LINE, csv);
  }

  public static List<String> internalFlatCsvBuilder(List<String> pastLine, ImTree tree) {
    List<String> currentLine = new ArrayList<>();
    currentLine.add(tree.getTreeLevel());
    pastLine.removeIf(string -> StringUtils.equalsIgnoreCase(string, TotalClass.TOTAL.getLabel()));
    if (!pastLine.isEmpty()) currentLine.addAll(pastLine.subList(1, pastLine.size()));
    currentLine.add(tree.getMarginIdentifier().getLabel());

    // now we need to add on any extra missing commas
    int currentCommaCount = currentLine.size() - 1;
    String line = String.join(COMMA, currentLine);
    for (int i = 0; i < TOTAL_COMMAS - currentCommaCount; i++) {
      line = line + COMMA;
    }

    List<String> csvFormatted = new ArrayList<>();
    csvFormatted.add(line + tree.getMargin());
    for (ImTree child: tree.getChildren()) {
      csvFormatted.addAll(internalFlatCsvBuilder(currentLine, child));
    }

    return csvFormatted;
  }

  public MarginIdentifier getMarginIdentifier();

  public BigDecimal getMargin();

  public List<ImTree> getChildren();

  public String getTreeLevel();

}
