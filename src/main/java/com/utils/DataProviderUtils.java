package com.utils;

import com.constants.FrameworkConstants;
// import org.testng.annotations.DataProvider;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public final class DataProviderUtils {

  /** Private constructor to avoid external initialization */
  private DataProviderUtils() {}

  private static List<Map<String, String>> list = new ArrayList<>();

  /**
   * Acts as a single Data-provider for all the test cases. Parallel = true indicates that each of
   * the Iteration will be run in Parallel.
   *
   * <p>Jul 4, 2021
   *
   * @author Krishanu
   * @param m {link java.lang.reflect.Method} holds the information about the Test cases at runtime.
   * @return Object[] contains the List. Each index of the list contains HashMap and each of map
   *     entries contains the test data needed to run the iterations.
   * @see // com.tests.AmazonDemoTest
   * @see // com.listeners.AnnotationTransformer
   */
  // @DataProvider(parallel = true)
  public static Object[] getData(Method m) {

    String testName = m.getName();

    if (list.isEmpty()) {
      list = ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet());
    }

    List<Map<String, String>> filteredList = new ArrayList<>();

    for (int i = 0; i < list.size(); i++) {

      if (list.get(i).get("testName").equalsIgnoreCase(testName)
          && list.get(i).get("execute").equalsIgnoreCase("yes")) {
        filteredList.add(list.get(i));
      }
    }
    System.out.println(filteredList);
    return filteredList.toArray();
  }
}
