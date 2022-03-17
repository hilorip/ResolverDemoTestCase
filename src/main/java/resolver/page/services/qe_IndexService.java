package resolver.page.services;

import recolver.base.testBase;
import resolver.page.fieldMapping.qe_Index;
import resolver.page.interfaces.*;

public class qe_IndexService extends testBase implements iQe_Index {

	/**
	 * This function will check email text box is present or not
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	@Override
	public boolean isTxtEmailPresent() throws Exception {
		// TODO Auto-generated method stub
		return isElementPresent(qe_Index.txtEmail);
	}

	/**
	 * This function will check password text box is present or not
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	@Override
	public boolean isTxtPasswordPresent() throws Exception {
		return isElementPresent(qe_Index.txtPassword);
	}

	/**
	 * This function will check sign in button present of not 
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	@Override
	public boolean isBtnSignInPresent() throws Exception {
		return isElementPresent(qe_Index.btnSignIn);
	}

	/**
	 * This function will set email id to the field
	 * @param emailId this is a value of email id
	 * @throws Exception
	 */
	@Override
	public void setTxtEmain(String emailId) throws Exception {
		sendTextToField(qe_Index.txtEmail, emailId, true);
	}

	/**
	 * This function will set password to the field
	 * @param password this is a value of password
	 * @throws Exception
	 */
	@Override
	public void setTxtPassword(String password) throws Exception {
		sendTextToField(qe_Index.txtPassword, password, true);
	}

	/**
	 * This function will click on signin button 
	 * @throws Exception
	 */
	@Override
	public void clickBtnSignIn() throws Exception {
		clickField(qe_Index.btnSignIn);
	}

	/**
	 * This funtion will count  listitems from list group
	 * @return number of list item in list group
	 * @throws Exception
	 */
	@Override
	public int countLblListGroup() throws Exception {
		return countWebElement(qe_Index.lblListgroup);
	}

	/**
	 * This function will get value of list by given list 
	 * @param lblCount = this is a value of list 
	 * @return  returns value of nth number of list
	 * @throws Exception
	 */
	@Override
	public String getLblValueFromListGroup(int lblCount) throws Exception {
		return getValueFromElementList(qe_Index.lblListgroup, lblCount).replace(getLblBadgeFromListGroup(lblCount), "");
	}

	/**
	 * This function will get value of badge by given badge value 
	 * @param lblCount = this is a value of badge 
	 * @return  returns value of nth number of badge
	 * @throws Exception
	 */
	@Override
	public String getLblBadgeFromListGroup(int lblCount) throws Exception {
		return getValueFromElementList(qe_Index.lblBadge, lblCount);
	}

	/**
	 * This function will get selected value from dropdown menue
	 * @return returns selected value from dropdown
	 * @throws Exception
	 */
	@Override
	public String getSelectedbtnDrpMenue() throws Exception {
		return getValueFromElement(qe_Index.btnDrpMenue);
	}

	/**
	 * This function will select value from dropdown menu
	 * @param optionValue this is a value to be select
	 * @throws Exception
	 */
	@Override
	public void clickLnkDrpMenuOption(String optionValue) throws Exception {
		clickField(qe_Index.btnDrpMenue);
		clickField(qe_Index.lnkDrpMenuOption(optionValue));

	}

	/**
	 * This function will check primary button is enable or not
	 * @return True : if enable, Flase: if not enable
	 * @throws Exception
	 */
	@Override
	public boolean isBtnPrimaryButtonEnable() throws Exception {
		return isElementEnable(qe_Index.btnPrimaryButton);
	}

	/**
	 * This function will check Secondary button is enable or not
	 * @return True : if enable, Flase: if not enable
	 * @throws Exception
	 */
	@Override
	public boolean isBtnSecondaryButtonEnable() throws Exception {
		return isElementEnable(qe_Index.btnSecondaryButton);
	}

	/**
	 * This funcrion will click button from test 5
	 * @throws Exception
	 */
	@Override
	public void clickBtnTest5Button() throws Exception {
		clickField(qe_Index.btnTest5Button);

	}

	/**
	 * This  funtion will get alert text
	 * @return return alert text
	 * @throws Exception
	 */
	@Override
	public String getLblButtonAlertText() throws Exception {
		return getValueFromElement(qe_Index.lblButtonAlertText);
	}

	/**
	 * This funtion will check button from test 5 is enable or not 
	 * @return true : if enable . False : if not enable
	 * @throws Exception
	 */
	@Override
	public boolean isBtnTest5ButtonEnable() throws Exception {
		return isElementEnable(qe_Index.btnTest5Button);
	}

	/**
	 * This function allow user to get data with  row and column cordinates from webtable
	 * @param row this is a value of row cordinates
	 * @param col this is a valu of column cordinates
	 * @return return text of cell from data table
	 * @throws Exception
	 */
	public String getDataFromTable(int row, int col) throws Exception {
		return getValueFromElement(qe_Index.dtRowColumnValue(row + 1, col + 1));
	}
}