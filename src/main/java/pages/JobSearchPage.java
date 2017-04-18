package pages;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.PageBase;

public class JobSearchPage extends PageBase{
	
	@FindBy(name = "JobCategory")
	public WebElement jobCategoryDropDownList;
	
	@FindBy(name = "submit")
	public WebElement searchButton;
	
	// new job Feature
	@FindBy(xpath = ".//*[@id='job_title_style']/a")
	public List <WebElement> jobTitleLinkList;
	

	public String processDropDownList(WebElement element) {
		String category = randomlySelectFromDropdownList(element);
		searchButton.click();

		
		return category;
		
	}
	
	
	
	
	
	

}
