package ObjectRepositories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage {
	
	WebDriver driver;
	public ProductPage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	@FindBy(xpath="//span[text()='Add Product']")
	private WebElement addProductLink;
	
	@FindBy(name="productName")
	private WebElement prodName;
	
	@FindBy(name="quantity")
	private WebElement quantity;
	
	@FindBy(name="price")
	private WebElement price;
	
	@FindBy(name="productCategory")
	private WebElement productCat;
	
	@FindBy(name="vendorId")
	private WebElement vendorId;
	
	@FindBy(xpath="//button[text()='Add']")
	private WebElement addProduct;
	
	@FindBy(xpath="//div[@role='alert']")
	private WebElement toastMsg;
	
	@FindBy(xpath="//button[@aria-label='close']")
	private WebElement closeBtn;
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement getAddProductLink() {
		return addProductLink;
	}

	public WebElement getProdName() {
		return prodName;
	}

	public WebElement getQuantity() {
		return quantity;
	}

	public WebElement getPrice() {
		return price;
	}

	public WebElement getProductCat() {
		return productCat;
	}

	public WebElement getVendorId() {
		return vendorId;
	}

	public WebElement getAddProduct() {
		return addProduct;
	}

	public WebElement getToastMsg() {
		return toastMsg;
	}

	public WebElement getCloseBtn() {
		return closeBtn;
	}
	
	
	
	

}
