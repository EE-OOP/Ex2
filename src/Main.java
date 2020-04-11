public class Main {
    public static void main(String[] args) {
        Scalar s1 = new RealScalar();
        Scalar s2 = new RealScalar();

        Scalar s3 = new RationalScalar();
        Scalar s4 = new RationalScalar();

        System.out.println("real vs real");
        System.out.println(s1.isMatch(s2));
        System.out.println("real vs rational");
        System.out.println(s2.isMatch(s3));
        System.out.println("rational vs real");
        System.out.println(s3.isMatch(s2));
        System.out.println("rational vs rational");
        System.out.println(s3.isMatch(s4));
    }
}
