package ScalarPackage;

import VisitorPackage.*;

public class RationalScalar implements Scalar {

    private int a;
    private int b;

    public RationalScalar() {
    }

    public RationalScalar(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public RationalScalar(int num) { //if input is an integer, sets the denominator to 1
        this.a = num;
        this.b = 1;
    }

    @Override
    public Scalar clone() { //Generates an exact copy of 'this'
        return new RationalScalar(a,b);
    }

    public int getNumerator() {
        return a;
    }

    public int getDenominator() {
        return b;
    }

    @Override
    public boolean isMatch(Scalar s) { //Uses the visitor pattern to check Scalar type compatibility
        MatcherVisitor visitor = new MatcherVisitor();
        s.accept(visitor, this);
        return visitor.isMatch();
    }

    @Override
    public Scalar add(Scalar s) { //Uses the visitor pattern to ensure compatibility and produce the desired sum
        AdderVisitor visitor = new AdderVisitor();
        s.accept(visitor, this);
        return visitor.getSum();
    }

    @Override
    public Scalar mul(Scalar s) { //Uses the visitor pattern to ensure compatibility and produce the desired product
        MultiplierVisitor visitor = new MultiplierVisitor();
        s.accept(visitor, this);
        return visitor.getProduct();
    }

    @Override
    public Scalar mul(int i) {
        return new RationalScalar(getNumerator() * i, getDenominator());
    }

    @Override
    public Scalar power(int exp) {
        return new RationalScalar((int) Math.pow(getNumerator(), exp), (int) Math.pow(getDenominator(), exp));
    }

    @Override
    public int sign() {
        return (int) Math.signum(getNumerator() * getDenominator());
    }

    @Override
    public void accept(Visitor visitor, RealScalar s) { //Function to allow the visitor to behave appropriately
        visitor.visit(this, s);
    }

    @Override
    public void accept(Visitor visitor, RationalScalar s) { //Function to allow the visitor to behave appropriately
        visitor.visit(this, s);
    }

    @Override
    public String toString() {
        if (a % b == 0)
            return "" + a / b;
        if((a < 0 | b<0) & !(a<0 & b<0))
            return "(-" + Math.abs(a) + "/" + Math.abs(b) + ")";

        return "(" + Math.abs(a) + "/" + Math.abs(b) + ")";
    }
}
