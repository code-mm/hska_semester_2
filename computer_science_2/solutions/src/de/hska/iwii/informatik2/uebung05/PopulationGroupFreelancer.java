package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupFreelancer extends PopulationGroup {

  public PopulationGroupFreelancer(double salary) {
    super(salary);
  }

  /**
   * Calculates and returns the tax.
   * @return  Tax
   */
  @Override
  public int getTax() {
    return (int) this.taxTable.getTaxRate(this.getSalary());
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
