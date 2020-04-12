package MonomialPackage;

import ScalarPackage.Scalar;

public class Monomial {
    private Scalar coe;
    private int exp;

    public Monomial (Scalar coe, int exp) {
        this.coe = coe;
        this.exp = exp;
    }

    public boolean isMatch (Monomial m) {
        return coe.isMatch(m.coe);
    }

    public boolean canAdd (Monomial m) {
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
        coe = this.coe.mul(exp);
        exp--;
        return this;
    }

    public int sign() {
        return coe.sign();
    }

    public String toString() {
        if (coe.toString().equals("1") & exp>1)
            return "x";
        else if (coe.toString().equals("-1") & exp>1)
            return "-x";
        else if (exp==1)
        return coe + "x^" + exp;

        switch(coe.toString()) {
            case "1":
                if (exp==1)
                    return "x";
                else if(exp>0)
                    return "x^" + exp;
                else
                    return "1";
            case "-1":
                if (exp==1)
                    return "-x";
                else if (exp>0)
                    return "-x^" + exp;
                else
                    return "-1";
            default:
                if (exp==1)
                    return coe + "x";
                else if (exp==0)
                    return coe + "";
                else
                    return coe + "x^" + exp;
        }
    }
}
