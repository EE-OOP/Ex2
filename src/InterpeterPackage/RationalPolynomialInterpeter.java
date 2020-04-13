package InterpeterPackage;

import MonomialPackage.Monomial;
import ScalarPackage.RationalScalar;


import java.util.ArrayList;
import java.util.Collection;

public class RationalPolynomialInterpeter implements PolynomialInterpeter {

    public ArrayList<Monomial> monomialInterpreter(String input) {
        ArrayList<Monomial> monomials = new ArrayList<>();
        int exp = 0;
        while(!input.isEmpty()){
            if(input.charAt(0) == ' ')
                input = input.substring(1);
            else{
                RationalScalar tempRationalScalar = extractCoefficient(input);
                int toCutFromString = ((Integer) tempRationalScalar.getNumerator()).toString().length() + ((Integer) tempRationalScalar.getDenominator()).toString().length();
                monomials.add(new Monomial(tempRationalScalar,exp));
                input = input.substring(toCutFromString+1);
                exp++;
            }
        }
        return monomials;
    }

    private RationalScalar extractCoefficient(String input){
        String nextMonomial = "";
        while(input.charAt(0) != ' '){
            nextMonomial += input.charAt(0);
            input = input.substring(1);
        }
        String[] tempStringArray = nextMonomial.split("/");
        if(tempStringArray.length == 2)
            return new RationalScalar(Integer.parseInt(tempStringArray[0]),Integer.parseInt(tempStringArray[1]));
        else
            return new RationalScalar(Integer.parseInt(tempStringArray[0]),1);

    }
}
