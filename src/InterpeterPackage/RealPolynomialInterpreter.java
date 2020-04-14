package InterpeterPackage;

import PolynomialPackage.Monomial;
import ScalarPackage.RealScalar;

import java.util.ArrayList;

public class RealPolynomialInterpreter implements PolynomialInterpreter {

    @Override
    public ArrayList<Monomial> monomialInterpreter(String input) {
        ArrayList<Monomial> monomials = new ArrayList<>();
        int exp = 0;
        while(!input.isEmpty()){
            if(input.charAt(0) == ' ')
                input = input.substring(1);
            else{
                RealScalar tempRealScalar = extractCoefficient(input);
                int toCutFromString = tempRealScalar.toString().length();
                monomials.add(new Monomial(tempRealScalar,exp));
                input = input.substring(toCutFromString);
                exp++;
            }
        }
        return monomials;
    }

    private RealScalar extractCoefficient(String input){
        String nextCoefficient = "";
        while(!input.isEmpty() && input.charAt(0) != ' '){
            nextCoefficient += input.charAt(0);
            input = input.substring(1);
        }
        double coefficient = Double.parseDouble(nextCoefficient);
        return new RealScalar(coefficient);
    }
}
