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

    private char getType() {
        for (Monomial monomial : monomials) {
            if (monomial.getCoefficient().isMatch(new RealScalar()))
                return 'R';
            else
                break;
        }
        return 'Q';
    }

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
        Vector<Monomial> monomialA = new Vector<>();
        monomialA.setSize(p.getMonomials().size()+this.getMonomials().size()-1);
        for (Monomial monomial : getMonomials()) {
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
        Scalar s = scalar.clone();
        s = s.mul(0);
        for (Monomial monomial : monomials) {
            s = s.add(monomial.evaluate(scalar));
        }
        return s;
    }

    public Polynomial derivative() {
        Vector<Monomial> derivative = new Vector();
        derivative.setSize(Math.max(1,getMonomials().size()-1));
        Polynomial derivate = new Polynomial();
        derivate.build(getType(), "");
        Iterator<Monomial> monomialIt = monomials.iterator();
        Monomial monoNext = monomialIt.next();
        if (!monomialIt.hasNext()) {
            derivative.set(0, monoNext.derivative());
            derivate.setMonomials(derivative);
            return derivate;
        }
        while (monomialIt.hasNext()) {
            Monomial tempMonomial = monomialIt.next().derivative();
            derivative.set(tempMonomial.getExp(), tempMonomial);
        }
        derivate.setMonomials(derivative);
        return derivate;
    }



    @Override
    public String toString() {
        String polynomial = "";
        if (getMonomials().size()==1)
            return this.getMonomials().iterator().next().getCoefficient().toString();
        for (Monomial monomial : monomials) {
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
