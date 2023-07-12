package sistgerenciamento;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
plugin = {"pretty"},
features = "src\\resources\\features\\gerenciamentoAcademico.feature", glue = "sistgerenciamento")
public class TestAcceptanceCucumber {

}
