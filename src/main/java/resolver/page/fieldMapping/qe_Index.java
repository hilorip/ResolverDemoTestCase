package resolver.page.fieldMapping;

import org.openqa.selenium.By;

import recolver.base.testBase;

public  class qe_Index extends testBase {
	
	public static By txtEmail = By.xpath("//input[@id='inputEmail']");
	public static By txtPassword = By.xpath("//input[@id='inputPassword']");
	public static By btnSignIn = By.xpath("//button[contains( text(),'Sign in')]");
	public static By lblListgroup = By.xpath("//ul[@class='list-group']/li");
	public static By lblBadge = By.xpath("//ul[@class='list-group']/li/span");
	public static By btnDrpMenue = By.xpath("//button[@id='dropdownMenuButton']");
	public static By btnPrimaryButton = By.xpath("//div[@id='test-4-div']/button[@class='btn btn-lg btn-primary']");
	public static By btnSecondaryButton = By.xpath("//div[@id='test-4-div']/ button[@class='btn btn-lg btn-secondary']");
	public static By btnTest5Button = By.xpath("//div[@id='test-5-div']/ button");
	public static By lblButtonAlertText = By.xpath("//div[@id='test5-alert']");
	public static By lnkDrpMenuOption(String optionValue)
	{
		return By.xpath("//div[contains(@class,'dropdown')]/button[@id='dropdownMenuButton']/following-sibling :: div/a[contains(text(),'"+optionValue+"')]");
	}
	
	public static By dtRowColumnValue(int rowValue, int columnValue)
	{
		return By.xpath("//div[@id='test-6-div']//table//tbody//tr["+rowValue+"]//td["+columnValue+"]");
	}
}
