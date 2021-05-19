package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupEmployee extends PopulationGroup {

  public PopulationGroupEmployee(double salary) {
    super(salary);
    this.taxFreeAmount = 12000.00;
  }

  /**
   * Calculates and returns the tax.
   * @return  Tax
   */
  @Override
  public int getTax() {
    if (this.getSalary() > this.getTaxFreeAmount()) {
      return (int) this.taxTable.getTaxRate(this.getSalary());
    } else {
      return 0;
    }
  }

  /**
   * Calculates and returns the social tax.
   * @return  Tax
   */
  @Override
  public int getSocialTax() {
    return (int) (salary * this.socialTax);
  }

}
