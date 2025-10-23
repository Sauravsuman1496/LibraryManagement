

public class User {
    int id;
    String name;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public void displayUser() {
        System.out.println("User ID: " + id + " | Name: " + name);
    }
}
