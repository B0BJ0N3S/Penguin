public class MoodBar {
  private int moodLevel;

  public MoodBar() {
    this.moodLevel = 0;
  }

  public PenguinMood getMood() { // gets mood based on mood level
    if (this.moodLevel == 0) {
      return PenguinMood.CRYING;
    } else if (this.moodLevel == 1) {
      return PenguinMood.TEAR;
    } else if (this.moodLevel == 2) {
      return PenguinMood.SAD;
    } else if (this.moodLevel == 3) {
      return PenguinMood.OKAY;
    } else if (this.moodLevel == 4) {
      return PenguinMood.HAPPY;
    } else {
      return PenguinMood.SUPER_HAPPY;
    }
  }

  public void incrementMood() {
    if (this.moodLevel <= 4) {
      this.moodLevel += 1;
    }
  }

  public void resetMoodLevel(){
      this.moodLevel = 0;
  }

  public int getMoodLevel() {
    return this.moodLevel;
  }
}
