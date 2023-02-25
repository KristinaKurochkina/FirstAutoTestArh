package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AuthorizationComponent extends AbsComponent {

    private final String loginSelector = "//input[@type='text' and @name='email' and @placeholder = 'Электронная почта']";
    private final String passwordSelector = "//input[ @name='password' and @placeholder = 'Введите пароль']";
    private final String submitButtonSelector = "form.new-log-reg__form>div>button[type='submit']";
    private final String login = "fivod55542@vingood.com";
    private final String pas = "Gipunu13!";

    public AuthorizationComponent(WebDriver driver) {
        super(driver);
    }

    public void loginInOtus() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(loginSelector)));
        enterNewValue(By.xpath(loginSelector), login);
        enterNewValue(By.xpath(passwordSelector), pas);
        driver.findElement(By.cssSelector("form.new-log-reg__form>div>button[type='submit']")).submit();

    }
}
