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

public class SelectRoomsAndGuestsPage {

    protected AndroidDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Select rooms and guests']")
    private RemoteWebElement selectRoomsAndGuestsText;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[1]")
    private RemoteWebElement increaseRoomsCountButton;

    @AndroidFindBy(xpath = "(//android.widget.Button[@content-desc='Increase'])[2]")
    private RemoteWebElement increaseAdultsCountButton;

    @AndroidFindBy(id = "com.booking:id/group_config_apply_button")
    private RemoteWebElement applyButton;

    public SelectRoomsAndGuestsPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Select rooms and guests page is loaded")
    public boolean selectRoomsAndGuestsPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectRoomsAndGuestsText)).isDisplayed();
    }

    @Step("Click `Increase rooms count`")
    public void clickIncreaseRoomsCount() {
        increaseRoomsCountButton.click();
    }

    @Step("Click `Increase adults count`")
    public void clickIncreaseAdultsCount() {
        increaseAdultsCountButton.click();
    }

    @Step("Click `Apply` button")
    public void clickApplyButton() {
        applyButton.click();
    }
}
