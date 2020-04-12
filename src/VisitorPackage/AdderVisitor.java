package VisitorPackage;

import ScalarPackage.*;

public class AdderVisitor implements Visitor {

    Scalar sum;

    @Override
    public void visit(RealScalar realS1, RealScalar realS2) {
        setSum(new RealScalar(realS1.getValue() + realS2.getValue()));
    }

    @Override
    public void visit(RealScalar realS, RationalScalar rationalS) {
        setSum(null);
    }

    @Override
    public void visit(RationalScalar rationalS, RealScalar realS) {
        setSum(null);
    }

    @Override
    public void visit(RationalScalar rationalS1, RationalScalar rationalS2) {
        setSum(new RationalScalar((rationalS1.getNumerator() * rationalS2.getDenominator()) + (rationalS2.getNumerator() * rationalS1.getDenominator()), rationalS1.getDenominator() * rationalS2.getDenominator()));
    }

    public Scalar getSum() {
        return sum;
    }

    private void setSum(Scalar sum) {
        this.sum = sum;
    }
}
