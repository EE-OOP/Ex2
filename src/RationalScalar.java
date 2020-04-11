public class RationalScalar extends AbstractScalar {

    private int a;
    private int b;

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
        return false;
    }

    public boolean visit(RationalScalar rs) {
        return true;
    }
}
