# CLI Program으로 만드는 카부캠 도서관리 봇

카부캠 도서관리 봇은 콘솔 환경에서 동작하는 도서관 대출/반납 시스템이다. 도서관의 기본 업무인 도서 대출과 반납 처리를 메인 클래스에 기본 메소드로 만들었다. 그 외에도 상속을 사용해서 Book, Ebook을 따로 관리하도록 설계했다.

## 세부 구현사항

### 1. 클래스 설계도(다이어그램) 작성하기

<div align="center">
<img src="https://github.com/user-attachments/assets/89a0be98-ab03-4c2a-92df-d4582534d712" alt="" width=150 style="text-align: center"/>
</div>

- **`Material`** class : 모든 도서 자원에 필요한 최상위 클래스이다. 기본적인 정보(ID, 제목, 대출 가능 여부, 대출 기간)를 관리하며 대출과 반납이라는 핵심 기능을 메소드로 가진다.
- **`Book`** class : `Material`를 상속받는 “종이책”에 관한 클래스이다. 저자, 출판사, 페이지 수 등 도서 고유의 정보를 추가로 관리하며 도서 정보 조회와 대출 연장 기능을 제공한다.
- **`EBook`** class :`Book` 클래스를 상속받는 “전자책”에 관한 클래스이다. ebook 다운로드 링크를 추가로 관리하여 전자책만의 특성을 가진다.

<br/>

### 2. 설계도 기반 콘솔 프로그램 제작

<img src="https://github.com/user-attachments/assets/81349dc8-b3af-4889-a984-d90087040efc" alt="" width=300 style="text-align: center"/>

<br/>

<img src="https://github.com/user-attachments/assets/4411f796-143c-4009-87d3-f2bb49e35075" alt="" width=500 style="text-align: center"/>

<br/>

<img src="https://github.com/user-attachments/assets/20540d61-0e34-49d6-9490-1e4b2ab01934" alt="" width=380 style="text-align: center"/>

<br/>

<img src="https://github.com/user-attachments/assets/6854f98c-d43b-4337-909e-06620cda77ba" alt="" width=380 style="text-align: center"/>

<br/>

<img src="https://github.com/user-attachments/assets/264569b5-92de-4de4-ab61-ce290558f4a3" alt="" width=300 style="text-align: center"/>

(대출 여부에 따라 도서 목록 상태 `대출중` 또는 `대출가능` 으로 업데이트)

<br/>

## 회고 및 리팩토링

### 어려웠던 부분

자바를 처음 배워봐서 개념과 문법을 이해하고 과제를 시작하는데까지 오래걸렸다.

처음엔 도서관회원 - 빌린 책 목록 - 전체 책.. 이런 구조로 아이디어를 구상했는데 아키텍쳐가 좀 복잡해 지는 느낌이 들어서

상속구조가 명확히 보이는 Material ← Book ← Ebook 구조로 수정해서 진행했다.

초반에 입력 버퍼? 를 지우는 라인을 추가하지 않아서 콘솔 실행에 애를 먹었다.

```java
System.out.print("대출할 도서 ID를 입력하세요: ");
scanner.nextLine(); // 이전 입력 버퍼 비우기
```

<br/>

### 리팩토링을 한다면?

- 샘플데이터.. 리팩토링 해보기

책 하나에 종이책, 전자책이 모두 있는 경우엔 같은 책을 각각 다른 객체로 만들어야 할까?

같은 파라미터로 2가지 객체를 동시에 만들 수 있는 방법이 있는지 고민해봐야겠다.

자바스크립트에선 JSON 형태로 데이터를 만들고 `map` 을 써서 많은 객체를 쉽게 만들수 있었다.

지금은 아래처럼 하드코딩으로 모든 줄을 작성했는데 자바에도 비슷한 문법이 있는지 알아봐야겠다.

```java
materials.add(new Book("B001", "리팩터링 2판 (개정판)", "마틴 파울러", "한빛미디어", 550 ));
materials.add(new Book("B002", "클린 코드 Clean Code", "로버트 C. 마틴", "인사이트", 584));
materials.add(new Book("B003", "우아한 타입스크립트 with 리액트", "우아한형제들", "한빛미디어", 380));
materials.add(new Book("B004", "HTTP 완벽 가이드", "데이빗 고울리,브라이언 토티", "인사이트", 380));

materials.add(new EBook("E001", "클라우드 전환 그 실제 이야기", "공용준", "에이콘출판", 244 ));
materials.add(new EBook("E002", "함께 자라기", "김창준", "인사이트", 228));
materials.add(new EBook("E003", "손에 잡히는 10분 SQL", "벤 포터", "인사이트", 320));
materials.add(new EBook("E004", "스프링 입문을 위한 자바 객체 지향의 원리와 이해", "김종민", "위키북스", 396));
```

<br/>

- 코드 반복 줄이기

`checkOutBook()` 과 `returnBook()` 메서드의 구조가 거의 동일한데 파라미터를 전달해서 재사용 할 수있는 메소드를 만들어 봐야겠다.

```java
private static void checkOutBook() {
  System.out.println("\n=== 도서 대출 ===");
  System.out.print("대출할 도서 ID를 입력하세요: ");

  scanner.nextLine(); // 이전 입력 버퍼 비우기
  String id = scanner.nextLine();

  // 입력된 ID로 도서 찾기
  Material book = null;
  for (Material material : materials) {
     // ...
  }

  // 도서 대출 처리
  if (book == null) {
      System.out.println("해당 도서를 찾을 수 없습니다.");
  } else {
      // ...
  }
}

```

```java
private static void returnBook() {
    System.out.println("\n=== 도서 반납 ===");
    System.out.print("반납할 도서 ID를 입력하세요: ");

    scanner.nextLine(); // 이전 입력 버퍼 비우기
    String id = scanner.nextLine();

    // 입력된 ID로 도서 찾기
    Material book = null;
    for (Material material : materials) {
        // ...
    }

    // 도서 반납 처리
    if (book == null) {
        System.out.println("해당 도서를 찾을 수 없습니다.");
    } else {
       // ...
    }
}
```

### 추가로 구현 할 것

- [ ] Book, EBook 클래스의 메소드 구현하기 (책정보확인, 대출기간연장, ebook URL 확인)
- [ ] 대출할 때 반납일(dueDate) 언제인지 함께 출력해보기 (반납일 = 오늘날짜 + 14일)
- [ ] 책 제목 검색해서 대출 가능한지 알아보는 기능
- [ ] 예외 처리
