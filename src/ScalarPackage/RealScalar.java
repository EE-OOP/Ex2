package ScalarPackage;

import VisitorPackage.*;

import java.text.DecimalFormat;

public class RealScalar implements Scalar {

    private double v;


    public RealScalar() {
    }

    public RealScalar(double v){
        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        this.v = Double.parseDouble(threeAfterDot.format(v)); //Rounds v to the closest value following the pattern
    }

    @Override
    public Scalar clone() {
        return new RealScalar(v);
    } //Generates an exact copy of 'this'

    @Override
    public boolean isMatch(Scalar s) { //Uses the visitor pattern to check Scalar type compatibility
        MatcherVisitor visitor = new MatcherVisitor();
        s.accept(visitor,this);
        return visitor.isMatch();
    }

    @Override
    public Scalar add(Scalar s) { //Uses the visitor pattern to ensure compatibility and produce the desired sum
        AdderVisitor visitor = new AdderVisitor();
        s.accept(visitor,this);
        return visitor.getSum();
    }

    @Override
    public Scalar mul(Scalar s) { //Uses the visitor pattern to ensure compatibility and produce the desired product
        MultiplierVisitor visitor = new MultiplierVisitor();
        s.accept(visitor,this);
        return visitor.getProduct();
    }

    @Override
    public Scalar mul(int i) {
        return new RealScalar(getValue()*i);
    }

    @Override
    public Scalar power(int exp) {
        return new RealScalar(Math.pow(v,exp));
    }

    @Override
    public int sign() {
       return (int) Math.signum(v);
    }

    @Override
    public void accept(Visitor visitor, RealScalar s) { //Function to allow the visitor to behave appropriately
        visitor.visit(this,s);
    }

    public void accept(Visitor visitor, RationalScalar s) { //Function to allow the visitor to behave appropriately
        visitor.visit(this,s);
    }

    public double getValue() {
        return v;
    }

    @Override
    public String toString() { //Ensures desired format is saved and that unnecessary characters are omitted
        DecimalFormat threeAfterDot = new DecimalFormat("#.###");
        return threeAfterDot.format(getValue());
    }
}
