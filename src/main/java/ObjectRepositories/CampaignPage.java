package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampaignPage {
	
	WebDriver driver;
	public CampaignPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	
	@FindBy(name="campaignName")
	private WebElement campName;
	
	@FindBy(name="campaignStatus")
	private WebElement campStatus;
	
	@FindBy(name="targetSize")
	private WebElement targetSize;
	
	@FindBy(name="expectedCloseDate")
	private WebElement expCloseDate;
	
	@FindBy(xpath="//button[text()='Create Campaign']")
	private WebElement createCampBtn;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastMsg;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closeBtn;

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getCampStatus() {
		return campStatus;
	}

	public WebElement getTargetSize() {
		return targetSize;
	}

	public WebElement getExpCloseDate() {
		return expCloseDate;
	}

	public WebElement getCreateCampBtn() {
		return createCampBtn;
	}

	public WebElement getToastMsg() {
		return toastMsg;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}
	
	
	

}
