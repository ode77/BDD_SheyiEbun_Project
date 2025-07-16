package StepDefs;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.PropertyReaders;

import java.io.IOException;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static StepDefs.Hook.driver;

public class UKBAVisaChecksStepDef {

    @Given("I am on UKba Website")
    public void i_am_on_u_kba_website() throws IOException {
        // Write code here that turns the phrase above into concrete actions
        PropertyReaders propReaders = new PropertyReaders();
        driver.get(propReaders.getUKBA_Url());
    }
    @When("I click on Accept additional cookies")
    public void iClickOnAcceptAdditionalCookies() {
        try{
        WebElement clickOnCokies = driver.findElement(By.xpath("//button[@data-accept-cookies='true']"));
            if (clickOnCokies.isDisplayed()) {
                clickOnCokies.click();
                System.out.println("Cookies accepted.");
            }
        } catch (Exception e) {
            // Cookie popup not found or not displayed
            System.out.println("No cookie popup found. Continuing test...");
        }
    }
    @Then("the Check if you need a UK visa page is displayed")
    public void theCheckIfYouNeedAUKVisaPageIsDisplayed() {
        WebElement pageIsDisplayed = driver.findElement(By.xpath("//h1[contains(text(),' Check if you need a UK visa')]"));
        assertThat(pageIsDisplayed.getText(), is(Matchers.equalTo("Check if you need a UK visa")));

    }
    @And("I click on StartNow button")
    public void iClickOnStartNowButton() {
        WebElement clickOnStartNow = driver.findElement(By.xpath(" (//a[@role='button'])[1]"));
        clickOnStartNow.click();
    }

    @When("I provide nationality of {string}")
    public void i_provide_nationality_of(String countryNme) {
        // Write code here that turns the phrase above into concrete actions
        WebElement setNationality = driver.findElement(By.id("response"));
        Select nation = new Select(setNationality);
        nation.selectByVisibleText(countryNme);
    }
    @When("I click on Continue button")
    public void i_click_on_continue_button() {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickOnContinueBtn = driver.findElement(By.xpath("//button[contains(text(),'Continue')]"));
        clickOnContinueBtn.click();
    }
    @And("I select reason as {string}")
    public void iSelectReasonAs(String arg0) {
        WebElement setReasons = driver.findElement(By.xpath("//input[@id='response-2']"));
        setReasons.click();
    }

    @When("I state I intend to stay for more than {int} months")
    public void i_state_i_intend_to_stay_for_more_than_months(Integer int1) {
        // Write code here that turns the phrase above into concrete actions
        WebElement clickHowLong = driver.findElement(By.xpath("//input[@id='response-1']"));
        clickHowLong.click();
    }
    @Then("I should get a respond {string} as coming to UK")
    public void i_should_get_a_respond_as_coming_to_uk(String mssge) {
        // Write code here that turns the phrase above into concrete actions
        WebElement getResponseMessage = driver.findElement(By.xpath("//h2[@class='gem-c-heading__text gem-c-heading--font-size-27']"));
        assertThat(getResponseMessage.getText(),is(equalTo(mssge)));

    }


    @And("I select the reason as {string}")
    public void iSelectTheReasonAs(String arg0) {
        WebElement setTourism = driver.findElement(By.xpath("//input[@id='response-0']"));
        setTourism.click();


    }

    @And("I select {string} button for travelling with or visiting partner or family member")
    public void iSelectButtonForTravellingWithOrVisitingPartnerOrFamilyMember(String arg0) {
        WebElement setYes = driver.findElement(By.xpath("//input[@id='response-0']"));
        setYes.click();

    }
    @Then("I should get a {string} as coming to UK")
    public void iShouldGetAAsComingToUK(String mssge) {
        WebElement getInformedMessage = driver.findElement(By.xpath("//h2[@class='gem-c-heading__text gem-c-heading--font-size-27']"));
        assertThat(getInformedMessage.getText(),is(equalTo(mssge)));

    }

}
