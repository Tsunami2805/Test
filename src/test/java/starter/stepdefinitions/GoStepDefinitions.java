package starter.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import starter.search.SearchFor;
import starter.search.SearchResult;

import starter.navigation.NavigateToTiki;

import static org.assertj.core.api.Assertions.assertThat;
import static starter.matchers.TextMatcher.textOf;

public class GoStepDefinitions {


	@Steps
	SearchFor searchFor;
	
	@Steps
	SearchResult searchResultCompare;
	
	@Steps
	SearchResult tikiNow;
	
	@Steps
	SearchResult pickItems;

	@Steps
	SearchResult searchResult;
	
	@Steps
	SearchResult addItemsToCarts;


	@Steps
	NavigateToTiki navigateToTiki;
	
	@Steps
	SearchFor declineOffer;

	@Given("^(?:.*) is on the Tiki home page")
	public void i_am_on_the_Tiki_home_page() {
		navigateToTiki.TikiHomePage();
		declineOffer.DeclineOffer();
	}
	
	@When("^s?he is (?:looking|searching|finding) for \"(.*)\" products to buy as (?:gift|present) to \"(.*)\", \"(.*)\", \"(.*)\"")
	public void i_search_for(String keyword, String city, String district, String ward) {
		searchFor.term(keyword);
		searchResultCompare.result_contains(keyword);
		tikiNow.select_checkbox_tiki_now(city, district, ward);
	}
	
	@When("he picked the {int} th item on the search result")
	public void i_pick_for(int num) {
		pickItems.select_item_from_search_result(num);
	}
	
	
	@Then("he adds {int} items to the cart to check out")
	public void i_check_out(int num){
		addItemsToCarts.increase_the_item_count(num);
		addItemsToCarts.add_item_to_the_cart(num);
		
	}
}
