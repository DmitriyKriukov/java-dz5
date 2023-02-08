import java.util.*;

public class Main {
    public static void main(String[] args) {
        ex1();
    }

    static void ex0() {
        /*
        Реализуйте структуру телефонной книги с помощью HashMap,
        учитывая, что 1 человек может иметь несколько телефонов.
        */
        Map<String, List<Integer>> phoneBook = new HashMap<>();
        fillPhoneBook(phoneBook, "Иван", 11111);
        fillPhoneBook(phoneBook, "Петр", 33333);
        fillPhoneBook(phoneBook, "Василий", 44444);
        fillPhoneBook(phoneBook, "Иван", 22222);
        System.out.println(phoneBook);
    }

    static void fillPhoneBook(Map<String, List<Integer>> phoneBook, String name, int number) {
        if (phoneBook.containsKey(name)) {
            List<Integer> list = phoneBook.get(name);
            list.add(number);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(number);
            phoneBook.put(name, list);
        }
    }

    static void ex1() {
        /*
        Пусть дан список сотрудников: Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина,
        Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова,
        Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов.
        Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
        Отсортировать по убыванию популярности. Для сортировки использовать TreeMap.
        */
        String listEmployees = "Иван Иванов, Светлана Петрова, Кристина Белова, Анна Мусина, " +
                "Анна Крутова, Иван Юрин, Петр Лыков, Павел Чернов, Петр Чернышов, Мария Федорова, Марина Светлова, " +
                "Мария Савина, Мария Рыкова, Марина Лугова, Анна Владимирова, Иван Мечников, Петр Петин, Иван Ежов";
        listEmployees = listEmployees.replace(",", "");
        String[] employees = listEmployees.split(" ");
        TreeMap<Integer, List<String>> treeMap = new TreeMap<>(Comparator.reverseOrder());
        List<String> names = new ArrayList<>();
        for (int i = 0; i < employees.length; i += 2) {
            int count = 1;
            if (!names.contains(employees[i])) {
                List<String> list = new ArrayList<>();
                for (int j = i + 2; j < employees.length; j += 2) {
                    if (employees[i].equals(employees[j])) {
                        count++;
                    }
                }
                names.add(employees[i]);
                if (treeMap.containsKey(count)) {
                    list = treeMap.get(count);
                    list.add(employees[i]);
                } else {
                    list.add(employees[i]);
                    treeMap.put(count, list);
                }
            }
        }
        System.out.println(treeMap);
    }
}