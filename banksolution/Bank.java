package predavanja.banksolution;

import predavanja.queueimplementation.QueueArr;

import java.util.Set;
import java.util.TreeSet;

public class Bank {

    private static int cntID = 100;
    private final int BANKCAP = 30;
    private final String bankName;
    private final int id;
    private final Set<BankStand> stands;
    private final QueueArr<Customer> queue;
    private int totalTime;

    public Bank(String bankName) {
        this.bankName = bankName;
        this.id = cntID++;
        this.stands = new TreeSet<>();
        this.queue = new QueueArr<>(BANKCAP);
        this.totalTime = 0;
    }

    public String getBankName() {
        return bankName;
    }

    public void addStand(Employee employee, int processingTime) {
        BankStand stand = new BankStand(employee, processingTime);
        stands.add(stand);
    }

    public void addCustomerToQueue(Customer customer) {
        queue.enqueue(customer);
    }

    public void startTransactionsOnBankStands() {

        for (BankStand stand : stands) {
            if (!stand.statusProcessing) {
                stand.changeBankStandStatus(true);
            }
        }
    }

    public void preformTransactionsOnStands(int workingMinutes) {
        totalTime += workingMinutes;
        System.out.println(totalTime + " minutes passed from starting transactions...");
        QueueArr<Customer> tempQueue = null;
        try {
            tempQueue = (QueueArr<Customer>) queue.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }

        for (int i = 0; i <= totalTime; i++) {
            for (BankStand stand : stands) {
                if (i % stand.getProcessingTimeMinutes() == 0) {
                    stand.setCurrentCustomer(tempQueue.dequeue());
                }
            }
        }
    }


    @Override
    public String toString() {
        String repr = "--------------" + getBankName() + "--------------";
        String tempRepr = repr;
        for (BankStand stand : stands) {
            repr += "\n" + stand + "\n";
        }
        for (int i = 0; i < tempRepr.length(); i++) {
            repr += "-";
        }
        return repr;
    }

    private static class BankStand implements Comparable<BankStand> {

        private static int cntID = 1;
        private final int id;
        private final int processingTimeMinutes;
        private boolean statusProcessing;
        private final Employee employee;
        private Customer currentCustomer;

        public BankStand(Employee employee, int processingTime) {
            this.employee = employee;
            id = cntID++;
            this.processingTimeMinutes = processingTime;
            statusProcessing = false;
            currentCustomer = null;
        }

        public void setCurrentCustomer(Customer currentCustomer) {
            this.currentCustomer = currentCustomer;
        }

        public int getId() {
            return id;
        }

        public int getProcessingTimeMinutes() {
            return processingTimeMinutes;
        }

        public void changeBankStandStatus(boolean newStatus) {
            statusProcessing = newStatus;
        }

        @Override
        public String toString() {
            return "STAND ID = " + getId()
                    + "\nEmployee: " + employee +
                    "\nStatus: " + (statusProcessing ? "OPEN" : "CLOSED") +
                    "\nProcessing time: " + processingTimeMinutes + " min" +
                    "\nCurrent customer: " + currentCustomer;
        }

        @Override
        public int compareTo(BankStand o) {
            if (this.getId() > o.getId()) {
                return 1;
            } else if (this.getId() < o.getId()) {
                return -1;
            } else {
                return 0;
            }
        }
    }
}
