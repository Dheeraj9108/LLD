package LibraryManagementSystemLLD.entites;

public class Magazine extends LibraryItem{
    
    private String publisher; 

    public Magazine(String title, String publisher) {
        super(title);
        this.publisher = publisher;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String getAuthorPublisher() {
        return publisher;
    }
}
