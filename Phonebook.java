import java.util.*;

public class Phonebook {

    private HashMap<String, List<String>> phonebook;

    public Phonebook(){
        this.phonebook = new HashMap<>();
    }

    public void add(String lastName, String number){
        if(phonebook.containsKey(lastName)){
            List<String> numbers = phonebook.get(lastName);
            if(!numbers.contains(number)){
                numbers.add(number);
                System.out.println(String.format("Contact " + lastName + " with phone number " + number + " has been added to the Phonebook"));
            } else {
                System.out.println(String.format("Phone number" + number + " has already been added to the contact " + lastName));
            }
        } else {
            phonebook.put(lastName, new ArrayList<>(Arrays.asList(number)));
            System.out.println(String.format("Contact " + lastName + " with phone number " + number + " has been added to the Phonebook"));
        }
    }

    public List<String> get(String lastName){
        if(phonebook.containsKey(lastName)){
            return phonebook.get(lastName);
        } else {
            System.out.println(String.format("Not found"));
            return new ArrayList<>();
        }
    }

}
