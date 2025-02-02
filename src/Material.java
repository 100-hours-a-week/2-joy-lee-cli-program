public class Material {
    // property
    protected String id;
    protected String title;
    protected boolean isAvailable;
    protected int loanPeriod;
    
    // constructor
    public Material(String id, String title) {
        this.id = id;
        this.title = title;
        this.isAvailable = true;
        this.loanPeriod = 14;
    }

    // 대출 method
    public void checkOut() {
        if (isAvailable) {
            isAvailable = false;
        } else {
            // 이미 대출 중
        }
    }

    // 반납 method
    public void returnItem() {
        if (!isAvailable) {
            isAvailable = true;
        } else {
            // 반납 불가능. 다시 확인
        }
    }

    public String getStatus() {
        return "[" + id + "] " + title + " - " + (isAvailable ? "대출가능" : "대출중");
    }
}
