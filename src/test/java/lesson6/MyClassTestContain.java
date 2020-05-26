package lesson6;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class MyClassTestContain {

    @Parameterized.Parameters
    public static Collection<Object[]> data1() {
        return Arrays.asList(new Object[][]{
                {new int[]{1, 2, 4, 4, 2, 3, 4, 1, 7}, true},
                {new int[]{2, 1, 2, 5, 3, 7}, false},
                {new int[]{5, 4, 3, 2, 7, 8, 4, 9, 5, 6, 7}, false},
                {new int[]{5, 7, 8, 4, 5, 6, 1, 9, 8, 5, 4}, true},
                {new int[]{5, 7, 8, 4, 5, 6, 1, 9, 8, 5, 4}, false}
        });
    }

    private int[] actuals;
    private Boolean expected;
    private MyClass myClass;

    public MyClassTestContain(int[] actuals, boolean expected) {
        this.actuals = actuals;
        this.expected = expected;
    }

    @Before
    public void init() {
        myClass = new MyClass();
    }

    @Test
    public void testContain() {
        Assert.assertEquals(expected, myClass.contain(actuals));
    }
}
