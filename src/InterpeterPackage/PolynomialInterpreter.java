package InterpeterPackage;

import PolynomialPackage.Monomial;
        import java.util.ArrayList;
import java.util.Vector;


public interface PolynomialInterpreter {
    Vector<Monomial> monomialInterpreter(String input);
}
