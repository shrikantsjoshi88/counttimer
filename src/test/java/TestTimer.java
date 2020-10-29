import commonactions.CommonActions;
import io.qameta.allure.Allure;
import modulepages.WelcomePage;
import org.testng.ITestResult;
import org.testng.annotations.*;
import timeinfo.TimeInfo;

public class TestTimer extends CommonActions {

    @BeforeTest
    public void objectInitialization() {
        welcomePage = new WelcomePage();
        timeInfo = new TimeInfo();
    }

    @Test
    public void testCountdownTimer() {
        System.setProperty("TestName", "TestCountdownTimer");
        timeInfo.setTime("25");
        welcomePage.navigateToCountDownTimer(timeInfo);
    }

    @AfterMethod
    public void failedScreenhot(ITestResult result) throws Exception {
        if (result.getStatus() == ITestResult.FAILURE) {
            Allure.addAttachment("Failed Screenshot for:" + result.getName() + "is:", getScrenshot());
            System.out.println("TimerTest Failed is :" + result.getName() + "\n" + result.getThrowable());
            logToReport("TimerTest Failed is :" + result.getName() + "\n" + result.getThrowable());
            driver.get().quit();
            driver.remove();
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            System.out.println("TimerTest Passed is :" + result.getName());
            logToReport("TimerTest Passed is :" + result.getName());
            driver.get().quit();
            driver.remove();
        }
    }

}
