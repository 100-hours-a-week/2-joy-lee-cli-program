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

    public void getBookInfo() {
        // 작가, 출판사 출력
    }
    
    public void renewLoan() {
        // 대출 기간 연장
    }
}
