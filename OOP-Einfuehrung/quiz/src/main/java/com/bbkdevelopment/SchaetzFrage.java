package com.bbkdevelopment;

/**
 * Klasse, die eine Schaetzfrage implementiert.
 */
public class SchaetzFrage extends AbstrakteZahlenfrage {

  /**
   * Die prozentuale Abweichung, die die Antwort haben darf.
   */
  private final int prozentualeAbweichung;

  /**
   * Die richtige Antwort auf die Frage.
   */
  private final int richtigeAntwort;

  /**
   * Konstruktor, der die Frage, die maximal erreichbaren Punkte, die richtige Antwort und die
   * prozentuale Abweichung festlegt.
   *
   * @param frage                 Die Frage, die gestellt wird.
   * @param punkte                Die maximal erreichbaren Punkte für die Frage.
   * @param richtigeAntwort       Die richtige Antwort auf die Frage.
   * @param prozentualeAbweichung Die prozentuale Abweichung, die die Antwort haben darf.
   */
  public SchaetzFrage(String frage, int punkte, int richtigeAntwort, int prozentualeAbweichung) {
    super(frage, punkte);
    this.richtigeAntwort = richtigeAntwort;
    this.prozentualeAbweichung = prozentualeAbweichung;
  }

  @Override
  public boolean istRichtigBeantwortet() {
    final double min = this.richtigeAntwort * (100 - this.prozentualeAbweichung) / 100.0;
    final double max = this.richtigeAntwort * (100 + this.prozentualeAbweichung) / 100.0;
    return super.istBeantwortet() && super.antwort >= min && super.antwort <= max;
  }
}
