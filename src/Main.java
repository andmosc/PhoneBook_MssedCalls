import java.util.Scanner;

public class Main {
    public static final boolean RECEIVED_CALL = true;
    public static final boolean MISSED_CALL = false;

    public static void main(String[] args) throws InterruptedException {
        PhoneBook phoneBook = new PhoneBook();
        Calls calls = new Calls();

        addContact(phoneBook);

        Call(incommingCall(phoneBook, 100), calls);
        Call(incommingCall(phoneBook, 300), calls);
        Call(incommingCall(phoneBook, 77700), calls);
        Call(incommingCall(phoneBook, 500), calls);

        calls.showAllCals(RECEIVED_CALL);
        calls.showAllCals(MISSED_CALL);
    }

    public static void addContact(PhoneBook phoneBook) {
        phoneBook.addContactToGroup(new Contact("Петр", 100), "Работа,Другие");
        phoneBook.addContactToGroup(new Contact("Олег", 200), "Работа,Друзья");
        phoneBook.addContactToGroup(new Contact("Елена", 300), "Другие");
        phoneBook.addContactToGroup(new Contact("Виктория", 400), "Работа,Друзья");
        phoneBook.addContactToGroup(new Contact("Александр", 500), "Работа,Друзья");
    }

    public static void Call(String number, Calls calls) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Входящий вызов от аббонента: " + number);
        while (true) {
            System.out.print("Принять входящий звонок? Y/N: ");
            String input = scanner.nextLine();
            switch (input.toUpperCase()) {
                case "Y":
                    System.out.println("Входящий звонок приянт");
                    calls.addCall(number, RECEIVED_CALL);
                    return;
                case "N":
                    System.out.println("Входящий звонок не приянт");
                    calls.addCall(number, MISSED_CALL);
                    return;
            }
        }
    }

    public static String incommingCall(PhoneBook phoneBook, int number) {
        String strNumber = String.valueOf(number);
        if (phoneBook.searchContact(number) != null) {
            strNumber = String.valueOf(phoneBook.searchContact(number).getName());
        }
        return strNumber;
    }
}