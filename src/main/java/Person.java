import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    protected final String name;
    protected final String surname;
    protected int age;
    protected String address;

    public Person(String name, String surname, int age, String address) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.address = address;
    }

    public boolean hasAge() {
        if (age == 0) {
            return false;
        }
        return true;
    }

    public boolean hasAddress(String city) {
        if (address == null) {
            return false;
        }
        return true;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setAge(int age) {
        if (hasAge() == false) {
            this.age = age;
        } else {
            getAge();
            happyBirthday();
        }
    }

    public OptionalInt getAge() {
        return OptionalInt.of(age);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (hasAddress(address) == false) {
            this.address = address;
        } else {
            getAddress();
        }
    }

    public void happyBirthday() {
        this.age = age + 1;
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.surname = this.surname;
        child.address = this.address;
        return child;
    }

    @Override
    public String toString() {
        return String.format("%s %s -> %s, %s", name, surname, age, address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname);
    }
}

