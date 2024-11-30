package com.bbkdevelopment;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Ein einfaches Spiel zum Erraten von Wörtern.
 */
public class Woerterraten {

  private final String[] woerter = {"Schifffahrt", "Museum", "Gesellschaft", "Marktplatz"};
  public StringBuilder erratenesWort;
  public String zuRatendesWort;

  /**
   * erzeugt ein neues Spiel.
   */
  public Woerterraten() {
    // Konstruktor.
  }

  /**
   * erzeugt ein neues Spiel und startet es.
   *
   * @param args wird nicht benötigt.
   */
  public static void main(String[] args) {
    new Woerterraten().starteSpiel();
  }

  /**
   * aktualisiert das bisher erratene Wort, indem alle Vorkommen von <code>c</code> aufgedeckt
   * werden.
   *
   * @param c der geratene Buchstabe
   */
  public void aktualisiereLoesung(char c) {
    // alle Vorkommen von c im zu ratenden Wort aufdecken.
    for (var i = 0; i < zuRatendesWort.length(); i++) {
      // wenn der Buchstabe an der Stelle i im zu ratenden Wort gleich c ist, wird er im erratenen
      // Wort aufgedeckt.
      if (zuRatendesWort.charAt(i) == c) {
        erratenesWort.setCharAt(i, c);
      }
    }
  }

  /**
   * initialisiert das erratene Wort mit der entsprechenden Anzahl an Sternchen.
   */
  public void init() {
    // der String buffer mit der gleichen L�nge wie das zu ratende Wort angelegt.
    erratenesWort = new StringBuilder(zuRatendesWort.length());
    // es werden entsprechend viele Sternchen erzeugt
    erratenesWort.append("*".repeat(zuRatendesWort.length()));
  }

  /**
   * startet das Spiel.
   */
  public void starteSpiel() {
    // ein neues Wort auswählen.
    zuRatendesWort = zufallsWort().toUpperCase();

    // das erratene Wort initialisieren.
    init();

    // Vorbereitungen zum Einlesen.
    final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    // zum Zählen der Versuche.
    int counter = 0;

    System.out.println("Gesucht wird folgendes Wort:");
    System.out.println(erratenesWort);

    // solange das Wort noch nicht vollständig erraten wurde, wird weitergeraten.
    while (!zuRatendesWort.contentEquals(erratenesWort)) {
      System.out.println("Bitte geben Sie einen Buchstaben ein und bestätigen Sie mit ENTER:");

      final String line;
      try {
        // einlesen
        line = br.readLine();
      } catch (IOException e) {
        e.printStackTrace();
        return;
      }
      if (line.isEmpty()) {
        // leere Zeilen ignorieren
        continue;
      }

      // in Grossbuchstaben umwandeln
      final char c = Character.toUpperCase(line.charAt(0));

      // überprüfen, ob Buchstabe schon erraten wurde.
      if (erratenesWort.toString().contains(String.valueOf(c))) {
        System.out.println("Diesen Buchstaben haben sie schon erraten!");
        continue;
      }

      // Rateversuche erhöhen.
      counter++;

      // prüfen, ob Buchstabe enthalten.
      if (!zuRatendesWort.contains(String.valueOf(c))) {
        System.out.println("Der Buchstabe " + c + " ist nicht enthalten.");
        continue;
      }

      // bisher erratenes Wort aktualisieren.
      aktualisiereLoesung(c);

      // aktuelles Rateergebnis ausgeben.
      System.out.println("So sieht das Wort nun aus:");
      System.out.println(erratenesWort);
    }

    System.out.println("Glückwunsch! Sie haben das Wort erraten: " + erratenesWort);
    System.out.println("Sie haben " + counter + " Versuche benötigt.");
  }

  /**
   * erzeugt ein Zufallswort.
   *
   * @return ein Zufallswort.
   */
  private String zufallsWort() {
    // Zufallszahl im entsprechenden Intervall erzeugen [0,woerter.length[
    final var i = (int) (Math.random() * woerter.length);
    return woerter[i];
  }
}