package VisitorPackage;

import ScalarPackage.*;
public class MultiplierVisitor implements Visitor {

    protected Scalar result;

    public Scalar getResult() {
        return result;
    }

    protected void setResult(Scalar result) {
        this.result = result;
    }

    @Override
    public void visit(RealScalar realS1, RealScalar realS2) {
        setResult(new RealScalar(realS1.getV()*realS2.getV()));
    }

    @Override
    public void visit(RealScalar realS, RationalScalar rationalS) {
        setResult(null);
    }

    @Override
    public void visit(RationalScalar rationalS, RealScalar realS) {
        setResult(null);
    }

    @Override
    public void visit(RationalScalar rationalS1, RationalScalar rationalS2) {
        setResult(new RationalScalar(rationalS1.getA()*rationalS2.getA(),rationalS1.getB()*rationalS2.getB()));
    }
}
