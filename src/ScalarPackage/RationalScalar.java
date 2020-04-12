package ScalarPackage;

import VisitorPackage.*;

public class RationalScalar implements Scalar {

    private int a;
    private int b;

    public RationalScalar() {
    }

    public RationalScalar(int a, int b){
        this.a = a;
        this.b = b;

    }

    public int getA() {
        return a;
    }

    public int getB() {
        return b;
    }

    @Override
    public boolean isMatch(Scalar s) {
        MatcherVisitor v = new MatcherVisitor();
        s.accept(v,this);
        return v.isMatch();
    }

    @Override
    public Scalar add(Scalar s) {
        AdderVisitor v = new AdderVisitor();
        s.accept(v,this);
        return v.getResult();
    }

    @Override
    public Scalar mul(Scalar s) {
        MultiplierVisitor v = new MultiplierVisitor();
        s.accept(v,this);
        return v.getResult();
    }

    @Override
    public Scalar mul(int i) {
        return new RationalScalar(getA()*i,getB());
    }

    @Override
    public Scalar power(int exp) {
        return new RationalScalar( (int) Math.pow(getA(),exp),(int) Math.pow(getB(),exp));
    }

    @Override
    public int sign() {
        return (int) Math.signum(getA()*getB());
    }

    @Override
    public void accept(Visitor v, RealScalar s) {
        v.visit(this,s);
    }

    @Override
    public void accept(Visitor v, RationalScalar s) {
        v.visit(this,s);
    }
}
