package task3;

public class Rational extends Number implements Comparable<Rational> {
    private long numerator;
    private long denominator;

    public Rational() {
        this(0, 1);
    }

    public Rational(long numerator, long denominator) {
        if (denominator == 0) {
            throw new ArithmeticException("Знаменатель не может быть равен нулю");
        }

        if (denominator < 0) {
            numerator = -numerator;
            denominator = -denominator;
        }

        long gcd = gcd(Math.abs(numerator), denominator);
        this.numerator = numerator / gcd;
        this.denominator = denominator / gcd;
    }

    private static long gcd(long n, long d) {
        if (n == 0) return d;
        return gcd(d % n, n);
    }

    public long getNumerator() {
        return numerator;
    }

    public long getDenominator() {
        return denominator;
    }

    public Rational add(Rational secRational) {
        long n = (this.numerator * secRational.getDenominator()) +
                (this.denominator * secRational.getNumerator());
        long d = this.denominator * secRational.getDenominator();
        return new Rational(n, d);
    }

    public Rational subtract(Rational secRational) {
        long n = (this.numerator * secRational.getDenominator()) -
                (this.denominator * secRational.getNumerator());
        long d = this.denominator * secRational.getDenominator();
        return new Rational(n, d);
    }

    public Rational multiply(Rational secRational) {
        long n = this.numerator * secRational.getNumerator();
        long d = this.denominator * secRational.getDenominator();
        return new Rational(n, d);
    }

    public Rational divide(Rational secRational) {
        long n = this.numerator * secRational.getDenominator();
        long d = this.denominator * secRational.getNumerator();
        return new Rational(n, d);
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public double doubleValue() {
        return (double) numerator / denominator;
    }

    @Override
    public int compareTo(Rational o) {
        long left = this.numerator * o.getDenominator();
        long right = o.getNumerator() * this.denominator;

        return Long.compare(left, right);
    }


    @Override
    public String toString() {
        if (denominator == 1) {
            return String.valueOf(numerator);
        } else {
            return numerator + "/" + denominator;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if ((obj == null) || (this.getClass() != obj.getClass())) return false;
        Rational other = (Rational) obj;
        return this.numerator == other.numerator &&
                this.denominator == other.denominator;
    }
}