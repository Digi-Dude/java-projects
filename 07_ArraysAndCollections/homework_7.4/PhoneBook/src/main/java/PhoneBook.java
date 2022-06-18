import java.util.*;

public class PhoneBook {

    public static Map<String, String> phoneBook = new HashMap<>();

    public void addContact(String phone, String name) {
        // проверьте корректность формата имени и телефона
        // если такой номер уже есть в списке, то перезаписать имя абонента
        if (phone.matches("\\d{11}") && name.matches("[А-я]+")) {
            phoneBook.put(phone, name);
        }
    }

    ////////////////////////////////////////////////////////////////////////

    public String getNameByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
        String contact = "";
        if(phoneBook.containsKey(phone)) {
            for (Map.Entry<String, String> entry : phoneBook.entrySet()) {
                if (entry.getKey().equals(phone)) {
                    String name = entry.getValue();
                    contact = entry.getValue() + " - ";
                    for (Map.Entry<String, String> newEntry : phoneBook.entrySet()) {
                        if (newEntry.getValue().equals(name)) {
                            contact += newEntry.getKey() + ", ";
                        }
                    }
                    contact = contact.replaceAll("\\,\\s+$", "");
                }
            }
        }
        return contact;

    }

    //////////////////////////////////////////////////////////////////////// не работает?????

    public Set<String> getPhonesByName(String name) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        String stringContact = "";                                      // Создание пустой строки
        Set<String> contact = new TreeSet<>();                          // Создание путой коллекции
        if(phoneBook.containsValue(name)) {
            stringContact += name + " - ";                              // Добавление имени в строку
            for (Map.Entry entry : phoneBook.entrySet()) {
                if (entry.getValue().equals(name)) {                    // Проверка на соответствие имени
                    stringContact += entry.getKey() + ", ";
                }
            }
            stringContact = stringContact.replaceAll("\\,\\s+$", "");
            contact.add(stringContact);
        }
        else return contact;
        return contact;
    }

    ////////////////////////////////////////////////////////////////////////

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        Set<String> contacts = new TreeSet<>();
        Set<String> names = new HashSet<>();
        for (String name: phoneBook.values()) {
            names.add(name);
        }
        for (String nameContact: names) {
            String contact = nameContact + " - ";
            for (Map.Entry entry: phoneBook.entrySet()) {
                if (entry.getValue().equals(nameContact)) {
                    contact += entry.getKey() + ", ";
                }

            }
            contact = contact.replaceAll("\\,\\s+$", "");
            contacts.add(contact);
        }


        if (contacts.size() > 0) {
            return contacts;
        }
        else return new TreeSet<>();
    }

}