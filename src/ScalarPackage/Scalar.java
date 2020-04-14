package ScalarPackage;

import VisitorPackage.Visitor;

public interface Scalar {
    //Checks if Scalar s is of the same type as the implementing Object
    boolean isMatch(Scalar s);

    //Sums Scalar s with the implementing Object if they are of the same type
    Scalar add(Scalar s);

    //Multiplies Scalar s with the implementing Object if they are of the same type
    Scalar mul(Scalar s);

    //Multiplies the implementing object by the value of 'i'
    Scalar mul(int i);

    //Raises the implementing Object to the power of the value 'exp'
    Scalar power(int exp);

    //Returns <-1 for negative values, 0 for 0, >1 for positive numbers
    int sign();

    //Uses the visitor pattern to ensure compatibility and produce the desired product
    void accept(Visitor visitor, RealScalar s);

    //Uses the visitor pattern to ensure compatibility and produce the desired product
    void accept(Visitor visitor, RationalScalar s);

    //Generates an exact copy of the implementing Object
    Scalar clone ();
}
