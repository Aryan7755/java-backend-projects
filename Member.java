import java.util.ArrayList;
import java.util.List;

public class Member {

    private int memberId;
    private String name;
    private List<Book> issuedBooks;

    public Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getMemberId() {
        return memberId;
    }

    public String getName() {
        return name;
    }

    public List<Book> getIssuedBooks() {
        return issuedBooks;
    }

    public void addIssuedBook(Book book) {
        issuedBooks.add(book);
    }

    public void removeIssuedBook(Book book) {
        issuedBooks.remove(book);
    }

    public void displayDetails() {

        System.out.println("Member ID: " + memberId);
        System.out.println("Name: " + name);

        if (issuedBooks.isEmpty()) {
            System.out.println("No books issued.");
        } else {
            System.out.println("Issued Books:");
            for (Book b : issuedBooks) {
                b.display();
            }
        }
    }
}