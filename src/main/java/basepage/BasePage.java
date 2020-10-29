package basepage;

import modulepages.WelcomePage;
import org.openqa.selenium.WebDriver;
import timeinfo.TimeInfo;

public class BasePage {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
    public String before = null;
    public String after = null;
    public WelcomePage welcomePage;
    public TimeInfo timeInfo;


    public WebDriver driver() {
        return driver.get();
    }
}
