import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    private static ArrayList<Material> materials = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

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
            System.out.print("메뉴 선택: ");

            // 사용자 선택
            int num = scanner.nextInt();

            switch (num) {
                case 1:
                    showBookList();
                    break;
                case 2:
                    checkOutBook();
                    break;
                case 3:
                    returnBook();
                    break;
                case 0:
                    running = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
            }
        }
    }
    
    private static void showBookList() {
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
    }

    private static void checkOutBook() {
        System.out.println("\n=== 도서 대출 ===");
        System.out.print("대출할 도서 ID를 입력하세요: ");
    }

    private static void returnBook() {
        System.out.println("\n=== 도서 반납 ===");
        System.out.print("반납할 도서 ID를 입력하세요: ");
    }
}
