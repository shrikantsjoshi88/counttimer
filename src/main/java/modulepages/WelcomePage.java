package modulepages;

import commonactions.CommonActions;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import timeinfo.TimeInfo;

public class WelcomePage extends CommonActions {

    By TIMER_LOCATOR = By.cssSelector("#start_a_timer");
    By TIMER_GO_LOCATOR = By.cssSelector("#timergo");

    @Step("Welcome to e.ggtimer.com page displayed Successfullly")
    public void navigateToCountDownTimer(TimeInfo timeInfo) {
        launchBrowser(timeInfo);
        System.out.println("Welcome to e.ggtimer.com page displayed successfullly");
        findElement(TIMER_LOCATOR).clear();
        System.out.println("Timer locator identified successfullly");
        sendKeys(TIMER_LOCATOR, timeInfo.getTime());
        System.out.println("Timer entered successfullly");
        clickElement(TIMER_GO_LOCATOR);
        System.out.println("Go button clicked successfullly");
        countLogic();
    }
}
