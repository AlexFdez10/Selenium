package cucumberTest;
 
import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
 
//Para relacionar el TestRunner con el paquete StepDefinition y las carpetas features
@RunWith(Cucumber.class)
@CucumberOptions(
 features = "Feature"
 ,glue={"stepDefinition"},
 plugin = {"com.cucumber.listener.ExtentCucumberFormatter:report/report.html"}
 )
 
public class TestRunner {
 
}