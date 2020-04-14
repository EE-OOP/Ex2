package VisitorPackage;

import ScalarPackage.*;

public interface Visitor {
    //Performs appropriate operations according to the various types of input received

    void visit(RealScalar realS1, RealScalar realS2);

    void visit(RealScalar realS, RationalScalar rationalS);

    void visit(RationalScalar rationalS, RealScalar realS);

    void visit(RationalScalar rationalS1, RationalScalar rationalS2);
}
