package InterpeterPackage;

import PolynomialPackage.Monomial;
import ScalarPackage.RationalScalar;


import java.util.ArrayList;
import java.util.Vector;

public class RationalPolynomialInterpreter implements PolynomialInterpreter {

    public Vector<Monomial> monomialInterpreter(String input) {
        Vector<Monomial> monomials = new Vector<>();
        int exp = 0;
        while(!input.isEmpty()){
            if(input.charAt(0) == ' ')
                input = input.substring(1);
            else{
                RationalScalar tempRationalScalar = extractCoefficient(input);
                int toCutFromString;
                if (input.indexOf("/")!=-1 & input.indexOf("/") < input.indexOf(tempRationalScalar.getDenominator() + "")) { //case equals check
                    toCutFromString = ((Integer) tempRationalScalar.getNumerator()).toString().length() + ((Integer) tempRationalScalar.getDenominator()).toString().length()+1; }
                else {
                    toCutFromString = ((Integer) tempRationalScalar.getNumerator()).toString().length(); }
                monomials.add(new Monomial(tempRationalScalar,exp));
                input = input.substring(toCutFromString);
                exp++;
            }
        }
        return monomials;
    }

    private RationalScalar extractCoefficient(String input){
        String nextMonomial = "";
        while(!input.isEmpty() && input.charAt(0) != ' '){
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
