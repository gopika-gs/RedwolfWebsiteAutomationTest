package pagepkg;

import java.time.Duration;
import com.github.javafaker.Faker;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RedwolfPage {

	WebDriver driver;
	WebDriverWait wait;
	
	//website logo
	@FindBy(xpath="//*[@id=\"header-logo\"]")
	WebElement logo;
	//login link on the home page 
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/a")
	WebElement loginLink;
	//register link on the login popup
	@FindBy(xpath="//div[11]/div/div[@class=\"login-heads\"]/a[@class=\"register-here\"]")
	WebElement registerLink;
	//firstname on the register form 
	@FindBy(xpath="//*[@id='input-firstname']")
	WebElement registerFirstname;
	//lastname on the register form 
	@FindBy(xpath="//*[@id='input-lastname']")
	WebElement registerLatname;
	//email on the register form
	@FindBy(xpath="//*[@id='input-email']")
	WebElement regemail;
	//phonenumber on the register form
	@FindBy(xpath="//*[@id='input-telephone']")
	WebElement regphoneNumber;
	//password filed on the register form 
	@FindBy(xpath="//*[@id='input-password']")
	WebElement regpassword;
	//confirm password on register form 
	@FindBy(xpath="//*[@id='input-confirm']")
	WebElement regconfirmPassword;
	//newsletter radio button on the register form 
	@FindBy(xpath="//*[@id='register-form']/div[7]/div[2]/label[2]/input[@name='newsletter']")
	WebElement regnewsletterRadiobutton;
	//submit button on the register form 
	@FindBy(xpath="//*[@id=\"register-button\"]")
	WebElement registerSubmitButton;
	//error message on the register form 
	@FindBy(xpath="//div[@class='text-danger']")
	WebElement regerrorMessage;
	//otp field of register form
	@FindBy(xpath="//*[@id=\"code\"]")
	WebElement registerOtp;
	//email on the login form
	@FindBy(xpath="//*[@id='email']")
	WebElement loginEmail;
	//password on the login form
	@FindBy(xpath="//*[@id='password']")
	WebElement loginpassword;
	//login button on the login form 
	@FindBy(xpath="//*[@id='login-button']")
	WebElement loginButton;
	//error message on the login form
	@FindBy(xpath="//*[@id='login-form']/div[1]")
	WebElement loginErrorMessage;
	//account page heading
	@FindBy(xpath="//*[@class='account_content_container']")
	WebElement accountHeading;
	//search input field on the home page
	@FindBy(xpath="//div[8]/form/input[@name='search']")
	WebElement searchField;
	//selecting the first product from the search result
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]")
	WebElement firstProduct;
	//title of the product in product detail page
	@FindBy(xpath="//*[@id=\"product-container\"]/div[@class='product-info-container']/div[3]/h2")
	WebElement titleofProduct;
	//dropdown menu from the home page dropdown
	@FindBy(xpath="//div[7]/div[4]/div/div[1]")
	WebElement dopdownMenu;
	//catagory in the homepage;
	@FindBy(xpath="//*[@id=\"featured-themes-carousel\"]/div[1]/div/div[4]/div/a[1]")
	WebElement category;
	//product from the category
	@FindBy(xpath="//div[@class='category-product-container official_merch_box']//div[@class=\"product-image page_no\"]/a")
	WebElement product;
	//colour on the product detail page
	@FindBy(xpath="//*[@id=\"product-container\"]/div[2]/div[3]/div[3]/div[1]/select")
	WebElement colorDropdown;
	//selecting the color of the prodiuct
	@FindBy(xpath="//*[@id=\"product-container\"]/div[2]/div[3]/div[3]/div[1]/select/option[3]")
	WebElement color;
	//size from the product detail page
	@FindBy(xpath="//*[@class='product-option']//div[2]//div[2]")
	WebElement productSize;
	//Clicking the quality dropdown in product detail page 
	@FindBy(xpath="//*[@id=\"select-quantity\"]")
	WebElement quantityDropdown;
	//selecting an option from dropdown options
	@FindBy(xpath="//*[@id=\"select-quantity\"]/option[3]")
	WebElement quantity;
	//add to cart button
	@FindBy(xpath="//*[@id=\"add-to-cart-btn\"]")
	WebElement addtocartButton;
	//view cart popup
	@FindBy(xpath="//*[@id=\"popup-view-cart-btn\"]")
	WebElement viewcart;
	//checkout Button
	@FindBy(xpath="//*[@id=\"content\"]/form/div[2]/div[6]/span")
	WebElement checkoutButton;
	//already added address
	@FindBy(xpath="//*[@id=\"shipping-existing\"]/div[1]/div")
	WebElement defaultAddress;
	//add address 
	@FindBy(xpath="//*[@id=\"collapse-payment-address\"]/div/form/div[1]/div[2]/div[2]/div/button")
	WebElement addaddress;
	//address pop up
	@FindBy(xpath="//*[@id=\"payment-new\"]/div[2]")
	WebElement addressPopup;
	//first name on the address field
	@FindBy(xpath="//*[@id=\"input-payment-firstname\"]")
	WebElement addressfirstnamefield;
	//last name on the address field
	@FindBy(xpath="//*[@id=\"input-payment-lastname\"]")
	WebElement addresslastnamefield;
	//address on the address pop up
	@FindBy(xpath="//*[@id=\"input-payment-address-1\"]")
	WebElement addressfield;
	//city field on the address pop up
	@FindBy(xpath="//*[@id=\"input-payment-city\"]")
	WebElement cityfield;
	//postcode field on the address pop up
	@FindBy(xpath="//*[@id=\"input-payment-city\"]")
	WebElement postcodefield;
	//country dropdown
	@FindBy(xpath="//*[@id=\"input-payment-country\"]")
	WebElement countrydropdown;
	//country option from the dropdown
	@FindBy(xpath="//*[@id=\"input-payment-country\"]/option[2]")
	WebElement countryoption;
	//state dropdown 
	@FindBy(xpath="//*[@id=\"input-payment-zone\"]")
	WebElement statedropdown;
	//state option
	@FindBy(xpath="//*[@id=\"input-payment-zone\"]/option[19]")
	WebElement stateoption;
	//telephone field on the address pop up
	@FindBy(xpath="//*[@id=\"input-payment-custom-field2\"]")
	WebElement telephone;
	//submit button on the address pop up
	@FindBy(xpath="//*[@id=\"button-payment-address_form\"]")
	WebElement submitButton;
	//countinue button on the cart page
	@FindBy(xpath="//div[@class='pull-right']//span[text()='Checkout']")
	WebElement cartCountinue;
	//countinue button on cheaout address page
	@FindBy(xpath="//*[@id=\"button-continue-payment_big\"]")
	WebElement countinueButtonOnaddresspage;
	//countinue button on the paymane page
	@FindBy(xpath="//input[@value='Continue']")
	WebElement countinueButtonOnPaymentPage;
	//order confirm button
	@FindBy(xpath="//*[@id=\"button-confirm\"]")
	WebElement orderconfirm;
	//account dropdown
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/div[@class='dropdown']")
	WebElement accountdropdown;
	//wishlist from account dropdown
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/div/div/ul/a[2]")
	WebElement wishlist;
	//Adding the product to the sishlist
	@FindBy(xpath="//*[@id=\"product-container\"]/div[2]/div[3]/button")
	WebElement addtowishlist;
	//remove the product from wishlist
	@FindBy(xpath="//*[@id=\"content\"]/div[1]/div/div[2]/div/button")
	WebElement remove;
	//logout
	@FindBy(xpath="//*[@id=\"login-modal-button\"]/div/div/ul/a[5]/li")
	WebElement logout;

	public RedwolfPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	public void logo() {
		System.out.println("Checking wether the logo is redirecting to the home page =  ");
		logo.click();
		String expectedRedirectingUrl = "https://www.redwolf.in/";
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.equals(expectedRedirectingUrl)) {
			System.out.println("passed");
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			System.out.println("Failed");
		}
	}
	
	public void register() {
		System.out.println("Checking whether the register is working =   ");
		logo.click();
		String firstName = randomName();
        String lastName = randomName();
        String phone = randomPhoneno();
        String email = randomEmail();
        String password = randomPassword();
		wait.until(ExpectedConditions.visibilityOf(loginLink));
		loginLink.click();
		wait.until(ExpectedConditions.visibilityOf(registerLink));
		registerLink.click();
		wait.until(ExpectedConditions.visibilityOf(registerFirstname));
		registerFirstname.sendKeys(firstName);
		registerLatname.sendKeys(lastName);
		regphoneNumber.sendKeys(phone);
		regemail.sendKeys(email);
		regpassword.sendKeys(password);
		regconfirmPassword.sendKeys(password);
		
		if(regconfirmPassword != regpassword) {
			System.out.println("The password is not matching");
		}
        if (!regnewsletterRadiobutton.isSelected()) {
        	regnewsletterRadiobutton.click();
        }
        
        wait.until(ExpectedConditions.visibilityOf(registerSubmitButton));
        registerSubmitButton.click();
        System.out.println("If captcha uppears, try to solve it mannually");
        try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        
        if(registerOtp.isDisplayed()) {
        	System.out.println("passed");
        	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }else {
        	System.out.println("failed");
        }
	}
	
	public void loginusingDataDriven(String email, String password) {
		System.out.println("Checking whether the login is working  =   ");
		loginLink.click();
		wait.until(ExpectedConditions.visibilityOf(loginEmail));
		loginEmail.clear();
		loginEmail.sendKeys(email);
		loginpassword.clear();
		loginpassword.sendKeys(password);
		loginButton.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean urlContainsAccount = false;
        int attempts = 0;
        while (!urlContainsAccount && attempts < 10) {
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/account")) {
                urlContainsAccount = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            attempts++;
        }
        if(urlContainsAccount) {
        	System.out.println("passed");
        	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }else {
        	System.out.println("failed");
        }
       
	}
	
	public void login() {
		System.out.println("Check weather the login is working or not =   ");
		logo.click();
		loginLink.click();
		wait.until(ExpectedConditions.visibilityOf(loginEmail));
		loginEmail.clear();
		loginEmail.sendKeys("gsgopika00@gmail.com");
		loginpassword.clear();
		loginpassword.sendKeys("123456789@gopika");
		loginButton.click();
		try {
			Thread.sleep(8000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		boolean urlContainsAccount = false;
        int attempts = 0;
        while (!urlContainsAccount && attempts < 10) {
            String currentUrl = driver.getCurrentUrl();
            if (currentUrl.contains("/account")) {
                urlContainsAccount = true;
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            attempts++;
        }
        if(urlContainsAccount) {
        	System.out.println("passed");
        	try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
        }else {
        	System.out.println("failed");
        }
	}
	
	public void search() {
		System.out.println("Checking wether the search is working properly =   ");
		wait.until(ExpectedConditions.visibilityOf(searchField));
		searchField.sendKeys("shirt");
		searchField.sendKeys(Keys.ENTER);
		wait.until(ExpectedConditions.visibilityOf(firstProduct));
		firstProduct.click();
		if(titleofProduct.isDisplayed()) {
			System.out.println("passed");
			try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}else {
			System.out.println("failed");
		}
	}
	
	public void homePageDropdown() {
		System.out.println("Checking wether the home dropdown is working properly   =  ");
		Actions actions = new Actions(driver);
		actions.moveToElement(dopdownMenu).perform();
		WebElement dropdownOption = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[7]/div[4]/div/div[3]/div/div/div/ul/li[1]/a")));
	    dropdownOption.click();
	    System.out.println("passed");
	    try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public void addtocart() {
		logo.click();
		System.out.println("Checking wether the add to cart function is  working properly  =   ");
		category.click();
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		wait.until(ExpectedConditions.visibilityOf(colorDropdown));
		colorDropdown.click();
		wait.until(ExpectedConditions.visibilityOf(color));
		color.click();
		productSize.click();
		quantityDropdown.click();
		quantity.click();
		addtocartButton.click();
		wait.until(ExpectedConditions.visibilityOf(viewcart));
		viewcart.click();
		String ExpectedRedirectingUrl = "https://www.redwolf.in/index.php?route=checkout/cart";
		String actualUrl = driver.getCurrentUrl();
		if(actualUrl.equals(ExpectedRedirectingUrl)) {
			System.out.println("passed");
			try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}else {
			System.out.println("failed");
		}
	}
	
	public void checkout() {
		System.out.println("Checking wether the cheakout function is  working properly   =  ");
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", cartCountinue);
        wait.until(ExpectedConditions.visibilityOf(cartCountinue));
		cartCountinue.click();
		wait.until(ExpectedConditions.visibilityOf(defaultAddress));
		if(defaultAddress.isDisplayed()) {
			wait.until(ExpectedConditions.visibilityOf(countinueButtonOnaddresspage));
			countinueButtonOnaddresspage.click();
			wait.until(ExpectedConditions.visibilityOf(countinueButtonOnPaymentPage));
			countinueButtonOnPaymentPage.click();
			wait.until(ExpectedConditions.visibilityOf(orderconfirm));
			orderconfirm.click();
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}else {
			String firstName = randomName();
	        String lastName = randomName();
	        Faker faker = new Faker();
	        String streetAddress = faker.address().streetAddress();
	        String city = faker.address().city();
	        String postcode = faker.address().zipCode();
			checkoutButton.click();
			wait.until(ExpectedConditions.visibilityOf(addaddress));
			addaddress.click();
			wait.until(ExpectedConditions.visibilityOf(addressPopup));
			addressPopup.click();
			addressfirstnamefield.sendKeys(firstName);
			addresslastnamefield.sendKeys(lastName);
			addressfield.sendKeys(streetAddress);
			cityfield.sendKeys(city);
			postcodefield.sendKeys(postcode);
			countrydropdown.click();
			wait.until(ExpectedConditions.visibilityOf(countryoption));
			countryoption.click();
			statedropdown.click();
			wait.until(ExpectedConditions.visibilityOf(stateoption));
			stateoption.click();
			telephone.sendKeys(randomPhoneno());
			submitButton.click();
			wait.until(ExpectedConditions.visibilityOf(countinueButtonOnaddresspage));
			countinueButtonOnaddresspage.click();
			wait.until(ExpectedConditions.visibilityOf(countinueButtonOnPaymentPage));
			countinueButtonOnPaymentPage.click();
			wait.until(ExpectedConditions.visibilityOf(orderconfirm));
			orderconfirm.click();
		}
		String redirectingUrl = "https://api.cashfree.com/checkout";
		if(driver.getCurrentUrl().equals(redirectingUrl)){
			System.out.println("passed");
			try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}else {
			System.out.println("failed");
		}
		
	}
	
	public void wishlist() {
		System.out.println("Checking wheather the wishlist is working as expected  =   ");
		logo.click();
		category.click();
		wait.until(ExpectedConditions.visibilityOf(product));
		product.click();
		wait.until(ExpectedConditions.visibilityOf(addtowishlist));
		addtowishlist.click();
	 	Actions actions = new Actions(driver);
        actions.moveToElement(accountdropdown).perform();
        wishlist.click();
        try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
        System.out.println("passed");
	}
	
	public void removePrdocuFromWishlist() {
		System.out.println("Checking wheather the product can be removed from the wishlist    =   ");
		Actions actions = new Actions(driver);
        actions.moveToElement(accountdropdown).perform();
        wishlist.click();
		wait.until(ExpectedConditions.visibilityOf(remove));
		remove.click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("passed");
	}
	
	public void logout() {
		System.out.println("Checking wether the logout function is working properly  =   ");
		String redirectingUrl = "https://www.redwolf.in/";
		Actions actions = new Actions(driver);
        actions.moveToElement(accountdropdown).perform();
    	wait.until(ExpectedConditions.visibilityOf(logout));
        logout.click();
        if(driver.getCurrentUrl().equals(redirectingUrl)){
        	System.out.println("passed");
			try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
		}else {
			System.out.println("failed");
		}
        
	}
	
	public static String randomName() {
		String characters = "abcdefghijklnmopqrstuvwxyz";
		Random random = new Random();
		StringBuilder name = new StringBuilder();
        for (int i = 0; i < 7; i++) {
        	name.append(characters.charAt(random.nextInt(characters.length())));
        }
        return name.toString();
	}
	
	public static String randomEmail() {
		String characters = "abcdefghijklnmopqrstuvwxyz";
		String numbers = "0123456789";
		Random random = new Random();
		StringBuilder email = new StringBuilder();
        for (int i = 0; i < 7; i++) {
        	email.append(characters.charAt(random.nextInt(characters.length())));
        }
        for (int i = 0; i < 3; i++) {
            email.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        email.append("@gmail.com");
        return email.toString();
	}
	
	public static String randomPhoneno() {
		Random random = new Random();
		StringBuilder phonenumber = new StringBuilder("9");
		for (int i = 1; i < 10; i++) {
			phonenumber.append(random.nextInt(10)); 
	    }
		return phonenumber.toString();
	}
	
	public static String randomPassword() {
		String characters = "abcdefghijklnmopqrstuvwxyz";
		String numbers = "0123456789";
		Random random = new Random();
		StringBuilder password = new StringBuilder();
        for (int i = 0; i < 7; i++) {
        	password.append(characters.charAt(random.nextInt(characters.length())));
        }
        for (int i = 0; i < 6; i++) {
        	password.append(numbers.charAt(random.nextInt(numbers.length())));
        }
        return password.toString();
	}
	
}
