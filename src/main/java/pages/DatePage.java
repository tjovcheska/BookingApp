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

public class DatePage {

    protected AndroidDriver driver;

    @AndroidFindBy(id="com.booking:id/bui_calendar_view")
    private RemoteWebElement calendarView;

    @AndroidFindBy(id="com.booking:id/calendar_confirm")
    private RemoteWebElement selectDatesButton;

    public DatePage(AndroidDriver driver) {
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @Step("Date page is loaded")
    public boolean datePageLoaded() {
        return new WebDriverWait(driver, GlobalVariables.globalTimeout).until(ExpectedConditions.visibilityOf(calendarView)).isDisplayed();
    }

    @Step("Choose {0} date")
    public void chooseDate(String date) {
        driver.findElement(By.xpath(String.format("//android.view.View[@content-desc='%s']", date))).click();
    }

    @Step("Click `Select dates button`")
    public void clickSelectDatesButton() {
        selectDatesButton.click();
    }
}
