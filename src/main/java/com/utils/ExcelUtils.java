package com.utils;

import com.constants.FrameworkConstants;
import com.customexceptions.FrameworkExceptions;
import com.customexceptions.InvalidPathForFilesException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public final class ExcelUtils {

  private ExcelUtils() {}

  @SuppressWarnings("resource")
  public static List<Map<String, String>> getTestDetails(String sheetName) {

    List<Map<String, String>> list = null;

    // try with resources
    try (FileInputStream fis = new FileInputStream(FrameworkConstants.getExcelpath()); ) {

      XSSFWorkbook workBook = new XSSFWorkbook(fis);
      XSSFSheet workSheet = workBook.getSheet(sheetName);

      int lastRowNum = workSheet.getLastRowNum();
      System.out.println("The Number of Rows => " + lastRowNum);

      int coulmnNum = workSheet.getRow(0).getLastCellNum();
      System.out.println("The Number of Columns => " + coulmnNum);

      Map<String, String> map = null;
      list = new ArrayList<>();

      for (int i = 1; i <= lastRowNum; i++) { // Rows

        map = new HashedMap<>();
        for (int j = 0; j < coulmnNum; j++) { // Columns

          String key = workSheet.getRow(0).getCell(j).getStringCellValue();
          String value = workSheet.getRow(i).getCell(j).getStringCellValue();
          map.put(key, value);
        }

        list.add(map);
      }

    } catch (FileNotFoundException e1) {

      throw new InvalidPathForFilesException("Excel file you are trying to read is not present...");

    } catch (IOException e2) {

      throw new FrameworkExceptions("IO Exception occurred...");
    }

    return list;
  }
}
