abstract class User {
    private String username;
    public User(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public abstract void login(String username, String password) throws Exception;
}
class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Admin.");
        }
        System.out.println("Admin " + getUsername() + " logged in successfully.");
    }
}
class Editor extends User {
    public Editor(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Editor.");
        }
        System.out.println("Editor " + getUsername() + " logged in successfully.");
    }
}

class Viewer extends User {
    public Viewer(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Viewer.");
        }
        System.out.println("Viewer " + getUsername() + " logged in successfully.");
    }
}

public class UserLoginSystem {
    public static void main(String[] args) {
        User[] users = {
            new Admin("adminUser ", "adminPass"),
            new Editor("editorUser ", "editorPass"),
            new Viewer("viewerUser ", "viewerPass")
        };
        String[][] loginAttempts = {
            {"adminUser ", "adminPass"},
            {"editorUser ", "wrongPass"},
            {"viewerUser ", "viewerPass"},
            {"unknownUser ", "somePass"}
        };

        for (User  user : users) {
            for (String[] attempt : loginAttempts) {
                try {
                    user.login(attempt[0], attempt[1]);
                } catch (Exception e) {
                    System.out.println("Login failed: " + e.getMessage());
                }
            }
            System.out.println(); 
        }

        System.out.println("Testing error case...");
        try {
            User invalidUser  = new Admin(null, "adminPass");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
