public class RealScalar implements Scalar {

    private double v;

    public boolean isMatch(Scalar s) {
        return accept(s);
    }

    public Scalar add(Scalar s) {
        return null;
    }

    public Scalar mul(Scalar s) {
        return null;
    }

    public Scalar power(int exp) {
        return null;
    }

    public int sign() {
        return 0;
    }

    public boolean accept(Scalar s) {
        return s.visit(this);
    }

    public boolean visit(RealScalar rs) {
        return true;
    }

    public boolean visit(RationalScalar rs) {
        return false;
    }
}
