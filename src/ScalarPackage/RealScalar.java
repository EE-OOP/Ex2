package ScalarPackage;

import VisitorPackage.*;
public class RealScalar implements Scalar {

    private double v;


    public RealScalar() {
    }

    public RealScalar(double v){
        this.v = v;
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
        return new RealScalar(getV()*i);
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
    public void accept(Visitor v, RealScalar s) {
        v.visit(this,s);
    }

    public void accept(Visitor v, RationalScalar s) {
        v.visit(this,s);
    }

    public double getV() {
        return v;
    }
}
