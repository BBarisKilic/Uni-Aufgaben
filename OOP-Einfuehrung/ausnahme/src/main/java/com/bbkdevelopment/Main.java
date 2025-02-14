package com.bbkdevelopment;

/**
 * Die Hauptklasse des Programms.
 */
public final class Main {

  /**
   * Die Hauptmethode des Programms.
   *
   * @param args Die Kommandozeilenargumente.
   */
  public static void main(String[] args) {
    final MeinMietpreisBerechner mietpreisBerechner = new MeinMietpreisBerechner();
    try {
      final int tage = 5;
      final int kilometer = 100;
      final long mietpreis = mietpreisBerechner.berechneMietpreis(tage, kilometer);
      final double mietpreisInEuro = mietpreis / 100.0;
      System.out.println("Der Mietpreis beträgt: " + mietpreisInEuro + " Euro.");
    } catch (UngueltigeKilometerangabeAusnahme | UngueltigeTagesanzahlAusnahme e) {
      System.out.println("Fehler: " + e.getMessage());
    }
  }
}