package com.bbkdevelopment;

/**
 * Main klasse.
 */
public final class Main {

  /**
   * Main-Methode.
   *
   * @param args die Argumente.
   */
  public static void main(String[] args) {
    final var konto = new Konto(123456, new Bank("Sparkasse", 255671), new Kunde("Max Mustermann"));
    konto.einzahlen(1000);
    konto.auszahlen(500);
    System.out.println(
        "Kontostand von " + konto.liefereInhabername() + ": " + konto.liefereKontostand()
            + " Cent");
  }
}