package steps;

import cucumber.api.java.Before;
import cucumber.api.java.bs.A;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import pages.*;
import utilities.Driver;
import utilities.Waiter;

public class CarvanaSteps {
    public WebDriver driver;
    public CarvanaPage carvanaPage;
    public CarvanaHelpMePage carvanaHelpMePage;
    public CarvanaSellMyCarPage carvanaSellMyCarPage;
    public CarvanaHelpMeSearchQaPage carvanaHelpMeSearchQaPage;
    public CarvanaAutoLoanPage carvanaAutoLoanPage;
    public CarvanaGetOfferPage carvanaGetOfferPage;

    @Before
    public void setUp(){
        driver = Driver.getDriver();
        carvanaPage = new CarvanaPage(driver);
        carvanaHelpMePage = new CarvanaHelpMePage(driver);
        carvanaSellMyCarPage = new CarvanaSellMyCarPage(driver);
        carvanaHelpMeSearchQaPage = new CarvanaHelpMeSearchQaPage(driver);
        carvanaAutoLoanPage = new CarvanaAutoLoanPage(driver);
        carvanaGetOfferPage = new CarvanaGetOfferPage(driver);
    }


    @Given("user is on {string}")
    public void userIsOn(String url) {
        driver.get(url);
        Waiter.pause(2);
    }

    @When("user clicks on {string} menu item")
    public void userClicksOnMenuItem(String item) {
        switch (item){
            case"CAR FINDER":
                carvanaPage.carFinderLink.click();
                break;
            case"SELL/TRADE":
                carvanaPage.sellTrade.click();
                break;
            case"AUTO LOAN CALCULATOR":
                carvanaAutoLoanPage.autoLoan.click();
                break;
            default:
                throw new NotFoundException(item + " is not found!!!");
        }


    }

    @Then("user should  be navigated to {string}")
    public void userShouldBeNavigatedTo(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
        Waiter.pause(2);
    }

    @And("user should see {string} text")
    public void userShouldSeeText(String text) {
        switch (text){
            case "WHAT CAR SHOULD I GET?":
                Assert.assertEquals(text, carvanaHelpMePage.header1.getText());
                break;
            case "Car Finder can help! Answer a few quick questions to find the right car for you.":
                Assert.assertEquals(text, carvanaHelpMePage.header3.getText());
                break;
            case "WHAT IS MOST IMPORTANT TO YOU IN YOUR NEXT CAR?":
                Assert.assertEquals(text , carvanaHelpMeSearchQaPage.headline.getText());
                break;
            case "Select up to 4 in order of importance":
                Assert.assertEquals(text, carvanaHelpMeSearchQaPage.selectUp.getText());
                break;
            case"GET A REAL OFFER IN 2 MINUTES":
                Assert.assertEquals(text, carvanaSellMyCarPage.getAReal.getText());
                break;
            case "We pick up your car. You get paid on the spot.":
                Assert.assertEquals(text, carvanaSellMyCarPage.wePickUp.getText());
                break;
            case "We couldn’t find that VIN. Please check your entry and try again.":
                Waiter.pause(2);
                Assert.assertEquals(text, carvanaGetOfferPage.failedMessage.getText());
                break;
            default:
                throw new NotFoundException(text + " is not found!!!");
        }

        Waiter.pause(2);

    }

    @And("user should see {string} link")
    public void userShouldSeeLink(String link) {
        Assert.assertEquals(carvanaHelpMePage.tryCarFinder.getText() , link);

    }

    @When("user clicks on {string} link")
    public void userClicksOnLink(String link) {
                carvanaHelpMePage.tryCarFinder.click();

    }

    @Then("user should be navigated to {string}")
    public void userShouldBeNavigatedToQa(String url) {
        Waiter.pause(2);
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }


    @When("user clicks on {string} button")
    public void userClicksOnButton(String button) {
        switch (button){
            case"VIN":
                carvanaSellMyCarPage.vinButton.click();
                break;
            case"GET MY OFFER":
                carvanaSellMyCarPage.getMyOfferButton.click();
                break;
            default:
                throw new NotFoundException(button + " can not be found!!!");
        }
    }

    @And("user enters vin number as {string}")
    public void userEntersVinNumberAs(String key) {
        carvanaSellMyCarPage.vinInput.sendKeys("12345678912345678");
    }

    @When("user hovers over on {string} menu item")
    public void userHoversOverOnMenuItem(String item) {
        Actions actions = new Actions(driver);
        actions.moveToElement(carvanaPage.financing).perform();
    }

    @When("user enters {string} as {string}")
    public void userEntersAs(String carCost, String price) {
        switch (carCost){
            case"Cost of Car I want":
                carvanaAutoLoanPage.vehiclePrice.sendKeys(price);
                break;
            case"What is Your Down Payment?":
                carvanaAutoLoanPage.downPayment.sendKeys(price);
                break;
            default:
                throw new NotFoundException(price + " can not be found!!!");
        }

    }

    @And("user selects {string} as {string}")
    public void userSelectsAs(String element, String dropdown) {
        switch (element){
            case"What’s Your credit Score?":
                Select select = new Select(carvanaAutoLoanPage.creditStore);
                select.selectByIndex(0);
                break;
            case"Choose Your Loan Terms":
                Select select2 = new Select(carvanaAutoLoanPage.loanTerm);
                select2.selectByIndex(1);
                break;
            default:
                throw new NotFoundException(dropdown + " can not be found!!!");
        }

    }

    @Then("user should see the monthly payment as {string}")
    public void userShouldSeeTheMonthlyPaymentAs(String payment) {
        Assert.assertEquals(payment, carvanaAutoLoanPage.montlyPayment.getText());
    }
}
