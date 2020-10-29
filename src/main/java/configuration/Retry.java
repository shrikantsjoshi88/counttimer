package configuration;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.ITestAnnotation;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public class Retry implements IRetryAnalyzer, IAnnotationTransformer {

    private int count = 0;
    private int maxCount = 0;

    @Override
    public boolean retry(ITestResult result) {
        if (count < maxCount) {
            count++;
            return true;
        }
        return false;
    }

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {

    }
}
