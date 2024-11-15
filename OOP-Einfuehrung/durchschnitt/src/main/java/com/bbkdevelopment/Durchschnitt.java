package com.bbkdevelopment;

/**
 * Programm zur Berechnung des Durschnittes aus einem Array von int-Zahlen.
 */
public class Durchschnitt {

  /**
   * Methode zur Berechnung des Durchschnittes eines Arrays von nichtnegativen int-Zahlen.
   *
   * @param feld ein Array von int-Zahlen.
   * @return Der berechnete Durchschnitt der Zahlen im Array.
   */
  public double berechneDurchschnitt(int[] feld) {
    if (feld.length == 0) {
      return 0;
    }

    int durchschnitt = 0;
    for (final int i : feld) {
      durchschnitt += i;
    }
    return (double) durchschnitt / feld.length;
  }
}