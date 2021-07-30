import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Task3 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Аргументов должно быть 2");
            return;
        }
        try (FileReader fileReader = new FileReader(args[0]);
             FileReader fileReader1 = new FileReader(args[1]);
             Writer writer = Files.newBufferedWriter(Paths.get("report.json"))) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            Test1 test1 = gson.fromJson(fileReader, Test1.class);
            Values values = gson.fromJson(fileReader1, Values.class);
            HashMap<Integer, String> map = new HashMap<>();
            for (int i = 0; i < values.values.size(); i++) {
                map.put(values.values.get(i).id, values.values.get(i).value);
            }
            putIn(map, test1.tests);
            gson.toJson(test1, writer);
        } catch (IOException | JsonIOException | JsonSyntaxException | NullPointerException e) {
            System.out.println("Некорректные входные данные\n" + e);
            return;
        }
    }

    static void putIn(HashMap map, List<Test> testList) {
        for (int i = 0; i < testList.size(); i++) {
            if (map.containsKey(testList.get(i).id))
                testList.get(i).value = (String) map.get(testList.get(i).id);
            if (testList.get(i).values != null)
                putIn(map, testList.get(i).values);
        }
    }
}


