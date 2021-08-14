package AppTest;

import App.CalcInterface;
import App.Calculator;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class CalcTest {

    Calculator calculator = null;
    CalcInterface calcInterface = mock(CalcInterface.class);

    @Before
    public void setup() {
        calculator = new Calculator(calcInterface);
    }

    @Test
    public void toZero() {
        when(calcInterface.fun(-50)).thenReturn(50);
        when(calcInterface.fun(-10245)).thenReturn(10245);
        when(calcInterface.fun(0)).thenReturn(0);
        assertEquals("toZero ,Negative: Successful",(Integer) 50, calculator.toZero(50, 100));
        assertEquals("toZero ,Positive : Successful",(Integer) 10245, calculator.toZero(0,10245));
        assertEquals("toZero ,Zero : Successful",(Integer) 0, calculator.toZero(2300,2300));
    }

    @Test
    public void testAdd() {
        assertEquals("Addition, Arbitrary : Successful",(Integer) 2450, calculator.add(2351, 99));
        assertEquals("Addition, Arbitrary : Successful",(Integer) 1201, calculator.add(1201, 0));
    }

    @Test
    public void testSubtract() {
        assertEquals("Subtraction Arbitrary",(Integer) 1201, calculator.sub(1301, 100));
        assertEquals("Subtraction Arbitrary",(Integer) (-200), calculator.sub(1101, 1301));
        assertEquals("Subtraction Equal",(Integer) 0, calculator.sub(525, 525));
    }

    @Test
    public void testMultiply() {
        assertEquals("Multiplication, Arbitrary : Successful",(Integer) 21000, calculator.mul(30, 700));
        assertEquals("Multiplication, Arbitrary : Successful",(Integer) (-21000), calculator.mul(-30, 700));
        assertEquals("Multiplication, Zero : Successful",(Integer) 0, calculator.mul(3106, 0));
        assertEquals("Multiplication, Identity : Successful",(Integer) 1301, calculator.mul(1301, 1));
    }

    @Test
    public void testDivide() {
        assertEquals("Division, '<' : Successful",(Integer) 0, calculator.div(2, 20));
        assertEquals("Division, '>' : Successful",(Integer) 7, calculator.div(15, 2));
        assertEquals("Division, Equal : Successful",(Integer) 1, calculator.div(30, 30));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivideByZero() {
        calculator.div(10, 0);
    }
}
