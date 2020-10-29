package commonactions;

import basepage.BasePage;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import timeinfo.TimeInfo;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Reporter.log;

public class CommonActions extends BasePage {

    By PROGRESS_LOCATOR = By.cssSelector("#progressText");
    ArrayList<Integer> out = new ArrayList<>();

    @Step("Browser Launched and Url Accessed Successfully")
    public WebDriver launchBrowser(TimeInfo timeInfo) {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("-incognito");
        WebDriverManager.chromedriver().setup();
        driver.set(new ChromeDriver(options));
        driver().manage().window().maximize();
        driver().get(timeInfo.getUrl());
        implicitWait();
        return driver();
    }
    @Step("Waiting for the page load successfully")
    public WebDriver implicitWait() {
        driver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        return driver();
    }
    @Step("Element Clicked Successfully")
    public WebDriver clickElement(By elementBy) {
        driver().findElement(elementBy).click();
        return driver();
    }
    @Step("Element Found Successfully")
    public WebElement findElement(By elementBy) {
        return driver().findElement(elementBy);
    }

    @Step("Value Set Successfully")
    public WebDriver sendKeys(By elementBy, String text) {
        driver().findElement(elementBy).sendKeys(text);
        return driver();
    }

    public WebDriver countLogic() {
        try {
            while (true) {
                after = driver().findElement(PROGRESS_LOCATOR).getText();
                if (!after.equals(before)) {
                    out.add(Integer.parseInt(after.substring(0, 2)));
                    before = after;
                }
            }
        } catch (Exception e) {
            System.out.println("Handled the unexpected Alert!");
        }

        Integer[] arr = new Integer[out.size()];
        arr = out.toArray(arr);


        for (int i = 0; i < arr.length - 1; i++) {
            System.out.print(arr[i]);
            if (arr[i] - arr[i + 1] == 1) {
                System.out.print(" The timer is ticking every second and the timer value is getting decremented by 1!" +"\n");
            }
        }
        logToReport("The timer is ticking every second and the timer value is getting decremented by 1!");
        return driver();
    }

    public InputStream getScrenshot() throws IOException {
        BufferedImage Img = Shutterbug.shootPage(driver()).getImage();
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        ImageIO.write(Img,"png",os);
        InputStream is = new ByteArrayInputStream(os.toByteArray());
        return is;
    }

    @Step("{0}")
    public WebDriver logToReport(String message)
    {
        log(message);
        return driver();
    }

}
