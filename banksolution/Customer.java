package predavanja.banksolution;

public class Customer {

    private final String name;
    private final int age;

    public Customer() {
        this.name = AUXCLS.generateRandomName();
        this.age = AUXCLS.generateRandomAge();
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
