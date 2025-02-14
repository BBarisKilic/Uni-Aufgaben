package com.bbkdevelopment;

/**
 * Ein Mietpreisberechner.
 */
public class MeinMietpreisBerechner {

  /**
   * Berechnet den Mietpreis für ein Auto.
   *
   * @param tage Die Anzahl der Tage, für die das Auto gemietet wird.
   * @param km   Die Anzahl der Kilometer, die mit dem Auto gefahren werden.
   * @return Der Mietpreis für das Auto.
   * @throws UngueltigeTagesanzahlAusnahme     Wenn die Anzahl der Tage kleiner als 1 ist.
   * @throws UngueltigeKilometerangabeAusnahme Wenn die Anzahl der Kilometer negativ ist.
   */
  public long berechneMietpreis(int tage, int km)
      throws UngueltigeTagesanzahlAusnahme, UngueltigeKilometerangabeAusnahme {
    if (tage < 1) {
      throw new UngueltigeTagesanzahlAusnahme("Die Anzahl der Tage muss mindestens 1 betragen.");
    }
    if (km < 0) {
      throw new UngueltigeKilometerangabeAusnahme(
          "Die Anzahl der Kilometer darf nicht negativ sein.");
    }
    if (tage <= 14) {
      final long tageKosten = tage * 2000L;
      final long kmKosten = km > 200 ? (km - 200) * 15L + 4000 : 4000;
      return tageKosten + kmKosten;
    }

    final long tageKosten = 30000;
    final long kmKosten = km * 12L;
    return tageKosten + kmKosten;
  }
}
