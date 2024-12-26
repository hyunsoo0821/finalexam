# 1.개요
## 1.1 목적, 주제선정이유(기초 틀) 
![기말고사 설계 (8)](https://github.com/user-attachments/assets/3cce7505-85b2-4666-ab50-8b8e9b1ecbdb)
>**먼저 설문조사 양식을 여러 사이트를 보고 참고하여 만들었습니다**
> >## 그중 구글폼을 참고하여 설문조사코드를 만들어 보았으며 
> > >### 중간고사 계산기코드를 참고하여 만든 설문조사코드도 만들어 보았습니다.
> > > >#### 설문조사 종류를 2가지 한이유는 중간고사 계산기코드랑 연관지어 할 수 있어서 궁금하여 참고하면서 코드를 만들고 싶었고 어떻게 나올지 궁금해서 만들었습니다. 또한 홈페이지 html로 만든다면 이렇게도 만들수 있어서 만들었습니다.(요약: 설문조사 종류를 많이 해보고 싶었습니다)
## 1.2  대상
![스크린샷 2024-12-24 101927](https://github.com/user-attachments/assets/eb968d76-aea5-4e91-94df-67b83ffda4b5)
>**대상: 청주대학교 8명중 남자 5명, 여자3명 입니다**
# 2. 중요성과 필요성 
![KakaoTalk_20241224_143428396](https://github.com/user-attachments/assets/bf8d8e6f-7248-41dd-b0ea-5f5ef6d87427)
>**청주대학교 8명 대상 설문조사 결과**
> >## 설문조사결과 8명중 4명이 주차장관련 자리 문제에 대해 고민이 많았고
> > >### 이에 대해 해결문제로 주차장 자리 현황판을 만들어보았습니다
# 3.1 프로그램 수행 절차 설계 다이어그램 
![기말고사 구동 설계도](https://github.com/user-attachments/assets/6c6c0208-f437-4aec-9cb7-2c98e010c428)
># 첫번째는 기말고사까지 배웠던내용을 가지고 프로그램을 구현 했으며 컬렉션 프레임워크(컬랙션 3개)및 파일 입출력 코드를 사용 했습니다.
> > ## 두번째는 중간고사 계산기 코드를 사용했습니다. Textfild보다 TextArea를 쓴이유는 TextArea가 키보드 입력도 가능하고 버튼 클릭 리스너입력을 받을수있기 때문입니다 Textfield는 버튼리스너를 사용할 수 없어 사용하지 않았습니다.
> > >### 세번째는 설문조사 결과중 제일 많이 선택한 주차자리문제를 주차자리 현황판 코드로 해결문제를 하기위해 만들어 보았습니다.
> > >#### 그이유는 거의 주차자리문제관해 주차 요금이나 주차자리 주차 가능한 공간이 있는지 없는지 확인이 안되어 차를 뺑뺑 돈 기억이 많다는 응답이 많아 해결책으로 주차자리 현황판코드를 짜보았습니다.  
# 3.2 클래스 다이어그램 
># 첫번째가 중간고사 계산기 내용 참고하여 만든 설문조사 클래스 다이어그램이며
> >## 두번째가 기말고사 내용 참고하여 컬랙션프레임워크와 파일입출력을 활용한 설문조사 클래스 다이어그램입니다
![프로그램 클래스다이어그램 (9)](https://github.com/user-attachments/assets/230569ce-2dff-4593-b3e4-b3d80ae6ca15)
># 아래 사진은 설문조사 결과 해결방법으로 주차장자리현황판 코드입니다 
![제목 없는 다이어그램](https://github.com/user-attachments/assets/446f51e3-2d47-4ccc-bc8b-0d7a7e2544ba)
> # 이미지가 안보이신다면 위에 파일을 올려놨으니 프로그램 클래스 다이어그램 이미지 파일을 누르시고 보시면 됩니다.
# 3.3 프로그램 절차
# 기말고사 내용 활용 프로그램코드 컬랙션3개 파일입출력 코드 사용 
![력크컬레셩프레임워크 컬렉션3개 파일입출력 2개 USER_CREDENTIALS_FILE1개 사용](https://github.com/user-attachments/assets/955f18d1-d539-4a00-a945-f4dba218ab60)
>### saveCredentials(String 아이디, String 비번): 로그인 정보를 properties 파일에 저장
>### tryAutoLogin(Scanner): 자동 로그인 시도, 파일에 저장된 로그인 정보를 읽고 사용자가 입력한 아이디와 비밀번호와 비교
>### saveResponse(Map<String, String> responseMap): 설문 응답을 파일에 저장, 각 항목은 Map으로 저장되어 하나의 파일에 추가됩니다
>### summarizeResponse(String response):설문 응답을 요약하여 새로운 파일에 저장합니다, 개별 응답을 요약하는 함수로, 응답이 10단어를 넘으면 첫 10단어를 출력하고 ...을 뒤에 붙이게 했습니다.(첫문장을 요약한문장을 쓰게 했습니다)
> > ## 주요 클래스 및 매서드
> > >### Scanner: 사용자 입력을 받는 데 사용
> > >### BufferedWriter, FileWriter: 파일에 데이터를 작
> > >### Properties: 로그인 정보를 저장하고 불러오는데 사용
> > >### Map<String>: 설문 응답을 저장하는 자료구조
# 중간고사 계산기 활용 설문조사 내용 코드
![스크린샷 2024-12-25 105717](https://github.com/user-attachments/assets/9dee3481-a492-467d-87e8-b80e1c21a19f)
>**본 사진은 프로그램코드를 실행하면 나오는사진입니다**
![KakaoTalk_20241224_153450843](https://github.com/user-attachments/assets/db2be244-bb74-4639-912f-ff4d36ba9507)
>**위의 사진은 설명하기위해 그려놓은 사진입니다 참고만 해주시길 바랍니다**
> > # 보시다시피 먼저 TextArea 에 작성할내용을 입력합니다
> > ## 작성방법이 ButtonclickListener인 6개의 버튼이 있고 TextArea에 키보드로 내용을 작성할수 있습니다.
> > > ### 여기서 버튼을 추가한이유는 2,3번문제는 객관식으로 답을 받기가 적절하여 버튼을 만들었습니다.(객관식으로 받아야 그래프 분석하기가 편함)
> > > > ####  TextArea에 작생한내용을 메뉴Bar로 파일저장하기 하여 택스트 파일로 내보내기가 가능합니다.
# 설문조사 해결방법 주차장 자리 현황판 코드
![스크린샷 2024-12-24 155917](https://github.com/user-attachments/assets/3649a45a-73cb-4e9b-a81e-d3e5526015c9)
![스크린샷 2024-12-24 155847](https://github.com/user-attachments/assets/eb165b07-b826-467a-9050-05eb10c2f875)
> # Total_spacses: 주차장 총 공간수, OccupidSpaces:현재 주차된 자리수, AvailableSpaces:비어있는 주차 공간 수
> > ## simulateParking(): 주차 공간의 상태를 시뮬레이션.
> > > ## Random random = new Random();을 사용하여 랜덤 객체를 생성.
> > > > ## Map<Integer, String> parkingSpaces = new HashMap<>();을 사용하여 각 주차 공간의 상태를 저장하는 Map 객체를 생성
> > > >  ## for (int i = 1; i <= TOTAL_SPACES; i++) { ... } 루프를 사용하여 각 주차 공간을 순회하며 상태를 설정합니다. i <= occupiedSpaces일 경우 "Occupied":현재 주차된 자리수로 설정,그 외는 "Available":비어있는 주차된 상태로 설정.
# 4.1 결론 느낀점
> **자바언어로 파일 내보내기 형식중 택스트 파일, csv파일만 가능하여 프로그램을 짤때 한계점이 많았습니다**
> > **하지만 지금까지 자바언어로 배운 기능을 잘 활용한다면 개발이 어렵지만 않게 느껴집니다.**
> > **물론 아직 언어밖에 안배웠지만 계속 프로그램을 짜보고 프로그래밍에 대해 공부하여 기능과 생산형AI에 의존할게 아니라 먼저 프로그램을 짜기 위한 설계를 구상하고 어떤 클래스를 사용할지 구상이 먼저라는걸 깨달았습니다**
> >  > **설계가 잘되어 있지 않으면 목적성을 잃고 방향성을 잃어 시간도 오래걸릴뿐더러 완성도 떨어지기 때문입니다**
> >  > **앞으로도 자바 패키지를 찾아보며 실험하며 여러가지기능을을 깔아보고 프로그램을 개발해보도록 하겠습니다**
> >  >  >**한학기 가르쳐주신 교수님 노고에 감사합니다**
