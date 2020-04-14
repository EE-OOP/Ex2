package InterpeterPackage;

import PolynomialPackage.Monomial;
import ScalarPackage.RationalScalar;
import java.util.Vector;

public class RationalPolynomialInterpreter implements PolynomialInterpreter {

    @Override
    public Vector<Monomial> monomialInterpreter(String input) {
        Vector<Monomial> monomials = new Vector<>();
        int exp = 0;
        while(!input.isEmpty()){ //While input is not empty, continue interpreting the monomials
            if(input.charAt(0) == ' ') //If there's a space at the beginning of the string, remove it
                input = input.substring(1);
            else{ //Else begin interpreting the monomial
                RationalScalar tempRationalScalar = extractCoefficient(input); //Extract the coefficient into a temporary variable
                int toCutFromString; //Variable to determine the amount of characters to cut from input
                if (input.indexOf(" ")==-1) { //If there are no spaces left in input i.e. only the final coefficient to extract is left, prepare to cut the entire string
                    toCutFromString = input.length(); }
                else { //Else prepare to cut the string until the next space
                    toCutFromString = input.indexOf(" "); }
                monomials.add(new Monomial(tempRationalScalar,exp)); //Add a new monomial created with the extracted coefficient to the monomials collection
                input = input.substring(toCutFromString); //Cut the string according to the predetermined value
                exp++; //Prepare input into the next slot inside the collection (also represents that monomial's exponent)
            }
        }
        return monomials;
    }

    private RationalScalar extractCoefficient(String input){ //Given the input, extracts the coefficient in the beginning of the string
        String nextMonomial = "";
        while(!input.isEmpty() && input.charAt(0) != ' '){
            nextMonomial += input.charAt(0);
            input = input.substring(1);
        }
        String[] tempStringArray = nextMonomial.split("/");
        if(tempStringArray.length == 2) //If the coefficient is represented by a numerator and a denominator, the array will have 2 slots
            return new RationalScalar(Integer.parseInt(tempStringArray[0]),Integer.parseInt(tempStringArray[1]));
        else //Else it will only have one and the denominator will be equal to 1
            return new RationalScalar(Integer.parseInt(tempStringArray[0]),1);

    }
}
