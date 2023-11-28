package solid.di.framework;

import java.util.ArrayList;
import java.util.List;

public class JunitApplication {
    private static final List<TestCase> testCases = new ArrayList<>();
    public static void register(TestCase testCase){
        testCases.add(testCase);
    }

    public static void main(String[] args){
        for(TestCase testCase : testCases){
            testCase.doTest();
        }
    }
}
