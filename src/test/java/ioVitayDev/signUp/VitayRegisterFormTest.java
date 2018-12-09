package ioVitayDev.signUp;

import ioVitayDev.WebDriverSettingsChrome;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import java.util.Random;

public class VitayRegisterFormTest extends WebDriverSettingsChrome {

    @Test
    public void VitayPositiveRegisterCandidate(){

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        Random random = new Random();
        int n = random.nextInt(100) + 1;

        String email = "r922" + n + "@ukr.net";

        registerPage.fillEmail(email);
        registerPage.fillUserTypeCandidate();
        registerPage.fillpassword("j3498ojcjc30");
        registerPage.fillConfirmPassword("j3498ojcjc30");
        registerPage.submitRegister();
        registerPage.checkSubmitRegisterCandidate();
    }
    @Test
    public void VitayPositiveRegisterRecruiter(){

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        Random random = new Random();
        int n = random.nextInt(200) + 1;

        String email = "1str" + n + "@ukr.net";

        registerPage.fillEmail(email);
        registerPage.fillUserTypeRecruiter();
        registerPage.fillpassword("j3498ojcjc30");
        registerPage.fillConfirmPassword("j3498ojcjc30");
        registerPage.submitRegister();
        registerPage.checkSubmitRegisterRecruiter();
    }

    @Test
    public void VitayUnSignUpEmptyFieldSandByRoration(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        registerPage.clickEmail();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getRequiredEmail(), "Required");
        registerPage.checkEnabled();

        registerPage.clickUserType();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getRequiredUserType(), "Required");
        registerPage.checkEnabled();

        registerPage.clickPassword();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getRequiredPassword(), "Required");
        registerPage.checkEnabled();

        registerPage.clickConfirmPassword();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getRequiredConfirmPassword(), "Required");
        registerPage.checkEnabled();

    }

    @Test
    public void VitayUnSignUpSpecificNegativTestEmail(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        registerPage.fillUserTypeCandidate();
        registerPage.fillpassword("j3498ojcjc30");
        registerPage.fillConfirmPassword("j3498ojcjc30");

        registerPage.fillEmail("r922gmail.com");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotAnEmail(), "Not an email");
        registerPage.checkEnabled();
        registerPage.clearEmail();

        registerPage.fillEmail("r992@gmailcom");
        //Поиск драйвера кнопки Register и проверка что она активна-------------нужно доработать (когда кнопка неактивна появляеся disabled , а когда активна пусто)
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]"));
        registerPage.clearEmail();

        registerPage.fillEmail("@gmail.com");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotAnEmail(), "Not an email");
        registerPage.checkEnabled();
        registerPage.clearEmail();

        registerPage.fillEmail("r922@");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotAnEmail(), "Not an email");
        registerPage.checkEnabled();
        registerPage.clearEmail();

        registerPage.fillEmail("кр@ukr.net");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotAnEmail(), "Not an email");
        registerPage.checkEnabled();
        registerPage.clearEmail();

        registerPage.fillEmail(" r922@ukr.net");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotAnEmail(), "Not an email");
        registerPage.checkEnabled();
        registerPage.clearEmail();

    }

    @Test
    public void VitayUnSignUpSpecificPositiveTestPassword(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        registerPage.fillEmail("r922@ukr.net");
        registerPage.fillUserTypeCandidate();
        registerPage.fillpassword("q");
        registerPage.fillConfirmPassword("q");
        //Поиск драйвера кнопки Register и проверка что она активна-------------нужно доработать (когда кнопка неактивна появляеся disabled , а когда активна пусто)
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]"));
        registerPage.clearPassword();
        registerPage.clearConfirmPassword();

        registerPage.fillpassword(" ");
        registerPage.fillConfirmPassword(" ");
        //Поиск драйвера кнопки Register и проверка что она активна-------------нужно доработать (когда кнопка неактивна появляеся disabled , а когда активна пусто)
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]"));
        registerPage.clearPassword();
        registerPage.clearConfirmPassword();

        registerPage.fillpassword("%?");
        registerPage.fillConfirmPassword("%?");
        //Поиск драйвера кнопки Register и проверка что она активна-------------нужно доработать (когда кнопка неактивна появляеся disabled , а когда активна пусто)
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]"));
        registerPage.clearPassword();
        registerPage.clearConfirmPassword();

        registerPage.fillpassword("кириллица");
        registerPage.fillConfirmPassword("кириллица");
        //Поиск драйвера кнопки Register и проверка что она активна-------------нужно доработать (когда кнопка неактивна появляеся disabled , а когда активна пусто)
        driver.findElement(By.xpath("//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]"));

    }

    @Test
    public void VitayUnSignUpSpecificNegativTestPasswordConfirm(){
        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.open();

        RegisterPage registerPage = PageFactory.initElements(driver, RegisterPage.class);
        registerPage.openRegisterPage();

        registerPage.fillEmail("r922@ukr.net");
        registerPage.fillUserTypeCandidate();

        registerPage.fillpassword("q");
        registerPage.fillConfirmPassword("0");
        registerPage.setImgClick();
        registerPage.checkErrorRequired();
        registerPage.getNotIdenticalConfirmPassword();
        Assert.assertEquals(registerPage.getNotIdenticalConfirmPassword(), "Not identical");
        registerPage.checkEnabled();
        registerPage.clearPassword();
        registerPage.clearConfirmPassword();

        registerPage.fillpassword("1");
        registerPage.fillConfirmPassword("1");
        registerPage.clearPassword();
        registerPage.fillpassword("2");
        registerPage.clearPassword();
        registerPage.fillpassword("1");
        registerPage.checkErrorRequired();
        Assert.assertEquals(registerPage.getNotIdenticalConfirmPassword(), "Not identical");
        registerPage.checkEnabled();

    }
}
