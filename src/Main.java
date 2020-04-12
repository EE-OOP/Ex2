import ScalarPackage.RationalScalar;
import ScalarPackage.RealScalar;
import ScalarPackage.Scalar;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        double d = 3.00;
        System.out.println(threeAfterDot.format(d));
    }
}
