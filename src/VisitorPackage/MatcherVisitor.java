package VisitorPackage;

import ScalarPackage.*;

public class MatcherVisitor implements Visitor {

    private boolean isMatch;

    //In case the Scalars are of the same type, they are matching, otherwise they are not
    @Override
    public void visit(RealScalar realS1, RealScalar realS2) {
        isMatch = true;
    }

    @Override
    public void visit(RealScalar realS, RationalScalar rationalS) {
        isMatch = false;
    }

    @Override
    public void visit(RationalScalar rationalS, RealScalar realS) {
        isMatch = false;
    }

    @Override
    public void visit(RationalScalar rationalS, RationalScalar rationalScalar) {
        isMatch = true;
    }

    public boolean isMatch() {
        return isMatch;
    }
}
