package ioVitayDev.signUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    private WebDriver driver;
    private WebDriverWait wait;

    public RegisterPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, 20);
    }

    @FindBy(xpath = "//a[@href=\"/login/register\"]")
    private WebElement formRegister;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "userType")
    private WebElement userType;

    @FindBy(xpath = "//option[@value=\"1: Candidate\"]")
    private WebElement userTypeCandidate;

    @FindBy(xpath = "//option[@value=\"2: Recruiter\"]")
    private WebElement userTypeRecruiter;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "confirm")
    private WebElement confirmPassword;

    @FindBy(xpath = "//button[@class=\"btn btn-lg vitay-btn-primary vitay-btn--wauto vitay-btn--hauto\"]")
    private WebElement buttonRegister;

    @FindBy(xpath = "//img[@class=\"mx-auto d-block mb-4\"]")
    private WebElement imgClick;

    @FindBy(css = ".container-fluid > .row:nth-of-type(1) > .col > .ng-pristine > .form-group > .form-control-label > span")
    private WebElement spanEmailRequired;

    @FindBy(css = ".container-fluid > .row:nth-of-type(2) > .col > .ng-pristine > .form-group > .form-control-label > span")
    private WebElement spanUserType;

    @FindBy(css = ".container-fluid > .row:nth-of-type(3) > .col > .ng-pristine > .form-group > .form-control-label > span")
    private WebElement spanPassword;

    @FindBy(css = ".container-fluid > .row:nth-of-type(4) > .col > .ng-pristine > .form-group > .form-control-label > span")
    private WebElement spanConfirmPassword;

    @FindBy(css = ".container-fluid > .row:nth-of-type(1) > .col > .ng-dirty > .form-group > .form-control-label > span")
    private WebElement spanEmailNotAnEmail;

    @FindBy(css = ".container-fluid > .row:nth-of-type(4) > .col > .ng-invalid > .form-group > .form-control-label > span")
    private WebElement spamConfirmPasswordNotIdentical;

    private By formLocator = By.id("userType");
    private By registerCandidateComplete = By.xpath("//a[@class=\"btn btn-lg vitay-btn-primary vitay-btn-sm-block\"]");
    private By registerRecruiterComplete = By.xpath("//div[@class=\"col-12 col-md-6 d-flex align-items-center\"]");
    private By fadeIn = By.cssSelector("[class=\"fadeIn\"]");

    public void openRegisterPage(){
        formRegister.click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
    }

    public void fillEmail(String emailText){
        email.sendKeys(emailText);
    }

    public void fillUserTypeCandidate(){
        userTypeCandidate.click();
    }

    public void fillUserTypeRecruiter(){
        userTypeRecruiter.click();
    }

    public void fillpassword(String pass){
        password.sendKeys(pass);
    }

    public void fillConfirmPassword(String confPass){
        confirmPassword.sendKeys(confPass);
    }

    public void submitRegister(){
        buttonRegister.click();
    }

    public void checkSubmitRegisterCandidate(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerCandidateComplete));
    }

    public void checkSubmitRegisterRecruiter(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(registerRecruiterComplete));
    }

    public void clickEmail(){
        email.click();
        imgClick.click();
    }

    public String getRequiredEmail(){
        return spanEmailRequired.getText();
    }

    public void clickUserType(){
        userType.click();
        imgClick.click();
    }

    public String getRequiredUserType(){
        return spanUserType.getText();
    }

    public void clickPassword(){
        password.click();
        imgClick.click();
    }

    public String getRequiredPassword(){
        return spanPassword.getText();
    }

    public String getNotIdenticalConfirmPassword(){
        return spamConfirmPasswordNotIdentical.getText();
    }

    public void clickConfirmPassword(){
        confirmPassword.click();
        imgClick.click();
    }

    public String getRequiredConfirmPassword(){
        return spanConfirmPassword.getText();
    }

    public void checkErrorRequired(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(fadeIn));
    }

    public void checkEnabled(){
        buttonRegister.isEnabled();
    }

    public void setImgClick(){
        imgClick.click();
    }

    public String getNotAnEmail(){
        return spanEmailNotAnEmail.getText();
    }

    public void clearEmail(){
        email.clear();
    }

    public void clearPassword(){
        password.clear();
    }

    public void clearConfirmPassword(){
        confirmPassword.clear();
    }

}
