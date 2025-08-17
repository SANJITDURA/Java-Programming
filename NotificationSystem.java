abstract class Notification {
    private String recipient;

    public Notification(String recipient) {
        if (recipient == null || recipient.isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be null or empty.");
        }
        this.recipient = recipient;
    }

    public String getRecipient() {
        return recipient;
    }

    public abstract void send();
}
class EmailNotification extends Notification {
    private String subject;
    private String message;

    public EmailNotification(String recipient, String subject, String message) {
        super(recipient);
        if (subject == null || subject.isEmpty()) {
            throw new IllegalArgumentException("Subject cannot be null or empty.");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }
        this.subject = subject;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending Email to: " + getRecipient());
        System.out.println("Subject: " + subject);
        System.out.println("Message: " + message);
    }
}
class SMSNotification extends Notification {
    private String message;

    public SMSNotification(String recipient, String message) {
        super(recipient);
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending SMS to: " + getRecipient());
        System.out.println("Message: " + message);
    }
}
class PushNotification extends Notification {
    private String title;
    private String message;

    public PushNotification(String recipient, String title, String message) {
        super(recipient);
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Title cannot be null or empty.");
        }
        if (message == null || message.isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty.");
        }
        this.title = title;
        this.message = message;
    }

    @Override
    public void send() {
        System.out.println("Sending Push Notification to: " + getRecipient());
        System.out.println("Title: " + title);
        System.out.println("Message: " + message);
    }
}
public class NotificationSystem {
    public static void main(String[] args) {
        Notification[] notifications = {
            new EmailNotification("alice@example.com", "Welcome!", "Thank you for joining us!"),
            new SMSNotification("123-456-7890", "Your verification code is 123456."),
            new PushNotification("user123", "New Message", "You have a new message in your inbox.")
        };

        System.out.println("Sending notifications...\n");

        for (Notification notification : notifications) {
            try {
                notification.send();
                System.out.println();
            } catch (Exception e) {
                System.out.println("Error sending notification: " + e.getMessage());
            }
        }

        System.out.println("Testing error case...");
        try {
            Notification invalidNotification = new EmailNotification("", "Subject", "Message");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
