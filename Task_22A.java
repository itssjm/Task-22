import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.util.List;

public class Task_22A {
		    public static void main(String[] args)  throws InterruptedException {
	        // Set the path of ChromeDriver executable
	        System.setProperty("webdriver.chrome.driver",  "C:/Users/Moses/Documents/chromedriver-win64/chromedriver.exe");

        // Initialize ChromeDriver
        WebDriver driver = new ChromeDriver();

        // Maximize the window
        driver.manage().window().maximize();

        // Navigate to the form page of phptravels.com
        driver.get("https://phptravels.com/demo/");

        // Fill in the form details
        WebDriverWait wait = new WebDriverWait(driver, 10);
        
        WebElement nameInput = wait.until(ExpectedConditions.elementToBeClickable(By.name("firstname")));
        nameInput.sendKeys("John");

        WebElement emailInput = driver.findElement(By.name("last_name"));
        emailInput.sendKeys("Joe");

        WebElement phoneInput = driver.findElement(By.name("business_name"));
        phoneInput.sendKeys("Testing");

        WebElement countryDropdown = driver.findElement(By.xpath("//input[@placeholder='Email']"));
        countryDropdown.sendKeys("john@example.com");

        WebElement submitButton = driver.findElement(By.xpath("//button[@type='submit']"));
        submitButton.click();

        // Add logic for sum verification
        List<WebElement> messages = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.className("alert")));
        boolean formSubmitted = false;
        for (WebElement message : messages) {
            if (message.getText().contains("success")) {
                formSubmitted = true;
                break;
            }
        }

        // Verify that the form is submitted successfully
        if (formSubmitted) {
            System.out.println("Form submitted successfully.");
        } else {
            System.out.println("Form submission failed.");
        }

     
        // Close the browser
        driver.quit();
    }
}
