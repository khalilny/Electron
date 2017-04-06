package base;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class PageBase extends Driver {

	public String getCurrentUrl() {
		
		return driver.getCurrentUrl();
	}

	// All suporting method should be write here different scenerio

	/**write a method that take a dropdownList WebElement and select option randomly
	 */
	
	public static void randomlySelectFromDropdownList( WebElement dropdownList ) {
        Select select = new Select(dropdownList);
        List<WebElement> optionsList = select.getOptions();
        
        int minIndex = 1;
        int maxIndex = optionsList.size() - 1;
        Random random = new Random();
        int randomIndex = random.nextInt( maxIndex - minIndex + 1 ) + minIndex;
       
        select.selectByIndex(randomIndex);
     
        
	}
        
        
        
        
        
    
	
	
	
	
	
}
