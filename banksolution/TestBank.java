package predavanja.banksolution;

public class TestBank {

    public static void main(String[] args) {

        System.out.println("First let's make 3 employees for our bank...");
        Employee emp1 = new Employee("Mirjana", 37);
        Employee emp2 = new Employee("Ivana", 25);
        Employee emp3 = new Employee("Zvone", 30);
        System.out.println(emp1);
        System.out.println(emp2);
        System.out.println(emp3);
        System.out.println("\n");

        System.out.println("Then we make a bank and add 3 stands in the bank...");
        Bank bank = new Bank("OTP");
        bank.addStand(emp1, 5);
        bank.addStand(emp2, 8);
        bank.addStand(emp3, 12);
        System.out.println(bank + "\n\n");

        System.out.println("Now we can add customer to the bank queue...");
        for (int i = 0; i < 20; i++) {
            Customer customer = new Customer();
            bank.addCustomerToQueue(customer);
        }

        System.out.println("\n\nNow we open bank stands and then we start performing transactions for given time...");
        bank.startTransactionsOnBankStands();
        System.out.println(bank);

        showBankStatusAfterMinutes(bank, 1);
        showBankStatusAfterMinutes(bank, 6);
        showBankStatusAfterMinutes(bank, 9);
        showBankStatusAfterMinutes(bank, 13);
        showBankStatusAfterMinutes(bank, 7);
        showBankStatusAfterMinutes(bank, 33);

    }

    private static void showBankStatusAfterMinutes(Bank bank, int minutesPassed) {
        System.out.println("\n\n" + minutesPassed + " minutes passed ");
        bank.preformTransactionsOnStands(minutesPassed);
        System.out.println(bank);
    }
}
