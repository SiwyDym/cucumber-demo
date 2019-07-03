package hellocucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import static hellocucumber.IsItFriday.isItFriday;
import static org.junit.Assert.assertEquals;

public class Stepdefs {
    private String today;
    private String actualAnswer;

    @Given("today is {string}")
    public void todayIs(String day) {
        this.today = day;
    }

    @When("^I ask whether it's Friday yet$")
    public void i_ask_whether_it_s_Friday_yet() {
        actualAnswer = isItFriday(today);
    }

    @Then("^I should be told \"([^\"]*)\"$")
    public void i_should_be_told(String expectedAnswer) {
        assertEquals(expectedAnswer, actualAnswer);
    }
}

class IsItFriday {
    static String isItFriday(String today) {
        if ("Friday".equals(today)) {
            return "TGIF";
        }
        return "Nope";
    }

}