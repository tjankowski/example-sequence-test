package pl.contium.sequence;

import java.math.BigInteger;

/**
 * Simple sequence class for generating BigInteger numbers.<br />
 * Default first value of the sequence is BigInteger.ONE and increment value is also BigInteger.ONE. <br />
 * By default, the sequence does not have a cycle, minimal or maximal value.
 * 
 * @author Tomasz Jankowski
 * @see Sequence
 * @see BigInteger
 */
public class SimpleBigIntegerSequence implements Sequence<BigInteger> {

    /**
     * Specifies which value is added to the current sequence value to create a new value.
     */
    private BigInteger increment = BigInteger.ONE;
    
    /**
     * Specifies last generated value in sequence.
     */
    private BigInteger lastValue = BigInteger.ONE;

    /**
     * Determines the minimum value a sequence can generate.
     */
    private BigInteger minValue;

    /**
     * Determines the maximum value for the sequence.
     */
    private BigInteger maxValue;

    /**
     * Specifying first generated number.
     */
    private BigInteger start = BigInteger.ONE;

    /**
     * Determines whether the sequence have  already generate value.
     */
    private boolean isCalled = false;

    /**
     * Option that allows sequence wrap around when the minimal or maximum value has been reached.
     */
    private boolean cycle = false;

    /**
     * Class constructor.
     */
    public SimpleBigIntegerSequence() {
    }

    /**
     * Class constructor specifying increment value.
     * @param increment specifies which value is added to the current sequence value to create a new value.
     */
    public SimpleBigIntegerSequence(BigInteger increment) {
        this.increment = increment;
        if (this.increment.compareTo(BigInteger.ZERO) > 0) {
            this.start = BigInteger.ONE;
            
        } else {
            this.start = BigInteger.valueOf(-1);
        }
        this.lastValue = this.start;
    }

    /**
     * Class constructor specifying start value and increment value.
     * @param start value specifying first generated number.
     * @param increment specifies which value is added to the current sequence value to create a new value.
     */
    public SimpleBigIntegerSequence(BigInteger start, BigInteger increment) {
        this.increment = increment;
        this.start = start;
        this.lastValue = this.start;
    }

    /**
     * Class constructor specifying minimum value, maximum value and cycle.
     * Throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @param min determines the minimum value a sequence can generate.
     * @param max determines the maximum value for the sequence.
     * @param cycle option that allows sequence wrap around when the minimal or maximum value has been reached.
     * @throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @see BadMinOrMaxValueException
     */
    public SimpleBigIntegerSequence(BigInteger min, BigInteger max, boolean cycle) throws BadMinOrMaxValueException {
        if (min.compareTo(max) > -1) {
            throw new BadMinOrMaxValueException("Minimum sequence value cannot be equal or bigger than maximum value");
        }
        this.minValue = min;
        this.maxValue = max;
        this.cycle = cycle;
        if (this.increment.compareTo(BigInteger.ZERO) > 0) {
            this.start = this.minValue;
        } else {
            this.start = this.maxValue;
        }
        this.lastValue = this.start;
    }

    /**
     * Class constructor specifying increment value, minimum value, maximum value and cycle.
     * Throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @param increment specifies which value is added to the current sequence value to create a new value.
     * @param min determines the minimum value a sequence can generate.
     * @param max determines the maximum value for the sequence.
     * @param cycle option that allows sequence wrap around when the minimal or maximum value has been reached.
     * @throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @see BadMinOrMaxValueException
     */
    public SimpleBigIntegerSequence(BigInteger increment, BigInteger min, BigInteger max, boolean cycle) throws BadMinOrMaxValueException {
        if (min.compareTo(max) > -1) {
            throw new BadMinOrMaxValueException("Minimum sequence value cannot be equal or bigger than maximum value");
        }
        this.increment = increment;
        this.minValue = min;
        this.maxValue = max;
        this.cycle = cycle;
        if (this.increment.compareTo(BigInteger.ZERO) > 0) {
            this.start = this.minValue;
        } else {
            this.start = this.maxValue;
        }
        this.lastValue = this.start;
    }

    /**
     * Class constructor specifying start value, increment value, minimum value, maximum value and cycle.
     * Throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * Throws BadStartValueException if start value is smaller than minimal value or bigger than maximal value.
     * @param start value specifying first generated number.
     * @param increment specifies which value is added to the current sequence value to create a new value.
     * @param min determines the minimum value a sequence can generate.
     * @param max determines the maximum value for the sequence.
     * @param cycle option that allows sequence wrap around when the minimal or maximum value has been reached.
     * @throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @throws BadStartValueException if start value is smaller than minimal value or bigger than maximal value.
     * @see BadMinOrMaxValueException
     * @see BadStartValueException
     */
    public SimpleBigIntegerSequence(BigInteger start, BigInteger increment, BigInteger min, BigInteger max, boolean cycle) throws BadMinOrMaxValueException, BadStartValueException {
        if (min.compareTo(max) > -1) {
            throw new BadMinOrMaxValueException("Minimum sequence value cannot be equal or bigger than maximum value");
        }
        if ((start.compareTo(min) < 0) || (start.compareTo(max) > 0)) {
            throw new BadStartValueException("Start sequence value must be equal or smaller then maximum sequence value and equal or bigger then minimum sequence value");
        }
        this.increment = increment;
        this.start = start;
        this.minValue = min;
        this.maxValue = max;
        this.cycle = cycle;
        this.lastValue = this.start;
    }

    /**
     * Advance the sequence object to its next value and return that value.
     * @return next value in the sequence.
     */
    public synchronized BigInteger nextValue() {
        if (this.isCalled) {
            this.lastValue = this.lastValue.add(this.getIncrement());
        } else {
            this.isCalled = true;
        }

        if (isCycle()) {
            if (this.getIncrement().compareTo(BigInteger.ZERO) > 0) {
                if (this.lastValue.compareTo(this.getMaxValue()) > 0) {
                    return this.lastValue = this.getMinValue();
                } else {
                    return this.lastValue;
                }
            } else {
                if (this.lastValue.compareTo(this.getMinValue()) < 0) {
                    return this.lastValue = this.getMaxValue();
                } else {
                    return this.lastValue;
                }
            }
        } else {
            if (this.getIncrement().compareTo(BigInteger.ZERO) > 0) {
                if ((this.getMaxValue() != null) && (this.lastValue.compareTo(this.getMaxValue()) > 0)) {
                    return this.lastValue = this.getMaxValue();
                } else {
                    return this.lastValue;
                }
            } else {
                if ((this.getMinValue() != null) && (this.lastValue.compareTo(this.getMinValue()) < 0)) {
                    return this.lastValue = this.getMinValue();
                } else {
                    return this.lastValue;
                }
            }
        }
    }

    /**
     * Return the value most recently obtained by nextValue method.
     * @return most recently obtained by nextValue method.
     */
    public synchronized BigInteger currentValue() {
        return this.lastValue;
    }

    /**
     * Reset the sequence object's counter value.
     * @param value sets the sequence's last value to the specified value.
     * @return the result returned is just the value of its argument.
     */
    public synchronized BigInteger setValue(BigInteger value) {
        this.lastValue = value;
        this.isCalled = true;
        return this.lastValue;
    }

    /**
     * Reset the sequence object's counter value.
     * @param value sets the sequence's last value to the specified value.
     * @param is_called if true the next nextValue method will advance the sequence before returning a value or not.
     *        If it is set to false, the next nextValue method will return exactly the specified value.
     * @return the result returned is just the value of its first argument.
     */
    public synchronized BigInteger setValue(BigInteger value, boolean is_called) {
        this.lastValue = value;
        this.isCalled = is_called;
        return this.lastValue;
    }

    /**
     * Changes the current value of the sequence to the start value.
     * @return start value.
     */
    public synchronized BigInteger restart() {
        return this.setValue(this.start, false);
    }

    /**
     * Changes the current value of the sequence.
     * This is equivalent to calling the setValue(value, is_called) function with is_called = false.
     * The specified value will be returned by the next call of nextValue method.
     * @param value  sets the sequence's last value to the specified value.
     * @return the result returned is just the value of its argument.
     */
    public synchronized BigInteger restart(BigInteger value) {
        return this.setValue(value, false);
    }

    /**
     * Gets the increment value of this sequence.
     * @return the increment specifies value added to the current sequence value to create a new value.
     */
    public synchronized BigInteger getIncrement() {
        return increment;
    }

    /**
     * Sets the increment value of this sequence.
     * @param increment specifies which value is added to the current sequence value to create a new value.
     */
    public synchronized void setIncrement(BigInteger increment) {
        this.increment = increment;
    }

    /**
     * Gets the minimal value a sequence can generate.
     * @return the minValue determines the minimum value a sequence can generate.
     */
    public synchronized BigInteger getMinValue() {
        return minValue;
    }

    /**
     * Sets the minimal value a sequence can generate.
     * Throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @param minValue determines the minimum value a sequence can generate.
     * @throws BadMinOrMaxValueException if minimal value is bigger than maximal sequence value.
     * @see BadMinOrMaxValueException
     */
    public synchronized void setMinValue(BigInteger minValue) throws BadMinOrMaxValueException {
        if ((this.maxValue != null) && (minValue.compareTo(this.maxValue) > -1)) {
            throw new BadMinOrMaxValueException("Minimum sequence value cannot be equal or bigger than maximum value");
        } else {
            this.minValue = minValue;
        }
    }

    /**
     * Gets the maximum value a sequence can generate.
     * @return the maxValue determines the maximum value a sequence can generate.
     */
    public synchronized BigInteger getMaxValue() {
        return maxValue;
    }

    /**
     * Sets the maximum value a sequence can generate.
     * Throws BadMinOrMaxValueException if maximal value is smaller than minimal sequence value.
     * @param maxValue determines the maximum value a sequence can generate.
     * @throws BadMinOrMaxValueException if maximal value is smaller than minimal sequence value.
     * @see BadMinOrMaxValueException
     */
    public synchronized void setMaxValue(BigInteger maxValue) throws BadMinOrMaxValueException {
        if ((this.minValue != null) && (this.minValue.compareTo(maxValue) > -1)) {
            throw new BadMinOrMaxValueException("Minimum sequence value cannot be equal or bigger than maximum value");
        } else {
            this.maxValue = maxValue;
        }
    }

    /**
     * Gets cycle value that allows sequence wrap around when the minimal or maximum value has been reached.
     * @return the cycle value.
     */
    public synchronized boolean isCycle() {
        return cycle;
    }

    /**
     * Sets cycle value that allows sequence wrap around when the minimal or maximum value has been reached.
     * @param cycle the cycle value to set.
     */
    public synchronized void setCycle(boolean cycle) {
        this.cycle = cycle;
    }

    /**
     * Gets start value specifying first generated number.
     * @return the start specifying first generated number.
     */
    public synchronized BigInteger getStart() {
        return start;
    }

    /**
     * Sets start value specifying first generated number.
     * Throws BadStartValueException if start value is smaller than minimal value or bigger than maximal value.
     * @param start value specifying first generated number.
     * @throws BadStartValueException if start value is smaller than minimal value or bigger than maximal value.
     * @see BadStartValueException
     */
    public synchronized void setStart(BigInteger start) throws BadStartValueException {
        if (((this.minValue != null) && (start.compareTo(this.minValue)) < 0) || ((this.maxValue != null) && (start.compareTo(this.maxValue) > 0))) {
            throw new BadStartValueException("Start sequence value must be equal or smaller then maximum sequence value and equal or bigger then minimum sequence value");
        }
        this.start = start;
    }
}
