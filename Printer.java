import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        phoneBook.computeIfAbsent(name, k -> new ArrayList<>()).add(phoneNum);
    }

    public List<Integer> find(String name) {
        return phoneBook.getOrDefault(name, new ArrayList<>());
    }

    public HashMap<String, ArrayList<Integer>> getPhoneBook() {
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
        System.out.println(myPhoneBook.getPhoneBook());

        // Сортировка по убыванию числа телефонов
        List<String> sortedContacts = new ArrayList<>(myPhoneBook.getPhoneBook().keySet());
        sortedContacts.sort(Comparator.comparingInt(o -> myPhoneBook.getPhoneBook().get(o).size()));
        Collections.reverse(sortedContacts);

        // Вывод отсортированных контактов
        for (String name : sortedContacts) {
            System.out.println(name + ": " + myPhoneBook.find(name));
        }
    }
}
