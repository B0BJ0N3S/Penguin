import java.util.ArrayList;
import java.util.List;

public class Penguin {

  private static final int MAX_WATER_LEVEL = 8;
  private static final int MAX_MOOD_LEVEL = 5;
  
  private String name;
  public List<Homework> homeworkList;
  private WaterBar waterBar;
  private MoodBar moodBar;

  public Penguin(String name) {
    this.name = name;
    this.waterBar = new WaterBar();
    this.homeworkList = new ArrayList<>();
    this.moodBar = new MoodBar();
  }

  public Penguin() {
	  this.name = new String();
	  this.waterBar = new WaterBar();
	  this.homeworkList = new ArrayList<>();
	  this.moodBar = new MoodBar();
  }
  
  public String getName() {
    return this.name;
  }

  public void setName(String newName) {
    this.name = newName;
  }

  // Homework
  public List<Homework> getHomeworkList() {
    return this.homeworkList;
  }

  public void completeHomework(int index) {
    //this.homeworkList.remove(index);
    this.moodBar.incrementMood();
  }

  public void addHomework(Homework homework) {
    this.homeworkList.add(homework);
  }

  public void listOfHomework() {
    for (int i = 0; i < homeworkList.size(); i++) {
      System.out.println("-" + homeworkList.get(i) + "\n");
    }
  }

  /*
  public boolean aHomeworkDone() {
    return true;
  }*/

  //  water
  public int getWaterLevel() {
    return this.waterBar.getWaterLevel();
  }

  public void drinkWater() {
    if (this.waterBar.getWaterLevel() <= MAX_WATER_LEVEL - 2) {
      this.waterBar.increment();
      System.out.println("glug glug"); // temp
    } else if (this.waterBar.getWaterLevel() == MAX_WATER_LEVEL - 1) {
      this.waterBar.increment();
      this.moodBar.incrementMood();
      System.out.println("last cup"); // temp
    } else {
      System.out.println("stay hydrated :D"); // temp
    }
  }

  // possible reset option
  public void reset(){
      this.moodBar.resetMoodLevel();
      this.waterBar.setWaterLevel(0);
  }

  // mood
  public int getMoodLevel() {
    return moodBar.getMoodLevel();
  }

  public PenguinMood getMood() {
    return moodBar.getMood();
  }

  public MoodBar getMoodbar() {
    return this.moodBar;
  }
}
