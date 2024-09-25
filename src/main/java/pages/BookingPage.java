
package pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.baseClass;
import freemarker.core.ParseException;

public class BookingPage extends baseClass {

	
	By dateTimeElement = By.xpath("//span[@class=\"u-bold\"]");
	By doctorNameElement = By.xpath("//div[@data-qa-id=\"doctor_name\"]");
	
	public boolean [] slot_validation(String date, String time,String name) {
		
		String doctorName = driver.findElement(doctorNameElement).getText();
		
		List<WebElement> dateTime = driver.findElements(dateTimeElement);
		System.out.println("Opened");
		Boolean isDate=false;
		Boolean isTime=false;
		Boolean isName = false;
		
		for(WebElement w:dateTime) {
			
			if(w.getText().contains(date)) {
				System.out.println("Date is matched");
				isDate=true;
			}
			else if(time.contains(w.getText())) {
				System.out.println("Time is matched");
				isTime=true;
			}
			else {
				System.out.println("Before Date = "+ w.getText() + " After Date = "+date);
				System.out.println("Before Time = "+ w.getText() + " After Time = "+time);
			}
			
			
		}
		
		if(name.contains(doctorName)) {
			isName=true;
			System.out.println("Doctor Name matched");
		}
		
		return new boolean [] {isDate,isTime,isName};
		
	}
}
