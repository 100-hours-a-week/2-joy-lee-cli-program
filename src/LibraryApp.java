import java.util.ArrayList;
import java.util.Scanner;

public class LibraryApp {
     // 인스턴스 변수 선언
     private Scanner scanner;
     private LibraryService libraryService;

    // 생성자로 인스턴스 변수 초기화
    public LibraryApp() {
        this.scanner = new Scanner(System.in);
        this.libraryService = new LibraryService(); // 비즈니스 로직 클래스
    }
    

    public void run() {
        boolean running = true;
        while (running) {
            displayIntro(); // 인트로 메세지 출력
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
        libraryService.showBookList();
    }

    private void checkOutBook() {
        System.out.println("\n=== 도서 대출 ===");
        System.out.print("대출할 도서 ID를 입력하세요: ");

        scanner.nextLine(); 
        String id = scanner.nextLine();
        libraryService.checkOutBook(id);
    }

    private void returnBook() {
        System.out.println("\n=== 도서 반납 ===");
        System.out.print("반납할 도서 ID를 입력하세요: ");

        scanner.nextLine(); 
        String id = scanner.nextLine();
        libraryService.returnBook(id);
    }
    
    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}
