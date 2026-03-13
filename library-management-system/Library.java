import java.util.HashMap;

public class Library {
    HashMap<Integer,Book> bookMap;
    HashMap<Integer,Member> membersMap;
    HashMap<Integer,Book> issuedBookMap;

    public Library(HashMap<Integer, Book> bookMap, HashMap<Integer, Member> membersMap, HashMap<Integer, Book> issuedBookMap) {
        this.bookMap = bookMap;
        this.membersMap = membersMap;
        this.issuedBookMap = issuedBookMap;
    }

    public void addBook(Book book){
        bookMap.put(book.getId(), book);
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

    }

    public Book searchBookById(int bookId){

        return null;
    }

    public List<Book> searchBookByTitle(String title) {
        return null;
    }

    public List<Book> searchBookByAuthor(String author) {
        return null;
    }

    public List<Book> searchBookByGenre(String genre) {
        return null;
    }

}
