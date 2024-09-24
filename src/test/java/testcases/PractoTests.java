//
//package testcases;
//
//import pages.HomePage;
//import pages.DoctorsPage;
//import base.baseClass;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//public class PractoTests extends baseClass {
//    HomePage homePage;
//    DoctorsPage doctorsPage;
//
//    @BeforeClass
//    public void setUp() {
//        homePage = new HomePage();
//        doctorsPage = new DoctorsPage();
//        openURL();
//    }
//
//    @Test
//    public void verifyDoctorDetails() throws InterruptedException {
//        homePage.selectLocationAndSpecialist();
//        homePage.selectSpecialist();
//        doctorsPage.validateCity();
//        doctorsPage.validateDoctorsSpeciality();
//    }
//
//    @AfterClass
//    public void tearDown() {
//        close_browser();
//    }
//}
package testcases;

import pages.HomePage;
import pages.DoctorsPage;
import pages.BookingPage;
import base.baseClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PractoTests extends baseClass {
    HomePage homePage;
    DoctorsPage doctorsPage;
    BookingPage bookingPage;

    @BeforeClass
    public void setUp() {
        homePage = new HomePage();
        doctorsPage = new DoctorsPage();
        bookingPage = new BookingPage();
        openURL();
    }

    @Test(priority = 1)
    public void verifyDoctorCategoryList() throws InterruptedException {
        homePage.selectLocation();
        homePage.selectSpecialist();
        doctorsPage.validateCity();
        doctorsPage.validateDoctorsSpeciality();
        homePage.report();
    }

    @Test(priority = 2)
    public void verifyDoctorDetails() throws InterruptedException {
//        homePage.selectLocation();
//        homePage.selectSpecialist();
        String specificDoctorName = "Dr. Vartika Singh";
        homePage.selectDoctor(specificDoctorName);
        String expectedDate = "2024-09-26"; 
        String expectedTime = "10:00 AM"; 
        
        bookingPage.selectAvailableDate();
        bookingPage.selectTimeSlot();

        String bookedDoctorName = bookingPage.getDoctorName();
        String bookedDate = bookingPage.getSelectedDate();
        String bookedTimeSlot = bookingPage.getSelectedTimeSlot();

        assert bookedDoctorName.equals(specificDoctorName) : "Doctor name mismatch!";
        assert bookedDate.equals(expectedDate) : "Date mismatch!";
        assert bookedTimeSlot.equals(expectedTime) : "Time slot mismatch!";
    }
    @Test(priority = 3)
   public void verifyFilteredValues() throws InterruptedException {

        homePage.selectLocation();
        homePage.selectSpecialist();
        
      int minFee = 0;
       int maxFee = 500;
       homePage.selectConsultationFeeFilter();
        doctorsPage.validateConsultationFees(minFee, maxFee);
       
   
    }

    

    @AfterClass
    public void tearDown() {
        close_browser();
    }
}
