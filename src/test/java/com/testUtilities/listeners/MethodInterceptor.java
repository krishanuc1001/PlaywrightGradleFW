package com.testUtilities.listeners;

import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import java.util.List;

public class MethodInterceptor implements IMethodInterceptor {

    @Override
    public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
        return null;
    }

//	@Override
//	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
//
//		List<Map<String, String>> list = ExcelUtils.getTestDetails(FrameworkConstants.getRunmanagersheet());
//		List<IMethodInstance> result = new ArrayList<>();
//
//		for (int i = 0; i < methods.size(); i++) {
//			for (int j = 0; j < list.size(); j++) {
//
//				if (methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("testName"))
//						&& list.get(j).get("execute").equalsIgnoreCase("yes")) {
//
//					methods.get(i).getMethod().setDescription(list.get(j).get("testDescription"));
//					methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("priority")));
//					methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("count")));
//					result.add(methods.get(i));
//
//				}
//
//			}
//
//		}
//
//		return result;
//	}

}
