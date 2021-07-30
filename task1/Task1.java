public class Task1 {

    public static void main(String[] args) {
        if (args.length != 2)
        {
            System.out.println("Количество аргументов должно быть 2");
            return;
        }
        int m = 0;
        int n = 0;
        try {
            n = Integer.parseInt(args[0]);
            m = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.out.println("Неверный формат ввода\n" + e);
            System.exit(1);
        }
        MyLinkedList list = new MyLinkedList();
        for (int i = 1; i <= n; i++)
            list.add(i);
        list.circle();
        System.out.println(list.printResult(m));
    }
}
