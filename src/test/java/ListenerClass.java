import org.testng.IClass;
import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

/**
 * Created by dmytro_moskalenko2 on 12/10/2015.
 */

public class ListenerClass extends TestListenerAdapter {

    @Override
    public void onTestStart(ITestResult tr) {
        log("Test Started..___..");
    }

    @Override
    public void onTestSuccess(ITestResult tr) {

        log("Test '" + tr.getName() + "' PASSED");

        log(tr.getTestClass());

        log("Priority of this method is " + tr.getMethod().getPriority());

        System.out.println(".....");
    }

    @Override
    public void onTestFailure(ITestResult tr) {

        log("Test '" + tr.getName() + "' FAILED");
        log("Priority of this method is " + tr.getMethod().getPriority());
        System.out.println(".....");
    }

    @Override
    public void onTestSkipped(ITestResult tr) {
        log("Test '" + tr.getName() + "' SKIPPED");
        System.out.println(".....");
    }

    @Override
    public void onFinish(ITestContext tc) {
        System.out.println("....." + getPassedTests().toString());
    }

    private void log(String methodName) {
        System.out.println(methodName);
    }

    private void log(IClass testClass) {
        System.out.println(testClass);
    }
}

