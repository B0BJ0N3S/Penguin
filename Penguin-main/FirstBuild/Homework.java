import java.util.List;

public class Homework {

  List<String> homeworks;
  private String name;

  public Homework(String name) {
    this.name = name;
  }

  public String getName() {
    return this.name;
  }

  public void addHomework(String homeworkName) {
    this.homeworks.add(homeworkName);
  }

  public void removeHomework(int index) {
    this.homeworks.remove(index);
  }

  public String getName(int index) {
    return this.homeworks.get(index);
  }

  public int homeworksRemain() {
    return this.homeworks.size();
  }

}