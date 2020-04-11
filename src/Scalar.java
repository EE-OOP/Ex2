public interface Scalar {
    boolean isMatch(Scalar s);
    Scalar add(Scalar s);
    Scalar mul(Scalar s);
    Scalar power(int exp);
    int sign();
    boolean accept(Scalar s);
    boolean visit(RealScalar rs);
    boolean visit(RationalScalar rs);
}
