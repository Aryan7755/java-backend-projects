import java.util.List;

public class Member {
    int id;
    String name;
    List<String> issuedBooks;

    public Member(int id, String name, List<String> issuedBooks) {
        this.id = id;
        this.name = name;
        this.issuedBooks = issuedBooks;
    }
    public void displayDetails(){
        System.out.println("User Details : ID is "+ id +" ,Name is "+name+" and List of Issued Books "+issuedBooks);
    }
}
