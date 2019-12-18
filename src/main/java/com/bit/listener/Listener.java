package com.bit.listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

//import utility.Helper;

public class Listener implements ITestListener {

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailure(ITestResult r) {
		// TODO Auto-generated method stub
		switch (r.getStatus()) {
		case ITestResult.FAILURE: {
			System.out.println("took screen shotttt");
			//Helper.screenShot(driver);
		}
		case ITestResult.SUCCESS: {
			System.out.println(r.getName() + " is passed");
		}}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

}
