public class Actor {
    private String firstName;
    private String lastName;

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}
