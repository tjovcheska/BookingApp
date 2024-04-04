package util;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.List;

import static java.time.Duration.ZERO;
import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class Helpers {

    public enum Directions {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private final PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public void scrollToElementWithText(AndroidDriver driver, String text) {
        driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true)).setAsVerticalList()" +
                ".scrollIntoView(new UiSelector().text(\"" + text + "\").instance(0));"));
    }

    public void swipeVertically(AndroidDriver driver, Directions direction) {
        int startX = driver.manage().window().getSize().getWidth() / 2;
        int startY = driver.manage().window().getSize().getHeight() / 2;

        int endY;

        switch (direction) {
            case UP -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.2);
            case DOWN -> endY = (int) (driver.manage().window().getSize().getHeight() * 0.8);
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipe = new Sequence(FINGER, 0);

        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), startX, endY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    public void swipeHorizontally(AndroidDriver driver, Directions direction) {
        int startY = driver.manage().window().getSize().getHeight() / 2;
        int startX;
        int endX;

        switch (direction) {
            case LEFT -> {
                startX = (int) (driver.manage().window().getSize().getWidth() * 0.8);
                endX = (int) (driver.manage().window().getSize().getWidth() * 0.2);
            }
            case RIGHT -> {
                startX = (int) (driver.manage().window().getSize().getWidth() * 0.2);
                endX = (int) (driver.manage().window().getSize().getWidth() * 0.8);
            }
            default -> throw new IllegalArgumentException("Invalid direction selected: " + direction);
        }

        Sequence swipe = new Sequence(FINGER, 0);

        swipe.addAction(FINGER.createPointerMove(ZERO, viewport(), startX, startY));
        swipe.addAction(FINGER.createPointerDown(LEFT.asArg()));
        swipe.addAction(FINGER.createPointerMove(ofMillis(1000), viewport(), endX, startY));
        swipe.addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(List.of(swipe));
    }

    public void swipeVerticallyN(AndroidDriver driver, Directions direction, int numberOfScrolls) {
        for (int i = 0; i <= numberOfScrolls; i++) {
            swipeVertically(driver, direction);
        }
    }

    public void swipeHorizontallyN(AndroidDriver driver, Directions direction, int numberOfScrolls) {
        for (int i = 0; i <= numberOfScrolls; i++) {
            swipeHorizontally(driver, direction);
        }
    }
}
