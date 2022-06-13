import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {
    private Map<String, List<Contact>> map = new HashMap<>();

    public void addNewGroup(String nameGroup) {
        if (!map.containsKey(nameGroup))
            map.put(nameGroup, new ArrayList<>());
    }

    public void addContactToGroup(Contact contact, String group) {
        String[] strGroup = group.split(",");
        for (String s : strGroup) {
            addNewGroup(s);
            if (!map.get(s).contains(contact))
                map.get(s).add(contact);
        }
    }

    public Contact searchContact(int number) {
        for (List<Contact> contactList : map.values()) {
            for (Contact contact : contactList) {
                if (contact.getNumber() == number) {
                    return contact;
                }
            }
        }
        return null;
    }

    public List<Contact> searchGroup(String group) {
        System.out.println("\nВсе контакты группы: " + group);
        return map.get(group);
    }

    public void showAllGroups() {
        System.out.println("Все группы в телефонном справочнике");
        for (Map.Entry<String, List<Contact>> entryMap : map.entrySet()) {
            System.out.println("Группа: " + entryMap.getKey());
            showContacts(entryMap.getValue());
        }
    }

    public void showContacts(List<Contact> contactList) {
        int i = 1;
        for (Contact contact : contactList) {
            System.out.println(i + "." + contact);
            i++;
        }
        System.out.println();
    }
}