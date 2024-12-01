package com.bbkdevelopment;

/**
 * Interface, das eine Zahlenfrage definiert.
 */
public interface Zahlenfrage {

  /**
   * Gibt an, ob die Frage beantwortet wurde.
   *
   * @return true, wenn die Frage beantwortet wurde, ansonsten false.
   */
  boolean istBeantwortet();

  /**
   * Gibt an, ob die Frage richtig beantwortet wurde.
   *
   * @return true, wenn die Frage richtig beantwortet wurde, ansonsten false.
   */
  boolean istRichtigBeantwortet();

  /**
   * Legt die Antwort auf die Frage fest.
   *
   * @param antwort Die Antwort auf die Frage.
   */
  void legeAntwortFest(int antwort);

  /**
   * Liefert die erreichten Punkte für die Frage.
   *
   * @return Die erreichten Punkte für die Frage.
   */
  int liefereErreichtePunkte();

  /**
   * Liefert die Frage.
   *
   * @return Die Frage.
   */
  String liefereFrage();

  /**
   * Liefert die maximal erreichbaren Punkte für die Frage.
   *
   * @return Die maximal erreichbaren Punkte für die Frage.
   */
  int liefereMoeglichePunkte();
}
