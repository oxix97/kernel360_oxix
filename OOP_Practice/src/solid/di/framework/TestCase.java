package solid.di.framework;

public abstract class TestCase {
    public void test() {
        if (doTest()) {
            System.out.println("Test succeeded");
        } else {
            System.out.println("Test fail");
        }
    }

    public abstract boolean doTest();
}
