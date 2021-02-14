import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class FileChecker {

  private String name;
  private File file;
  private Penguin penguin;

  public FileChecker() {
    File file = new File("file.txt");
    this.penguin = new Penguin(name);
  }

  public void fileCheck() throws FileNotFoundException {
    if (file.exists()) {
      reader();
    } else {
      try {
        this.file.createNewFile();

      } catch (IOException e) {

        e.printStackTrace();
      }
    }
  }

  public void writer() throws IOException {
    PrintWriter fw = new PrintWriter("file.txt");
    Penguin peb = new Penguin(name);
    fw.println(peb.getName());
    fw.println(peb.getHomeworkList());
  }

  public void reader() throws FileNotFoundException {
    Scanner scanner = new Scanner(new File("file.txt"));
    name = scanner.nextLine();
  }
}
