package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MenuComponents extends AbsComponent{
    private String buttonSelector = ".header3__button-sign-in";
    public MenuComponents (WebDriver driver) {

        super(driver);
    }
    public void clickLoginButton(){
        actions.moveToElement(driver.findElement(By.cssSelector(buttonSelector))).perform();
        waiter.waitForCondition(ExpectedConditions.visibilityOf((driver.findElement(By.cssSelector(buttonSelector)))));
        click(driver.findElement(By.cssSelector(buttonSelector)));
    }
}
