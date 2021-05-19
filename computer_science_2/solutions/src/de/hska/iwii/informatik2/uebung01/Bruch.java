package de.hska.iwii.informatik2.uebung01;

public class Bruch {
  private int zaehler;
  private int nenner;

  /**
   * Erzeugt einen Bruch mit Standardwert 1/1.
   */
  public Bruch() {
    this.zaehler = 1;
    this.nenner = 1;
  }

  /**
   * Erzeugt einen Bruch mit vorgegebenem Wert.
   * 
   * @param zaehler Zähler des zu erzeugenden Bruchs
   * @param nenner  Nenner des zu erzeugenden Bruchs
   */
  public Bruch(int zaehler, int nenner) {
    if (nenner == 0) {
      throw new IllegalArgumentException("Nenner darf nicht Null sein!");
    } else {
      this.zaehler = zaehler;
      this.nenner = nenner;
    }
    bruchKuerzen();
  }

  /**
   * Gibt den Zähler zurück.
   * @return  Wert des Zählers
   */
  public int getZaehler() {
    return this.zaehler;
  }

  /**
   * Gibt den Nenner zurück.
   * @return  Wert des Nenners
   */
  public int getNenner() {
    return this.nenner;
  }

  /**
   * Setzt den Zähler auf gegebenen Wert.
   * @param zaehler Zu setzender Wert des Zählers
   */
  public void setZaehler(int zaehler) {
    this.zaehler = zaehler;
    bruchKuerzen();
  }

  /**
   * Setzt den Nenner auf gegebenen Wert.
   * @param nenner  Zu setzender Wert des Nenners
   */
  public void setNenner(int nenner) {
    if (nenner == 0) {
      throw new IllegalArgumentException("Nenner kann nicht null sein!");
    } else {
      this.nenner = nenner;
    }
    bruchKuerzen();
  }

  /**
   * Addiert zwei Brüche.
   * @param bruch1  Erster zu addierender Bruch
   * @param bruch2  Zweiter zu addierender Bruch
   * @return        Neuer Bruch mit addierten Werten
   */
  public static Bruch addition(Bruch bruch1, Bruch bruch2) {
    if (bruch1.getNenner() == bruch2.getNenner()) {
      return (new Bruch(bruch1.getZaehler() + bruch2.getZaehler(), bruch1.getNenner()));
    } else {
      return (new Bruch(bruch1.getZaehler() * bruch2.getNenner()
          + bruch2.getZaehler() * bruch1.getNenner(), bruch1.getNenner() * bruch2.getNenner()));
    }
  }

  /**
   * Subtrahiert zwei Brüche.
   * @param bruch1  Erster zu subtrahierender Bruch
   * @param bruch2  Zweiter zu subtrahierender Bruch
   * @return        Neuer Bruch mit subtrahierten Werten
   */
  public static Bruch subtraktion(Bruch bruch1, Bruch bruch2) {
    if (bruch1.getNenner() == bruch2.getNenner()) {
      Bruch bruchSubtrahiert = new Bruch(bruch1.getZaehler() - bruch2.getZaehler(),
          bruch1.getNenner());
      return bruchSubtrahiert;
    } else {
      return (new Bruch(bruch1.getZaehler() * bruch2.getNenner() - bruch2.getZaehler()
          * bruch1.getNenner(), bruch1.getNenner() * bruch2.getNenner()));
    }
  }

  /**
   * Multipliziert zwei Brüche.
   * @param bruch1  Erster zu multiplizierender Bruch
   * @param bruch2  Zweiter zu multipliziernder Bruch
   * @return        Neuer Bruch mit multiplizierten Werten
   */
  public static Bruch multiplikation(Bruch bruch1, Bruch bruch2) {
    return (new Bruch(bruch1.getZaehler() * bruch2.getZaehler(),
        bruch1.getNenner() * bruch2.getNenner()));
  }

  /**
   * Dividiert zwei Brüche.
   * @param bruch1  Erster zu dividierender Bruch
   * @param bruch2  Zweiter zu dividierender Bruch
   * @return        Neuer Bruch mit dividierten Werten
   */
  public static Bruch division(Bruch bruch1, Bruch bruch2) {
    return (new Bruch(bruch1.getZaehler() * bruch2.getNenner(),
        bruch1.getNenner() * bruch2.getZaehler()));
  }

  /**
   * Kürzt den Bruch.
   */
  private void bruchKuerzen() {
    if (this.zaehler == 1 | this.nenner == 1 | (this.nenner - this.zaehler) == 1) {
      return;
    }

    int ggt = ggt(Math.abs(this.zaehler), Math.abs(this.nenner));
    this.zaehler = this.zaehler / ggt;
    this.nenner = this.nenner / ggt;
  }

  /**
   * Ermittelt den größten gemeinsamen Teiler zweier Zahlen.
   * @param zaehler Der Zähler des Bruchs
   * @param nenner  Der Nenner des Bruchs
   * @return        Der größte gemeinesame Teiler aus Parameter Zähler und Nenner
   */
  private static int ggt(int zaehler, int nenner) {
    return (nenner == 0) ? zaehler : ggt(nenner, zaehler % nenner);
  }
}
