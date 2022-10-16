## 기본 요구사항

`소비내역을 기록/관리` 에 목적을 둔 가계부

1. 인증

   - 이메일 / 비밀번호 두 양식으로 회원가입가능
   - 로그인 / 로그아웃 가능하게함

2. 인가

   - 로그인 하지 않은 익명 사용자 => 401 Unauthorized  응답
   - 로그인 했으나 가계부의 주인이 아닌 경우 => 403 Forbbiden 응답
   - 로그인 했고 자신의 가계부리스트 / 상세내역 조회 => 200응답 

3. 서비스

   - `홍길동@google.com`  계정으로 여러 테마의 가계부 A, B, C, , , 를 생성/조회/수정/삭제 할 수 있음

     - 가계부를 삭제할 때 `한 가지 방식`이 있다 => 개별삭제

   - 가계부 A 를 생성했으면

     - `오늘 사용한 돈의 금액` 과 `메모` 를 등록/조회/수정/삭제.

       - 삭제처리된 내역의 `돈`, `메모`를 수정/삭제 하려는 행위는 막는다.
       - 내역을 삭제할 때 `두 가지 방식`이 있다
         - 개별삭제, 일괄 삭제

     - 삭제된 내역은 언제든 복구가능함.

       - 삭제된 내역들만 조회할 수 있어야함.

       - 개별복구, 일괄복구

         