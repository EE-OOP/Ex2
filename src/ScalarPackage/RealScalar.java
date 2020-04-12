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
        MatcherVisitor visitor = new MatcherVisitor();
        s.accept(visitor,this);
        return visitor.isMatch();
    }

    @Override
    public Scalar add(Scalar s) {
        AdderVisitor visitor = new AdderVisitor();
        s.accept(visitor,this);
        return visitor.getResult();
    }

    @Override
    public Scalar mul(Scalar s) {
        MultiplierVisitor visitor = new MultiplierVisitor();
        s.accept(visitor,this);
        return visitor.getResult();
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
    public void accept(Visitor visitor, RealScalar s) {
        visitor.visit(this,s);
    }

    public void accept(Visitor visitor, RationalScalar s) {
        visitor.visit(this,s);
    }

    public double getV() {
        return v;
    }
}
