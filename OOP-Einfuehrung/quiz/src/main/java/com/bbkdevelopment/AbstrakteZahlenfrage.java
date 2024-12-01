package com.bbkdevelopment;

/**
 * Abstrakte Klasse, die die gemeinsamen Eigenschaften von Zahlenfragen implementiert.
 */
public abstract class AbstrakteZahlenfrage implements Zahlenfrage {

  /**
   * Die Frage, die gestellt wird.
   */
  private final String frage;

  /**
   * Die maximal erreichbaren Punkte für die Frage.
   */
  private final int punkte;

  /**
   * Die Antwort, die gegeben wurde.
   */
  public int antwort;

  /**
   * Gibt an, ob die Frage beantwortet wurde.
   */
  private boolean istBeantwortet;

  /**
   * Konstruktor, der die Frage und die maximal erreichbaren Punkte festlegt.
   *
   * @param frage  Die Frage, die gestellt wird.
   * @param punkte Die maximal erreichbaren Punkte für die Frage.
   */
  public AbstrakteZahlenfrage(String frage, int punkte) {
    this.frage = frage;
    this.punkte = punkte;
    this.istBeantwortet = false;
  }

  @Override
  public boolean istBeantwortet() {
    return this.istBeantwortet;
  }

  @Override
  public void legeAntwortFest(int antwort) {
    this.istBeantwortet = true;
    this.antwort = antwort;
  }

  @Override
  public int liefereErreichtePunkte() {
    if (!istBeantwortet()) {
      return 0;
    }
    if (!istRichtigBeantwortet()) {
      return 0;
    }
    return this.punkte;
  }

  @Override
  public String liefereFrage() {
    return this.frage;
  }

  @Override
  public int liefereMoeglichePunkte() {
    return this.punkte;
  }
}
