import ScalarPackage.RationalScalar;
import ScalarPackage.RealScalar;
import ScalarPackage.Scalar;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        double d = 3.0101;
        System.out.println(threeAfterDot.format(d));

        RealScalar s1 = new RealScalar(2);
    }
}
