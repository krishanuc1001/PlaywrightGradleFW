package com.utils;

import com.constants.FrameworkConstants;
import java.util.Base64;

public final class PasswordManagement {

  private PasswordManagement() {}

  public static String encryptPassword(String password) {
    String encodedPW =
        Base64.getEncoder()
            .encodeToString(
                ExcelUtils.getTestDetails(FrameworkConstants.getDatasheet())
                    .get(0)
                    .get("password")
                    .getBytes());
    System.out.println("The Encoded Password is => " + encodedPW);
    return encodedPW;
  }

  public static String decryptPassword(String password) {
    return new String(Base64.getDecoder().decode(encryptPassword(password).getBytes()));
  }
}
