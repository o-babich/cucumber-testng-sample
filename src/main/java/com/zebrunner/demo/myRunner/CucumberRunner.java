package com.zebrunner.demo.myRunner;

import com.zebrunner.agent.core.annotation.Maintainer;
import com.zebrunner.agent.core.annotation.ZephyrTestCaseKey;
import com.zebrunner.agent.testng.core.testname.TestNameResolverRegistry;
import com.zebrunner.demo.CucumberNameResolver;
import io.cucumber.testng.*;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;

public abstract class CucumberRunner extends AbstractTestNGCucumberTests {
    private TestNGCucumberRunner testNGCucumberRunner;

    protected CucumberRunner() {
        TestNameResolverRegistry.set(new CucumberNameResolver());
    }


    @BeforeClass(alwaysRun = true)
    public void setUpClass(ITestContext context) {
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Maintainer("obabich")
    @ZephyrTestCaseKey({"ZEB-53", "ZEB-52", "ZEB-54"})
    @Test(groups = {"cucumber"}, description = "Runs Cucumber Feature", dataProvider = "features")
    public void feature(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper, @SuppressWarnings("unused") String uniqueId) {

        CucumberNameResolver.generateTestName(pickleWrapper, featureWrapper, this.testNGCucumberRunner.provideScenarios().length);

        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider()
    public Object[][] features(ITestContext context) {
        context.setAttribute(CucumberNameResolver.SCENARIO_COUNT_PARAMETER, this.testNGCucumberRunner.provideScenarios().length);
        Object[][] parameters = testNGCucumberRunner.provideScenarios();
        Object[][] newParams = new Object[parameters.length][1];
        for (int i = 0; i < parameters.length; i++) {
            newParams[i] = new Object[3];
            newParams[i][0] = parameters[i][0];
            newParams[i][1] = parameters[i][1];

            PickleWrapper pickleWrapper = (PickleWrapper) parameters[i][0];
            Pickle pickle = pickleWrapper.getPickle();
            // set unique id for correct reporting (it guarantee that same test will be used for rerunning (retry)
            newParams[i][2] = String.format("%s.%s.%s.%s", pickle.getUri(), pickle.getScenarioLine(), pickle.getLine(), pickle.getName());
        }
        return newParams;
    }

    @AfterClass
    public void tearDownClass(ITestContext context) {
        this.testNGCucumberRunner.finish();
    }
}

