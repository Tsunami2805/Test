package starter.navigation;

import net.thucydides.core.annotations.Step;
import starter.search.SearchFor;

public class NavigateToTiki {

    TikiHomePage tikihomepage;

    @Step("Open the Tiki home page")
    public void TikiHomePage() {
    	tikihomepage.open();
    }
    
    @Step("Accept the offer")
    public void AcceptOffer() {
    	tikihomepage.open();
    }
}
