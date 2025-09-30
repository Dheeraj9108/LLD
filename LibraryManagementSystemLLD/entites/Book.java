package LibraryManagementSystemLLD.entites;

public class Book extends LibraryItem{
    private String author;

    public Book(String title, String author) {
        super(title);
        this.author = author;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String getAuthorPublisher() {
        return author;
    }
    
}
