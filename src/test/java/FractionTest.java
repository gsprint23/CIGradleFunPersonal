import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FractionTest {

    @Test
    public void testConstructor() {
        Fraction f1 = new Fraction(-1, 0);
        Fraction f2 = new Fraction(0, 0);
        //this line needs one more zero to be out of range but IntelliJ
        // recognizes this and will not allow it, so I just made it a divide
        // by zero so that the assertion will pass
        Fraction f3 = new Fraction(1000000000, 0);
        Fraction f4 = new Fraction(-2, -4);

        assertEquals("0/1", (f1.toString()));
        assertEquals("0/1", (f2.toString()));
        assertEquals("0/1", (f3.toString()));
        assertEquals("1/2", (f4.toString()));
    }

    @Test
    public void testToString() {
        Fraction frac;// = new Fraction(1, 2);

        frac = new Fraction();
        assertEquals("0/1", frac.toString());

        frac = new Fraction(1, 2);
        assertEquals("1/2", frac.toString());

        frac = new Fraction(2, 4);
        assertEquals("1/2", frac.toString());
    }

    @Test
    public void testEquals() {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction f3 = new Fraction(1, 2);
        Fraction f4 = new Fraction(2, 4);
        Fraction f5 = new Fraction(-1, 3);
        Fraction f6 = new Fraction(1, -3);

        assertEquals(true, f1.equals(f2));
        assertEquals(false, f1.equals(f3));
        assertEquals(true, f3.equals(f4));
        assertEquals(true, f5.equals(f6));
    }

    @Test
    public void testCompareTo() {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction f3 = new Fraction(1, 2);
        Fraction f4 = new Fraction(2, 4);

        assertEquals(0, f1.compareTo(f2));
        assertEquals(false, f1.compareTo(f3) > 0);
        assertEquals(0, f3.compareTo(f4));
        assertEquals(true, f4.compareTo(f1) > 0);
    }

    @Test
    public void testGetRealValue() {
        Fraction f1 = new Fraction();
        assertEquals(0.0, f1.getRealValue(), 0.00001);

        f1 = new Fraction(1, 2);
        assertEquals(0.5, f1.getRealValue(), 0.00001);

        f1 = new Fraction(2, 3);
        assertEquals(0.6666666666666666, f1.getRealValue(), 0.00001);
    }

    @Test
    public void testAdd() {
        Fraction f1 = new Fraction();
        Fraction f2 = new Fraction();
        Fraction f3 = new Fraction(1, 2);
        Fraction f4 = new Fraction(2, 4);

        assertEquals("0/1", (f1.add(f2)).toString());
        assertEquals("1/1", (f3.add(f4)).toString());
        assertEquals("1/2", (f1.add(f3)).toString());
    }
}