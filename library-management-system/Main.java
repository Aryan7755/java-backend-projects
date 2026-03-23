import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Library library = new Library();
        library.getBooksFromFile();
        library.getMembersFromFile();

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Library Menu =====");
            System.out.println("1. Add Book");
            System.out.println("2. Add Member");
            System.out.println("3. Issue Book");
            System.out.println("4. Return Book");
            System.out.println("5. View All Books");
            System.out.println("6. View Issued Books");
            System.out.println("7. Search Book");
            System.out.println("8. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {

                case 1:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    System.out.print("Enter author: ");
                    String author = sc.nextLine();
                    System.out.print("Enter genre: ");
                    String genre = sc.nextLine();

                    library.addBook(title, author, genre);
                    break;

                case 2:
                    System.out.print("Enter member name: ");
                    String name = sc.nextLine();
                    library.addMember(name);
                    break;

                case 3:
                    System.out.print("Enter member ID: ");
                    int mId = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    int bId = sc.nextInt();
                    library.issueBook(mId, bId);
                    break;

                case 4:
                    System.out.print("Enter member ID: ");
                    mId = sc.nextInt();
                    System.out.print("Enter book ID: ");
                    bId = sc.nextInt();
                    library.returnBook(mId, bId);
                    break;

                case 5:
                    library.listAllBooks();
                    break;

                case 6:
                    library.getIssuedBooks();
                    break;

                case 7:
                    System.out.print("Enter keyword: ");
                    String keyword = sc.nextLine();
                    library.searchBookByTitle(keyword);
                    break;

                case 8:
                    library.addBooksToFile();
                    library.addMembersToFile();
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}