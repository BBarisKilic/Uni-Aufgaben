package com.bbkdevelopment;

/**
 * Ein Stapel, der Elemente vom Typ String speichert.
 */
public class Stapel {

  /**
   * Das oberste Element des Stapels.
   */
  private StapelElement oberstesElement;

  /**
   * Fügt ein Element zum Stapel hinzu.
   *
   * @param s das hinzuzufügende Element
   */
  public void fuegeElementHinzu(String s) {
    final StapelElement neuesElement = new StapelElement(s);
    if (oberstesElement != null) {
      neuesElement.setNaechstesElement(oberstesElement);
    }
    oberstesElement = neuesElement;
  }

  /**
   * Entfernt das oberste Element des Stapels und gibt es zurück.
   *
   * @return das entfernte Element oder {@code null}, wenn der Stapel leer ist
   */
  public String entferneOberstesElement() {
    if (oberstesElement == null) {
      return null;
    }

    final String element = oberstesElement.getElement();
    oberstesElement = oberstesElement.getNaechstesElement();
    return element;
  }

  /**
   * Gibt das oberste Element des Stapels zurück, ohne es zu entfernen.
   *
   * @return das oberste Element oder {@code null}, wenn der Stapel leer ist
   */
  public String liefereOberstesElement() {
    if (oberstesElement == null) {
      return null;
    }

    return oberstesElement.getElement();
  }

  /**
   * Gibt die Anzahl der Elemente im Stapel zurück.
   *
   * @return die Anzahl der Elemente im Stapel
   */
  public long liefereGroesse() {
    if (oberstesElement == null) {
      return 0;
    }

    StapelElement aktuellesElement = oberstesElement;
    long groesse = 1;
    while (aktuellesElement.getNaechstesElement() != null) {
      aktuellesElement = aktuellesElement.getNaechstesElement();
      groesse++;
    }
    return groesse;
  }

  /**
   * Gibt zurück, ob der Stapel leer ist.
   *
   * @return {@code true}, wenn der Stapel leer ist, ansonsten {@code false}
   */
  public boolean istLeer() {
    return oberstesElement == null;
  }
}
