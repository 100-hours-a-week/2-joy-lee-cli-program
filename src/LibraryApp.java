import java.util.InputMismatchException;
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
            } catch (InputMismatchException e) {
                System.out.println("0~3까지의 숫자만 입력해주세요");
                scanner.nextLine(); // 잘못된 입력 비우기
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
        printHeader("도서 대출 📤");
        System.out.print("대출할 도서 ID를 입력하세요: ");
        
        scanner.nextLine(); 
        String id = scanner.nextLine();
        
        if (validateBook(id)) libraryService.checkOutBook(id); // ID 유효성 검사
    }

    private void returnBook() {
        printHeader("도서 반납 📥");
        System.out.print("반납할 도서 ID를 입력하세요: ");

        scanner.nextLine(); 
        String id = scanner.nextLine();

        if (validateBook(id)) libraryService.returnBook(id); // ID 유효성 검사
    }

    private void printHeader(String title) {
        System.out.println("\n┌──────────────────────────────────────┐");
        System.out.println("│             " + title + "             │");
        System.out.println("""
            ├──────────────────────────────────────┤
            │  도서 ID 형식: 코드 + 숫자 3자리     │
            │  ✔️ 코드 : 종이책(B) / 전자책(E)      │
            └──────────────────────────────────────┘""");
    }

    private boolean validateBook(String id) {
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

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}
