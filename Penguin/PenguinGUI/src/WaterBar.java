public class WaterBar {

  private int waterLevel;

  // constructor for WaterBar object
  public WaterBar() {
    this.waterLevel = 0;
  }

  // raise waterLevel by one
  public void increment() {
    this.waterLevel++;
  }

  // get the current water level
  public int getWaterLevel() {
    return this.waterLevel;
  }

  public void setWaterLevel(int level) {
    this.waterLevel = level;
  }
}
