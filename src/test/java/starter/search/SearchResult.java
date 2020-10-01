package starter.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.core.steps.UIInteractionSteps;
import net.thucydides.core.annotations.Step;
import static org.assertj.core.api.Assertions.assertThat;
import static starter.matchers.TextMatcher.textOf;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import groovy.util.logging.Log;

public class SearchResult extends UIInteractionSteps {
    
    @Step("The search result should contain the keyword {0}")
	public void result_contains(String term) {

//      Giang note: Due to the natural of automation testing is to replace actions of end user,
//      The verification process of the correct results for {string} would be checking the following:
//		1. Preview image of said {string} product
//		2. Title of said {string product
//		Option 1 is technically not possible considering blackbox testing,
//		Option 2 is do-able but 
//    	- Some title return a partial string : "Tai nghe nhét tai có dây Jack c?m 3.5mm có..." which does not contains {string} at all.
//		- Verifying using "Tai nghe nhét tai có dây Jack c?m 3.5mm có" + apple does not work because it's too generic.
//    	- Open/hovers 50 or so times on each results is not practical
//		Then the optimal solution for end user would be viewing each result at a time, for example open 50 first result to see if it's what they want.
//		Conclusion: I will do the "verifying if the user properly get to the search page" method  for now.

		
//    	Result for comparing titles with {string}
//		assertThat(searchResult.titles()).allMatch(title -> textOf(title).containsIgnoringCase(expectedTerm));
//		System.out.println(searchResult.titles());
//		System.out.println("Giang coi: " + searchResult.search_result_str());
    	
    	
    	String a = find(SearchResultList.SEARCH_RESULT_STR).getText();
		assertThat(a).matches(search_result_str -> textOf(search_result_str).containsIgnoringCase(term));
		
	}
    
    @Step("He picked city {0}, district {1}, ward {2} on tiki now for fast delivery")
	public void select_checkbox_tiki_now(String city, String district, String ward) {
    	System.out.println("Giang coi print : " + city + district + ward);
    	$(SearchResultList.TIKI_NOW_CHECKBOX).click();
    	if ($(SearchResultList.TIKI_NOW_CONFIRM_SELECTED_LOCATION).isCurrentlyVisible()) {
			return;
		}
    	else {
    		$(SearchResultList.TIKI_NOW_CONFIRM_CHECK).click();
    		$(SearchResultList.TIKI_NOW_CITY_SELECT).selectByVisibleText(city);
        	$(SearchResultList.TIKI_NOW_DIST_SELECT).selectByVisibleText(district);
        	$(SearchResultList.TIKI_NOW_WARD_SELECT).selectByVisibleText(ward);
        	$(SearchResultList.TIKI_NOW_CONFIRM_SELECTED_LOCATION).click();
    	}
    }
    
    @Step("He selected the {0} th item on the result")
	public void select_item_from_search_result(int num) {
    	//passing dynamic value into xpath
    	By TIKI_PICK_ITEM_FROM_RESULT = By.xpath("/html/body/div[10]/div/div[2]/div[2]/div[3]/div[" + num + "]");
    	By TIKI_ITEM_FROM_RESULT_REGULAR_PRICE = By.xpath("/html/body/div[10]/div/div[2]/div[2]/div[3]/div[" + num +  "]//span[@class=\"price-regular\"]");
    	By TIKI_ITEM_DETAILS_REGULAR_PRICE = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[3]/div/div[2]/div[2]/div[1]/div[1]/div[2]/p[2]");
    	
    	String a = $(TIKI_ITEM_FROM_RESULT_REGULAR_PRICE).getText().toString();
    	$(TIKI_PICK_ITEM_FROM_RESULT).click();
//    	By TIKI_PICK_ITEM_FROM_RESULT_DETAILS = By.xpath("//*[@id=\"__next\"]/div[1]/main/div[3]/div/div[2]/div[1]/h1");
    	String b = $(TIKI_ITEM_DETAILS_REGULAR_PRICE).getText().toString();
    	
    	
    	String a_filtered = a.replaceAll("[^\\d.]", "");
    	String b_filtered = b.replaceAll("[^\\d.]", "");
    	try {
    		assertThat(b_filtered).contains(a_filtered);
		} catch (Exception ex) {
			// TODO: handle exception
			ex.getStackTrace();
		}
    	
    }
    
    @Step("He increased the item counts to {0}")
	public void increase_the_item_count(int num) {
    	
    		$(SearchResultList.TIKI_ITEM_COUNT).clear();
            $(SearchResultList.TIKI_ITEM_COUNT).sendKeys(String.valueOf(num));
            $(SearchResultList.TIKI_ADD_TO_CART).click();
            if ($(SearchResultList.TIKI_NOW_CONFIRM_SELECTED_LOCATION).isCurrentlyEnabled()) {
            	$(SearchResultList.TIKI_ITEM_COUNT).clear();
                $(SearchResultList.TIKI_ITEM_COUNT).sendKeys(String.valueOf(num));
                $(SearchResultList.TIKI_ADD_TO_CART).click();
			}
            else {
            	return;
			}
    }
    
    @Step("He added {0} items to the cart and verify the price ")
	public void add_item_to_the_cart(int num) {
    	String a = $(SearchResultList.TIKI_ITEM_DISCOUNTED_PRICE).getText();
    	$(SearchResultList.TIKI_VIEW_CART_BTN).click();
    	String b = $(SearchResultList.TIKI_CART_TOTAL_PRICE).getText();
    	String a_filtered = a.replaceAll("[^0-9]","");
    	String b_filtered = b.replaceAll("[^0-9]","");
    	
    	int a_int = Integer.parseInt(a_filtered);  
    	int b_int  = Integer.parseInt(b_filtered);
    	System.out.println("Log giang 666  :" + a_int + " " + b_int);
    	
//    	assertThat((a_int)*num).isEqualTo(b_int);
    	assertThat(a_int*num == b_int).isTrue();

    }
    
    
    
    // Unused for now
    public List<String> titles() {
        return findAll(SearchResultList.RESULT_TITLES)
                .stream()
                .map(WebElementFacade::getTextContent)
                .filter(text -> !text.equalsIgnoreCase("Ad"))
                .collect(Collectors.toList());
    }
}
