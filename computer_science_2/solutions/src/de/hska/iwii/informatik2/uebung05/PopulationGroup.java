package de.hska.iwii.informatik2.uebung05;

public abstract class PopulationGroup {
  double salary = 0;
  final double socialTax = 0.28;
  double taxFreeAmount = 0;

  final TaxTableList taxTable = new TaxTableList(
      new TaxTableListElement(0, 12000, 0.10),
      new TaxTableListElement(12001, 24000, 0.25),
      new TaxTableListElement(24001, 50000, 0.30),
      new TaxTableListElement(50001, 75000, 0.40),
      new TaxTableListElement(75001, Integer.MAX_VALUE, 0.50)
      );

  /**
   * Creates a abstract group of population.
   * @param salary  The salary of a group
   */
  public PopulationGroup(double salary) {
    this.setSalary(salary);
  }

  /**
   * Return the salary of a person.
   * @return Salary as value
   */
  public double getSalary() {
    return this.salary;
  }

  /**
   * Set the salary of a person.
   * @param salary  Salary as value
   */
  public void setSalary(double salary) {
    if (salary < 0) {
      throw new IllegalArgumentException("Negative salary not possible.");
    } else {
      this.salary = salary;
    }
  }

  /**
   * Calculates and returns the tax.
   * @return tax
   */
  public abstract int getTax();

  /**
   * Calculates and returns the social tax.
   * @return tax
   */
  public abstract int getSocialTax();

  /**
   * Returns the limit over which the population group has to pay taxes.
   * @return The limit between no tax and tax payment
   */
  public double getTaxFreeAmount() {
    return this.taxFreeAmount;
  }

}
