import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class LibraryService {
    private ArrayList<Material> materials;

    public LibraryService() {
        materials = new ArrayList<>();
        init();
    }

    private void init() {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("db/books.txt"));
            List<String> lines = reader.lines().toList(); // db 파일 텍스트를 리스트로 변환

            for(String line : lines) {
                String[] data = line.split(",");

                String id = data[0];
                String title = data[1];
                String author = data[2];
                String publisher = data[3];
                int pages = Integer.parseInt(data[4]);

                // 코드에 따라 Book 또는 EBook 객체 생성
                if(id.startsWith("B")){
                    Book book = new Book(id, title, author, publisher, pages);
                    materials.add(book);
                } else if(id.startsWith("E")){
                    EBook ebook = new EBook(id, title, author, publisher, pages);
                    materials.add(ebook);
                }
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("도서 데이터 파일을 불러오는데 실패했습니다. 다시 시도해 주세요");
        }
    }

    public void manageBook(String id, String service){
        if(!isValidated(id)) return;

        if(service.equals("대출")) {
            checkOutBook(id);
        } else if (service.equals("반납")) {
            returnBook(id);
        }
    }

    // 도서 전체 목록
    public void showBookList() {
        System.out.println("\n=== 도서 목록 ===");
        System.out.println("\n📕 일반 도서");
        for (Material material : materials) {
            if (material.id.startsWith("B")) {
                System.out.println(material.getStatus());
            }
        }
            
        System.out.println("\n📘 전자책");
        for (Material material : materials) {
            if (material.id.startsWith("E")) {
                System.out.println(material.getStatus());
            }
        }
    }

    // 도서 대출하기
    public void checkOutBook(String id) {
        Material book = findBookById(id);
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            book.checkOut();
        }
    }

    // 도서 반납하기
    public void returnBook(String id) {
        Material book = findBookById(id);
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            book.returnItem();
        }
    }
    
    // 도서 검색하기
    public void searchBook(String keyword, int type) {
        System.out.println(keyword + " searching...");
    }

    // ID로 도서 찾기
    private Material findBookById(String id) {
        for (Material material : materials) {
            if (material.id.equals(id)) {
                return material;
            }
        }
        return null;
    }

    // 유효성 검사
    private boolean isValidated(String id) {
        if (id.isEmpty()) {
            System.out.println("❓ 도서 ID를 입력해주세요.");
            return false;
        }
    
        if (!id.matches("^[BE]\\d{3}$")) {
            System.out.println("❌ 잘못된 도서 ID 형식입니다.");
            return false;
        }
        return true;
    }

}
