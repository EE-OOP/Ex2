package InterpeterPackage;

import PolynomialPackage.Monomial;
import ScalarPackage.RealScalar;
import java.util.Vector;

public class RealPolynomialInterpreter implements PolynomialInterpreter {

    @Override
    public Vector<Monomial> monomialInterpreter(String input) {
        Vector<Monomial> monomials = new Vector<>();
        int exp = 0;
        while(!input.isEmpty()){ //While input is not empty, continue interpreting the monomials
            if(input.charAt(0) == ' ') //If there's a space at the beginning of the string, remove it
                input = input.substring(1);
            else{ //Else begin interpreting the monomial
                RealScalar tempRealScalar = extractCoefficient(input); //Extract the coefficient into a temporary variable
                int toCutFromString; //Variable to determine the amount of characters to cut from input
                if (input.indexOf(" ")==-1) { //If there are no spaces left in input i.e. only the final coefficient to extract is left, prepare to cut the entire string
                    toCutFromString = input.length(); }
                else { //Else prepare to cut the string until the next space
                    toCutFromString = input.indexOf(" "); }
                monomials.add(new Monomial(tempRealScalar,exp)); //Add a new monomial created with the extracted coefficient to the monomials collection
                input = input.substring(toCutFromString); //Cut the string according to the predetermined value
                exp++; //Prepare input into the next slot inside the collection (also represents that monomial's exponent)
            }
        }
        return monomials;
    }

    private RealScalar extractCoefficient(String input){ //Given the input, extracts the coefficient in the beginning of the string
        String nextCoefficient = "";
        while(!input.isEmpty() && input.charAt(0) != ' '){
            nextCoefficient += input.charAt(0);
            input = input.substring(1);
        }
        double coefficient = Double.parseDouble(nextCoefficient);
        return new RealScalar(coefficient);
    }
}
