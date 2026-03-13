class Book {
    int bookId;
    String title;
    String author;
    boolean isIssued;

    public Book(int id, String title, String author) {
        this.bookId = id;
        this.title = title;
        this.author = author;
        this.isIssued = false;
    }

    public int getId() {
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

    void display() {
        System.out.println(bookId + " " + title + " " + author + " Issued: " + isIssued);
    }
}
