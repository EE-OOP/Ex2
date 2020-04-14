package PolynomialPackage;

import ScalarPackage.Scalar;

public class Monomial {
    private Scalar coe;
    private int exp;

    public Monomial (Scalar coe, int exp) {
        this.coe = coe;
        this.exp = exp;
    }

    public Scalar getCoefficient() {
        return coe;
    }

    public int getExp() {
        return exp;
    }

    public boolean isMatch (Monomial m) { //Checks if both Monomials' coefficients are of a matching type
        return coe.isMatch(m.coe);
    }

    public boolean canAdd (Monomial m) { //Checks matching coefficients and identical exponent values
        return m.isMatch(this) & this.exp == m.exp;
    }

    public Monomial add (Monomial m) {
        if (canAdd(m))
            return new Monomial(m.coe.add(this.coe), this.exp);
        return null;
    }

    public Monomial mul (Monomial m) {
        if (isMatch(m))
            return new Monomial(m.coe.mul(this.coe), this.exp + m.exp);
        return null;
    }

    public Scalar evaluate (Scalar scalar) {
        if (coe.isMatch(scalar)) {
            return this.coe.mul(scalar.power(exp));
        }
        return null;
    }

    public Monomial derivative() {
        return new Monomial(this.coe.mul(exp), exp-1);
    }

    public int sign() {
        return coe.sign();
    }

    @Override
    public String toString() {
        switch(coe.toString()) {
            case"0": //In case the coefficient is 0 returns 0 regardless of other parameters
                return "0";
            case "1": //In case the coefficient is 1, omit it from the final expression
                if (exp==1) //If the exponent is 1, omit it from the final expression
                    return "x";
                else if(exp>0) //If the exponent is larger than, 1 provide the full expression
                    return "x^" + exp;
                else
                    return "1"; //Else the exponent = 0 - return the coefficient
            case "-1": //In case the coefficient is -1, omit it from the final expression but leave its sign
                if (exp==1)
                    return "-x";
                else if (exp>0)
                    return "-x^" + exp;
                else
                    return "-1";
            default: //In case the coefficient is >|1| provides the complete expression
                if (exp==1)
                    return coe + "x";
                else if (exp==0)
                    return coe + "";
                else
                    return coe + "x^" + exp;
        }
    }
}
