package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class LandingPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/decor_content_parent")
    private RemoteWebElement landingPage;

    @AndroidFindBy(accessibility = "Navigate up")
    private RemoteWebElement closeButton;

    public LandingPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Landing page is loaded")
    public boolean landingPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(landingPage)).isDisplayed();
    }

    @Step("Click `Close` button")
    public void clickCloseButton() {
        closeButton.click();
    }
}
