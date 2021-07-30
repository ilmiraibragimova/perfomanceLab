import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Task4 {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Аргумент должен быть 1");
            System.exit(1);
        }
        List<Integer> list = new ArrayList<>();
        try (FileReader fileReader = new FileReader(args[0])) {
            Scanner scanner = new Scanner(fileReader);
            while (scanner.hasNextLine()) {
                String[] s = scanner.nextLine().split(" ");
                if (s.length != 1) {
                    System.out.println("Неверный ввод");
                    return;
                }
                list.add(Integer.parseInt(s[0]));
            }
        } catch (NumberFormatException | IOException e) {
            System.out.println("Неверный ввод\n" + e);
            return;
        }
        findPath(list);
    }

    static void findPath(List<Integer> list) {
        int[] array = new int[list.size()];
        for (int j = 0; j < list.size(); j++) {
            array[j] = 0;
            for (int i = 0; i < list.size(); i++) {
                array[j] += Math.abs(list.get(j) - list.get(i));
            }
        }
            OptionalInt min = Arrays.stream(array).min();
        System.out.println(min.getAsInt());
    }
}

