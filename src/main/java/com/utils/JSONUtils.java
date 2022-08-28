package com.utils;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import com.constants.FrameworkConstants;
import com.enums.ConfigPropertiesEnum;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

/*
 * Can we use JSON instead of Properties file in the Framework?
 * How to use JSON file instead of a Properties file?
 * 
 * See below...
 * 
 * 
 */

public class JSONUtils {

	private JSONUtils() {
	}

	private static Map<String, String> CONFIGMAP;

	// static block
	static {

		try {
			CONFIGMAP = new ObjectMapper().readValue(new File(FrameworkConstants.getConfigjsonpath()),
					new TypeReference<HashMap<String, String>>() {
					});

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("null")
	public static String get(ConfigPropertiesEnum enumkey) throws Exception {

		if (Objects.isNull(enumkey) && Objects.isNull(CONFIGMAP.get(enumkey.name().toLowerCase()))) {
			throw new Exception(
					"Property with Key => " + enumkey + " is not found!!! Please check config.properties...");
		}

		return CONFIGMAP.get(enumkey.name().toLowerCase());

	}

}
