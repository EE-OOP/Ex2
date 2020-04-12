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

    public int getNumerator() {
        return a;
    }

    public int getDenominator() {
        return b;
    }

    @Override
    public boolean isMatch(Scalar s) {
        MatcherVisitor visitor = new MatcherVisitor();
        s.accept(visitor, this);
        return visitor.isMatch();
    }

    @Override
    public Scalar add(Scalar s) {
        AdderVisitor visitor = new AdderVisitor();
        s.accept(visitor, this);
        return visitor.getSum();
    }

    @Override
    public Scalar mul(Scalar s) {
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
    public void accept(Visitor visitor, RealScalar s) {
        visitor.visit(this, s);
    }

    @Override
    public void accept(Visitor visitor, RationalScalar s) {
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
