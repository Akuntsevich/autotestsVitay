package ioVitayDev;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverSettingsChrome {
    public ChromeDriver driver;
    public WebDriverWait wait;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
        driver = new ChromeDriver();
        System.out.println("Start");
        wait = new WebDriverWait(driver, 20);
    }

    @After
    public void Close(){
        driver.quit();
        System.out.println("Exit");
    }
}
