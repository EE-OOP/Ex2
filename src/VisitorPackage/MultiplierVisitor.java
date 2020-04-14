package VisitorPackage;

import ScalarPackage.*;

public class MultiplierVisitor implements Visitor {

    private Scalar product;

    public Scalar getProduct() {
        return product;
    }

    private void setProduct(Scalar product) {
        this.product = product;
    }

    @Override
    public void visit(RealScalar realS1, RealScalar realS2) {
        setProduct(new RealScalar(realS1.getValue() * realS2.getValue()));
    }

    @Override
    public void visit(RealScalar realS, RationalScalar rationalS) {
        setProduct(null);
    }

    @Override
    public void visit(RationalScalar rationalS, RealScalar realS) {
        setProduct(null);
    }

    @Override
    public void visit(RationalScalar rationalS1, RationalScalar rationalS2) {
        setProduct(new RationalScalar(rationalS1.getNumerator() * rationalS2.getNumerator(), rationalS1.getDenominator() * rationalS2.getDenominator()));
    }
}
