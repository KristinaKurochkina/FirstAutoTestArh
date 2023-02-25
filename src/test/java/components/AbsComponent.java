package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pageObject.AbsPageObject;

public abstract class AbsComponent extends AbsPageObject {

    public AbsComponent(WebDriver driver) {

        super(driver);
    }
    protected void enterNewValue(By by, String text) {
        driver.findElement(by).clear();
        driver.findElement(by).sendKeys(text);
    }
}