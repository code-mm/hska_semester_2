package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupStudent extends PopulationGroup {

  public PopulationGroupStudent(double salary) {
    super(salary);
    this.taxFreeAmount = 6000.0;
  }

  /**
   * Calculates and returns the tax.
   * @return  Tax
   */
  @Override
  public int getTax() {
    if (this.getSalary() <= this.getTaxFreeAmount()) {
      return 0;
    } else {
      return (int) this.taxTable.getTaxRate(this.getSalary());
    }
  }

  /**
   * Calculates and returns the social tax.
   * @return  Tax
   */
  @Override
  public int getSocialTax() {
    return 0;
  }

}
