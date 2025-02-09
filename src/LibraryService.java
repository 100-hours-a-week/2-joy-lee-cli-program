import java.util.ArrayList;

public class LibraryService {
    private ArrayList<Material> materials;
    
    public LibraryService() {
        materials = new ArrayList<>();
        init();
    }

    // 샘플 데이터 초기화
    private void init() {
        // 일반 도서 추가
        materials.add(new Book("B001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550));
        materials.add(new Book("B002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        materials.add(new Book("B003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        materials.add(new Book("B004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));
        
        // 전자책 추가
        materials.add(new EBook("E001", "클라우드 전환 그 실제 이야기", "공용준", "에이콘출판", 244));
        materials.add(new EBook("E002", "함께 자라기", "김창준", "인사이트", 228));
        materials.add(new EBook("E003", "손에 잡히는 10분 SQL", "벤 포터", "인사이트", 320));
        materials.add(new EBook("E004", "스프링 입문을 위한 자바 객체 지향의 원리와 이해", "김종민", "위키북스", 396));
    }

    public void showBookList() {
        System.out.println("\n📕 일반 도서");
        for (Material resource : materials) {
            if (resource.id.startsWith("B")) {
                System.out.println(resource.getStatus());
            }
        }
            
        System.out.println("\n📘 전자책");
        for (Material resource : materials) {
            if (resource.id.startsWith("E")) {
                System.out.println(resource.getStatus());
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

    // ID로 도서 찾기
    private Material findBookById(String id) {
        for (Material material : materials) {
            if (material.id.equals(id)) {
                return material;
            }
        }
        return null;
    }
}
