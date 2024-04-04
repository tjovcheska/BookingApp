package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class CarRentalPage {

    protected AndroidDriver driver;

    @AndroidFindBy(accessibility = "Selected, you will return the car to the same location")
    private RemoteWebElement returnToSameLocationButton;

    @AndroidFindBy(accessibility = "Enter a pick-up location")
    private RemoteWebElement pickUpLocationButton;

    @AndroidFindBy(accessibility = "Enter a drop-off location")
    private RemoteWebElement dropOffLocationButton;

    @AndroidFindBy(xpath = "//android.view.View[@content-desc='Car rental search box']/android.view.View[2]/android.widget.Button")
    private RemoteWebElement searchButton;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Pick-up date:')]")
    private RemoteWebElement pickUpDateField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Pick-up time:')]")
    private RemoteWebElement pickUpTimeField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Drop-off date:')]")
    private RemoteWebElement dropOffDateField;

    @AndroidFindBy(xpath = "//android.widget.Button[contains(@content-desc, 'Drop-off time:')]")
    private RemoteWebElement dropOffTimeField;

    @AndroidFindBy(accessibility = "Enter the driver's age")
    private RemoteWebElement driverAgeField;

    public CarRentalPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Car rental page is loaded")
    public boolean carRentalPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(searchButton)).isDisplayed();
    }

    @Step("Disable `Return to same location` button")
    public void disableReturnToSameLocationButton() {
        returnToSameLocationButton.click();
    }

    @Step("Validate that `Pick up location` is displayed")
    public void validatePickUpLocationDisplayed() {
        pickUpLocationButton.isDisplayed();
    }

    @Step("Validate that `Drop off location is displayed`")
    public void validateDropOffLocationDisplayed() {
        dropOffLocationButton.isDisplayed();
    }

    @Step("Click `Pick up location`")
    public void clickPickUpLocation() {
        pickUpLocationButton.click();
    }

    @Step("Click `Drop off location`")
    public void clickDropOffLocation() {
        dropOffLocationButton.click();
    }

    @Step("Click `Pick up date`")
    public void clickPickUpDate() {
        pickUpDateField.click();
    }

    @Step("Click `Drop off date`")
    public void clickDropOffDate() {
        dropOffDateField.click();
    }

    @Step("Click `Pick up time`")
    public void clickPickUpTime() {
        pickUpTimeField.click();
    }

    @Step("Click `Drop off time`")
    public void clickDropOffTime() {
        dropOffTimeField.click();
    }

    @Step("Click `Driver's age` field")
    public void clickDriverAgeField() {
        driverAgeField.click();
    }

    @Step("Add {0} as driver's age")
    public void addDriverAge(String age) {
        for (char digit : age.toCharArray()) {
            driver.pressKey(new KeyEvent().withKey(AndroidKey.valueOf("DIGIT_" + digit)));
        }
    }

    @Step("Click `Search` button")
    public void clickSearchButton() {
        searchButton.click();
    }
}
