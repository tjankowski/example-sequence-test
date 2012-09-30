/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.contium;

import java.math.BigInteger;
import pl.contium.sequence.BadMinOrMaxValueException;
import pl.contium.sequence.BadStartValueException;
import pl.contium.sequence.SimpleBigIntegerSequence;

/**
 * Testing class for SimpleBigIntegerSequence class
 * @author Tomasz Jankowski
 * @see SimpleBigIntegerSequence
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        SimpleBigIntegerSequence sequence = new SimpleBigIntegerSequence();
        try {
            for (int i = 0; i < 10; i++) {
                System.out.print(sequence.nextValue() + " ; ");
            }
            System.out.println();

            sequence.setMaxValue(BigInteger.TEN);
            sequence.setMinValue(BigInteger.ONE);
            for (int i = 0; i < 3; i++) {
                System.out.print(sequence.nextValue() + " ; ");
            }
            System.out.println();

            sequence.setCycle(true);
            for (int i = 0; i < 15; i++) {
                System.out.print(sequence.nextValue() + " ; ");
            }
            System.out.println();

            sequence.setIncrement(BigInteger.valueOf(-3));
            sequence.setMinValue(BigInteger.valueOf(-30));
            for (int i = 0; i < 15; i++) {
                System.out.print(sequence.nextValue() + " ; ");
            }
            System.out.println();

            sequence.setIncrement(BigInteger.ONE);
            sequence.restart(BigInteger.ZERO);
            for (int i = 0; i < 15; i++) {
                System.out.print(sequence.nextValue() + " ; ");
            }
            System.out.println();

            sequence.setStart(BigInteger.valueOf(100));
        } catch (BadMinOrMaxValueException exception) {
            System.out.println();
            System.out.println("Exception: " + exception.getMessage());
        } catch (BadStartValueException exception) {
            System.out.println();
            System.out.println("Exception: " + exception.getMessage());
        }
    }
}
