package com.bbkdevelopment;

/**
 * Diese Klasse prüft, ob eine übergebene nichtnegative Zahl eine Primzahl ist.
 */
public class PrimzahlTester {

  /**
   * Diese Methode wird aufgerufen, wenn das Programm gestartet wird.
   *
   * @param args die übergebenen Argumente
   */
  public static void main(String[] args) {
    // Diese Variable können sie verändern, um Ihre Implementierung zu testen
    final int x = 11;
    // Der nachfolgende Quelltext erzeugt nur die Ausgabe
    System.out.print("Ist ");
    System.out.print(x);
    System.out.println(" eine Primzahl?");
    new PrimzahlTester().istPrimzahl(x);
  }

  /**
   * Prüft, ob die übergebene nichtnegative Zahl eine Primzahl ist, wenn die übergebene Zahl eine
   * Primzahl ist, wir JA ausgegeben ansonsten NEIN.
   *
   * @param n die zu testende nichtnegative Zahl.
   */
  public void istPrimzahl(long n) {
    // Wenn die übergebene Zahl kleiner oder gleich 1 ist, ist sie keine Primzahl.
    if (n <= 1) {
      System.out.println("NEIN");
      return;
    }
    // Wenn die übergebene Zahl kleiner oder gleich 3 ist, ist sie eine Primzahl.
    if (n <= 3) {
      System.out.println("JA");
      return;
    }
    // Wenn die übergebene Zahl durch 2 oder 3 teilbar ist, ist sie keine Primzahl.
    if (n % 2 == 0 || n % 3 == 0) {
      System.out.println("NEIN");
      return;
    }

    // Wenn die übergebene Zahl durch 5 oder 7 teilbar ist, ist sie keine Primzahl.
    long i = 5;
    while (i * i <= n) {
      if (n % i == 0 || n % (i + 2) == 0) {
        System.out.println("NEIN");
        return;
      }
      // Die Primzahlen sind 6k-1 und 6k+1, daher wird i um 6 erhöht.
      i += 6;
    }

    // Ansonsten ist die übergebene Zahl eine Primzahl.
    System.out.println("JA");
  }
}
