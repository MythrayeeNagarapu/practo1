package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import base.baseClass;
import org.openqa.selenium.WebElement;
import java.util.List;

public class HomePage extends baseClass {
    By locationInput = By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/input");
    By clearLocation = By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/span[2]");
    By specialistDropdown = By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/input");
    By locationOptions = By.xpath("//*[@id='c-omni-container']/div/div[1]/div[1]/div/div/div"); // Location dropdown
    By specialistOptions = By.xpath("//*[@id='c-omni-container']/div/div[2]/div[1]/div/div/div"); // Specialist dropdown
    By doctorList = By.xpath("//*[@id='container']/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/a/div/h2");
    
    
    
    public void selectLocationNewHyderabad() throws InterruptedException {
        WebElement city = driver.findElement(locationInput);
        
        city.click();
        city.clear();

        city.sendKeys(prop.getProperty("city"));
        Thread.sleep(1000);
        for(int i=0;i<3;i++) {
        	city.sendKeys(Keys.ARROW_DOWN);
        }
    	city.sendKeys(Keys.ENTER);

        
    }
   
    
    public void selectSpecialtyPediatricDentist() throws InterruptedException {
        WebElement specilization = driver.findElement(specialistDropdown);
        specilization.click();
        specilization.sendKeys(prop.getProperty("specilization"));
        
        Thread.sleep(1000);
        
        for(int i=0;i<3;i++) {
        	specilization.sendKeys(Keys.ARROW_DOWN);
        	
        }
        specilization.sendKeys(Keys.ENTER);

        Thread.sleep(1000);
    }

    // Method to retrieve the list of doctors for verification
    public List<WebElement> getDoctorList() {
        return driver.findElements(doctorList); // Returns a list of doctor elements
    }

}
