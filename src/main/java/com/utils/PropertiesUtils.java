package com.utils;

import com.constants.FrameworkConstants;
import com.customexceptions.PropertyFileException;
import com.enums.ConfigPropertiesEnum;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Properties;

/**
 * Reading the property file and store it in a HashMap for faster processing
 *
 * <p>Jul 4, 2021
 *
 * @author Krishanu
 */
public final class PropertiesUtils {

  /** Private constructor to avoid external initialization */
  private PropertiesUtils() {}

  private static Properties prop = new Properties();
  private static final Map<String, String> CONFIGMAP = new HashMap<>();

  // static block
  static {
    try (FileInputStream fis = new FileInputStream(FrameworkConstants.getConfigproppath()); ) {

      prop.load(fis);

      for (Map.Entry<Object, Object> entry : prop.entrySet()) {
        CONFIGMAP.put(
            String.valueOf(entry.getKey()).trim(), String.valueOf(entry.getValue()).trim());
      }

    } catch (IOException e) {
      e.printStackTrace();
      System.exit(0);
    }
  }

  /**
   * Receives the {@link com.enums.ConfigPropertiesEnum}, converts to lowercase, return the
   * corresponding value for the key from the HashMap.
   *
   * <p>Jul 4, 2021
   *
   * @author Krishanu
   * @param enumkey To be fetched from the Property file
   * @return corresponding value for the requested key if found else throws {@link
   *     com.exceptions.custom.PropertyFileException}
   */
  @SuppressWarnings("null")
  public static String get(ConfigPropertiesEnum enumkey) {

    if (Objects.isNull(enumkey) && Objects.isNull(CONFIGMAP.get(enumkey.name().toLowerCase()))) {
      throw new PropertyFileException(
          "Property with Key => " + enumkey + " is not found!!! Please check config.properties...");
    }

    return CONFIGMAP.get(enumkey.name().toLowerCase());
  }
}
