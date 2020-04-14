package InterpeterPackage;

import PolynomialPackage.Monomial;
import java.util.Vector;


public interface PolynomialInterpreter {
    //Interprets a given string into a collection of Monomials
    Vector<Monomial> monomialInterpreter(String input);
}
