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

public class StaysPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Accommodation search box")
    private RemoteWebElement accommodationSearchBox;

    @AndroidFindBy(accessibility = "Enter your destination")
    private RemoteWebElement destinationField;

    @AndroidFindBy(xpath = "//android.widget.Button[@content-desc='1 room, 2 adults, 0 children']")
    private RemoteWebElement roomsAndGuestsField;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Accommodation search box']/android.view.View/android.widget.Button")
    private RemoteWebElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Car rental']")
    private RemoteWebElement carRentalButton;

    public StaysPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Stays page is loaded")
    public boolean staysPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(accommodationSearchBox)).isDisplayed();
    }

    @Step("Click `Choose destination`")
    public void clickChooseDestination() {
        destinationField.click();
    }

    @Step("Click `Select rooms and guests`")
    public void clickSelectRoomsAndGuests() {
        roomsAndGuestsField.click();
    }

    @Step("Click `Search` button")
    public void clickSearchButton() {
        searchButton.click();
    }

    @Step("Click `Car rental` button")
    public void clickCarRentalButton() {
        carRentalButton.click();
    }
}
