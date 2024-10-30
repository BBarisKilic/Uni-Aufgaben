package com.bbkdevelopment;

/**
 * Diese Klasse berechnet den Wochentag zu einem gültigen Datum.
 */
public class WochentagBerechner {

  /**
   * Diese Methode wird beim Start des Programms aufgerufen.
   *
   * @param args die Kommandozeilenargumente
   */
  public static void main(String[] args) {
    // Diese Variablen können sie verändern, um Ihre Implementierung zu testen.
    final int t = 5; // der Tag
    final int m = 6; // der Monat
    final int j = 2009; // das Jahr
    // Der nachfolgende Quelltext erzeugt nur die Ausgabe.
    System.out.print("Der ");
    System.out.print(t);
    System.out.print(".");
    System.out.print(m);
    System.out.print(".");
    System.out.print(j);
    System.out.print(" ist ein ");
    new WochentagBerechner().berechneWochentag(t, m, j);
  }

  /**
   * Es wird der Wochentag zu einem gültigen Datum bestimmt.
   *
   * @param tag   der Tag (0 < tag <= 31)
   * @param monat der Monat (0 < monat <= 12)
   * @param jahr  die vierstellige Jahreszahl (z. B. 2009)
   */
  public void berechneWochentag(int tag, int monat, int jahr) {
    // w = (d + (26 * (m + 1))/10 + (5 * y)/4 + c/4 + 5 * c - 1) mod 7
    // w = Wochentag (0 = Sonntag, 1 = Montag, ..., 6 = Samstag)
    // d = Tag
    // m = Monat (3 = März, 4 = April, ..., 12 = Dezember, 13 = Januar, 14 = Februar)
    // y = Jahr (letzte zwei Ziffern)
    // c = Jahrhundert (erste zwei Ziffern)

    // Januar und Februar werden als 13. und 14. Monat des Vorjahres betrachtet.
    final int m = monat == 1 ? 13 : monat == 2 ? 14 : monat;
    // Wenn der Monat Januar oder Februar ist, wird das Jahr um 1 verringert.
    final int y = (m > 12 ? jahr - 1 : jahr) % 100;
    final int c = (m > 12 ? jahr - 1 : jahr) / 100;
    // Berechnung des Wochentags
    final int wochentag = (tag + (26 * (m + 1)) / 10 + (5 * y) / 4 + c / 4 + 5 * c - 1) % 7;

    // Ausgabe des Wochentags
    switch (wochentag) {
      case 0:
        System.out.println("Sonntag");
        break;
      case 1:
        System.out.println("Montag");
        break;
      case 2:
        System.out.println("Dienstag");
        break;
      case 3:
        System.out.println("Mittwoch");
        break;
      case 4:
        System.out.println("Donnerstag");
        break;
      case 5:
        System.out.println("Freitag");
        break;
      case 6:
        System.out.println("Samstag");
        break;
      default:
        System.out.println("Fehler");
    }
  }
}