package de.hska.iwii.informatik2.uebung05;

import junit.framework.TestCase;

public class PopulationGroupFreelancerTest extends TestCase {

  /**
   * Test if tax is calculated correct for different tax classes.
   */
  public void testGetTax() {
    PopulationGroupFreelancer freelancer = new PopulationGroupFreelancer(12000.00);
    assertEquals(1200, freelancer.getTax());
    freelancer.setSalary(24000.00);
    assertEquals(6000, freelancer.getTax());
    freelancer.setSalary(50000.00);
    assertEquals(15000, freelancer.getTax());
    freelancer.setSalary(75000.00);
    assertEquals(30000, freelancer.getTax());
    freelancer.setSalary(75001.00);
    assertEquals(37500, freelancer.getTax());
  }

  /**
   * Test if social tax returns zero.
   */
  public void testGetSocialTax() {
    PopulationGroupFreelancer freelancer = new PopulationGroupFreelancer(100.00);
    assertEquals(0, freelancer.getSocialTax());
  }

  /**
   * Test if constructor sets the salary and free tax amount correct.
   */
  public void testPopulationGroupFreelancer() {
    PopulationGroupFreelancer freelancer = new PopulationGroupFreelancer(100.00);
    assertEquals(100.00, freelancer.getSalary());
    assertEquals(0.00, freelancer.getTaxFreeAmount());
  }

}
