package com.bbkdevelopment;

/**
 * Die Hauptklasse des Programms.
 */
public class Main {

  /**
   * Die Hauptmethode des Programms.
   *
   * @param args Die Kommandozeilenargumente.
   */
  public static void main(String[] args) {
    final Baum beispielBaum = Baum.erzeugeBeispielBaum(1, 2, 3, 4, 5);
    System.out.println(beispielBaum.werteAus());
  }
}
