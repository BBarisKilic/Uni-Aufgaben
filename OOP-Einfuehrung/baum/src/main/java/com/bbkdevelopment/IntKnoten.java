package com.bbkdevelopment;

/**
 * Ein Knoten, der einen int-Wert repräsentiert.
 */
public class IntKnoten implements Knoten {

  /**
   * Der Wert des Knotens.
   */
  private int wert;

  /**
   * Erzeugt einen neuen int-Knoten.
   *
   * @param wert Der Wert des Knotens.
   */
  public IntKnoten(int wert) {
    this.wert = wert;
  }

  @Override
  public int werteAus() {
    return wert;
  }

  @Override
  public String toString() {
    return Integer.toString(wert);
  }
}
