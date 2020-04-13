package ScalarPackage;

import VisitorPackage.*;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

    private double v;


    public RealScalar() {
    }

    public RealScalar(double v){
        this.v = v;
    }

    @Override
    public Scalar clone() {
        return new RealScalar(v);
    }

    @Override
    public boolean isMatch(Scalar s) {
        MatcherVisitor visitor = new MatcherVisitor();
        s.accept(visitor,this);
        return visitor.isMatch();
    }

    @Override
    public Scalar add(Scalar s) {
        AdderVisitor visitor = new AdderVisitor();
        s.accept(visitor,this);
        return visitor.getSum();
    }

    @Override
    public Scalar mul(Scalar s) {
        MultiplierVisitor visitor = new MultiplierVisitor();
        s.accept(visitor,this);
        return visitor.getProduct();
    }

    @Override
    public Scalar mul(int i) {
        return new RealScalar(getValue()*i);
    }

    @Override
    public Scalar power(int exp) {
        return new RealScalar(Math.pow(v,exp));
    }

    @Override
    public int sign() {
       return (int) Math.signum(v);
    }

    @Override
    public void accept(Visitor visitor, RealScalar s) {
        visitor.visit(this,s);
    }

    public void accept(Visitor visitor, RationalScalar s) {
        visitor.visit(this,s);
    }

    public double getValue() {
        return v;
    }

    @Override
    public String toString() {
        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        return threeAfterDot.format(getValue());
    }
}
