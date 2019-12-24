# java-chicken-2019-retry
우아한 테크 코스 2차 오프라인 코딩테스트 때 진행한 치킨집 미션을 다시 한 번 진행해보는 저장소

## 주의사항

- 3항 연산자 사용하지 않기
- indent depth 최대 2까지만 허용
- 자바 코드 컨벤션을 지키면서 프로그래밍 하기
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현하기
- else 예약어를 사용하지 않기
- 함수(또는 메서드)의 인자 수를 3개까지만 허용

## 기능 구현 목록

- POS 프로그램 구현
	- 주문등록, 결제하기, 프로그램 종료 기능
- 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가짐
- 테이블 기본 정보가 주어지며 테이블 번호를 가짐
- 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개
- 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시
- 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 다름
	- 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인
	- 현금 결제는 5%가 할인, 할인된 금액에 대해서 한 번 더 할인 가능
- 주문 혹은 결제가 불가능할 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능해야 함
- 최종 결제 금액을 보여주어야 함


1. InputView

	- Menu 입력
	- Table 입력
	- 등록할 메뉴 입력
	- 메뉴의 수량 입력
	
2. OutputView

	- Table 에 착석, 미착석 여부를 판별하여 출력
	- 메인화면을 출력
	
3. Validator

	- Null 일 경우 예외 처리 후 종료
	- 0 보다 큰 수인지 판별하는 기능
	- 최소, 최대 값과 비교 값을 받아 범위안에 속하는지 판별하는 기능
	
4. TableRepository

    - 주문 등록을하고 테이블을 선택할 경우 해당 테이블의 결제할 금액이 남음 여부를 변경
    - 테이블을 sort 해서 반환 해주는 기능
    
5. Pos

    - 프로그램의 전반적인 진행과정을 관리
	