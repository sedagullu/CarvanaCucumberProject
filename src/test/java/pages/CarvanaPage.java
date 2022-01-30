package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CarvanaPage {
    public CarvanaPage(WebDriver driver) {
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//*[@data-cv-test='headerCarFinderLink']")
    public WebElement carFinderLink;

    @FindBy(linkText = "SELL/TRADE")
    public WebElement sellTrade;

    @FindBy(xpath = "//div[@data-cv-test='headerFinanceDropdown']")
    public WebElement financing;




}
