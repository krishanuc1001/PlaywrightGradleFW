package com.customAnnotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.enums.CategoryTypeEnum;

@Documented
@Retention(RUNTIME)
@Target(METHOD)
public @interface FrameworkAnnotations {

	public String[] author();
	
	public CategoryTypeEnum[] category();

}
