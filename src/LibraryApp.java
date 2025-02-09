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
                int num = scanner.nextInt();
                scanner.nextLine();

                switch (num) {
                    case 1 -> libraryService.showBookList();
                    case 2 -> admin("대출");
                    case 3 -> admin("반납");
                    case 4 -> search();
                    case 0 -> {
                        running = false;
                        System.out.println("도서관리 봇을 종료합니다.");
                    }
                    default ->  System.out.println("잘못된 선택입니다. 다시 선택해주세요.");
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
            │    카부캠 도서관리 봇 📚     │
            │    무엇을 도와드릴까요?      │
            ├──────────────────────────────┤
            │  1. 전체 도서 보기           │
            │  2. 도서 대출하기            │
            │  3. 도서 반납하기            │
            │  4. 도서 검색하기            │
            │  0. 종료                     │
            └──────────────────────────────┘""");
        System.out.print("번호 선택: ");
    }

    private void displayHeader(String title) {
        System.out.println("\n┌──────────────────────────────────────┐");
        System.out.println("│              도서 " + title + "               │");
        System.out.println("""
            ├──────────────────────────────────────┤
            │  도서 ID 형식: 코드 + 숫자 3자리     │
            │  ✔️ 코드 : 종이책(B) / 전자책(E)      │
            └──────────────────────────────────────┘""");
    }

    private void admin(String service) {
        displayHeader(service);
        System.out.print(service + "할 도서 ID를 입력하세요: ");
        String id = scanner.nextLine();
        libraryService.manageBook(id, service);
    }

    private void search(){
        System.out.println("""
            \n┌──────────────────────────────┐
            │         도서 검색 🔍         │
            ├──────────────────────────────┤
            │  1. 제목으로 검색            │
            │  2. 저자로 검색              │
            │  3. 출판사로 검색            │
            └──────────────────────────────┘""");
        System.out.print("검색 유형 선택: ");

        try {
            int type = scanner.nextInt();
            scanner.nextLine();

            System.out.print("\n검색어를 입력하세요: ");
            String keyword = scanner.nextLine();
            libraryService.searchBook(keyword, type);
        } catch (Exception e) {
            System.out.println("잘못된 입력입니다. 다시 시도해 주세요.");
        }
    }

    public static void main(String[] args) {
        LibraryApp app = new LibraryApp();
        app.run();
    }
}
