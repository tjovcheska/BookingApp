package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;

public class BottomNavigationBar {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Saved")
    private RemoteWebElement savedButton;

    @AndroidFindBy(accessibility = "Search")
    private RemoteWebElement searchButton;

    @AndroidFindBy(accessibility = "Sign in")
    private RemoteWebElement signInButton;

    public BottomNavigationBar(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Click `Saved` button")
    public void clickSaved() {
        savedButton.click();
    }

    @Step("Click `Search` button")
    public void clickSearch() {
        searchButton.click();
    }

    @Step("Click `Sign In` button")
    public void clickSignIn() {
        signInButton.click();
    }
}
