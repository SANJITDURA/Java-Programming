abstract class LibraryMember {
    private String name;
    private int borrowedBooks;
    private int borrowingLimit;

    public LibraryMember(String name, int borrowingLimit) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Name cannot be null or empty.");
        }
        if (borrowingLimit <= 0) {
            throw new IllegalArgumentException("Borrowing limit must be greater than zero.");
        }
        this.name = name;
        this.borrowingLimit = borrowingLimit;
        this.borrowedBooks = 0;
    }

    public String getName() {
        return name;
    }

    public int getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getBorrowingLimit() {
        return borrowingLimit;
    }

    protected void incrementBorrowedBooks() {
        borrowedBooks++;
    }

    public abstract void borrowBook() throws Exception;
}
class Student extends LibraryMember {
    public Student(String name) {
        super(name, 3); 
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= getBorrowingLimit()) {
            throw new Exception("Borrowing limit exceeded for Student: " + getName());
        }
        incrementBorrowedBooks();
        System.out.println("Student " + getName() + " borrowed a book. (Total: " + getBorrowedBooks() + ")");
    }
}

class Teacher extends LibraryMember {
    public Teacher(String name) {
        super(name, 5); 
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= getBorrowingLimit()) {
            throw new Exception("Borrowing limit exceeded for Teacher: " + getName());
        }
        incrementBorrowedBooks();
        System.out.println("Teacher " + getName() + " borrowed a book. (Total: " + getBorrowedBooks() + ")");
    }
}

class Guest extends LibraryMember {
    public Guest(String name) {
        super(name, 1);
    }

    @Override
    public void borrowBook() throws Exception {
        if (getBorrowedBooks() >= getBorrowingLimit()) {
            throw new Exception("Borrowing limit exceeded for Guest: " + getName());
        }
        incrementBorrowedBooks();
        System.out.println("Guest " + getName() + " borrowed a book. (Total: " + getBorrowedBooks() + ")");
    }
}

public class LibraryMemberSystem {
    public static void main(String[] args) {
        LibraryMember[] members = {
            new Student("Alice"),
            new Teacher("Mr. Smith"),
            new Guest("John Doe")
        };

        System.out.println("Library Member Borrowing System\n");

        for (LibraryMember member : members) {
            try {
                member.borrowBook();
                member.borrowBook();
                member.borrowBook(); 
                member.borrowBook(); 
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
            System.out.println();
        }

        System.out.println("Testing error case...");
        try {
            LibraryMember invalidMember = new Student("");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}