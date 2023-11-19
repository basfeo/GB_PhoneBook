import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class PhoneBook {
    private static Map<String, List<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        if (phoneBook.containsKey(name)) {
            // Если запись с именем name уже существует, добавляем новый номер телефона в список
            List<Integer> phoneNums = phoneBook.get(name);
            phoneNums.add(phoneNum);
        } else {
            // Если записи с именем name не существует, создаем новую запись
            List<Integer> phoneNums = new ArrayList<>();
            phoneNums.add(phoneNum);
            phoneBook.put(name, phoneNums);
        }
    }

    public List<Integer> find(String name) {
        if (phoneBook.containsKey(name)) {
            // Если запись с именем name существует, возвращаем список номеров телефона
            return phoneBook.get(name);
        } else {
            // Если записи с именем name не существует, возвращаем пустой список
            return new ArrayList<>();
        }
    }

    public static Map<String, List<Integer>> getPhoneBook() {
        // Возвращаем всю телефонную книгу
        return phoneBook;
    }
}

public class Printer {
    public static void main(String[] args) {
        String name1;
        String name2;
        int phone1;
        int phone2;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            phone1 = 123456;
            phone2 = 654321;
        } else {
            name1 = args[0];
            name2 = args[1];
            phone1 = Integer.parseInt(args[2]);
            phone2 = Integer.parseInt(args[3]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);

        System.out.println(myPhoneBook.find(name1));
        System.out.println(PhoneBook.getPhoneBook());

        // Выводим все контакты из телефонной книги отсортированными по убыванию числа телефонов
        // Выводим все контакты из телефонной книги отсортированными по убыванию числа телефонов
        List<Map.Entry<String, List<Integer>>> sortedEntries = new ArrayList<>(myPhoneBook.getPhoneBook().entrySet());
        Collections.sort(sortedEntries, (e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));
        for (Map.Entry<String, List<Integer>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}