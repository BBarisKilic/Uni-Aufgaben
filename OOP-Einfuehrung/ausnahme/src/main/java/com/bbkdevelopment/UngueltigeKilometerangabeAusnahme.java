package com.bbkdevelopment;

/**
 * Eine Ausnahme, die geworfen wird, wenn eine ungültige Kilometerangabe eingegeben wurde.
 */
public class UngueltigeKilometerangabeAusnahme extends Exception {

  /**
   * Erzeugt eine neue Ausnahme mit einer spezifischen Fehlermeldung.
   *
   * @param message Die Fehlermeldung.
   */
  public UngueltigeKilometerangabeAusnahme(String message) {
    super(message);
  }
}
