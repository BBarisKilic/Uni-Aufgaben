package com.bbkdevelopment;

/**
 * Bank klasse.
 */
public class Bank {

  private final long blz;

  private final String name;

  /**
   * Erzeugt eine neue Bank mit gegebenen Namen und BLZ.
   *
   * @param bankname     der Name der Bank.
   * @param bankleitzahl die BLZ.
   */
  public Bank(String bankname, long bankleitzahl) {
    name = bankname;
    blz = bankleitzahl;
  }

  /**
   * Liefert die Bankleitzahl der Bank.
   *
   * @return die BLZ.
   */
  @SuppressWarnings("checkstyle:AbbreviationAsWordInName")
  public long liefereBLZ() {
    return blz;
  }

  /**
   * Liefert den Namen der Bank.
   *
   * @return der Name der Bank.
   */
  public String liefereName() {
    return name;
  }

}