
package pages;

import org.openqa.selenium.By;
import base.baseClass;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.WebElement;

import com.aventstack.extentreports.Status;

public class DoctorsPage extends baseClass {
	int priceInteger=0;
	String formattedDate="";
    By getCityName = By.xpath("//h1[@class=\"u-xx-large-font u-bold\"]");
    By doctorSpeciality = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div[2]/div/button");
    By doctorFees = By.xpath("//span[@data-qa-id='consultation_fee']");
    By specialityElement = By.xpath("//span[.='Dentist']");
    By clinicButtonElement = By.xpath("//button[contains(.,'Book Clinic Visit')]");
    By slotDayElement = By.xpath("//div[@class=\"u-pos-rel c-slots-header__daybar \"]/div");
    By availableSlotTimeElement = By.xpath("//div[@data-qa-id=\"slot_time\"]/span");
    By filtersElement = By.xpath("//i[@data-qa-id=\"all_filters_icon\"]");
    By radioElement = By.xpath("//div[@class=\"o-page-container u-cushion--vertical pure-g\"]/div[1]/div/label/span");
    By doctorNameElement = By.xpath("//h2[@data-qa-id=\"doctor_name\"]");
    
    public void validateCity() {
        String cityName = driver.findElement(getCityName).getText();
        if (cityName.contains("New Hyderabad")) {
            test = report.createTest("Validate City");
            test.log(Status.PASS, "Location validated as New Hyderabad.");
        } else {
            test = report.createTest("Validate City");
            test.log(Status.FAIL, "Location mismatch! Expected: New Hyderabad, but got: " + cityName);
        }
    }

    public void validateDoctorsSpeciality() {
        List<WebElement> doctorList = driver.findElements(specialityElement);
        int pass=0,fail=0;
        for (WebElement doctor : doctorList) {
            if(doctor.getText().contains("Dentist")) {
            	pass +=1;
            }
            else {
            	fail+=1;
            }
        }
        System.out.println("Doctor Speciality: Pass =  " +pass+ " Failed = "+fail);
        if(fail==0) {
        	 test = report.createTest("Validate Doctor Speciality");
             test.log(Status.PASS, "Speciality validated successfully.");
        }
        else {
        	 test = report.createTest("Validate Doctor Speciality");
             test.log(Status.FAIL, "Speciality validated Unsuccessfully.");
        }
    }

    public void validateConsultationFees(int minFee, int maxFee) {
    	
    	driver.findElement(filtersElement).click();
    	
    	List<WebElement> radioButtons = driver.findElements(radioElement);
    	
    	Random random = new Random();
    	int radio = random.nextInt(radioButtons.size()-1);
    	
    	String price = radioButtons.get(radio).getText();
    	radioButtons.get(radio).click();
    	
    	System.out.println("price = "+ price);
    	
    	if(radio>1) {
    		String priceInt = price.replaceAll("[^0-9]", "");
    		priceInteger = Integer.parseInt(priceInt);
    		minFee = priceInteger;
    		maxFee = 10000;
    	}
    	
    	
        List<WebElement> feesList = driver.findElements(doctorFees);
        System.out.println("Opened");
        
        int pass=0,fail=0;
        
        for (WebElement feeElement : feesList) {
       
            String feeText = feeElement.getText().replaceAll("[^0-9]", "");
            
            int fee = Integer.parseInt(feeText);
            
            if (fee >= minFee && fee < maxFee) {
          
            	pass+=1;
            }
            else {
            	fail+=1;
            }
        }
        
        if(fail==0) {
        	System.out.println("success");
            test = report.createTest("Validate Consultation Fees");
            test.log(Status.PASS, "Fee of  is outside the expected range of " + minFee + " to " + maxFee);
        }
        else {
        	System.out.println("Fee out ofbounds");
        	 test = report.createTest("Validate Consultation Fees");
             test.log(Status.FAIL, "Consultant fee is not in range.");
        }
    }

    public String[] buttons() {
    	List<WebElement> buttons = driver.findElements(clinicButtonElement);
    	List<WebElement> doctorNames = driver.findElements(doctorNameElement);
    	
    	Random random = new Random();
    	
    	int num= random.nextInt(buttons.size()-1);
    	System.out.println(num);
    	String doctorName = doctorNames.get(num).getText();
    	buttons.get(num).click();
    	
    	List<WebElement> slotDays = driver.findElements(slotDayElement);
    	
    	int noOfDays=0;
    	
    	LocalDate now = LocalDate.now();
    	
    	
    	for(WebElement day:slotDays) {
    		if(!(day.getText().contains("No"))) {
    			day.click();
    			
    			break;
    		}
    		else {
    			noOfDays+=1;
    		}
    	}
    	
    	LocalDate futureDate = now.plusDays(noOfDays);
    	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd, yyyy");
    	formattedDate = futureDate.format(formatter);
    	
    	
    	
    	List<WebElement> availableSlots = driver.findElements(availableSlotTimeElement);
        	
    	int slot= random.nextInt(availableSlots.size()-1);
    	System.out.println(slot);
    	
    	String time = availableSlots.get(slot).getText();
    	
    	availableSlots.get(slot).click();
    	
    	System.out.println(formattedDate+" "+time);
    	
    	return new String[] {formattedDate,time,doctorName};
    	
    	
    }
}
