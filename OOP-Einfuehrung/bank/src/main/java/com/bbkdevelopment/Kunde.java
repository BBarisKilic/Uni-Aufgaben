package com.bbkdevelopment;

/**
 * Kunde klasse.
 */
public class Kunde {

  private String name;

  /**
   * Erzeugt einen neuen Kunden mit dem entsprechenden Namen.
   *
   * @param n der Name des Kunden.
   */
  public Kunde(String n) {
    name = n;
  }

  /**
   * Liefert den Namen des Kunden.
   *
   * @return der Name des Kunden.
   */
  public String liefereName() {
    return name;
  }
}