package ioVitayDev;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.firefox.FirefoxDriver;

public class WebdriverSettingsGecko {
    public FirefoxDriver driver;

    @Before
    public void SetUp(){
        System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
        driver = new FirefoxDriver();
        System.out.println("Start");
    }

    @After
    public void Close(){
        driver.quit();
        System.out.println("Exit");
    }
}
