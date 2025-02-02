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
