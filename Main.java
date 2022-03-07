import java.util.*;

public class Main {

    public static void main(String[] args){

        // Exercise 1
        System.out.println("Exercise 1:");
        System.out.println();

        List<String> languages = Arrays.asList("Python", "Java", "C#", "PHP", "Java", "C++", "C#", "PHP", "Python", "Java", "C++", "Java", "PHP", "Python", "Java");

        Set<String> unique = new HashSet<String>(languages);

        System.out.println("Array: " + languages.toString());
        System.out.println();

        System.out.println("Unique values: " + unique.toString());
        System.out.println();

        System.out.println("Value frequency: ");
        for (String key : unique) {
            System.out.println(key + ": " + Collections.frequency(languages, key));
        }
        System.out.println();

        // Exercise 2
        System.out.println("Exercise 2:");
        System.out.println();

        Phonebook phonebook = new Phonebook();

        phonebook.add("Potter", "+44 888 555 66 33");
        phonebook.add("Weasley", "+44 777 666 00 99");
        phonebook.add("Weasley", "+44 333 000 55 11");
        phonebook.add("Weasley", "+44 666 000 99 22");
        phonebook.add("Granger", "+44 666 444 88 00");
        phonebook.add("Longbottom", "+44 222 888 11 44");
        phonebook.add("Finnigan", "+44 111 999 22 55");
        phonebook.add("Thomas", "+44 555 000 33 11");
        System.out.println();

        System.out.println("Potter");
        System.out.println(phonebook.get("Potter"));
        System.out.println("Weasley");
        System.out.println(phonebook.get("Weasley"));
        System.out.println("Granger");
        System.out.println(phonebook.get("Granger"));
        System.out.println("Longbottom");
        System.out.println(phonebook.get("Longbottom"));
        System.out.println("Finnigan");
        System.out.println(phonebook.get("Finnigan"));
        System.out.println("Thomas");
        System.out.println(phonebook.get("Thomas"));
        System.out.println();
    }

}
