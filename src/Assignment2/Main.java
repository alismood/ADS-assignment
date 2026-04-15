package Assignment2;

import java.util.*;

public class Main {

    //accounts
    static LinkedList<BankAccount> accounts = new LinkedList<>();
    //history
    static Stack<String> history = new Stack<>();
    //bills
    static Queue<String> billQueue = new LinkedList<>();
    //account requests
    static Queue<BankAccount> accountRequests = new LinkedList<>();

    //Task1
    public static void addAccount(int accNum, String name, double balance) {
        accounts.add(new BankAccount(accNum, name, balance));
        System.out.println("Account added successfully");
    }

    public static void displayAccounts() {
        int i = 1;
        for (BankAccount acc : accounts) {
            System.out.print(i++ + ". ");
            acc.display();
        }
    }

    public static BankAccount searchAccount(String username) {
        for (BankAccount acc : accounts) {
            if (acc.username.equalsIgnoreCase(username)) {
                return acc;
            }
        }
        return null;
    }


    //Task2
    public static void deposit(String username, double amount) {
        BankAccount acc = searchAccount(username);
        if (acc != null) {
            acc.balance += amount;
            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("Account not found");
        }
    }

    public static void withdraw(String username, double amount) {
        BankAccount acc = searchAccount(username);
        if (acc != null && acc.balance >= amount) {
            acc.balance -= amount;
            System.out.println("New balance: " + acc.balance);
        } else {
            System.out.println("Insufficient balance or account not found");
        }
    }


    // Task3
    public static void addTransaction(String action) {
        history.push(action);
    }

    public static void undoTransaction() {
        if (!history.isEmpty()) {
            System.out.println("Undo → " + history.pop());
        } else {
            System.out.println("No transactions to undo");
        }
    }

    public static void lastTransaction() {
        if (!history.isEmpty()) {
            System.out.println("Last: " + history.peek());
        } else {
            System.out.println("No transactions yet");
        }
    }


    // Task4
    public static void addBill(String bill) {
        billQueue.add(bill);
        System.out.println("Added: " + bill);
    }

    public static void processBill() {
        if (!billQueue.isEmpty()) {
            System.out.println("Processing: " + billQueue.poll());
        } else {
            System.out.println("No bills in queue");
        }
    }

    public static void showBills() {
        System.out.println("Bills Queue: " + billQueue);
    }


    //Task5
    public static void requestAccount(BankAccount acc) {
        accountRequests.add(acc);
        System.out.println("Request submitted");
    }

    public static void processRequest() {
        if (!accountRequests.isEmpty()) {
            BankAccount acc = accountRequests.poll();
            accounts.add(acc);
            System.out.println("Account approved: " + acc.username);
        } else {
            System.out.println("No pending requests");
        }
    }

    public static void showRequests() {
        if (accountRequests.isEmpty()) {
            System.out.println("No pending requests");
        } else {
            for (BankAccount acc : accountRequests) {
                System.out.println(acc.username);
            }
        }
    }


    // Task6
    public static void arrayExample() {
        BankAccount[] arr = new BankAccount[3];

        arr[0] = new BankAccount(1, "Ali", 150000);
        arr[1] = new BankAccount(2, "Sara", 220000);
        arr[2] = new BankAccount(3, "John", 100000);

        System.out.println("Array Accounts:");
        for (BankAccount acc : arr) {
            acc.display();
        }
    }


    //Main menu
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Sample
        addAccount(1, "Ali", 150000);
        addAccount(2, "Sara", 220000);

        while (true) {
            System.out.println("\nMAIN MENU");
            System.out.println("1Bank");
            System.out.println("2ATM");
            System.out.println("3Admin");
            System.out.println("4Transactions");
            System.out.println("5ills");
            System.out.println("6Array Demo");
            System.out.println("7Exit");

            int choice = sc.nextInt();
            switch (choice) {
                // Bank!!!
                case 1://Another choice
                    System.out.println("1-Request Account 2-Deposit 3-Withdraw");
                    int b = sc.nextInt();

                    if (b == 1) {
                        System.out.print("Enter username: ");
                        String name = sc.next();
                        requestAccount(new BankAccount(0, name, 0));
                    }
                    else if (b == 2) {
                        System.out.print("Username: ");
                        String u = sc.next();
                        System.out.print("Amount: ");
                        double a = sc.nextDouble();
                        deposit(u, a);
                        addTransaction("Deposit " + a + " to " + u);
                    }
                    else if (b == 3) {
                        System.out.print("Username: ");
                        String u = sc.next();
                        System.out.print("Amount: ");
                        double a = sc.nextDouble();
                        withdraw(u, a);
                        addTransaction("Withdraw " + a + " from " + u);
                    }
                    break;


                // ATM
                case 2:
                    System.out.println("1-Balance 2-Withdraw");
                    int atm = sc.nextInt();

                    System.out.print("Username: ");
                    String user = sc.next();

                    BankAccount acc = searchAccount(user);

                    if (acc != null) {
                        if (atm == 1) {
                            System.out.println("Balance: " + acc.balance);
                        } else if (atm == 2) {
                            System.out.print("Amount: ");
                            double amt = sc.nextDouble();
                            withdraw(user, amt);
                        }
                    } else {
                        System.out.println("Account not found");
                    }
                    break;

                // Admin
                case 3:
                    System.out.println("1-Process Requests 2-View Requests 3-View Bills");
                    int admin = sc.nextInt();

                    if (admin == 1) processRequest();
                    else if (admin == 2) showRequests();
                    else if (admin == 3) showBills();
                    break;


                // Transactions
                case 4:
                    System.out.println("1-Show Last 2-Undo");
                    int t = sc.nextInt();

                    if (t == 1) lastTransaction();
                    else if (t == 2) undoTransaction();
                    break;


                // Bills
                case 5:
                    System.out.println("1-Add Bill 2-Process Bill 3-Show Bills");
                    int bill = sc.nextInt();

                    if (bill == 1) {
                        System.out.print("Enter bill name: ");
                        String bname = sc.next();
                        addBill(bname);
                    } else if (bill == 2) {
                        processBill();
                    } else if (bill == 3) {
                        showBills();
                    }
                    break;


                // Array demo
                case 6:
                    arrayExample();
                    break;


                case 7:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}