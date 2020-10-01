package starter.search;

import org.openqa.selenium.By;

class SearchForm {
    
	static By SEARCH_FIELD = By.xpath("//*[not(contains(@style,'display:none'))]//input[@class='FormSearch__Input-sc-1fwg3wo-2 eUnWAD']");
    static By SEARCH_BUTTON = By.xpath("//*[not(contains(@style,'display:none'))]//button[@class='FormSearch__Button-sc-1fwg3wo-3 ieXBRV']");
    
    
//   To-do Relocate these
    static By OFFER_DECLINE_BUTTON = By.xpath("//*[@id=\"slidedown-footer\"]/*[2]");
    static By OFFER_ACCEPT_BUTTON = By.xpath("//*[@id=\"slidedown-footer\"]/*[1]");
    
}
