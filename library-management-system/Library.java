import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Library {
    HashMap<Integer,Book> bookMap;
    HashMap<Integer,Member> membersMap;
    HashMap<Integer,Book> issuedBookMap;

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

    public List<Book> searchBookByTitle(String title) {
        List<Book> result = new ArrayList<>();

        for (Book b : bookMap.values()) {

            if (b.getTitle().equalsIgnoreCase(title)) {
                result.add(b);
            }

        }

        return result;
    }

    public List<Book> searchBookByAuthor(String author) {
        List<Book> result = new ArrayList<>();

        for (Book b : bookMap.values()) {

            if (b.getAuthor().equalsIgnoreCase(author)) {
                result.add(b);
            }

        }

        return result;
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

    public void listAllMembers(){

        if(membersMap.isEmpty()){
            System.out.println("No members found.");
            return;
        }

        for(Member m : membersMap.values()){
            m.displayDetails();
        }

    }

    public void issueBook(int memberId, int bookId) {

        Book book = bookMap.get(bookId);
        Member member = membersMap.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.setIssued(true);
        member.addIssuedBook(book);

        issuedBookMap.put(bookId, book);

        System.out.println("Book issued successfully.");
    }

    public void returnBook(int memberId, int bookId) {

        Book book = bookMap.get(bookId);
        Member member = membersMap.get(memberId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (member == null) {
            System.out.println("Member not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book was not issued.");
            return;
        }

        member.removeIssuedBook(book);
        book.setIssued(false);

        issuedBookMap.remove(bookId);

        System.out.println("Book returned successfully.");
    }
}
