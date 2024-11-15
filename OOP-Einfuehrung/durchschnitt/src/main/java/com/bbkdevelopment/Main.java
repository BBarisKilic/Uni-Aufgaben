package com.bbkdevelopment;

/**
 * Main-Klasse.
 */
public final class Main {

  /**
   * Main-Methode.
   *
   * @param args Argumente der Kommandozeile.
   */
  public static void main(String[] args) {
    final int[] feld = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    final Durchschnitt durchschnitt = new Durchschnitt();
    System.out.println(
        "Der Durchschnitt der Zahlen im Array ist: " + durchschnitt.berechneDurchschnitt(feld));
  }
}