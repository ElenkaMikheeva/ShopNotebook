import java.util.*;

public class Main {
    public static void main(String[] args) {

        Notebook[] notebooks = new Notebook[10];
        notebooks[0] = new Notebook("first",   16, 256,  17, "Win");
        notebooks[1] = new Notebook("second",  32, 512,  15, "Mac");
        notebooks[2] = new Notebook("third",   16, 1024, 13, "Win");
        notebooks[3] = new Notebook("fourth",  32, 256,  15, "Lin");
        notebooks[4] = new Notebook("fifth",   16, 512,  17, "Mac");
        notebooks[5] = new Notebook("sixth",   32, 1024, 13, "Lin");
        notebooks[6] = new Notebook("seventh", 16, 256,  13, "Win");
        notebooks[7] = new Notebook("eighth",  32, 512,  17, "Lin");
        notebooks[8] = new Notebook("ninth",   16, 1024, 15, "Win");
        notebooks[9] = new Notebook("tenth",   32, 256,  13, "Mac");


        Map<String, String> filters = GetFilter();

        System.out.println("\nПо Вашему запросу подобраны следующие ноутбуки: ");
        for (Notebook notebook : notebooks) {
            if (notebook.Filter(filters)) {
                System.out.println(notebook);
            }
        }

    }

    private static Map<String, String> GetFilter() {
        Map<String, String> result = new HashMap<>();
        Scanner s = new Scanner(System.in);

        System.out.print("Введите минимальный размер RAM ([Enter] - не фильтровать): ");
        result.put("ram", s.nextLine());

        System.out.print("Введите минимальный размер HDD ([Enter] - не фильтровать): ");
        result.put("hdd", s.nextLine());

        System.out.print("Введите минимальный размер экрана ([Enter] - не фильтровать): ");
        result.put("screen", s.nextLine());

        System.out.print("Введите операционную систему ([Enter] - не фильтровать): ");
        result.put("os", s.nextLine());

        s.close();

        return result;
    }
}

