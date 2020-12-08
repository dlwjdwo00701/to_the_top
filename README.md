
# [과탑을 향해서] TO_THE_TOP PROJECT
<center><img src="https://user-images.githubusercontent.com/47067905/101271773-44f82780-37c9-11eb-960e-e394c4e160e4.png" width="300" height="300"></center>
-과탑을 향해서 아이콘

 -----------------------------------------------------------

# 목차
 1. [프로젝트 소개](#1.-프로젝트-소개) 
 
       1.1 [프로젝트 소개 및필요성](#프로젝트-소개와-필요성)       
       1.2 [프로그램의 차별성](#프로그램의-차별성)      
       1.3 [프로젝트 라이브러리 및 구현과 디버그](#프로젝트-라이브러리-및-구현과-디버그)       
       1.4 [내부 코드 설명](#내부-코드-설명)       
       1.5 [UI 프로그램 구성 파일](#UI-프로그램-구성-파일)
       
2. [설치 및 사용 메뉴열](#설치_및_사용_메뉴열)
       2.1 [개발자의 경우(설치)](#개발자의-경우설치) 
       2.2 [일반 사용자의 경우(설치)](#일반-사용자의-경우설치)     
       2.3 [과탑을 향해서(캘린더) 사용 방법](#과탑을-향해서캘린더-사용-방법)       
              2.3.1 [로그인창](#로그인창)                          
              2.3.2 [로딩창](#로딩창)              
              2.3.3 [캘린더창](#캘린더창)
              
3.[프로젝트 제작에 참고된 참고문헌, 서적, URL](#3.프로젝트_제작에_참고된_참고문헌_서적_URL)

4.[프로젝트 개발자 정보](#프로젝트_개발자_정보)

------------------------------------------
 
# 1. 프로젝트 소개
  

## 1.1 프로젝트 소개 및 필요성

기존에 대면 수업으로 진행할 때에는 잘 쓰이지 않았던 스마트캠퍼스가 코로나로 인해 비대면 수업으로 전환되면서 교수님과 학우분들 사이에 연결고리가 필요해졌고, 이를 연결해주는 매개체는 스마트캠퍼스가 되었습니다. 대부분의 강의 및 과제가 스마트캠퍼스를 통해 업로드되었고, 이전 학기들에 비해 스마트캠퍼스의 중요도가 매우 높아졌습니다. 하지만 시스템 사용에 익숙하지 않은 학우분들은 많은 불편함을 겪었습니다. 강의 및 과제의 마감 기한일이나 출석 여부를 확인하기 위해서는 각 강의를 직접 접속하여 확인하여야 했고, 시스템의 오류 및 교수님께서 마감 기한에 임박하여 강의를 올리신 경우에는 억울하게 강의를 듣지 못 하는 경우도 빈번했습니다. 위와 같은 상황에 대처하기 위해서 학생들 개인의 학교 일정을 더 편안하게 관리하고, 강의 및 과제를 놓치지 않을 수 있도록 하는 캘린더의 필요성을 느껴 프로젝트를 진행하게 되었습니다. 

**과탑을 향해서** 는 스마트캠퍼스에서 사용자의 수강 과목 정보를 가져와 각 과목의 강의,  과제를 관리할 수 있도록 해주는 숭실대학교 학생을 위한 캘린더 프로그램입니다. "과탑을 향해서" 캘린더와 함께 공부하며 과탑을 노려보세요!

-과탑을 향해서 깃허브 주소 : https://github.com/dlwjdwo00701/to_the_top

 ------------------------------------------

## 1.2 프로그램의 차별성
  아래의 사진은 스마트캠퍼스 자체의 일정 기능을 캡쳐한 것입니다. 같은 강의가 그 강의의 마감일까지 계속 반복되어 표시되어 있음을 볼 수 있습니다. 이로 인해 가시성이 많이 부족하고, 강의 및 과제의 수강, 제출완료 여부를 알 수가 없습니다. 또한, 사용자를 위한 각종 편의 기능이 존재하지 않아 사용하는 데에 불편함이 많습니다. 

 또한 기존에 존재하는 보통의 캘린더 앱의 경우 편의기능이 있지만, 숭실대학교 학생이 스마트캠퍼스 일정을 추가할 경우 일일이 일정들을 모두 직접 추가하여야 해서 많은 번거로움이 있습니다.
 
![image](https://user-images.githubusercontent.com/71241552/101158844-c76cd400-366f-11eb-9610-ed2de6a23a0d.png)  

-스마트캠퍼스 자체의 일정표

------------------------------------------

## 1.3 프로젝트 라이브러리 및 구현과 디버그
  저희의 프로젝트는 JAVA언어를 이용해서 개발했으며, Eclipse IDE를 이용해 개발을 진행했습니다. 스마트캠퍼스에 사용자의 아이디와 비밀번호의 정보를 세션을 통해 보내 쿠키값을 유지해야 했습니다. 이에 찾아본 결과 JSOUP이라는 라이브러리가 있었고, 이를 이용했습니다. 또한 JAVA를 이용해 UI를 구현하고자 찾아본 결과, JAVAFX 라이브러리가 있었으며, 사용하게 되었습니다. 처음 사용해보는 라이브러리들이기에 많은 어려움이 있었으나, 열심히 노력해 마무리할 수 있었습니다. 또 스마트캠퍼스의 경우에는 많은 사용자, 많은 교수님들이 사용하시기에 정말 많은 변수들이 있었습니다. 과목 설정이 다른 경우, 정규 과목이 아니라 동아리가 있는 경우. 영어 과목의 경우, 과제 기한이 없는 경우, 과제가 다른 곳에 공지되어 있는 경우... 등등 많은 변수들이 있었습니다. 프로젝트를 진행하면서 열심히 노력해 최대한 많은 상황들을 다루고자 했습니다.

> -스마트캠퍼스/유세인트 서버 크롤링(JSoup)
[https://github.com/dlwjdwo00701/to_the_top/tree/master]

 * Jsoup 라이브러리를 이용하여 비동기 통신과 쿠키 방식을 활용한, 페이지 이동 구현
 * 스마트 캠퍼스 첫 페이지의 '강의 명'과 ,  '강의 링크' , '강의 수' 크롤링
 * 온라인/오프라인 강의 방식의 차이에 따른 스마트 캠퍼스 구조가 다름 확인
 * 온/오프 방식을 바탕으로 '주차 별 학습 활동'에 올려진 강의들을 1~15주 에 맞게 크롤링
       (0번 인덱스는 따로 구현)
 * '강의 개요'에 올리는 강의/과제들을 고려하여 0번 인덱스에 크롤링
 * '학습 진도 현황(오프라인)' , "온라인 출석부(온라인)"에서 강의 출석 여부 크롤링
 *  '과제' 체크란에서 과제 제출 여부 크롤링
 *  현재 시간을 알려주는 객체 생성
 * 현재 시간 대비 현재 주차에 미출석/미제출 된 강의만 담는 객체 생성
 * 유세인트 학사일정 크롤링
 * 학사일정을 스마트캠퍼스 형식으로 전환하는 객체 생성.
 * 현재 주차를 알려주는 객체 제작.
 * 강의/과제 기한 하루 전에 알려주는 객체 제작. 
 * (디버그 과정 중 수정된 내용들)
 * 15주차 강의 인덱스에서 무한루프 발생을 디버그
 * Kmooc 국제학술동아리와 같은 비교과 과목을 제외하도록 크롤링 코드 수정
 * 기한이 없는 과제의 경우 디버그
 

> -캘린더 UI,CSS개발작업(JavaFx+JSoup)
[https://github.com/dlwjdwo00701/to_the_top/tree/ui_]

  * 이번 프로젝트에 맞는 캘린더 UI 기본 틀 제작. 
  * 로그인, 로딩, 캘린더의 FXML과 CONTROLLER 제작 
  * CONTROLLER.JAVA파일에 크롤링 코드를 연결 시작 
  * 캘린더 버튼 꼬임과 자동로그인 대한 디버깅 완료 
  * (긴급)자동 로그인에 대한 방안설정 -> 보안상 취약할 수 있으므로, 이용자에게 확 인 후 비밀번호를 해시화하여 로그인 기능 구현 
  * 월별 29, 30, 31이 다르면 시작 요일이 다른 것에 대한 문제를 디버깅 
  * CSS파일 작성으로 UI 디자인 최종 마무리 
  * 캘린더에 표시할 방법 논의 -> 강의인덱스(1~마지막 번호)를 보여준 후 강의 마감일 (결석,지각)에 인덱스를 표기하는 방식 
  * 캘린더에 현재주차까지 듣지않은 강의/과제를 확인해주는 각 CONTROLLER와 FXML 구현 
  * 각 버튼과 배열들을 연결해 리스트에 출력해주었음 
  * 학사일정과 개인일정을 표시해주는 기능 구현 
  * 학교 공지사항 사이트를 웹뷰로 연결해 사용자가 확인할 수 있게 하는 기능 구현 
  * 각 일정들에 대해 삭제 및 추가해줄 수 있는 기능 구현 
  * 만약 다음날 강의와 과제가 있을 시 하루전에 자동적으로 알려주는 기능 구현 
  * 사용자가 원할 시 비밀번호를 확인하고 프로그램을 완전히 삭제해주는 기능 구현 
  * javafx,jsoup를 JAR로 EXPORT후 LAUNCH4J를 이용해 .exe파일 추출
 
------------------------------------------

## 1.4 내부 코드 설명

### 학생의 스마트캠퍼스 관련된 각종 정보들을 크롤링해온 멤버 변수들

  <img width="712" alt="SmartCampusMain 클래스 변수들" src="https://user-images.githubusercontent.com/70988272/101139015-46541380-3654-11eb-8afc-6c2f0b246322.PNG">
 

입력받은 사용자의 비밀번호와 아이디를 통해 스마트캠퍼스 서버에 세션을 보내 로그인상태를 유지해주는 로그인 확인 쿠키
>  -cookies

 첫 화면에서 강의 명/강의 링크를 담는 배열
 
> -subject_title [강의 개수의 index] , subject_link [강의 링크의 index]

과목 index에 해당하는 강좌로 이동해서, 주차별로 포함된 강의/과제/파일들을 모두 담는 배열

> -array_subject_link [해당 과목 index][해당 주차(0+1-15)][강의/과제/파일]

특정 강좌의 주차별(1-15) 강의 이름, 기간, 길이, 지각 정보 등을 담는 배열

> -subject_videoName / videoPeriod / videoLength / videoLate [해당 과목 index][주차 0+1~15][강의 Data(강의 이름,기한,길이.지각기한)]

해당 강의/과제를 들었는지 체크하기 위해 '온라인 출석부' , '학습진도현황'과 같은 이동할 링크를 담는 배열

> -check_video_link / check_assignment_link [] 

강의/과제를 수강/제출 했는지 o,x(강의) , 제출/미제출(과제) 등을 담아두는 배열

>-check_video [해당 강의 index] [주차 (1-15)] [DATA]
-check_assignment [해당 강의 index] [과제 제출 여부 DATA]

특정 강좌의 과제를 담는 배열

> -temp_subject_assignmentName/ temp_subject_assignmentPeriond [해당 강좌 index] [과제DATA]

교과 과목인지 비교과 과목인지 판단하는 필드들 (임시로 비교과까지 모두 담아둬서 가공하는 방식)

> -subject_title_temp / subject_link_temp / check_sub_label_array

------------------------------------------
### 과제, 영상 제출 및 수강 여부를 체크해주는 멤버 변수들
  <img width="678" alt="SmartCampusTokenizer" src="https://user-images.githubusercontent.com/70988272/101142411-e875fa80-3658-11eb-9a1e-d91eba468f0e.PNG">
  
  현재 시간을 알려주는 String 객체

> -current_time



이번주차에 시청하지 않은(X) 강의를 가공한 배열 (강의 과목명 / 이름 / 기간 / 지각 기간 / 길이)

>-if_notattendent_week_videoSubject / videoName / videoDate / videoLate / videoLength



이번주차에 제출하지 않은(X) 과제를 가공한 배열 (과제 과목명 / 과제 이름 / 과제 기한)

> -if_notPassed_AssignedSubject / AssignedName / AssignedDate
------------------------------------------

### 학교 학사일정 관련 멤버 변수들

  <img width="675" alt="SSU 학사일정" src="https://user-images.githubusercontent.com/70988272/101139731-4c96bf80-3655-11eb-9c7e-fcf31220f9b2.PNG">
  
  학사 일정을 담은 배열

>   -usaint_date [학사 일정 Data]
  -usaint_schedule[해당 학사 일정에 대한 제목 Data]



학사일정을 스마트 캠퍼스 일정 형식으로 전환 (2020.00.00 00:00:00)

> -usaint_date_token [0 (시작 날짜) / 1(끝 날짜)] [스케쥴 Data]
 
 
  ------------------------------------------
  
  ### 멤버 함수들(주요 함수들만 설명합니다.)
  
  <img width="635" alt="exe" src="https://user-images.githubusercontent.com/70988272/101144395-9aaec180-365b-11eb-8c3f-714d8bd6a82d.PNG">
  
* is_login(); | 로그인 함수

* access_lecture_index(); | 강의 인덱스를 계산하는 함수

* execution_crawling(); | 강의 안의 과제/강의들을 함꺼번에 크롤링하는 함수

* video_assignment_divide(); | 강의와 과제를 분리하는 함수

* current_time(); | 현재시간을 알려주는 함수

* check_video_count(); | 강의를 들었는지 (o/x) 체크하는 함수

* check_assign_count(); | 과제를 했는지 (제출/미제출) 체크하는 함수

-----------------------------------------

## UI 프로그램 구성 파일


![image](https://user-images.githubusercontent.com/50694545/101280416-3b43e380-380c-11eb-8a79-67da0743142d.png)

* Main.java –프로그램 메인문 시작 함수
* app.png –프로그램 아이콘 파일
* font.ttf –프로그램 폰트(경기천년제목 BOLD체 사용)
*  AddController.java –추가 기능 관련 이벤트 처리, Add.fxml –추가 창 ui 구현
* CalendarController.java –캘린더 이벤트 처리, Calendar.fxml –캘린더 창 ui 구현
* DeleteController.java –삭제 기능 이벤트 처리, Delete.fxml –삭제 창 ui 구현
* Explain_V_Controller.java – 상세정보 표시 이벤트 처리, Explain_V.fxml –상세정보 창 ui 구현
* HelpController.java –도움말 기능 이벤트 처리, Help.fxml –도움말 창 ui 구현
* LodingController.java –로딩창 이벤트 처리, Loding.fxml –로딩창 ui 구현
* LoginController.java –로그인창 이벤트 처리, Login.fxml –로그인 창 ui 구현
* NoticeController.java –공지사항 기능 이벤트 처리, Notice.fxml –공지사항 창 ui 구현
* WarnController.java –하루전 알림 기능 이벤트 처리, Warn.fxml –하루전 알림 창 ui 구현
 -----------------------------------------------------------

 # 2. 설치 및 사용 메뉴얼

 ## 2.1 개발자의 경우(설치)
  개발자의 경우 해당 프로젝트에 코드를 확인하고 수정하고자 하면 깃허브 주소에 들어가 모든 파일들을 다운 받으신 뒤 https://jsoup.org/ 에 접속해 JSOUP JAR를 다운받아 주세요. 

![image](https://user-images.githubusercontent.com/50694545/101280446-68909180-380c-11eb-944f-b11d97bcc29a.png)

  또한 사진처럼 JAVA ECLIPSE에서 HELP->ECLIPSE MARKETPLACE에서 JAVAFX를 검색하신 뒤 E(FX)CLIPSE를 설치해주세요. 깃허브 to_the_top 프로젝트에 다운 받으신 JSOUP과 JAVAFX 라이브러리를 사용자 라이브러리로 추가해주세요. 꼭 MODULE 적용이 안된 JAVA 편집기를 이용해주세요. MODULE 적용시 JAR로의 EXPORT가 되지 않습니다.
  
  -----------------------------------------------------------
 

 ## 2.2 일반 사용자의 경우(설치)

 깃허브 주소에서 과탑을향해서.jar와 과탑을향해서.exe를 다운받아 주세요. 만약 jar를 이용해 실행하고자 하시면 cmd 창을 여시고 아래의 사진과 같이
*java –jar [과탑을향해서.jar의 저장 위치]를 입력해주시면 실행이 됩니다.

![image](https://user-images.githubusercontent.com/50694545/101280464-8b22aa80-380c-11eb-92c9-d7e4db8c1c3c.png)

사용자 편의를 위해서 .exe 파일로 만들어진 실행 파일도 함께 첨부되어 있습니다. java가 컴퓨터에 설치가 되있다면, java가 있어야 하는 실행파일을 만약 그 실행파일이 실행 안될 경우 사용자 컴퓨터에 설치되어 있는 jre의 버전이 1.8.0이 아니거나 미설치일 가능성이 큽니다. 아래의 주소의 드라이브에 업로드 된 jre와 java가 안깔려 있을 시에 대한 exe 실행파일을 다운받아 주세요.

https://drive.google.com/file/d/1xxtbU_io5EkR-4CW_acheJ_9jC6x5HcJ/view?usp=sharing 

다운 받으신 jre 압축파일을 압축을 과탑을향해서.exe와 같은 위치에 풀어주신 뒤 과탑을향해서.exe를 실행하면 프로그램이 실행됩니다.

 ------------------------------------------ 
 ## 2.3 과탑을 향해서(캘린더) 사용 방법

### 2.3.1 로그인창

![image](https://user-images.githubusercontent.com/50694545/101280485-ba391c00-380c-11eb-8145-c8739c0f2f60.png)

-첫 실행(로그인 창의 캡쳐)

* 아이디와 비밀번호를 입력할 수 있으며, 비밀번호에는 가림막이 설정되어있습니다. 
* 프로그램 실행시 C드라이브에 SmartCampas파일과 로그인 성공시 사용자의 아이디 즉 학번으로 된 파일이 생깁니다.
* 꼭 한 컴퓨터에서 한 사용자만 사용해야 하는 것이 아니라 다른 사용자도 같은 컴퓨터에서 해당 프로그램을 이용할 수 있습니다. 
* 로그인 UI에 비밀번호를 저장하는 것을 확인하는 체크박스가 있습니다. 해당 체크박스를 체크할 경우 암호화를 해주고 C드라이브의 SmartCampas파일 안에 PASSW파일에 사용자의 비밀번호를 암호화해 저장해줍니다.

![image](https://user-images.githubusercontent.com/50694545/101280493-ca50fb80-380c-11eb-9bed-aa958e6afef0.png)

-암호화되어 저장되어있는 비밀번호(프로그램을 통해서만 복호화가 가능하다.)

* 첫 번째 접속의 경우 사용자의 아이디와 비밀번호를 스마트캠퍼스 서버에 보내서 옳게 입력되었는지를 확인해줍니다. 틀릴 시에는 다시 한번 입력해달라는 안내사항을 레이블을 이용해 안내합니다.
* 두 번째 접속의 경우 아래 스크롤바가 생겨 비밀번호가 저장되어있는 사용자의 학번을 띄워 고를 수 있게 해 아이디와 비밀번호를 치지 않아도 자동 로그인이 가능합니다. 
* 물음표 버튼을 누르면 이 프로젝트에 설명이 적힌 깃허브 주소로 연결됩니다.
* 지우기 버튼을 누르면 적었던 아이디와 비밀번호를 지워줍니다. 비밀번호가 틀리면 지워줍니다.

 ------------------------------------------
 ### 2.3.2 로딩창

![image](https://user-images.githubusercontent.com/50694545/101280504-da68db00-380c-11eb-8135-0a0242114435.png)

 -로딩창 캡쳐(사용자의 아이디와 비밀번호를 세션을 통해 보내 크롤링해오고 확인하는 것)

* 최초 접속 시에는 갱신 버튼을 누르면 입력받은 사용자의 아이디와 비밀번호를 스마트캠퍼스 서버에 세션으로 보내 로그인 유지 쿠키 값을 받아옵니다. 또 받아온 쿠키 값을 이용해 스마트캠퍼스의 HTML을 크롤링해 가져옵니다. 가져온 HTML을 가공해줍니다. 가공해 C드라이브SmartCampas/사용자 학번/배열.TXT의 형태로 저장해줍니다. 이 과정에서 10초 정도의 시간이 걸립니다. 

![image](https://user-images.githubusercontent.com/50694545/101280520-f3718c00-380c-11eb-9330-a1289e3591eb.png)

-크롤링해온 HTML을 가공해 저장한 모습

* 최초 접속 이후로 로그인을 하면 크롤링해오는 데이터를 갱신 하는 것이 아니라 기존의 데이터들을 읽고, 가져와 10초에서 1초로 로딩 시간을 단축해주었습니다.
* 크롤링과 가공과정이 완료된다면 학생이 수강하는 과목들을 맞는지 확인하고자 레이블에 표시해줍니다.
* 학생의 정보들이 맞으면 확인 버튼을 누르고, 확인 버튼을 누를 경우 다음 캘린더 화면으로 넘어가게 됩니다.

![image](https://user-images.githubusercontent.com/50694545/101280524-fec4b780-380c-11eb-95d6-224d521fd453.png)

-로딩창에서 확인을 눌렀을 때의 캡쳐

* 만약 사용자가 프로그램을 실행한 시점에서 다음날이 마감인 사용자의 강의와 과제가 있다면 사용자에게 이를 알려 확인하게 해줍니다.

------------------------------------------
 ### 2.3.3 캘린더 창

![image](https://user-images.githubusercontent.com/50694545/101280537-0d12d380-380d-11eb-9f36-dd0b8d25f7bb.png)

-로딩창에서 확인을 누르고 넘어온 캘린더 창의 캡쳐

* 오른쪽의 리스트에 표시된 과목들이 사용자가 요번 학기에 스마트캠퍼스를 통해 수강하는 과목들입니다. 과목 앞에 번호들을 매핑해두었는데 이 번호의 과목에 강의나 과제의 마감 기한이 해당 날짜와 같다면 해당 날짜 위에 매핑된 과목의 숫자들이 표시됩니다.
* 예를 들어 6번은 윈도우프로그래밍실습 매핑되어 있는데 12월 1일에 6이 표시되어 있는 것으로 보아 12월 1일에 윈도우프로그래밍 실습의 강의나 과제가 마감기한인 것을 알 수 있습니다. 또 각 날짜의 경우 버튼으로 되어있어 이벤트를 처리해줍니다.
* #의 경우 학사일정에 대한 표시로서 #이 있다면 그 날짜에 학사일정이 있다는 것을 알립니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280546-1b60ef80-380d-11eb-90d4-0a368f7dfeee.png)

 -12월 7일의 버튼을 눌렀을 때의 캡쳐

* 3/4/5/6/7이라 표시되어 있는 12월 7일의 버튼을 클릭 시 오른쪽 리스트에는 해당 요일이 마감기한인 강의와 과제들이 표시됩니다. 강의 명 앞에는 매핑되어있던 과목 번호들이 같이 표시됩니다. 
* 예를 들어 3번이었던 생명정보과학에 강의 수업, 수업이 있고 4번이었던 알고리즘에는 알고리즘 6C등이 12월 7일까지인 것을 알 수 있습니다.
------------------------------------------

![image](https://user-images.githubusercontent.com/50694545/101280555-261b8480-380d-11eb-894b-d3c0d55983f7.png)

-리스트의 값을 더블클릭 했을 때의 캡쳐

* 또한 해당 리스트들의 강의명 또는 과제명을 더블 클릭하시면 그 강의에 대해 과목이름, 강의 길이, 강의 기간(시작기간과 마감기한), 지각 기한에 대한 상세정보들을 사용자에게 창을 띄워 안내해줍니다.
* 과제의 경우에도 마찬가지로 리스트의 값을 더블 클릭 시 사용자에게 과목 이름과 과제의 기간을 안내해줍니다.
* 해당 더블클릭시 상세정보 안내 기능은 날짜 버튼 클릭시 표시되는 리스트뿐만 아니라 과제 확인, 영상 확인 시 표시되는 리스트에서도 사용가능 합니다.
* 확인 완료! 버튼을 누를 시 상세정보 안내 창은 꺼지고 다시 캘린더 창으로 돌아옵니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280561-2f0c5600-380d-11eb-8f6c-89cd2c09a9ac.png)

-리스트 위의 지난달로 버튼을 클릭했을 때의 캡쳐
* 리스트위에 있는 지난달로 버튼을 누르면 지난 달의 스마트캠퍼스 일정과 학사일정들을 캘린더에 적용해 출력해줍니다. 왼쪽 상단에 월이 11월로 바뀐 것을 볼 수 있습니다.
* 다음 달의 경우에도 똑같이 다음 달의 상황을 적용해주어 캘린더에 적용해 사용자에게 보여줍니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280568-37fd2780-380d-11eb-9f01-0c1686508654.png)

-두번째 과제확인 버튼을 눌렀을 때의 캡쳐

* 과제확인의 경우 사용자가 이번 주차까지 내야하는 과제가 있는데 과제를 제출하지 않았을 때, 그때의 여부를 확인해 리스트에 출력해줍니다. “이번 주에 아직 제출하지 못한 과제”가 리스트에 추가된 것을 볼 수 있습니다. 
* 예를 들어 “1>동료 평가”의 경우 1번이었던 오픈소스기초기반설계 과목의 동료평가라는 제목의 과제를 이번 주에 아직 제출하지 않을 것을 알려줍니다.
* 또한 더블 클릭 시 해당 과제에 대해 상세정보를 사용자에게 알립니다.
* 영상 확인의 경우에도 마찬가지로 이번 주까지 들어야하는 강의 중 사용자가 아직 완전히 수강하지 못한 강의들을 확인해 리스트에 표시해줍니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280571-41868f80-380d-11eb-84b9-8fc9e7db7995.png)

-첫번째 버튼인 공지사항 버튼을 눌렀을 때의 캡쳐
* 학교의 공지사항들이 어디에 올라오는지 모르는 학우들이 대다수입니다. 이에 해당 기능을 구현해주었습니다.
* 검색에 텍스트필드에 검색어를 입력한 뒤 검색 버튼을 눌러주면 학교 공지사항에서 해당 검색어를 갖는 것들을 웹뷰를 통해 보여줍니다.
* 기본 버튼을 누르면 학교 공지사항 사이트로 웹뷰를 연결해줍니다.
* 종료 버튼을 누를 시 해당 공지사항 안내 창이 꺼지고 캘린더 창으로 돌아옵니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280581-4d725180-380d-11eb-8d34-034c9ecac3c1.png)

-리스트 아래의 추가 버튼을 눌렀을 때의 캡쳐

* 추가버튼을 누를 경우 사용자가 원하는 개인 일정을 추가할 수 있습니다.
* 일정 일자의 달력버튼을 눌러 사용자의 일정의 날짜를 정한 뒤 일정 이름을 입력한 뒤 해당 창의 추가 버튼을 누르면 사용자의 일정이 저장되고 해당 .TXT파일에 저장됩니다.
* 12월 24일을 고른 뒤 테스트라는 일정을 추가하고 있는 모습입니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280593-595e1380-380d-11eb-9acc-5826e3fb6b3c.png)

* 사용자가 추가한 일정의 경우 캘린더에는 *의 모양으로 표시됩니다.
* 추가했었던 일자인 12월 24일의 버튼을 클릭할 경우 오른쪽 리스트에 “>테스트”라고 사용자가 지정했던 일정의 이름이 표시되는 것을 볼 수 있습니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280600-61b64e80-380d-11eb-8ab9-eabe830f2850.png)

-리스트 아래의 삭제 버튼을 눌렀을 때의 캡쳐

* 리스트에서 지우고자하는 사용자 일정이나, 학사일정, 강의일정, 과제일정들 중에서 마우스로 한번 클릭해 고른 뒤 리스트 아래의 삭제 버튼을 누르면 선택한 일정을 삭제할 수 있습니다.
* 해당 일정을 정말 삭제하는지에 대한 확인창이 뜬 뒤 삭제 버튼을 한번 더 누르면 캘린더에서와 저장되어 있던 TXT 파일에서 모두 삭제됩니다.
* 삭제 시 캘린더 날짜 위 레이블에 해당 일정이 표시가 안되는 것을 확인할 수 있습니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280605-6975f300-380d-11eb-8441-4df414e60219.png)

-5번째 재갱신 버튼을 눌렀을 때의 캡쳐

* 재갱신 버튼의 경우 이전의 로딩창과 같은 창이 뜨면서 사용자의 스마트캠퍼스 정보들을 다시 갱신해줍니다.
* 해당 갱신의 경우 JSOUP라이브러리를 이용해 크롤링해올 때 스마트캠퍼스의 특정 HTML을 크롤링해오는 것이 불가능하고 전체 HTML을 크롤링해오기 때문에 주차 갱신이더라도 항상 오랜 시간이 걸립니다. 이에 따로 갱신 버튼을 만들어 주어 사용자가 원할 때 갱신이 가능하도록 만들어 주었습니다.
* 주차의 시작인 월요일에 갱신 버튼을 누르는 것을 권장합니다.
* 갱신 후 확인 버튼을 누를 경우 갱신해온 내용들이 캘린더에 적용돼 표시됩니다.
------------------------------------------
![image](https://user-images.githubusercontent.com/50694545/101280613-7397f180-380d-11eb-8d08-c6630ec6586c.png)

-4번째 설정을 버튼을 눌렀을 때의 캡쳐

* 설정 버튼의 경우 프로그램을 삭제할 수 있습니다. 해당 로그인 했던 계정의 비밀번호를 확인하고 맞을 경우 해당 프로그램이 저장되어있던 폴더를 C드라이브에서 완전히 삭제해줍니다.
* 프로그램에 대하여 버튼을 클릭시 로그인 창과 마찬가지로 해당 프로그램에 대한 안내가 적혀있는 깃허브로 웹사이트를 연결시켜줍니다.

 ------------------------------------------
 
 # 3.프로젝트 제작에 참고된 참고문헌, 서적, URL
 

  ## 크롤링 부분
     1. 참고 서적   : Do It! 자바 스크립트 + 제이쿼리 입문/정인용 지음/이지스 퍼블리싱 (2019 개정)
     2. 참고 유튜브 : [코딩러]Java로 구현한 Crawler #1 , #2 ,#3 / [https://www.youtube.com/watch?v=XGyt3DAfZTk&t=103s]
     3. 참고 블로그 : Jsoup을 활용한 크롤링(IT일상 크롤링) / [https://blog.naver.com/chae1789/221861915056]
    -----------------------------
   
  ## Javafx 부분
     1. 참고 블로그
        1. css구현 관련          : [https://intellee.tistory.com/] 
        2. 로그인 쿠키, 세션 관련 : [https://seyul.tistory.com/41] 
        3. javafx 관련           : [https://m.blog.naver.com/PostView.nhn?blogId=qkrghdud0&logNo=220704213141&pr oxyReferer=https:%2F%2Fwww.google.com%2F] 
 
     2. Stack Over Flow
        * [https://stackoverflow.com/questions/43566587/styling-javafx-checkbox/43569915] 
        * [https://stackoverflow.com/questions/28558165/javafx-setvisible-hides-the-elementbut-doesnt-rearrange-adjacent-nodes] -      
        * [https://stackoverflow.com/questions/26526811/fxml-public-static-vars-in-javafx] 
        * [https://stackoverflow.com/questions/9722418/how-to-handle-listview-item-clickedaction] 
        * [https://stackoverflow.com/questions/57936266/eclipse-not-detecting-main-method -javafx] 
        * [https://stackoverflow.com/questions/9108124/what-causes-duplicate-entry-warnin gs-when-jaring-with-eclipse/38339622] 
        * [https://stackoverflow.com/questions/1112536/is-there-a-way-to-include-a-vm-par ameter-inside-a-jar]

     3. Stack OverRun
        * [https://stackoverrun.com/ko/q/12992806]
        * [https://stackoverrun.com/ko/q/10124827]
        
     ** JavaFx의 경우, 한글로 된 자료들과 각종 오류들에 있어 정보의 부족함이 많아 해외 stack overflow와 stack overrun의 사이트를 많이 검색 및 학습해 개발했습니다.*
  ------------------------------------------    
  # 4. 프로젝트 개발자 정보
     * 이정재 (소프트 19학번) : dlwjdwo00701@naver.com
     * 배준형 (컴퓨터 19학번) : baejh724@gmail.com
     * 장승헌 (소프트 19학번) : jangsh0422@naver.com
     * 이건욱 (소프트 19학번) : pingkiboos@naver.com
