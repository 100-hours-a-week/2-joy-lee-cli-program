public class EBook extends Book {
    private String link;

    public EBook(String id, String title, String author, String publisher, int pageCount) {
        super(id, title, author, publisher, pageCount);
        this.link = "http://library.com/ebook/" + id;
    }

    public void download() {
        // 다운로드 링크 출력
    }
}
