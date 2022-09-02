
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/Features/",
        monochrome = true,
        glue = {"step_definitions", "hooks"},
        plugin = {"pretty", "html:target/Reports/HtmlReport/report.html",
                  "pretty", "json:target/Reports/JSONReport/report.json",
                  "pretty", "junit:target/Reports/XMLReports/report.xml",
                  "json:target/cucumber.json" },
        tags = "@SearchTests or @LoginTest or @RatingsTest or @WatchlistTest"
)

public class Runner  {

}
