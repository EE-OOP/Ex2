public abstract class AbstractScalar implements Scalar {
    public boolean isMatch(Scalar s) {
        return accept(s);
    }

    public abstract boolean accept(Scalar s);
    public abstract Scalar add(Scalar s);
    public abstract Scalar mul(Scalar s);
    public abstract Scalar power(int exp);
    public abstract int sign();
    public abstract boolean visit(RealScalar rs);
    public abstract boolean visit(RationalScalar rs);

}
