package pl.contium.sequence;

/**
 * Thrown to indicate that start value is smaller than minimal value or bigger than maximal value.
 * @author Tomasz Jankowski
 */
public class BadStartValueException extends Exception{

    /**
     * Constructs a BadStartValueException with no detail message.
     */
    public BadStartValueException(){
        super();
    }

    /**
     * Constructs a BadStartValueException class with the specified detail message.
     * @param message the detail message.
     */
    public BadStartValueException(String message) {
        super(message);
    }

}
