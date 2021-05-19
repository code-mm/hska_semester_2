package de.hska.iwii.informatik2.uebung09;

public final class TimeMeasure {
  long startTime;
  long endTime;
  
  public TimeMeasure() {
    this.startTime = 0;
    this.endTime = 0;
  }
  
  /**
   * Sets the current time as start value for calculation.
   */
  public void setStartTime() {
    if (startTime != 0 | endTime != 0) {
      throw new UnsupportedOperationException("Start time can only be set if start "
          + "and end time are never set before.");
    }
    this.startTime = System.currentTimeMillis();
  }
  
  /**
   * Sets the current time as end value for calculation.
   */
  public void setEndTime() {
    if (endTime != 0) {
      throw new UnsupportedOperationException("End time can only be set if end "
          + "time are never set before.");
    }
    this.endTime = System.currentTimeMillis();
  }
  
  /**
   * Returns the time difference between the call of start and end method.
   * @return
   */
  public long getDuration() {
    if (this.endTime == 0 | this.startTime == 0) {
      throw new UnsupportedOperationException("Duration can only calculated "
          + "if start and end are called first.");
    }
    return this.endTime - this.startTime;
  }
  
}
