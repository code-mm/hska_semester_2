package de.hska.iwii.informatik2.uebung05;

public class PopulationGroupBereaved extends PopulationGroup {

  public PopulationGroupBereaved(double salary) {
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
    return (int) (salary * this.socialTax);
  }

}
