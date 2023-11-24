import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class FileReader {
  public static ArrayList<ArrayList<String[]>> getList(File a) throws FileNotFoundException {
    Scanner scan = new Scanner(a);

    ArrayList<ArrayList<String[]>> list = new ArrayList<ArrayList<String[]>>();

    String currFam = "";

    ArrayList<String[]> famList = new ArrayList<String[]>();
    while(scan.hasNextLine()) {
      String input = scan.nextLine();
      if (!input.equals("")) {
        String[] z = input.split(",");
        if (!z[2].equals(currFam)) {
          if (currFam.equals("")) {
            currFam = z[2];
          } else {
            currFam = z[2];
            list.add(famList);
            famList = new ArrayList<String[]>();
          }
        }
        famList.add(z);

      }
    }
    scan.close();
    list.add(famList);
    System.out.println(list.get(0));
    return list;
  }

  public static String[][] randomList(ArrayList<ArrayList<String[]>> b) {
    int size = 0;
    Random rand = new Random();
    for (ArrayList<String[]> family : b) {
      size += family.size();
    }

    String[][] newList = new String[size][3];

    ArrayList<ArrayList<String[]>> z = new ArrayList<ArrayList<String[]>>();

    for (ArrayList<String[]> family : b) {
      ArrayList<String[]> famList = new ArrayList<String[]>();
      for (String[] person : family) {
        famList.add(person);
      }
      z.add(famList);
    }
    String fam = b.get(0).get(0)[2];
    for (int i = 0; i < size; i++) {
      int si = getSize(z, fam);
      if (si <= 0) {
        return randomList(b);
      }
      int ran = rand.nextInt(si);
      newList[i] = getIndex(z, ran, fam);
      if (newList[i] == null) {
        return randomList(b);
      }
      fam = newList[i][2];

    }
    if(newList[0][2].equals(newList[newList.length-1][2])) {
      return randomList(b);
    }
    return newList;


  }

  public static int getSize(ArrayList<ArrayList<String[]>> a, String family) {
    int size = 0;

    for (ArrayList<String[]> fam : a) {
      boolean goNext = true;
      int sizeFamily = 0;
      for (String[] person : fam) {
        if (person[2].equals(family)) {
          goNext = false;
        }
        sizeFamily++;
      }
      if (goNext) {
        size += sizeFamily;
      }
    }
    return size;
  }

  public static String[] getIndex(ArrayList<ArrayList<String[]>> a, int b, String family) {
    int count = 0;

    for (ArrayList<String[]> fam : a) {
      boolean goNext = true;

      for (String[] person : fam) {
        if (person[2].equals(family)) {
          goNext = false;
        }
        if (goNext) {
          if (count == b) {
            fam.remove(person);
            return person;
          }
          count++;
        }
      }
    }
    return null;
  }
}