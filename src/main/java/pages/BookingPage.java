
package pages;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import org.openqa.selenium.By;
import base.baseClass;
import freemarker.core.ParseException;

public class BookingPage extends baseClass {
    By datePicker = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]"); 
    By timeSlots = By.xpath("//*[@id=\\\"container\\\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[2]/div/div[2]/div[4]/span\""); // Update with the actual locator for time slots
//    By confirmBookingButton = By.xpath("//button[text()='Confirm']"); // Update with actual locator if available
    By doctorNameOnBookingPage = By.xpath("//*[@id=\\\"container\\\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[1]/div[2]/a/div/h2"); // Update with actual locator
    By selectedDate = By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[3]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[1]"); // Update with actual locator for selected date
    By selectedTimeSlot = By.xpath("//*[@id=\\\"container\\\"]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/span[2]"); // Update with actual locator for selected time
   
    By todaySlotText = By.xpath("\"//*[@id=\\\"container\\\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[1]/div[2]\"");
    By tomorrowSlotText=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]");
	 By dayAfterTomorrowSlotText=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[1]/div[2]/div[3]/div[2]");
	  //to clicking on slots
	  By todaySlot=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[1]");
	  By tomorrowSlot=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[2]");
	  By dayAfterTomorrowSlot=By.xpath("//*[@id=\"container\"]/div/div[4]/div/div[1]/div/div[2]/div[2]/div/div/div/div[2]/div[2]/div[1]/div[2]/div[3]");
    By bookVisitButton = By.xpath("//*[@id=\\\"container\\\"]/div/div[4]/div/div[1]/div/div[3]/div[1]/div/div[2]/div/div/div[2]/div/button\"");
    public void selectAvailableDate() {
        driver.findElement(datePicker).click();
       
    }
    public void selectTimeSlot() {
        driver.findElements(timeSlots).get(0).click(); 

    }
    public void bookSlot() {
  	  String todaySlot_Text=driver.findElement(todaySlotText).getText();
  	  String tomorrowSlot_Text=driver.findElement(tomorrowSlotText).getText();
  	  String dayAfterTomorrowSlot_Text=driver.findElement(dayAfterTomorrowSlotText).getText();

  	private void validateTimeSlots(String timeSlot1, String timeSlot2) {
        SimpleDateFormat inputFormat = new SimpleDateFormat("h:mm a", Locale.ENGLISH);
        SimpleDateFormat outputFormat = new SimpleDateFormat("hh:mm a", Locale.ENGLISH);

        try {
            Date slot1 = inputFormat.parse(timeSlot1);
            Date slot2 = inputFormat.parse(timeSlot2);
            String formattedSlot1 = outputFormat.format(slot1);
            String formattedSlot2 = outputFormat.format(slot2);

            if (formattedSlot1.equals(formattedSlot2)) {
                System.out.println("Time slots match: " + formattedSlot1);
            } else {
                System.out.println("Time slots do not match.");
                System.out.println("Slot 1: " + formattedSlot1 + ", Slot 2: " + formattedSlot2);
            }
        } catch (ParseException enter) {
            System.out.println("Error parsing the time slots: " + enter.getMessage());
        }
    }}

    public String getDoctorName() {
        return driver.findElement(doctorNameOnBookingPage).getText();
    }

    public String getSelectedDate() {
        return driver.findElement(selectedDate).getText();
    }

    public String getSelectedTimeSlot() {
        return driver.findElement(selectedTimeSlot).getText();
    }
}
