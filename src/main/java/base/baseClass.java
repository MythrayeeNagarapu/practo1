
package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeSuite;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class baseClass {
    public static WebDriver driver;
    String url = "https://www.practo.com/";
    public static ExtentSparkReporter htmlreport;
    public static ExtentReports report;
    public static ExtentTest test;
    
    protected Properties prop = new Properties();
    
    @BeforeSuite
    public void Browser_setup() throws Exception {
    	
    	

        driver = new EdgeDriver();
        PageFactory.initElements(driver, this);
        
        htmlreport = new ExtentSparkReporter(new File("C:\\Users\\MythrayeeN\\Desktop\\Report1.html"));
        htmlreport.config().setReportName("Practo");
        htmlreport.config().setDocumentTitle("Practo Functional Test");
        htmlreport.config().setTheme(Theme.DARK);
        
        report = new ExtentReports();
        report.setSystemInfo("Environment", "TestEnvironment");
        report.setSystemInfo("TesterName", "Mythrayee");
        report.attachReporter(htmlreport);
       
        FileInputStream input = new FileInputStream("src/main/java/Config/configuration.properties");
        prop.load(input);
        input.close();
        
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        
    }

    public void openURL() {
        driver.get(prop.getProperty("url"));
    }

    public void report() {
        report.flush();
    }

    public void close_browser() {
        driver.quit();
    }
}
