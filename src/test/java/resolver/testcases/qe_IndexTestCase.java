package resolver.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import recolver.base.testBase;
import resolver.page.services.qe_IndexService;

public class qe_IndexTestCase extends testBase {
	qe_IndexService objQe_IndexService;

	public qe_IndexTestCase() {
		super();
	}

	@BeforeMethod
	public void setUp() {
		objQe_IndexService = new qe_IndexService();
	}

	@Test
	public void Test1() throws Exception {
		// 1. Navigate to Home Page
		initialization();

		// Assert that email, password and sign in button is displaying on the page
		Assert.assertTrue(
				objQe_IndexService.isTxtEmailPresent() && objQe_IndexService.isTxtPasswordPresent()
						&& objQe_IndexService.isBtnSignInPresent(),
				"Email address and password text box should present");

		// Enter emailid, password
		objQe_IndexService.setTxtEmain(("hilori.patel@gmail.com"));
		objQe_IndexService.setTxtPassword(("test@123"));
		objQe_IndexService.clickBtnSignIn();

	}

	@Test
	public void Test2() throws Exception {
		// 1. Navigate to Home Page
		initialization();
		
		// 2.In the test 2 div, assert that there are three values in the listgroup
		Assert.assertEquals(objQe_IndexService.countLblListGroup(), 3, "there should be 3 list in the list group");

		// 3.Assert that the second list item's value is set to "List Item 2"
		Assert.assertEquals(objQe_IndexService.getLblValueFromListGroup(2), "List Item 2 ",
				"List Item 2  should be present in  seconf list item");

		// 4.Assert that the second list item's badge value is 6
		Assert.assertEquals(objQe_IndexService.getLblBadgeFromListGroup(2), "6",
				"6  should be present in  seconf list item");
	}

	@Test
	public void Test3() throws Exception {
		// 1. Navigate to Home Page
		initialization();
		
		// 2.assert that "Option 1" is the default selected value
		Assert.assertEquals(objQe_IndexService.getSelectedbtnDrpMenue(), "Option 1");
		
		// 3.Select "Option 3" from the select list
		objQe_IndexService.clickLnkDrpMenuOption("Option 3");
		
		// 4. assert that "Option 3" is the current selected value
		Assert.assertEquals(objQe_IndexService.getSelectedbtnDrpMenue(), "Option 3");
	}

	@Test
	public void Test4() throws Exception {
		// 1. Navigate to Home Page
		initialization();
		
		// 2. assert that the first button is enabled and that the second button is
		// disabled
		Assert.assertTrue(objQe_IndexService.isBtnPrimaryButtonEnable(), "Primary Button should be enable default");
		Assert.assertFalse(objQe_IndexService.isBtnSecondaryButtonEnable(),
				"Secondary button should be disable by default");
	}

	@Test
	public void Test5() throws Exception {
		// 1. Navigate to Home Page
		initialization();
		
		// 2.wait for a button to be displayed (note: the delay is random) and then
		// click it
		objQe_IndexService.clickBtnTest5Button();
		
		// 3. assert that a success message is displayed
		Assert.assertEquals(objQe_IndexService.getLblButtonAlertText(), "You clicked a button!",
				"sucess message should display");
		
		// 4.Assert that the button is now disabled
		Assert.assertFalse(objQe_IndexService.isBtnTest5ButtonEnable(), "Button should disable after click");
	}

	@Test
	public void Test6() throws Exception {
		// 1. Navigate to Home Page
		initialization();
		
		// 2 find the value of the cell at coordinates 2, 2 (staring at 0 in the top
		// left corner)
		String myCellValue = objQe_IndexService.getDataFromTable(2, 2);
		System.out.println("cell at coordinates 2, 2 is : " + myCellValue);
		
		// 3.Assert that the value of the cell is "Ventosanzap"
		Assert.assertEquals(myCellValue, "Ventosanzap", "value of the cell at coordinates 2, 2 should be Ventosanzap");

	}

	@AfterMethod
	public void TearDown() {
		driver.quit();
	}
}