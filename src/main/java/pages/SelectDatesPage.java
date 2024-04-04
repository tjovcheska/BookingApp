package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

import io.qameta.allure.Step;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.GlobalVariables;

public class SelectDatesPage {

    protected AndroidDriver driver;

    @AndroidFindBy(id = "com.booking:id/design_bottom_sheet")
    private RemoteWebElement selectDatesPage;

    @AndroidFindBy(xpath = "//android.widget.Button[@text='Select dates']")
    private RemoteWebElement selectDatesButton;

    public SelectDatesPage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Select dates page is loaded")
    public boolean selectDatesPageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(selectDatesPage)).isDisplayed();
    }

    @Step("Choose {0} as start date and {1} as end date")
    public void chooseDates(String startDate, String endDate) {
        driver.findElement(By.xpath(String.format("//android.view.View[@content-desc='%s']", startDate))).click();
        driver.findElement(By.xpath(String.format("//android.view.View[@content-desc='%s']", endDate))).click();
    }

    @Step("Click `Select dates` button")
    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }
}
