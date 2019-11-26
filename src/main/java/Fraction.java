/**
 * Fraction class
 *
 * @author gsprint
 */
public class Fraction {
    int num;
    int den;

    public Fraction() {
        num = 0;
        den = 1;
    }

    public Fraction(int n, int d) {
        if (d > Integer.MAX_VALUE || n > Integer.MAX_VALUE || d < Integer.MIN_VALUE || n < Integer.MIN_VALUE) {
            num = 0;
            den = 1;
            System.out.println("Value must be in valid range. Fraction is set to 0/1\n");
        }
        else if (d == 0) {
            num = 0;
            den = 1;
            System.out.println("Value must be nonzero. Fraction is set to 0/1\n");
        }
        else if(n < 0 && d < 0) {
            num = Math.abs(n);
            den = Math.abs(d);
        }
        else {
            num = n;
            den = d;
        }
    }

    public String toString() {
        Fraction frac = reduce(num, den);
        return frac.num + "/" + frac.den;
    }

    public boolean equals(Fraction that) {
        Fraction frac = reduce(num, den);
        num = frac.num;
        den = frac.den;

        Fraction frac2 = reduce(that.num, that.den);
        that.num = frac2.num;
        that.den = frac2.den;

        return num == that.num && den == that.den;
    }

    public int compareTo(Fraction that) {
        Fraction frac = reduce(num, den);
        num = frac.num;
        den = frac.den;

        Fraction frac2 = reduce(that.num, that.den);
        that.num = frac2.num;
        that.den = frac2.den;
        if(num == that.num && den == that.den)
            return 0;

        double d = ((double) num/den - (double) that.num / that.den);
        if (d < 0) {
            return -1;
        }
        else {
            return 1;
        }
    }

    public double getRealValue() {
        return (double) num / (double) den;
    }

    public Fraction add(Fraction that) {
        int sumN = this.den * that.num + this.num * that.den;
        int sumD = this.den * that.den;
        return reduce(sumN, sumD);

    }

    public Fraction reduce(int num1, int num2) {
        int num1Copy = num1;
        int num2Copy = num2;
        int remainder = 0;
        while (num2 != 0) {
            remainder = num1 % num2;
            num1 = num2;
            num2 = remainder;
        }
        return new Fraction(num1Copy / num1,num2Copy / num1);
    }
}