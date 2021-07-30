import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Аргументов должно быть 2");
            System.exit(1);
        }
        List<MyPair> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(args[0]);
             FileReader fileReader1 = new FileReader(args[1])) {
            Scanner scanner = new Scanner(fileReader);
            Scanner scanner1 = new Scanner(fileReader1);
            float xOkr = scanner.nextFloat();
            float yOkr = scanner.nextFloat();
            float radius = scanner.nextFloat();
            MyPair pair;
            while (scanner1.hasNextLine()) {
                String str  = scanner1.nextLine();
                String[] str1 = str.split(" ");
                if (str1.length != 2)
                {
                    System.out.println("Неверный ввод");
                    return;
                }
                pair = new MyPair(Float.parseFloat(str1[0]), Float.parseFloat(str1[1]));
                list.add(pair);
            }
            pointAndCircle(xOkr, yOkr, radius, list);
        }
        catch (IOException  | NoSuchElementException | NumberFormatException e){
            System.out.println("Неверный ввод\n" + e);
            return;
        }
    }

    public static void pointAndCircle(float xOkr, float yOkr, float cetreOkr, List<MyPair> list) {
        for (int i = 0; i < list.size(); i++) {
            if (Math.sqrt((xOkr - list.get(i).getL()) * (xOkr - list.get(i).getL()) +
                    (yOkr - list.get(i).getR()) * (yOkr - list.get(i).getR())) > cetreOkr)
                System.out.println(2);
            else if (Math.sqrt((xOkr - list.get(i).getL()) * (xOkr - list.get(i).getL()) +
                    (yOkr - list.get(i).getR()) * (yOkr - list.get(i).getR())) < cetreOkr)
                System.out.println(1);
            else
                System.out.println(0);
        }
    }
}
