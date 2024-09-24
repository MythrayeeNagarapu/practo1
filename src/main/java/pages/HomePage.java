
package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

import base.baseClass;

public class HomePage extends baseClass {
    By locationInput = By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/input");
    By clear = By.xpath("//*[@id=\"c-omni-container\"]/div/div[1]/div[1]/span[2]");
    By specialistInput = By.xpath("//*[@id=\"c-omni-container\"]/div/div[2]/div[1]/input");
    By doctorList = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/a/div/h2");
    By allFiltersButton = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[1]/div/div[3]/i");
    By consultationFeeFilter = By.xpath("//*[@id=\"container\"]/div/div[3]/div/div/header/div[2]/div/div[1]/div/label[1]/div");


    public void selectLocation() throws InterruptedException {
        driver.findElement(locationInput).click();
        driver.findElement(clear).click();
        driver.findElement(locationInput).sendKeys("Hyderabad");
        Thread.sleep(1000);
        driver.findElement(locationInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(locationInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(locationInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(locationInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }

    public void selectSpecialist() throws InterruptedException {
        driver.findElement(specialistInput).sendKeys("Dentist"); 
        Thread.sleep(1000);
        driver.findElement(specialistInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(specialistInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(specialistInput).sendKeys(Keys.ARROW_DOWN);
        driver.findElement(specialistInput).sendKeys(Keys.ENTER);
        Thread.sleep(1000);
    }
    public void selectDoctor(String doctorName) {
       
		List<WebElement> doctors = driver.findElements(doctorList);
		boolean isValid=true;
		
        for (WebElement doctor : doctors) {
        	String specialist=doctor.getText();
            if (!specialist.equalsIgnoreCase(doctorName)) {
//                doctor.click();
                isValid = false;
                break;
            }
        }
        
        if(isValid) {
			System.out.println("All doctors are specialized in the specified speciality.we got the desired results");
			test=report.createTest("Validate specialization");
        	test.log(Status.PASS, "we got the desired speciality");
        	
        }
        else
        {	
        	test=report.createTest("Validate speciality");
        	test.log(Status.FAIL, "we didnt get the desired result");
        }
        
    }
    

    public void selectConsultationFeeFilter() throws InterruptedException {
        driver.findElement(allFiltersButton).click();
        Thread.sleep(1000);
        driver.findElement(consultationFeeFilter).click();
       
        Thread.sleep(1000); 
    }
    
}
