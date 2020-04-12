package ScalarPackage;

import VisitorPackage.Visitor;

public interface Scalar {
    boolean isMatch(Scalar s);
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar mul(int i);
    Scalar power(int exp);
    int sign();
    void accept(Visitor v, RealScalar s);
    void accept(Visitor v, RationalScalar s);

}
