package com.bbkdevelopment;

/**
 * Klasse, die ein Quiz implementiert.
 */
public class Quiz {

  /**
   * Die Anzahl der Fragen, die das Quiz enthalten soll.
   */
  private final int fragenAnzahl;

  /**
   * Die Fragen, die das Quiz enthält.
   */
  private final Zahlenfrage[] fragen;

  /**
   * Die Anzahl der gespeicherten Fragen.
   */
  private int gespeicherteFragenAnzahl;

  /**
   * Konstruktor, der die Anzahl der Fragen festlegt.
   *
   * @param fragenAnzahl Die Anzahl der Fragen, die das Quiz enthalten soll.
   */
  public Quiz(int fragenAnzahl) {
    this.fragenAnzahl = fragenAnzahl;
    this.fragen = new Zahlenfrage[fragenAnzahl];
    this.gespeicherteFragenAnzahl = 0;
  }

  /**
   * Fügt eine Frage zum Quiz hinzu.
   *
   * @param f Die Frage, die hinzugefügt werden soll.
   * @return true, wenn die Frage hinzugefügt werden konnte, ansonsten false.
   */
  public boolean fuegeFrageHinzu(Zahlenfrage f) {
    if (f == null) {
      return false;
    }
    if (gespeicherteFragenAnzahl == fragenAnzahl) {
      return false;
    }

    this.fragen[gespeicherteFragenAnzahl] = f;
    this.gespeicherteFragenAnzahl++;
    return true;
  }

  /**
   * Berechnet die erreichten Punkte des Quiz.
   *
   * @return Die erreichten Punkte des Quiz.
   */
  public int berechneErreichtePunkte() {
    int erreichtePunkte = 0;
    for (final Zahlenfrage frage : fragen) {
      if (frage == null) {
        continue;
      }
      erreichtePunkte += frage.liefereErreichtePunkte();
    }
    return erreichtePunkte;
  }

  /**
   * Berechnet die maximal möglichen Punkte des Quiz.
   *
   * @return Die maximal möglichen Punkte des Quiz.
   */
  public int berechneMaximalMoeglichePunkte() {
    int maximalMoeglichePunkte = 0;
    for (final Zahlenfrage frage : fragen) {
      if (frage == null) {
        continue;
      }
      maximalMoeglichePunkte += frage.liefereMoeglichePunkte();
    }
    return maximalMoeglichePunkte;
  }

  /**
   * Liefert die Frage an einem bestimmten Index.
   *
   * @param index Der Index der Frage, die geliefert werden soll.
   * @return Die Frage an dem Index oder null, wenn der Index nicht existiert.
   */
  public Zahlenfrage liefereFrage(int index) {
    if (index >= 0 && index < this.gespeicherteFragenAnzahl) {
      return this.fragen[index];
    }
    return null;
  }

  /**
   * Liefert die Anzahl der gespeicherten Fragen.
   *
   * @return Die Anzahl der gespeicherten Fragen.
   */
  public int liefereFragenAnzahl() {
    return this.gespeicherteFragenAnzahl;
  }
}
