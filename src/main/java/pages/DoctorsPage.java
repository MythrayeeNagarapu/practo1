
package pages;

import org.openqa.selenium.By;
import base.baseClass;
import java.util.List;
import org.openqa.selenium.WebElement;

public class DoctorsPage extends baseClass {
    By getCityName = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[1]/div[1]");
    By doctorSpeciality = By.xpath("//h2[contains(//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div/button"); 
    By doctorFees = By.xpath("");
    By dateSelected = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]") ;
    public void validateCity() {
    	 String cityName = driver.findElement(getCityName).getText();
       if (cityName.contains("New Hyderabad")) {
           System.out.println("Location is validated as New Hyderabad.");
       } else {
           System.out.println("Location mismatch.");
       }
    }

    

    public void validateDoctorsSpeciality() {
    	
    	 List<WebElement> doctorList = driver.findElements(doctorSpeciality);
       for (WebElement doctor : doctorList) {
           System.out.println("Doctor Name: " + doctor.getText());
           
    }
}
    public void validateConsultationFees(int minFee, int maxFee) {
        List<WebElement> feesList = driver.findElements(doctorFees);
        for (WebElement feeElement : feesList) {
            String feeText = feeElement.getText().replaceAll("[^0-9]", "");
            int fee = Integer.parseInt(feeText);
            if (fee < minFee || fee > maxFee) {
                System.out.println("Fee of " + fee + " is outside the expected range of " + minFee + " to " + maxFee);
            }
        }
        System.out.println("Consultant fee is on range");
    }
}
