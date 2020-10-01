package starter.search;

import org.openqa.selenium.By;

class SearchResultList {
    //Search
	static By RESULT_TITLES = By.xpath("//p[@class='title']");
    static By SEARCH_RESULT_STR = By.xpath("//div[@class='filter-list-box']/h1[1]");
    
    //Tiki
    static By TIKI_NOW_CHECKBOX = By.xpath("//label[@class='checkbox is-tikinow']/span[@class='ico' and 1]");
    static By TIKI_NOW_CONFIRM_CHECK = By.xpath("//*[@id=\"pre-location-picker-modal\"]/div/div[3]/div/button");
    static By TIKI_NOW_CITY_SELECT = By.xpath("//*[@id=\"location-picker-modal\"]/div/div[2]/div[2]/div[2]/div/div[1]/div/select");
    static By TIKI_NOW_DIST_SELECT = By.xpath("//*[@id=\"location-picker-modal\"]/div/div[2]/div[2]/div[2]/div/div[2]/div/select");
    static By TIKI_NOW_WARD_SELECT = By.xpath("//*[@id=\"location-picker-modal\"]/div/div[2]/div[2]/div[2]/div/div[3]/div/select");
    static By TIKI_NOW_CONFIRM_SELECTED_LOCATION = By.xpath("//*[@id=\"location-picker-modal\"]/div/div[3]/div/button");
    static By TIKI_NOW_ENABLED = By.xpath("//div[@class='filter-items']/p[1]");
    
    //TIKI item details
    static By TIKI_ITEM_COUNT = By.xpath("//input[@class='input']");
    static By TIKI_ADD_TO_CART = By.xpath("//button[@class='btn btn-add-to-cart']");
    static By TIKI_CART_BTN = By.xpath("//div[@class='Userstyle__Item-sc-6e6am-1 dFYIFY']/span[@class='Userstyle__ItemText-sc-6e6am-2 gGRKbG' and 1]");
    
  
    static By TIKI_ITEM_DISCOUNTED_PRICE = By.xpath("//div/p[@class='price' and 1]");
    static By TIKI_VIEW_CART_BTN = By.xpath("//a[@class='btn-view-cart']");
    static By TIKI_CART_TOTAL_PRICE = By.xpath("//span[@class='prices__value prices__value--final']");
    static By TIKI_CART_ITEM_PRICE = By.xpath("//p[@class='cart-products__real-prices']");
  
    static By TIKI_CANT_ADD_MORE_THAN_1 = By.xpath("//div[@class='SnackBar__Wrapper-cdh0b2-0 fKKvZy']");
  
    
  
    
}