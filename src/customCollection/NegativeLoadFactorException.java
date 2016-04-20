package customCollection;

/**
 * Created by Dim on 20.04.2016.
 */
public class NegativeLoadFactorException extends RuntimeException{

    public NegativeLoadFactorException(){
        super("Negative load factor!");
    }

}
