package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaSellMyCarPage {
    public CarvanaSellMyCarPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//div[@class='HeroFold__Verbage-sc-7cfq03-1 jloOVd']//div[3]")
    public WebElement wePickUp;

    @FindBy(xpath = "//div[@class='HeroFold__Verbage-sc-7cfq03-1 jloOVd']//div[2]")
    public WebElement getAReal;

    @FindBy(xpath = "//button[@data-cv-test='VINToggle']")
    public  WebElement vinButton;

    @FindBy(xpath = "//input[@aria-labelledby='VIN']")
    public  WebElement vinInput;

    @FindBy(xpath = "//button[@data-cv-test='heroGetMyOfferButton']")
    public  WebElement getMyOfferButton;


}
