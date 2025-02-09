public class Book extends Material { 
    private String author;
    private String publisher;
    private int pageCount;

    public Book(String id, String title, String author, String publisher, int pageCount) {
        super(id, title); 
        this.author = author;
        this.publisher = publisher;
        this.pageCount = pageCount;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getPageCount() {
        return pageCount;
    }
}
