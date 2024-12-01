package com.bbkdevelopment;

/**
 * Klasse, die eine einfache Zahlenfrage implementiert.
 */
public class EinfacheZahlenfrage extends AbstrakteZahlenfrage {

  /**
   * Die richtige Antwort auf die Frage.
   */
  private final int richtigeAntwort;

  /**
   * Konstruktor, der die Frage, die maximal erreichbaren Punkte und die richtige Antwort festlegt.
   *
   * @param frage           Die Frage, die gestellt wird.
   * @param punkte          Die maximal erreichbaren Punkte für die Frage.
   * @param richtigeAntwort Die richtige Antwort auf die Frage.
   */
  public EinfacheZahlenfrage(String frage, int punkte, int richtigeAntwort) {
    super(frage, punkte);
    this.richtigeAntwort = richtigeAntwort;
  }

  @Override
  public boolean istRichtigBeantwortet() {
    return super.istBeantwortet() && super.antwort == this.richtigeAntwort;
  }
}
