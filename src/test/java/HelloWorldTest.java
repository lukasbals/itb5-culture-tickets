import org.junit.Test;

public class HelloWorldTest {

    @Test
    public void test1() {
        assert HelloWorld.test().equals("SUCCESS");
    }
}