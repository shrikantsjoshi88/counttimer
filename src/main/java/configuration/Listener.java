package configuration;

import org.testng.*;

import java.util.Iterator;

public class Listener implements ITestListener {

    public void onTestStart(ITestResult result) {
        System.out.println("The test starts successfully");
    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("The test is passed successfully");
        result.setStatus(ITestResult.SUCCESS);
    }

    public void onTestFailure(ITestResult result) {
        Reporter.setCurrentTestResult(result);
        if (result.getMethod().getRetryAnalyzer().retry(result))
            result.setStatus(ITestResult.SKIP);
        Reporter.setCurrentTestResult(null);
    }

    public void onTestSkipped(ITestResult result) {
        System.out.println("The test is skipped successfully");
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        System.out.println("The test is failed! However, the percentage is:");
    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {
        Iterator<ITestResult> failedTestCases = context.getFailedTests().getAllResults().iterator();
        while (failedTestCases.hasNext()) {
            System.out.println("Failed Test Cases Are:");
            ITestResult failedTestCase = failedTestCases.next();
            ITestNGMethod method = failedTestCase.getMethod();
            if (context.getFailedTests().getResults(method).size() > 0) {
                System.out.println("Failed test case removed as duplicate:" + failedTestCase.getTestClass().toString());
                failedTestCases.remove();
            } else {
                if (context.getPassedTests().getResults(method).size() > 0) {
                    System.out.println("Passed test case removed as pass retry:" + failedTestCase.getTestClass().toString());
                    failedTestCases.remove();
                }
            }

        }
    }

}
