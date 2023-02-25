package components;

import data.CityData;
import data.CountryData;
import data.PersonalData;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PersonalInfoComponent extends AbsComponent{

    private final String firstNameSelector = "id_fname";
    private final String firstNameLatinSelector = "id_fname_latin";
    private final String lastNameSelector = "id_lname";
    private final String lastNameLatinSelector = "id_lname_latin";
    private final String blogNameSelector = "id_blog_name";
    private final String birthDateSelector = "input[name='date_of_birth']";
    private final String countryButtonSelector = "input[name=\"country\"]~div";
    private final String cityButtonSelector = "input[name=\"city\"]~div";
    private String countrySelector = "button[title='%s']";
    private String citySelector = "button[title='%s']";
    private final String englishButtonSelector = "input[name=\"english_level\"]~div";
    private final String englishLevelSelector = "button[title=\"Начальный уровень (Beginner)\"]";
    private final String contact1ButtonSelector = "input[name=\"contact-0-service\"]~div";
    private final String contact1Selector = "button[title=\"Viber\"]";
    private final String contact1ValueSelector = "id_contact-0-value";

    private final String addContactButtonSelector = "div[data-prefix='contact']> button";
    private final String contact2ButtonSelector = "input[name=\"contact-1-service\"]~div";
    private final String contact2Selector = "//*[@name='contact-1-id']//following::button[@title='Facebook']";
    private final String contact2ValueSelector = "id_contact-1-value";
    private final String saveButtonSelector = "button[title='Сохранить и заполнить позже']";

    public PersonalInfoComponent(WebDriver driver) {
        super(driver);
    }
    public PersonalInfoComponent addPersonalData() {
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(firstNameSelector)));
        enterNewValue(By.id(firstNameSelector), PersonalData.FIRSTNAME.getName());
        enterNewValue(By.id(firstNameLatinSelector), PersonalData.FIRSTNAMELATIN.getName());
        enterNewValue(By.id(lastNameSelector), PersonalData.LASTNAME.getName());
        enterNewValue(By.id(lastNameLatinSelector), PersonalData.LASTNAMELATIN.getName());
        enterNewValue(By.id(blogNameSelector), PersonalData.BLOGNAME.getName());
        enterNewValue(By.cssSelector(birthDateSelector), PersonalData.BIRTHDATE.getName());
        return this;
    }

    public PersonalInfoComponent addMainInfo() {
        click(driver.findElement(By.cssSelector(countryButtonSelector)));
        click(driver.findElement(By.cssSelector(String.format(countrySelector, CountryData.RUSSIA.getName()))));

        click(driver.findElement(By.cssSelector(englishButtonSelector)));
        click(driver.findElement(By.cssSelector(englishLevelSelector)));

        click(driver.findElement(By.cssSelector(cityButtonSelector)));
        click(driver.findElement(By.cssSelector(String.format(citySelector, CityData.MOSCOW.getName()))));

        return this;
    }

    public PersonalInfoComponent addContacts() {
        click(driver.findElement(By.cssSelector(contact1ButtonSelector)));
        click(driver.findElement(By.cssSelector(contact1Selector)));
        enterNewValue(By.id(contact1ValueSelector), PersonalData.CONTACTVALUE1.getName());

        click(driver.findElement(By.cssSelector(addContactButtonSelector)));

        click(driver.findElement(By.cssSelector(contact2ButtonSelector)));
        waiter.waitForCondition(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(contact2Selector)));
        click(driver.findElement(By.xpath(contact2Selector)));
        enterNewValue(By.id(contact2ValueSelector), PersonalData.CONTACTVALUE2.getName());

        return this;
    }

    public void clickSaveButton(){
        click(driver.findElement(By.cssSelector(saveButtonSelector)));
    }
    public PersonalInfoComponent checkAddedInformation(){
        Assertions.assertEquals("Кристина", driver.findElement(By.id(firstNameSelector)).getAttribute("value"));
        Assertions.assertEquals("Kristina", driver.findElement(By.id(firstNameLatinSelector)).getAttribute("value"));
        Assertions.assertEquals("Иванова", driver.findElement(By.id(lastNameSelector)).getAttribute("value"));
        Assertions.assertEquals("Ivanova", driver.findElement(By.id(lastNameLatinSelector)).getAttribute("value"));
        Assertions.assertEquals("Кристина", driver.findElement(By.id(blogNameSelector)).getAttribute("value"));
        Assertions.assertEquals("21.04.1990", driver.findElement(By.cssSelector(birthDateSelector)).getAttribute("value"));
        Assertions.assertEquals("Россия", driver.findElement(By.cssSelector(countryButtonSelector)).getText());
        Assertions.assertEquals("Москва", driver.findElement(By.cssSelector(cityButtonSelector)).getText());
        Assertions.assertEquals("Начальный уровень (Beginner)", driver.findElement(By.cssSelector(englishButtonSelector)).getText());
        Assertions.assertEquals("Facebook", driver.findElement(By.cssSelector(contact1ButtonSelector)).getText());
        Assertions.assertEquals("KrisK", driver.findElement(By.id(contact1ValueSelector)).getAttribute("value"));
        Assertions.assertEquals("Viber", driver.findElement(By.cssSelector(contact2ButtonSelector)).getText());
        Assertions.assertEquals("89677019887", driver.findElement(By.id(contact2ValueSelector)).getAttribute("value"));
        return this;
    }
    }


