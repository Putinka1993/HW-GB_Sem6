import java.util.*;

class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();
    public void add_contact(String name, Integer phoneNum) {
        if(phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNum);
        }
        else {
            ArrayList <Integer> l = new ArrayList<>();
            l.add(phoneNum);
            phoneBook.put(name, l);
        }
    }
    public void sorted_phonebook(HashMap<String, ArrayList<Integer>> dictionary){
        ArrayList<Integer> sort_value = new ArrayList<>();
        for (Map.Entry<String, ArrayList<Integer>> s : dictionary.entrySet()){
            ArrayList<Integer> v = s.getValue();
            int len_value = v.size();
            sort_value.add(len_value);
        }
        sort_value.sort(Comparator.reverseOrder());

        int count = sort_value.size();
        while (count != 0){
            for (int i = 0; i < sort_value.size(); i++){
                for (Map.Entry<String, ArrayList<Integer>> s : dictionary.entrySet()){
                    String k = s.getKey();
                    ArrayList<Integer> v = s.getValue();
                    int len_value = v.size();
                    if (sort_value.get(i) == len_value){
                        System.out.println(s);
                        count--;
                    }
                }
            }
        }
    }
    public static HashMap<String, ArrayList<Integer>> getPhoneBook() {
        return phoneBook;
    }

}

public class Phone_directory {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        int phone1;
        int phone2;
        int phone3;
        int phone4;
        int phone5;
        int phone6;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Kirill";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 999954;
            phone4 = 888884;
            phone5 = 222334;
            phone6 = 109944;

        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            phone1 = Integer.parseInt(args[3]);
            phone2 = Integer.parseInt(args[4]);
            phone3 = Integer.parseInt(args[5]);
            phone4 = Integer.parseInt(args[6]);
            phone5 = Integer.parseInt(args[7]);
            phone6 = Integer.parseInt(args[8]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add_contact(name1, phone1);
        myPhoneBook.add_contact(name1, phone3);
        myPhoneBook.add_contact(name2, phone2);
        myPhoneBook.add_contact(name3, phone6);
        myPhoneBook.add_contact(name3, phone4);
        myPhoneBook.add_contact(name3, phone5);

        PhoneBook sortedBook = new PhoneBook();

//        вывод
        System.out.println(PhoneBook.getPhoneBook());
        sortedBook.sorted_phonebook(PhoneBook.getPhoneBook());
        PhoneBook.getPhoneBook();
    }
}
