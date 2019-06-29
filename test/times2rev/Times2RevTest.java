package times2rev;

import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Times2RevTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void tearDown() throws Exception {
        System.setOut(null);
    }

    @Test
    public void test_no_args() {
        assertEquals("", this.run(new String[]{}));
    }

    @Test
    public void test_arg0() {
        assertEquals("0\n", this.run(new String[]{"0"}));
    }

    @Test
    public void test_arg123() {
        assertEquals("642\n", this.run(new String[]{"123"}));
    }

    @Test
    public void test_arg100() {
        assertEquals("2\n", this.run(new String[]{"100"}));
    }

    @Test
    public void test_args_1_2() {
        assertEquals("2\n4\n", this.run(new String[]{"1","2"}));
    }

    @Test
    public void test_arg_2_to_31_minus_1() {
        assertEquals("4927694924\n", this.run(new String[]{"2147483647"}));
    }


    private String run(String args[]) {
        outContent.reset();
        Times2Rev.main(args);
        return outContent.toString();
    }

}