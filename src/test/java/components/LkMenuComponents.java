package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LkMenuComponents extends AbsComponent{

    private final String LkMenuItemSelector = "a[title=\"О себе\"]";

    public LkMenuComponents(WebDriver driver) {
        super(driver);
    }

    public void goToLkMenuItem(){

        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(LkMenuItemSelector)));
        click(driver.findElement(By.cssSelector(LkMenuItemSelector)));
    }

}
