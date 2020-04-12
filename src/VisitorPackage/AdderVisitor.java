package VisitorPackage;

import ScalarPackage.*;
public class AdderVisitor implements Visitor {

    Scalar result;

    @Override
    public void visit(RealScalar realS1, RealScalar realS2) {
         setResult(new RealScalar(realS1.getV()+realS2.getV()));
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
        setResult(new RationalScalar((rationalS1.getA()*rationalS2.getB()) + (rationalS2.getA()*rationalS1.getB()),rationalS1.getB()*rationalS2.getB()));
    }

    public Scalar getResult() {
        return result;
    }

    private void setResult(Scalar result) {
        this.result = result;
    }
}
