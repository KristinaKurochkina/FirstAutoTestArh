package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class UserMenuComponents extends AbsComponent{
    private final String userMenuSelector = ".header3__user-info-name";
    private final String userMenuItemSelector = "a[href='/learning/']";
    public UserMenuComponents(WebDriver driver) {

        super(driver);
    }
    public void goToLk(){

        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(userMenuSelector)));
        actions.moveToElement(driver.findElement(By.cssSelector(userMenuSelector))).perform();
        click(driver.findElement(By.cssSelector(userMenuItemSelector)));
    }
}
