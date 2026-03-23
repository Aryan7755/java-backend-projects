import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    HashMap<Integer,Book> bookMap;
    HashMap<Integer,Member> membersMap;
    HashMap<Integer,Book> issuedBookMap;
    private int bookIdCounter = 1;
    private int memberIdCounter = 1;

    public Library() {
        bookMap = new HashMap<>();
        membersMap = new HashMap<>();
        issuedBookMap = new HashMap<>();
    }

    // book management methods

    public void addBook(Book book){
        bookMap.put(book.getBookId(), book);
        System.out.println("Book added successfully.");
    }
    public void removeBook(int bookId) {
        if (bookMap.containsKey(bookId)) {
            bookMap.remove(bookId);
            System.out.println("Book removed.");
        } else {
            System.out.println("Book not found.");
        }
    }

    public void updateBook(int bookId, String title, String author, String genre) {
        Book book = bookMap.get(bookId);
        if (book == null) {
            System.out.println("Book not found.");
            return;
        }
        book.setTitle(title);
        book.setAuthor(author);
        book.setGenre(genre);
    }

    public Book searchBookById(int bookId){

        return bookMap.get(bookId);
    }

    public void searchBookByTitle(String keyword) {

        bookMap.values().stream()
                .filter(b -> b.getTitle().toLowerCase().contains(keyword.toLowerCase()))
                .forEach(Book::display);
    }

    public void searchBookByAuthor(String author) {

        bookMap.values().stream()
                .filter(b -> b.getAuthor().equalsIgnoreCase(author))
                .forEach(Book::display);
    }

    public List<Book> searchBookByGenre(String genre) {
        List<Book> result = new ArrayList<>();

        for (Book b : bookMap.values()) {

            if (b.getGenre().equalsIgnoreCase(genre)) {
                result.add(b);
            }

        }

        return result;
    }

    public void addMember(Member member){
        membersMap.put(member.getMemberId(), member);
        System.out.println("Member added successfully.");
    }

    public void removeMember(int memberId){
        if(membersMap.containsKey(memberId)){
            membersMap.remove(memberId);
            System.out.println("Member removed.");
        }
        else{
            System.out.println("Member not found.");
        }
    }

    public void displayMemberDetails(int memberId){

        Member member = membersMap.get(memberId);

        if(member == null){
            System.out.println("Member not found.");
            return;
        }

        member.displayDetails();
    }

    public void addBooksToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("books.txt"))) {

            for (Book b : bookMap.values()) {

                writer.write(
                        b.getBookId() + "," +
                                b.getTitle() + "," +
                                b.getAuthor() + "," +
                                b.getGenre() + "," +
                                b.isIssued()
                );

                writer.newLine();
            }

            System.out.println("Books saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving books.");
        }
    }

    public void getBooksFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("books.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String title = parts[1];
                String author = parts[2];
                String genre = parts[3];
                boolean isIssued = Boolean.parseBoolean(parts[4]);

                Book book = new Book(id, title, author, genre);
                book.setIssued(isIssued);

                bookMap.put(id, book);
            }

            System.out.println("Books loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading books.");
        }
    }

    public void addMembersToFile() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("members.txt"))) {

            for (Member m : membersMap.values()) {

                writer.write(
                        m.getMemberId() + "," +
                                m.getName()
                );

                writer.newLine();
            }

            System.out.println("Members saved successfully.");

        } catch (IOException e) {
            System.out.println("Error saving members.");
        }
    }

    public void getMembersFromFile() {

        try (BufferedReader reader = new BufferedReader(new FileReader("members.txt"))) {

            String line;

            while ((line = reader.readLine()) != null) {

                String[] parts = line.split(",");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];

                Member member = new Member(id, name);

                membersMap.put(id, member);
            }

            System.out.println("Members loaded successfully.");

        } catch (IOException e) {
            System.out.println("Error loading members.");
        }
    }

    public void listAllBooks() {

        if (bookMap.isEmpty()) {
            System.out.println("No books available.");
            return;
        }

        for (Book b : bookMap.values()) {
            b.display();
        }
    }

    public void listAllMembers() {

        if (membersMap.isEmpty()) {
            System.out.println("No members found.");
            return;
        }

        for (Member m : membersMap.values()) {
            m.displayDetails();
        }
    }

    public List<Book> getIssuedBooks() {
        return bookMap.values().stream()
                .filter(Book::isIssued)
                .toList();
    }

    public void sortBooksByTitle() {

        bookMap.values().stream()
                .sorted((b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()))
                .forEach(Book::display);
    }

    public void sortBooksByAuthor() {

        bookMap.values().stream()
                .sorted((b1, b2) -> b1.getAuthor().compareToIgnoreCase(b2.getAuthor()))
                .forEach(Book::display);
    }
}
