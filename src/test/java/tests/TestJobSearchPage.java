package tests;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.PageBase;
import base.TestBase;

public class TestJobSearchPage extends TestBase {

	@BeforeClass

	public void classSetUp() {

		menuBar.jobSearchPageLink.click();

	}

	@Test
	public void testJobSearchWithoutSelectionCategory() {

		jobsearchPage.searchButton.click();

		String resultSummary = jobsearchResultPage.searchResultSummury.getText(); 
		String currentUrl = jobsearchResultPage.getCurrentUrl();

		Assert.assertTrue(currentUrl.contains("JobCategory=-Please+Select-&submit=Search"));

		Assert.assertEquals(resultSummary, "Please Select Job Category");

	}

	@Test
	public void testJobSearchWithRandomlySelectedCategory() {

		String selectedCatotegory = jobsearchPage.processDropDownList(jobsearchPage.jobCategoryDropDownList);

		String resultSummary = jobsearchResultPage.searchResultSummury.getText();

		// System.out.println(selectedCatotegory + ";"+
		// jobsearchPage.getNumFromString(resultSummary));

		int totalJob = jobsearchPage.getNumFromString(resultSummary);
		String currentUrl = jobsearchResultPage.getCurrentUrl();

		if (totalJob == 0) {

			Assert.assertTrue(currentUrl.contains("/jobsearch"));

		} else if (totalJob > 0) {

			int maxIndex = jobsearchPage.jobTitleLinkList.size() - 1;
			int randomIndex = jobsearchPage.getRandomNumber(0, maxIndex);

			jobsearchPage.jobTitleLinkList.get(randomIndex).click();

			String jobOverView = jobDetailPage.jobOverView.getText();

			Assert.assertTrue(jobOverView.contains(selectedCatotegory));

		}

		// String currentUrl=jobsearchResultPage.getCurrentUrl()
		//
		// Assert.assertTrue(currentUrl.contains("JobCategory=-Please+Select-&submit=Search"));
		//
		// Assert.assertEquals(resultSummary, "Please Select Job Category");
		//

	}

	@AfterMethod
	void classTearDown() {
		menuBar.jobSearchPageLink.click();

	}
}
