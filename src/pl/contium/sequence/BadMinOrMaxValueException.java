package pl.contium.sequence;

/**
 * Thrown to indicate that minimal value is bigger than maximal sequence value.
 * @author Tomasz Jankowski
 */
public class BadMinOrMaxValueException extends Exception{

    /**
     * Constructs a BadMinOrMaxValueException with no detail message.
     */
    public BadMinOrMaxValueException(){
        super();
    }

    /**
     * Constructs a BadMinOrMaxValueException class with the specified detail message.
     * @param message the detail message.
     */
    public BadMinOrMaxValueException(String message) {
        super(message);
    }

}
