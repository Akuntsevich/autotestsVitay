package ioVitayDev.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public LoginPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    private By loginEmail = By.id("email");

    public void open(){
        driver.get("https://dev.vitay.io/login/signin?returnUrl=%2Fr%2Fdashboard");
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginEmail));
    }

}
