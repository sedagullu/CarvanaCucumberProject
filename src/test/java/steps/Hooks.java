package steps;

import cucumber.api.java.After;
import utilities.Driver;

public class Hooks {
    //All our before and after actions here
    @After
    public void tearDown(){
        Driver.quitDriver();
    }
}
