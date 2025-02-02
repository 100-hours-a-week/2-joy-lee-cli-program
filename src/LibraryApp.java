import java.util.ArrayList;

class LibraryResource {
    // property
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected int loanPeriod;
    
    // constructor
    public LibraryResource() {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
        this.loanPeriod = loanPeriod;
    }

    // 대출 method
    public void checkOut() {
        if (isAvailable) {
            // 대출 완료
        } else {
            // 이미 대출 중
        }
    }

    // 반납 method
    public void returnItem() {
        if (!isAvailable) {
            // 반납 완료
        } else {
            // 반납 불가능. 다시 확인
        }
    }

    public void getStatus() {
        // return isAvailable ? "대출가능" : "대출중"
    }
}

class Book extends LibraryResource { 
    private String author;
    private String publisher;
    private int pageCount;

    public Book() {
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

class EBook extends Book {
    private String link;

    public EBook() {
        this.link = "http://library.com/ebook/" + id;
    }

    public void download() {
        // 다운로드 링크 출력
    }
}

public class LibraryApp {
    public static void main(String[] args) {
        ArrayList<LibraryResource> resources = new ArrayList<>();
        
        // sample data
        // resources.add(new Book());
        // resources.add(new EBook());
    }
}
