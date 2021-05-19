package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupRetiree extends PopulationGroup {

  public PopulationGroupRetiree(double salary) {
    super(salary);
  }

  /**
   * Calculates and returns the tax.
   * @return  Tax
   */
  @Override
  public int getTax() {
    return 0;
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
