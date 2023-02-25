import components.*;
import exceptions.BrowserNotSupportedException;
import factories.WebDriverFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pages.MainPage;

public class FirstTest {

    private WebDriver driver;

    @BeforeAll
    public static void setUp() {

        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void init() throws BrowserNotSupportedException {
        driver = new WebDriverFactory().createDriver();
    }
    @AfterEach
    public void close() {
        if (driver != null) {
            driver.close();
            driver.quit();
        }
    }

    @Test
    public void otusTest() {
        MainPage mainPage = new MainPage(driver);
        MenuComponents menuComponents = new MenuComponents(driver);
        AuthorizationComponent authorizationComponent = new AuthorizationComponent(driver);
        UserMenuComponents userMenuComponents =new UserMenuComponents(driver);
        LkMenuComponents lkMenuComponents = new LkMenuComponents(driver);
        PersonalInfoComponent personalInfoComponent = new PersonalInfoComponent(driver);

        mainPage.open();
        menuComponents.clickLoginButton();
        authorizationComponent.loginInOtus();
        userMenuComponents.goToLk();
        lkMenuComponents.goToLkMenuItem();

        personalInfoComponent.addPersonalData();
        personalInfoComponent.addMainInfo();
        personalInfoComponent.addContacts();
        personalInfoComponent.clickSaveButton();


        mainPage.clearSession();
        mainPage.open();
        menuComponents.clickLoginButton();
        authorizationComponent.loginInOtus();
        userMenuComponents.goToLk();
        lkMenuComponents.goToLkMenuItem();
        personalInfoComponent.checkAddedInformation();


   }
}

