package PolynomialPackage;

import InterpeterPackage.*;
import ScalarPackage.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class Polynomial {
    private Collection<Monomial> monomials;

    public Polynomial() { }

    private Collection<Monomial> getMonomials() {
        return monomials;
    }

    private void setMonomials(Collection<Monomial> monomials) {
        this.monomials = monomials;
    }

    private char getType() { //Returns the type of 'this' Polynomial
        for (Monomial monomial : monomials) {
            if (monomial.getCoefficient().isMatch(new RealScalar()))
                return 'R';
            else
                break;
        }
        return 'Q';
    }

    //Uses the interpreter to build the Polynomial represented in string value
    public Polynomial build (char type, String input) {
        PolynomialInterpreter interpreter;
        if (type == 'R') {
            interpreter = new RealPolynomialInterpreter(); }
        else {
            interpreter = new RationalPolynomialInterpreter(); }
        monomials = interpreter.monomialInterpreter(input);
        return this;
    }

    public boolean isMatch (Polynomial p) {
        return this.getType() == p.getType();
    }

    public Polynomial add (Polynomial p) {
        if (!this.isMatch(p))
            return null;
        Polynomial sum = new Polynomial();
        sum.build(getType(), "");
        Iterator<Monomial> otherMonomials = p.monomials.iterator();
        //Discerns between each Polynomial's most prominent exponent and performs the addition into a new Polynomial accordingly
        for (Monomial monomial : monomials) {
            if (otherMonomials.hasNext())
                sum.monomials.add(monomial.add(otherMonomials.next()));
            else
                sum.monomials.add(monomial);
        }
        while (otherMonomials.hasNext())
            sum.monomials.add(otherMonomials.next());
        return sum;
    }

    public Polynomial mul (Polynomial p) {
        if (!this.isMatch(p))
            return null;
        Polynomial product = new Polynomial();
        product.build(getType(), "");
        Vector<Monomial> monomialA = new Vector<>(); //Uses a Vector Collection in order to make use of its efficient value in index fetching capabilities
        monomialA.setSize(p.getMonomials().size()+this.getMonomials().size()-1); //Sets size to the maximal exponent expected in the output
        for (Monomial monomial : getMonomials()) { //Uses a nested loop to ensure each Monomial of each Polynomial is multiplied by the other's
            for (Monomial otherMonomial : p.getMonomials()) {
                Monomial tempMonomial = monomial.mul(otherMonomial);
                if (monomialA.get(tempMonomial.getExp())==null)
                    monomialA.set(tempMonomial.getExp(), tempMonomial);
                else
                    monomialA.set(tempMonomial.getExp(), tempMonomial.add(monomialA.get(tempMonomial.getExp())));
            }
        }
        product.setMonomials(monomialA);
        return product;
    }

    public Scalar evaluate (Scalar scalar) {
        if (!scalar.isMatch(this.getMonomials().iterator().next().getCoefficient()))
            return null;
        Scalar s = scalar.clone(); //Makes use of the clone method to produce a new Scalar of a matching type
        s = s.mul(0); //Sets the Scalar's value to 0 in order to compute the addition of the final value appropriately
        for (Monomial monomial : monomials) {
            s = s.add(monomial.evaluate(scalar));
        }
        return s;
    }

    public Polynomial derivative() {
        Vector<Monomial> derivation = new Vector(); //Uses a Vector Collection in order to make use of its efficient value in index fetching capabilities
        derivation.setSize(Math.max(1,getMonomials().size()-1)); //Sets its size to that of this Polynomial's maximal exponent Monomial-1
        Polynomial derivative = new Polynomial();
        derivative.build(getType(), "");
        Iterator<Monomial> monomialIt = monomials.iterator();
        Monomial monoNext = monomialIt.next();
        if (!monomialIt.hasNext()) { //If this Polynomial consists of a constant only, returns the 0 Polynomial
            derivation.set(0, monoNext.derivative());
            derivative.setMonomials(derivation);
            return derivative;
        }
        while (monomialIt.hasNext()) { //Otherwise this Polynomial contains more values, proceed with the regular derivation process
            Monomial tempMonomial = monomialIt.next().derivative();
            derivation.set(tempMonomial.getExp(), tempMonomial);
        }
        derivative.setMonomials(derivation);
        return derivative;
    }

    @Override
    public String toString() {
        String polynomial = "";
        if (getMonomials().size()==1) //If this Polynomial's Collection size is 1, return the coefficient representing it (takes care of the '0' Polynomial case)
            return this.getMonomials().iterator().next().getCoefficient().toString();
        for (Monomial monomial : monomials) { //Otherwise, parse the Polynomial into segments where every following positive value is preceded by a '+' sign
            if (monomial!=null) {
                if (monomial.getCoefficient().sign() > 0 & !polynomial.isEmpty())
                    polynomial += "+";
                if (monomial.getCoefficient().sign() != 0)
                    polynomial += monomial.toString();
            }
        }
        return polynomial;
    }
}
