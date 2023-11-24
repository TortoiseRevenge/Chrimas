import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

public class BadElep {
  public static void main(String[] args) throws UnsupportedEncodingException {
    try {
      ArrayList<ArrayList<String[]>> list = FileReader.getList(new File("list.txt"));

      String[][] newList = FileReader.randomList(list);
      int i = 0;

      PrintWriter writer = new PrintWriter("saveList.txt", "UTF-8");

      for (String[] a : newList) {
        System.out.println(i + ": " + " (" + a[2] + ")");
        writer.println(a[0]+"," + a[1] + "," + a[2]);
        i++;
      }
      writer.close();

    } catch (FileNotFoundException e) {
      // TODO Auto-generated catch block
      System.out.println("error");
    } catch (StackOverflowError e) {
      // TODO Auto-generated catch block
      System.out.println("Overflew");
    }
  }

}
