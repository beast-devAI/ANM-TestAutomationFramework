package com.sgm.listeners;

import com.sgm.utils.TestUtils;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.internal.TestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestStart(ITestResult result) {
        ITestListener.super.onTestStart(result);

        System.out.println("Test is started : "+result.getTestClass().getTestName());

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ITestListener.super.onTestSuccess(result);

        System.out.println("Test is passed :");

    }

    @Override
    public void onTestFailure(ITestResult result) {
        ITestListener.super.onTestFailure(result);

        System.out.println("Test is Failed :");

    }

    @Override
    public void onTestSkipped(ITestResult result) {
        ITestListener.super.onTestSkipped(result);

        System.out.println("Test is skipped :");

    }


    @Override
    public void onFinish(ITestContext context) {
        ITestListener.super.onFinish(context);

        System.out.println("Test is finished : ");

    }



}
