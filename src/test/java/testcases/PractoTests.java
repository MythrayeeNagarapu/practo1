
package testcases;

import pages.HomePage;
import pages.DoctorsPage;
import pages.BookingPage;
import base.baseClass;

import org.junit.AfterClass;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

public class PractoTests extends baseClass {
    HomePage homePage  = new HomePage();
    DoctorsPage doctorsPage =new DoctorsPage();
    BookingPage bookingPage=new BookingPage();

    @Test(priority = 1)
    public void verifyDoctorCategoryList() throws Exception {
    	homePage.Browser_setup();
    	homePage.openURL();
        homePage.selectLocationNewHyderabad();;
        homePage. selectSpecialtyPediatricDentist();
        doctorsPage.validateCity();
        doctorsPage.validateDoctorsSpeciality();
      //  homePage.report();
        
        homePage.report();
        homePage.close_browser();
    }

    @Test(priority = 2)
    public void verifyDoctorDetails() throws Exception {
    	homePage.Browser_setup();
    	homePage.openURL();
        homePage.selectLocationNewHyderabad();
        homePage. selectSpecialtyPediatricDentist();
        String result[] = doctorsPage.buttons();
        
        boolean[] doctorValidation = bookingPage.slot_validation(result[0],result[1],result[2]);
        
        if(doctorValidation[0] && doctorValidation[1] && doctorValidation[2]) {
        	 test = report.createTest("Date and Time Validation");
             test.log(Status.PASS, "Date, Time  and Doctor name is Matched");
        }
        else {
        	if(doctorValidation[0]) {
        		test = report.createTest("Date and Time Validation");
                test.log(Status.FAIL, "Only Date is Matched");
        	}
        	else if(doctorValidation[1]) {
        		test = report.createTest("Date and Time Validation");
                test.log(Status.FAIL, "Only Time is Matched");
        	}
        	else if(doctorValidation[2]){
        		test = report.createTest("Date and Time Validation");
                test.log(Status.FAIL, "Only Doctor name is Matched");
        	}
        	else {
        		test = report.createTest("Date and Time Validation");
                test.log(Status.FAIL, "Date, Time and Doctor name is not Matched");
        	}
        }
        
        homePage.report();
        homePage.close_browser();
        
    }
    @Test(priority = 3)
   public void verifyFilteredValues() throws Exception {
    	
    	homePage.Browser_setup();
    	homePage.openURL();

        homePage.selectLocationNewHyderabad();
        homePage.selectSpecialtyPediatricDentist();
        
        
        
        int minFee = 0;
        int maxFee = 500;
        
       doctorsPage.validateConsultationFees(minFee,maxFee);
              
       homePage.close_browser();
       
   
    }
    
    @AfterClass
    public void save_report() {
        homePage.report();

    }
    


}
