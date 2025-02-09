import java.time.LocalDate;

public class EBook extends Book {
    private String link;

    public EBook(String id, String title, String author, String publisher, int pageCount) {
        super(id, title, author, publisher, pageCount);
        this.link = "http://library.com/ebook/" + id;
    }

    @Override
    public void checkOut() {
        // 이북은 대출여부 확인 안해도 됨
        dueDate = LocalDate.now().plusDays(loanPeriod);
        System.out.println("\n[" + title + "] 대출이 완료되었습니다.");
        System.out.println("\n✅ 링크만료일은 " + formatDate(dueDate) + "입니다");
        System.out.println("\n📱 E-Book 다운로드 링크: " + link);
    }
}
