package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupOfficial extends PopulationGroup {

  public PopulationGroupOfficial(double salary) {
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
