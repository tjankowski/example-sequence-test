package pl.contium.sequence;

/**
 * Interface for interaction with sequence objects.<br />
 * Provides:
 * <ul>
 * <li>generating next value in sequence</li>
 * <li>getting last generated value in sequence</li>
 * <li>setting sequence last or current value</li>
 * <li>restarting sequence</li>
 * </ul>
 * 
 * @param <T> class representing generated values.
 * @author Tomasz Jankowski
 */
public interface Sequence<T> {

    /**
     * Returns next value in the sequence.
     * @return next value in the sequence.
     */
    public T nextValue();

    /**
     * Returns last generated value in the sequence or first value, if sequence have not generated value.
     * @return last generated value in sequence.
     */
    public T currentValue();
    
    /**
     * Reset the sequence object's counter value for the given value.
     * Next generated value will be next value after given.
     * @param value sets the sequence's last value to the specified value
     * @return the result returned is just the setted value.
     */
    public T setValue(T value);

    /**
     * Sets the sequence object's counter value for the given value.
     * Next generated value will be next value after given if is_called is true or given value if is_called is false.
     * @param value sets the sequence's last value to the specified value.
     * @param is_called if true the next nextValue method will advance the sequence before returning a value or not.
     *        If it is set to false, the next nextValue method will return exactly the specified value.
     * @return the result returned is just the setted value.
     */
    public T setValue(T value, boolean is_called);

     /**
     * Changes the current value of the sequence to the start value.
     * @return start value.
     */
    public T restart();
    
    /**
     * Changes the current value of the sequence.
     * This is equivalent to calling the setValue(value, is_called) function with is_called = false.
     * The specified value will be returned by the next call of nextValue method.
     * @param value  sets the sequence's last value to the specified value.
     * @return the result returned is just the setted value.
     */
    public T restart(T value);

}
