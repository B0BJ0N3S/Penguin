import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    System.out.println("what is the name of your pengu!!!!!!!: ");
    Scanner scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    Penguin penguin = new Penguin(name);
    System.out.println("The name is " + penguin.getName());

    System.out.printf("Your initial water is: %d \n", penguin.getWaterLevel());
    System.out.println("Your initial mood is: " + penguin.getMood());
    System.out.println("Your initial mood is: " + penguin.getMoodLevel());

    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    // expected output = 8 water
    System.out.printf("Your water is: %d \n", penguin.getWaterLevel());
    System.out.println("Your mood is: " + penguin.getMoodLevel());
    penguin.drinkWater();
    penguin.drinkWater();
    penguin.drinkWater();
    System.out.printf("Your water is: %d \n", penguin.getWaterLevel());
    System.out.println("Your mood is: " + penguin.getMoodLevel());

    List<Homework> hw =
        new ArrayList<>(List.of(new Homework("essay"), new Homework("cs"), new Homework("math")));

    penguin.listOfHomework();
    FileChecker file = new FileChecker();
    try {
      file.writer();
    } catch (IOException e) { // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
