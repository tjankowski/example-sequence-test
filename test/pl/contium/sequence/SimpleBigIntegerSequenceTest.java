/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.contium.sequence;

import pl.contium.sequence.BadStartValueException;
import pl.contium.sequence.BadMinOrMaxValueException;
import pl.contium.sequence.SimpleBigIntegerSequence;
import java.math.BigInteger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Tomasz Jankowski
 */
public class SimpleBigIntegerSequenceTest {

    public SimpleBigIntegerSequenceTest() {
    }

    /**
     * Test of 1 paramater constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test1ParamConstructor1() {
        System.out.println("1ParamConstructor1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN);
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 1 paramater constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test1ParamConstructor2() {
        System.out.println("1ParamConstructor2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.valueOf(-10));
        BigInteger expResult = BigInteger.valueOf(-11);
        instance.nextValue();
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 1 paramater constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test1ParamConstructor3() {
        System.out.println("1ParamConstructor3");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN);
        BigInteger expResult = BigInteger.valueOf(11);
        instance.nextValue();
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 2 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test2ParamConstructor1() {
        System.out.println("2ParamConstructor1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN, BigInteger.TEN);
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 2 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test2ParamConstructor2() {
        System.out.println("2ParamConstructor2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN, BigInteger.TEN);
        BigInteger expResult = BigInteger.valueOf(20);
        instance.nextValue();
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 2 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test2ParamConstructor3() {
        System.out.println("2ParamConstructor3");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN, BigInteger.valueOf(-10));
        BigInteger expResult = BigInteger.valueOf(0);
        instance.nextValue();
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 3 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test3ParamConstructor1() throws BadMinOrMaxValueException {
        System.out.println("3ParamConstructor1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.ONE, BigInteger.TEN, true);
        BigInteger expResult = BigInteger.ONE;
        for (int i = 0; i < 10; i++) {
            instance.nextValue();
        }
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 3 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test3ParamConstructor2() throws BadMinOrMaxValueException {
        System.out.println("3ParamConstructor2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.ONE, BigInteger.TEN, false);
        BigInteger expResult = BigInteger.TEN;
        for (int i = 0; i < 15; i++) {
            instance.nextValue();
        }
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 3 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test(expected = BadMinOrMaxValueException.class)
    public void test3ParamConstructor3() throws BadMinOrMaxValueException {
        System.out.println("3ParamConstructor3");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN, BigInteger.ONE, true);
    }

    /**
     * Test of 4 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test4ParamConstructor1() throws BadMinOrMaxValueException {
        System.out.println("4ParamConstructor1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.ONE, BigInteger.ONE, BigInteger.TEN, true);
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 4 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test4ParamConstructor2() throws BadMinOrMaxValueException, BadStartValueException {
        System.out.println("4ParamConstructor2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.valueOf(-1), BigInteger.ONE, BigInteger.TEN, true);
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 5 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test
    public void test5ParamConstructor1() throws BadMinOrMaxValueException, BadStartValueException {
        System.out.println("5ParamConstructor1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.TEN, BigInteger.valueOf(-1), BigInteger.ONE, BigInteger.TEN, false);
        BigInteger expResult = BigInteger.ONE;
        for (int i = 0; i < 15; i++) {
            instance.nextValue();
        }
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of 5 paramaters constuctor, of class SimpleBigIntegerSequence.
     */
    @Test(expected = BadStartValueException.class)
    public void test5ParamConstructor2() throws BadMinOrMaxValueException, BadStartValueException {
        System.out.println("5ParamConstructor2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence(BigInteger.valueOf(-1), BigInteger.ONE, BigInteger.ONE, BigInteger.TEN, true);
    }

    /**
     * Test of nextValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testNextValue1() {
        System.out.println("nextValue1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.nextValue();
        assertTrue(result.equals(expResult));
    }

    /**
     * Test of nextValue method, of class SimpleBigIntegerSequence after 10 calls.
     */
    @Test
    public void testNextValue2() {
        System.out.println("nextValue2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = null;
        for (int i = 0; i < 10; i++) {
            result = instance.nextValue();
        }
        assertTrue(result.equals(expResult));
    }

    /**
     * Test of currentValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testCurrentValue1() {
        System.out.println("currentValue1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.ONE;
        BigInteger result = instance.currentValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of currentValue method, of class SimpleBigIntegerSequence after 10 calls.
     */
    @Test
    public void testCurrentValue2() {
        System.out.println("currentValue2");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        for (int i = 0; i < 10; i++) {
            instance.nextValue();
        }
        BigInteger result = instance.currentValue();
        assertEquals(expResult, result);
    }

        /**
     * Test of restart method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testRestart1() {
        System.out.println("restart1");
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.ONE;
        for (int i = 0; i < 10; i++) {
            instance.nextValue();
        }
        instance.restart();
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of restart method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testRestart_BigInteger1() {
        System.out.println("restart_BigInteger1");
        BigInteger value = BigInteger.TEN;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        instance.restart(value);
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger1() {
        System.out.println("setValue_BigInteger1");
        BigInteger value = BigInteger.TEN;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        instance.setValue(value);
        BigInteger result = instance.currentValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger2() {
        System.out.println("setValue_BigInteger2");
        BigInteger value = BigInteger.TEN;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = instance.setValue(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger_boolean1() {
        System.out.println("setValue1_BigInteger_boolean");
        BigInteger value = BigInteger.TEN;
        boolean is_called = false;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = instance.setValue(value, is_called);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger_boolean2() {
        System.out.println("setValue_BigInteger_boolean2");
        BigInteger value = BigInteger.TEN;
        boolean is_called = true;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        BigInteger result = instance.setValue(value, is_called);
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger_boolean4() {
        System.out.println("setValue_BigInteger_boolean4");
        BigInteger value = BigInteger.TEN;
        boolean is_called = false;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.TEN;
        instance.setValue(value, is_called);
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }

    /**
     * Test of setValue method, of class SimpleBigIntegerSequence.
     */
    @Test
    public void testSetValue_BigInteger_boolean3() {
        System.out.println("setValue_BigInteger_boolean3");
        BigInteger value = BigInteger.TEN;
        boolean is_called = true;
        SimpleBigIntegerSequence instance = new SimpleBigIntegerSequence();
        BigInteger expResult = BigInteger.valueOf(11);
        instance.setValue(value, is_called);
        BigInteger result = instance.nextValue();
        assertEquals(expResult, result);
    }
}
