package de.hska.iwii.informatik2.uebung05;

public class TaxTableList {
  private TaxTableListElement[] list;

  /**
   * Creates a list of several tax elements.
   * @param elements  The tax elements
   */
  public TaxTableList(TaxTableListElement... elements) {
    this.list = elements;
  }

  /**
   * Returns the tax to pay.
   * @param salary  The salary for which the tax has to be calculated
   * @return The tax to pay
   */
  public double getTaxRate(double salary) {
    for (int i = 0; i < list.length; i++) {
      if (list[i].inSalaryClass(salary)) {
        return list[i].getTaxPercentage() * salary;
      }
    }
    return 0;
  }
}
