package resolver.page.interfaces;

public interface iQe_Index {

	/**
	 * This function will check email text box is present or not
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	boolean isTxtEmailPresent() throws Exception;
	
	/**
	 * This function will check password text box is present or not
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	boolean isTxtPasswordPresent() throws Exception;
	
	/**
	 * This function will check sign in button present of not 
	 * @return true: if present --> false if not present
	 * @throws Exception
	 */
	boolean isBtnSignInPresent() throws Exception;
	
	/**
	 * This function will set email id to the field
	 * @param emailId this is a value of email id
	 * @throws Exception
	 */
	void setTxtEmain(String emailId) throws Exception;
	
	/**
	 * This function will set password to the field
	 * @param password this is a value of password
	 * @throws Exception
	 */
	void setTxtPassword(String password) throws Exception;
	
	/**
	 * This function will click on signin button 
	 * @throws Exception
	 */
	void clickBtnSignIn() throws Exception;
	
	/**
	 * This funtion will count  listitems from list group
	 * @return number of list item in list group
	 * @throws Exception
	 */
	int countLblListGroup()throws Exception;
	
	/**
	 * This function will get value of list by given list 
	 * @param lblCount = this is a value of list 
	 * @return  returns value of nth number of list
	 * @throws Exception
	 */
	String getLblValueFromListGroup(int lblCount) throws Exception;
	
	/**
	 * This function will get value of badge by given badge value 
	 * @param lblCount = this is a value of badge 
	 * @return  returns value of nth number of badge
	 * @throws Exception
	 */
	String getLblBadgeFromListGroup(int lblCount) throws Exception;
	
	/**
	 * This function will get selected value from dropdown menue
	 * @return returns selected value from dropdown
	 * @throws Exception
	 */
	String getSelectedbtnDrpMenue() throws Exception;
	
	/**
	 * This function will select value from dropdown menu
	 * @param optionValue this is a value to be select
	 * @throws Exception
	 */
	void clickLnkDrpMenuOption(String optionValue) throws Exception;
	
	/**
	 * This function will check primary button is enable or not
	 * @return True : if enable, Flase: if not enable
	 * @throws Exception
	 */
	boolean isBtnPrimaryButtonEnable() throws Exception;
	
	/**
	 * This function will check Secondary button is enable or not
	 * @return True : if enable, Flase: if not enable
	 * @throws Exception
	 */
	boolean isBtnSecondaryButtonEnable() throws Exception;
	
	/**
	 * This funcrion will click button from test 5
	 * @throws Exception
	 */
	void clickBtnTest5Button() throws Exception;
	
	/**
	 * This  funtion will get alert text
	 * @return return alert text
	 * @throws Exception
	 */
	String getLblButtonAlertText() throws Exception;
	
	/**
	 * This funtion will check button from test 5 is enable or not 
	 * @return true : if enable . False : if not enable
	 * @throws Exception
	 */
	boolean isBtnTest5ButtonEnable() throws Exception;
	
	/**
	 * This function allow user to get data with  row and column cordinates from webtable
	 * @param row this is a value of row cordinates
	 * @param col this is a valu of column cordinates
	 * @return return text of cell from data table
	 * @throws Exception
	 */
	String getDataFromTable(int row,int col) throws Exception;

}
