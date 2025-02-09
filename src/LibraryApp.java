import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
    // 인스턴스 변수 선언
    private ArrayList<Material> materials;
    private Scanner scanner;

   // 생성자로 인스턴스 변수 초기화
   public LibraryApp() {
       this.materials = new ArrayList<>();
       this.scanner = new Scanner(System.in);
   }

    public void run() {
        // sample data
        materials.add(new Book("B001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
        materials.add(new Book("B002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
        materials.add(new Book("B003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
        materials.add(new Book("B004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));
        
        materials.add(new EBook("E001", "클라우드 전환 그 실제 이야기", "공용준", "에이콘출판", 244 ));
        materials.add(new EBook("E002", "함께 자라기", "김창준", "인사이트", 228));
        materials.add(new EBook("E003", "손에 잡히는 10분 SQL", "벤 포터", "인사이트", 320));
        materials.add(new EBook("E004", "스프링 입문을 위한 자바 객체 지향의 원리와 이해", "김종민", "위키북스", 396));

        boolean running = true;
        while (running) {
            displayIntro(); // 인트로 메세지
            try{
                switch (scanner.nextInt()) {
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
            } catch (Exception e) {
                System.out.println("오류가 발생했습니다: " + e.getMessage());
            }
        }
    }
    
    private void displayIntro() {
        System.out.println("""
            \n┌──────────────────────────────┐
            │    카부캠 도서관리 봇 🤖     │
            │    무엇을 도와드릴까요?      │
            ├──────────────────────────────┤
            │  1. 전체 도서 보기           │
            │  2. 도서 대출하기            │
            │  3. 도서 반납하기            │
            │  0. 종료                     │
            └──────────────────────────────┘""");
        System.out.print("번호 선택: ");
    }

    private void showBookList() {
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

    private void checkOutBook() {
        System.out.println("\n=== 도서 대출 ===");
        System.out.print("대출할 도서 ID를 입력하세요: ");

        scanner.nextLine(); // 이전 입력 버퍼 비우기
        String id = scanner.nextLine();

        // 입력된 ID로 도서 찾기
        Material book = null;
        for (Material material : materials) {
            if (material.id.equals(id)) {
                book = material;
                break;
            }
        }

        // 도서 대출 처리
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            book.checkOut();
        }
    }

    private void returnBook() {
        System.out.println("\n=== 도서 반납 ===");
        System.out.print("반납할 도서 ID를 입력하세요: ");
        
        scanner.nextLine(); // 이전 입력 버퍼 비우기
        String id = scanner.nextLine();

        // 입력된 ID로 도서 찾기
        Material book = null;
        for (Material material : materials) {
            if (material.id.equals(id)) {
                book = material;
                break;
            }
        }

        // 도서 반납 처리
        if (book == null) {
            System.out.println("해당 도서를 찾을 수 없습니다.");
        } else {
            book.returnItem();
        }
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}
