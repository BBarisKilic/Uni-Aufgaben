package com.bbkdevelopment;

/**
 * Konto klasse.
 */
public class Konto {

  private final long nummer;
  private final Bank bank;
  private final Kunde inhaber;
  private long kontostand;

  /**
   * Erstellt ein neues Konto mit der angegebenen Kontonummer, Bank und Kunde (Inhaber).
   *
   * @param ktoNr die Kontonummer.
   * @param b     die Bank, bei der das Konto geführt wird.
   * @param k     der Kunde, der Inhaber des Kontos.
   */
  public Konto(long ktoNr, Bank b, Kunde k) {
    this.nummer = ktoNr;
    this.bank = b;
    this.inhaber = k;
    this.kontostand = 0;
  }

  /**
   * Zahlt den angegebenen Betrag (in Cent) vom Konto aus.
   *
   * @param cent der auszuzahlende Betrag in Cent.
   */
  public void auszahlen(long cent) {
    if (this.kontostand >= cent) {
      this.kontostand -= cent;
    } else {
      System.out.println("Nicht genügend Guthaben auf dem Konto.");
    }
  }

  /**
   * Zahlt den angegebenen Betrag (in Cent) auf das Konto ein.
   *
   * @param cent der einzuzahlende Betrag in Cent.
   */
  public void einzahlen(long cent) {
    this.kontostand += cent;
  }


  /**
   * Liefert den Namen der Bank.
   *
   * @return der Name der Bank.
   */
  public String liefereBankname() {
    return bank.liefereName();
  }

  /**
   * Liefert die BLZ der Bank.
   *
   * @return die Bankleitzahl der Bank.
   */
  public long liefereBLZ() {
    return bank.liefereBLZ();
  }

  /**
   * Liefert den Namen des Inhabers des Kontos.
   *
   * @return der Name des Inhabers.
   */
  public String liefereInhabername() {
    return inhaber.liefereName();
  }

  /**
   * Liefert die Kontonummer.
   *
   * @return die Kontonummer.
   */
  public long liefereKontonummer() {
    return nummer;
  }

  /**
   * Liefert den aktuellen Kontostand.
   *
   * @return der Kontostand.
   */
  public long liefereKontostand() {
    return kontostand;
  }
}
