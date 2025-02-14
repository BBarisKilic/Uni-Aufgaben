package com.bbkdevelopment;

/**
 * Main class.
 */
public class Main {

  /**
   * Main method.
   */
  public static void main(String[] args) {
    final Stapel stapel = new Stapel();
    stapel.fuegeElementHinzu("Hallo");
    stapel.fuegeElementHinzu("Welt");
    System.out.println(stapel.entferneOberstesElement());
  }
}