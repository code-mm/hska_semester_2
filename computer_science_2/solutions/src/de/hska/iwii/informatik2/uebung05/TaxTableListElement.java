package de.hska.iwii.informatik2.uebung05;

public final class TaxTableListElement {
  private int min;
  private int max;
  private double tax;

  /**
   * Creates an element for use in TaxTableList.
   * @param min The lower limit where the tax class starts
   * @param max The upper limit where the tax class ends
   * @param tax The tax for this class
   */
  public TaxTableListElement(int min, int max, double tax) {
    if (min >= max) {
      throw new IllegalArgumentException("Max value must be greater than min value.");
    } else if (tax > 1.00) {
      throw new IllegalArgumentException("Tax value must be lower or equal than 100% value.");
    } else {
      this.min = min;
      this.max = max;
      this.tax = tax;
    }
  }

  /**
   * Returns the percentage value for the tax class.
   * @return The percentage value
   */
  public double getTaxPercentage() {
    return this.tax;
  }

  /**
   * Checks if salary matches the tax class.
   * @param salary  The salary
   * @return  Returns true if salary in tax class
   */
  public boolean inSalaryClass(double salary) {
    if (salary >= this.min & salary <= this.max) {
      return true;
    } else {
      return false;
    }
  }
}
