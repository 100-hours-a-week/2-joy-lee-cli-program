import java.util.ArrayList;

class LibraryResource {
    // property
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected int loanPeriod;
    
    // constructor
    public LibraryResource(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
        this.loanPeriod = 14;
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

    public String getStatus() {
        return "[" + id + "] " + title + " - " + (isAvailable ? "대출가능" : "대출중");
    }
}

class Book extends LibraryResource { 
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

class EBook extends Book {
    private String link;

    public EBook(String id, String title, String author, String publisher, int pageCount) {
        super(id, title, author, publisher, pageCount);
        this.link = "http://library.com/ebook/" + id;
    }

    public void download() {
        // 다운로드 링크 출력
    }
}


public class LibraryApp {
    private static ArrayList<LibraryResource> resources = new ArrayList<>();

    public static void main(String[] args) {
        // sample data
        resources.add(new Book("B001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
        resources.add(new Book("B002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        resources.add(new Book("B003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        resources.add(new Book("B004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));
        
        resources.add(new EBook("E001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
        resources.add(new EBook("E002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        resources.add(new EBook("E003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        resources.add(new EBook("E004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));

        boolean running = true;
        while (running) {
            System.out.println("\n=== 도서관 관리 프로그램 ===");
            System.out.println("1. 전체 도서 보기");
            System.out.println("2. 도서 대출하기");
            System.out.println("3. 도서 반납하기");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: \n");

             // 도서 목록 출력
             System.out.println("\n=== 도서 목록 ===");

             System.out.println("\n📕 일반 도서");
             for (LibraryResource resource : resources) {
                 if (resource.id.startsWith("B")) {
                     System.out.println(resource.getStatus());
                 }
             }
             
             System.out.println("\n📘 전자책");
             for (LibraryResource resource : resources) {
                 if (resource.id.startsWith("E")) {
                     System.out.println(resource.getStatus());
                 }
             }
             
            running = false;
        }
    }
}