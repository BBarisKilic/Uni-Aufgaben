package com.bbkdevelopment;

/**
 * Eine Ausnahme, die geworfen wird, wenn eine ungültige Tagesanzahl angegeben wurde.
 */
public class UngueltigeTagesanzahlAusnahme extends Exception {

  /**
   * Erzeugt eine neue Ausnahme mit einer spezifischen Fehlermeldung.
   *
   * @param message Die Fehlermeldung.
   */
  public UngueltigeTagesanzahlAusnahme(String message) {
    super(message);
  }
}
