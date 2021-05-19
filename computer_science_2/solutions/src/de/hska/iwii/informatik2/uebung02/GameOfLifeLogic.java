package de.hska.iwii.informatik2.uebung02;

import java.util.Arrays;

/**
 * Die eigentliche Spielelogik. Das Spielfeld wird hier nicht als zyklisch
 * geschlossen betrachtet wird.
 *
 * @author Holger Vogelsang
 */

public class GameOfLifeLogic {
  private boolean[][] playingFieldOld;
  private boolean[][] playingFieldNew;

  /**
   * Übernimmt die Startgeneration auf das Spielfeld.
   * @param generation  Startgeneration für das Spielfeld
   */
  public void setStartGeneration(boolean[][] generation) {
    this.playingFieldOld = new boolean[generation.length][generation[0].length];
    this.playingFieldNew = new boolean[generation.length][generation[0].length];

    booleanMultiArrayCopy(generation, this.playingFieldOld);
  }

  /**
   * Generiert den nächsten Zustand des Spielfeldes.
   */
  public void nextGeneration() {
    for (int i = 0; i < playingFieldOld.length; i++) {
      for (int j = 0; j < playingFieldOld[0].length; j++) {
        int activeCells = checkCellsAround(i, j);

        if (isCellAlive(i,j)) {
          if (activeCells == 2 | activeCells == 3) {
            this.playingFieldNew[i][j] = true;
          } else if (activeCells > 3) {
            this.playingFieldNew[i][j] = false;
          } else if (activeCells < 2) {
            this.playingFieldNew[i][j] = false;
          }
        } else {
          if (activeCells == 3) {
            this.playingFieldNew[i][j] = true;
          }
        }
      }
    }

    booleanMultiArrayCopy(this.playingFieldNew, this.playingFieldOld);

    // set values of new gamefield to false
    for (int i = 0; i < playingFieldOld.length; i++) {
      Arrays.fill(playingFieldNew[i], false);
    }
  }

  /**
   * Gibt für eine übergenbene Zelle den Zustand zurück.
   * 
   * @param x Die Zeile des Feldes
   * @param y Die Spalte des Feldes
   * @return  Feldbesetzung
   */
  public boolean isCellAlive(int x, int y) {
    try {
      return this.playingFieldOld[x][y] ? true : false;
    } catch (IndexOutOfBoundsException e) {
      return false;
    }
  }

  /**
   * Zähle wie viele umliegende Felder den Wert True (lebend) haben.
   * 
   * @param x Zeilenkoordinate für zu überprüfendes Feld
   * @param y Spaltenkoordinate für zuüberprüfendes Feld
   * @return  Anzahl der umliegenden besetzten Felder
   */
  private int checkCellsAround(int x, int y) {
    int activeCellsArround = 0;

    int leftBorder = 0;
    int topBorder = 0;
    int rightBorder = this.playingFieldOld.length;
    int bottomBorder = this.playingFieldOld[0].length;

    if (x < leftBorder | x > rightBorder | y < topBorder | y > bottomBorder) {
      throw new IllegalArgumentException("Cell not on gamefield.");
    }

    /*
     * 1 | 1 | 2
     * ---------
     * 4 | X | 2
     * ---------
     * 4 | 3 | 3
     */

    // 1. Segment
    if ((x - 1 >= leftBorder & y - 1 >= topBorder) && playingFieldOld[x - 1][y - 1]) {
      activeCellsArround++;
    }

    if ((x >= leftBorder & y - 1 >= topBorder) && playingFieldOld[x][y - 1]) {
      activeCellsArround++;
    }

    // 2. Segment
    if ((x + 1 < rightBorder & y - 1 >= topBorder) && playingFieldOld[x + 1][y - 1]) {
      activeCellsArround++;
    }

    if ((x + 1 < rightBorder & y >= topBorder) && playingFieldOld[x + 1][y]) {
      activeCellsArround++;
    }

    // 3. Segment
    if ((x + 1 < rightBorder & y + 1 < bottomBorder) && playingFieldOld[x + 1][y + 1]) {
      activeCellsArround++;
    }

    if ((x < rightBorder & y + 1 < bottomBorder) && playingFieldOld[x][y + 1]) {
      activeCellsArround++;
    }

    // 4. Segment
    if ((x - 1 >= leftBorder & y + 1 < bottomBorder) && playingFieldOld[x - 1][y + 1]) {
      activeCellsArround++;
    }

    if ((x - 1 >= leftBorder & y < bottomBorder) && playingFieldOld[x - 1][y]) {
      activeCellsArround++;
    }

    return activeCellsArround;
  }

  /**
   * Kopiert ein zweidimensionales Array mit Datentyp boolean.
   * 
   * @param srcArray  Das Quell-Array
   * @param destArray Das Ziel-Array
   */
  private void booleanMultiArrayCopy(boolean[][] srcArray, boolean[][] destArray) {
    for (int i = 0; i < srcArray.length; i++) {
      System.arraycopy(srcArray[i], 0, destArray[i], 0, srcArray[i].length);
    }
  }
}
