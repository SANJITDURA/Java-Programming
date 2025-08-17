abstract class Account {
    private String username;
    private String password;
    public Account(String username, String password) {
        if (username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Username cannot be null or empty.");
        }
        if (password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Password cannot be null or empty.");
        }
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public abstract void login(String username, String password) throws Exception;
}
class GoogleAccount extends Account {
    public GoogleAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Google Account.");
        }
        System.out.println("Google Account " + getUsername() + " logged in successfully.");
    }
}
class FacebookAccount extends Account {
    public FacebookAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Facebook Account.");
        }
        System.out.println("Facebook Account " + getUsername() + " logged in successfully.");
    }
}
class TwitterAccount extends Account {
    public TwitterAccount(String username, String password) {
        super(username, password);
    }

    @Override
    public void login(String username, String password) throws Exception {
        if (!username.equals(getUsername()) || !password.equals(password)) {
            throw new Exception("Incorrect credentials for Twitter Account.");
        }
        System.out.println("Twitter Account " + getUsername() + " logged in successfully.");
    }
}
public class AccountLoginSystem {
    public static void main(String[] args) {
        Account[] accounts = {
            new GoogleAccount("googleUser ", "googlePass"),
            new FacebookAccount("facebookUser ", "facebookPass"),
            new TwitterAccount("twitterUser ", "twitterPass")
        };

        String[][] loginAttempts = {
            {"googleUser ", "googlePass"},
            {"facebookUser ", "wrongPass"},
            {"twitterUser ", "twitterPass"},
            {"unknownUser ", "somePass"}
        };

        for (Account account : accounts) {
            for (String[] attempt : loginAttempts) {
                try {
                    account.login(attempt[0], attempt[1]);
                } catch (Exception e) {
                    System.out.println("Login failed: " + e.getMessage());
                }
            }
            System.out.println();
        }
        System.out.println("Testing error case...");
        try {
            Account invalidAccount = new GoogleAccount(null, "googlePass");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
