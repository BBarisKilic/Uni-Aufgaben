package com.bbkdevelopment;

/**
 * Ein Element, das in einem Stapel gespeichert werden kann.
 */
public class StapelElement {

  /**
   * Das zu speichernde Element.
   */
  private final String element;

  /**
   * Das nächste Element in der Stapelkette.
   */
  private StapelElement naechstesElement;

  /**
   * Erzeugt ein neues StapelElement.
   *
   * @param element das zu speichernde Element
   */
  public StapelElement(String element) {
    this.element = element;
  }

  /**
   * Gibt das gespeicherte Element zurück.
   *
   * @return das gespeicherte Element
   */
  public String getElement() {
    return element;
  }

  /**
   * Gibt das nächste Element in der Stapelkette zurück.
   *
   * @return das nächste Element in der Stapelkette
   */
  public StapelElement getNaechstesElement() {
    return naechstesElement;
  }

  /**
   * Setzt das nächste Element in der Stapelkette.
   *
   * @param naechstesElement das nächste Element in der Stapelkette
   */
  public void setNaechstesElement(StapelElement naechstesElement) {
    this.naechstesElement = naechstesElement;
  }
}