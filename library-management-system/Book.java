class Book {

    private  final int bookId;
    private String title;
    private String author;
    private String genre;
    private boolean isIssued;

    public Book(int id, String title, String author, String genre) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.isIssued = false;
    }

    public int getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getGenre() {
        return genre;
    }


    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isIssued() {
        return isIssued;
    }

    public void setIssued(boolean issued) {
        isIssued = issued;
    }

    void display() {
        System.out.println(bookId + " " + title + " " + author + " " + genre + " Issued: " + isIssued);
    }
}