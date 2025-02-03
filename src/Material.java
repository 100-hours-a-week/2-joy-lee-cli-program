import java.time.LocalDate;

public class Material {
    // property
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected int loanPeriod;
    protected LocalDate dueDate;
    
    // constructor
    public Material(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
        this.loanPeriod = 14;
        this.dueDate = null;
    }

    // 대출 method
    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
            dueDate = LocalDate.now().plusDays(loanPeriod);
            System.out.println("\n[" + title + "] 대출이 완료되었습니다.");
           System.out.println("\n✅ 반납예정일은 " + formatDate(dueDate) + "입니다");
        } else {
            System.out.println("이미 대출 중인 도서입니다.");
        }
    }

    // 반납 method
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
            System.out.println("\n[" + title + "] 반납이 완료되었습니다.");
        } else {
            System.out.println("대출 중인 도서가 아닙니다.");
        }
    }

    public String getStatus() {
        return "[" + id + "] " + title + " - " + (isAvailable ? "대출가능" : 
        "대출중 (반납예정일: " + formatDate(dueDate) + ")");
    }

    private String formatDate(LocalDate date) {
        return date.getYear() + "년 " + date.getMonthValue() + "월 " + date.getDayOfMonth() + "일";
    }
}
