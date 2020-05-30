package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyClassTest {

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, new int[]{1, 7}},
                {new int[]{2, 1, 2, 4, 5, 3, 7}, new int[]{5, 3, 7}},
                {new int[]{5, 4, 3, 2, 7, 8, 4, 9, 5, 6, 7}, new int[]{9, 5, 6, 7}},
                {new int[]{5, 7, 8, 4, 5, 6, 1, 9, 8, 5, 4}, new int[]{}}
        });
    }

    private int[] expected;
    private int[] actuals;
    private MyClass myClass;


    public MyClassTest(int[] actuals, int[] expected) {
        this.expected = expected;
        this.actuals = actuals;
    }

    @Before
    public void init() {
        myClass = new MyClass();
    }

    @Test
    public void testArrayAfterRuntimeException() {
        Assert.assertArrayEquals(expected, myClass.arrayAfter4(actuals));
    }


}
