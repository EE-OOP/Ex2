import PolynomialPackage.Polynomial;
import ScalarPackage.RationalScalar;
import ScalarPackage.RealScalar;
import ScalarPackage.Scalar;

import java.text.DecimalFormat;

public class Main {
    public static void main(String[] args) {
//        Polynomial R1 = new Polynomial(); R1.build('R', "0.5 1");
//        System.out.println(R1);
//        Polynomial R2 = new Polynomial(); R2.build('R', "1 0 -1 0 0.25");
//        System.out.println(R2);
//        Polynomial R3 = new Polynomial(); R3.build('R', "5 0 -2");
//        System.out.println(R3);
//        Polynomial R4 = new Polynomial(); R4.build('R', "5");
//        System.out.println(R4);
//        Polynomial Q1 = new Polynomial(); Q1.build('Q', "2/-1");
//        System.out.println(Q1);
//        Polynomial Q2 = new Polynomial(); Q2.build('Q', "1/2 1 0 8");
//        System.out.println(Q2);
//        Polynomial Q3 = new Polynomial(); Q3.build('Q', "0 0 100");
//        System.out.println(Q3);
//        Polynomial Q4 = new Polynomial(); Q4.build('Q', "0 -1");
//        System.out.println(Q4);
//        Polynomial Q5 = new Polynomial(); Q5.build('Q', "0 -1/-2");
//        System.out.println(Q5);


        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        System.out.println(threeAfterDot.format(1111.6549));
        double v = 1.9999;
        v = Double.parseDouble(threeAfterDot.format(v));
        System.out.println(v);
    }
}
