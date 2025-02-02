import java.util.ArrayList;

public class LibraryApp {
    private static ArrayList<Material> materials = new ArrayList<>();

    public static void main(String[] args) {
        // sample data
        materials.add(new Book("B001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
        materials.add(new Book("B002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        materials.add(new Book("B003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        materials.add(new Book("B004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));
        
        materials.add(new EBook("E001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
        materials.add(new EBook("E002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        materials.add(new EBook("E003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        materials.add(new EBook("E004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));

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
             
            running = false;
        }
    }
}
