# to_the_top
## [과탑을 향해서] Introduce
<center><img src="https://user-images.githubusercontent.com/47067905/101271773-44f82780-37c9-11eb-960e-e394c4e160e4.png" width="300" height="300"></center>

 -----------------------------------------------------------

# 목차
 1. [프로젝트 소개](#프로젝트-소개)
 
       1.1 [프로젝트 소개와 필요성](#프로젝트-소개와-필요성)
       
       1.2 [프로그램의 차별성](#프로그램의-차별성)]
       
       1.3 [프로젝트 라이브러리 및 구현과 디버그](#프로젝트-라이브러리-및-구현과-디버그)
       
       1.4 [내부 코드 설명](#내부-코드-설명)
       
       1.5 [UI 프로그램 구성 파일](#UI_프로그램_구성_파일)
       
2. [설치 및 사용 메뉴열](#설치-및-사용-메뉴얼)

       2.1 [개발자의 경우(설치)](#개발자의_경우설치] 
       
       2.2 [일반 사용자의 경우(설치)](#일반_사용자의_경우설치)       
       
       2.3 [과탑을 향해서(캘린더) 사용 방법](#과탑을_향해서캘린더_사용_방법)    
       
        2.3.1 [로그인창](#로그인창)     
        
        2.3.2 [로딩창](#로딩창)   
        
        2.3.3 [캘린더창](#캘린더창)
              
3.[프로젝트 제작에 참고된 참고문헌, 서적, URL](#참고-서적과,-URL,-내용들-,-개발자-정보들)

4.[프로젝트 개발자 정보](#프로젝트-개발자-정보)

------------------------------------------

# 프로젝트 소개
  
------------------------------------------

## 프로젝트 소개와 필요성

기존에 대면 수업으로 진행할 때에는 잘 쓰이지 않았던 스마트캠퍼스가 코로나로 인해 비대면 수업으로 전환되면서 교수님과 학우분들 사이에 연결고리가 필요해졌고, 이를 연결해주는 매개체는 스마트캠퍼스가 되었습니다. 대부분의 강의 및 과제가 스마트캠퍼스를 통해 업로드되었고, 이전 학기들에 비해 스마트캠퍼스의 중요도가 매우 높아졌습니다. 하지만 시스템 사용에 익숙하지 않은 학우분들은 많은 불편함을 겪었습니다. 강의 및 과제의 마감 기한일이나 출석 여부를 확인하기 위해서는 각 강의를 직접 접속하여 확인하여야 했고, 시스템의 오류 및 교수님께서 마감 기한에 임박하여 강의를 올리신 경우에는 억울하게 강의를 듣지 못 하는 경우도 빈번했습니다. 위와 같은 상황에 대처하기 위해서 학생들 개인의 학교 일정을 더 편안하게 관리하고, 강의 및 과제를 놓치지 않을 수 있도록 하는 캘린더의 필요성을 느껴 프로젝트를 진행하게 되었습니다. 

 "과탑을 향해서"는 스마트캠퍼스에서 사용자의 수강 과목 정보를 가져와 각 과목의 강의, 과제를 관리할 수 있도록 해주는 숭실대학교 학생을 위한 캘린더 프로그램입니다. "과탑을 향해서" 캘린더와 함께 공부하며 과탑을 노려보세요!

 ------------------------------------------

## 프로그램의 차별성
 스마트캠퍼스에서 제공하는 일정표는 다음과 같이 구성되어 있습니다.  
 
![image](https://user-images.githubusercontent.com/71241552/101158844-c76cd400-366f-11eb-9610-ed2de6a23a0d.png)  

위 사진에서 볼 수 있듯, 같은 강의가 그 강의의 마감일까지 계속 반복되어 표시되어 있음을 볼 수 있습니다.  
이로 인해 가시성이 많이 부족하고, 강의 및 과제의 완료 여부를 알 수가 없습니다.
또한, 강의 표시 및 개인 일정 추가 기능 외에는 기능이 존재하지 않아 사용하는 데에 불편함이 많습니다.
기존에 존재하는 캘린더 앱 또한, 사용자가 원하는 일정들을 모두 직접 추가하여야 해서 번거로움이 있습니다.  

![image](https://user-images.githubusercontent.com/71241552/101159722-2c74f980-3671-11eb-8b22-1c473299c108.png)  

"과탑을 향해서" 에서는 캘린더 자동 갱신, 일정 추가 및 삭제, 마감 기한 전 알림과 같은 기능들을 추가하여 스마트캠퍼스 일정표의 불편함을 해소하고, 
사용자가 원하는 일정 및 정보들을 보기 쉽게 나타내 줍니다.  

![image](https://user-images.githubusercontent.com/71241552/101159544-e881f480-3670-11eb-855f-b3d9f0affc1a.png)  

또한, 각 과목의 번호를 매겨 캘린더의 요일에 표시해줌으로써 쉽게 강의 및 과제의 마감일을 알 수 있도록 하였고,
기존의 스마트캠퍼스에서 각 과목에 직접 접속하여 확인해야 하는 번거로움을 덜어주었습니다.  

![image](https://user-images.githubusercontent.com/71241552/101160294-22072f80-3672-11eb-9faf-a2da29c3f27b.png)

------------------------------------------

## 프로젝트 라이브러리 및 구현과 디버그
 "과탑을 향해서"에 탑재되어 있는 기능들을 이용하면, 사용자가 원하는 자신만의 일정표를 만들어나갈 수 있습니다. 스마트캠퍼스의 정보를 계속 갱신할 수 있어 일정을 빠뜨리지 않을 수 있고, 자신이 원하는 대로 일정을 추가 및 삭제를 할 수 있어 나만의 개인 캘린더로 만들 수 있습니다. 잘 확인하지 못 하는 학교 주요 일정들도 캘린더를 통해 확인할 수 있어 캘린더의 주요 기능인 일정 관리 이외에도 학교 주요 행사들에 관한 정보를 수집할 수 있어 범용성이 높을 것으로 예상됩니다. 또한, 스마트캠퍼스에는 없는 기능인 강의 및 과제 마감 기한이 임박하면 알림을 사용자에게 보내주어 강의를 놓치지 않을 수 있습니다.  
 계획적인 삶을 사는 것과 계획 없이 닥치는 대로 눈앞의 일만을 해결하며 현재를 소비하는 것은 매우 큰 차이이며 미래를 대비하는 데에도 큰 영향을 미칩니다. "과탑을 향해서"의 기능들을 십분 활용한다면 매일 강의와 과제의 마감일을 확인하느라 불안감에 시달리는 일이 한층 줄어들 것이고, 자신만의 일정을 편리하게 관리함으로써 심리적 편안함을 느낄 수 있습니다. 내적인 평화는 곧 외적인 행복으로 드러날 것입니다. 심리적으로 편안함을 느끼면 자연스레 생활 리듬 또한 좋아지고 이는 사용자에게 긍정적인 영향을 미칠 것이며 시험과 같은 중요한 일정에서 이러한 긍정적 에너지는 더욱 빛을 발할 것입니다. 사용자의 성적 향상은 물론이고, 사용자의 체계적인 생활을 도와주는데 "과탑을 향해서"는 큰 버팀목 역할을 할 것입니다.

------------------------------------------

## 1.3 프로젝트 라이브러리 및 구현과 디버그
-----------------------------------------
저희의 프로젝트는 JAVA언어를 이용해서 개발했으며, Eclipse IDE를 이용해 개발을 진행했습니다. 스마트캠퍼스에 사용자의 아이디와 비밀번호의 정보를 세션을 통해 보내 쿠키값을 유지해야 했습니다. 이에 찾아본 결과 JSOUP이라는 라이브러리가 있었고, 이를 이용했습니다. 또한 JAVA를 이용해 UI를 구현하고자 찾아본 결과, JAVAFX 라이브러리가 있었으며, 사용하게 되었습니다. 처음 사용해보는 라이브러리들이기에 많은 어려움이 있었으나, 열심히 노력해 마무리할 수 있었습니다. 또 스마트캠퍼스의 경우에는 많은 사용자, 많은 교수님들이 사용하시기에 정말 많은 변수들이 있었습니다. 과목 설정이 다른 경우, 정규 과목이 아니라 동아리가 있는 경우. 영어 과목의 경우, 과제 기한이 없는 경우, 과제가 다른 곳에 공지되어 있는 경우... 등등 많은 변수들이 있었습니다. 프로젝트를 진행하면서 열심히 노력해 최대한 많은 상황들을 다루고자 했습니다.

-----------------------------------------

### 스마트캠퍼스/유세인트 서버 크롤링(JSoup)
#### [https://github.com/dlwjdwo00701/to_the_top/tree/master]
------------------------------------------
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
 *
 * (디버그 과정 중 수정된 내용들)
 * 15주차 강의 인덱스에서 무한루프 발생을 디버그
 * Kmooc 국제학술동아리와 같은 비교과 과목을 제외하도록 크롤링 코드 수정
 * 기한이 없는 과제의 경우 디버그
 
 ------------------------------------------
 
### 캘린더 UI,CSS개발작업(JavaFx+JSoup)
#### [https://github.com/dlwjdwo00701/to_the_top/tree/ui_]
---------------------------------------------
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
   
   
  ## 내부 코드 설명
  ------------------------------------------
  ### 크롤링 부분
  #### 멤버 변수들
  ------------------------------------------
  ##### SmartCampusMain 클래스의 필드들
  * <img width="712" alt="SmartCampusMain 클래스 변수들" src="https://user-images.githubusercontent.com/70988272/101139015-46541380-3654-11eb-8afc-6c2f0b246322.PNG">
  * 첫 화면에서 강의 명/강의 링크를 담는 배열
  1.     subject_title [강의 개수의 index] , subject_link [강의 링크의 index]
  
  * 과목 index에 해당하는 강좌로 이동해서, 주차별로 포함된 강의/과제/파일들을 모두 담는 배열
  1.     array_subject_link [해당 과목 index][해당 주차(0+1-15)][강의/과제/파일]
  
  * 특정 강좌의 주차별(1-15) 강의 이름, 기간, 길이, 지각 정보 등을 담는 배열
  1.     subject_videoName / videoPeriod / videoLength / videoLate [해당 과목 index][주차 0+1~15][강의 Data(강의 이름,기한,길이.지각기한)]
  
  * 해당 강의/과제를 들었는지 체크하기 위해 '온라인 출석부' , '학습진도현황'과 같은 이동할 링크를 담는 배열
  1.     check_video_link / check_assignment_link [] 
  
  * 강의/과제를 수강/제출 했는지 o,x(강의) , 제출/미제출(과제) 등을 담아두는 배열
  1.     check_video [해당 강의 index] [주차 (1-15)] [DATA]
  2.     check_assignment [해당 강의 index] [과제 제출 여부 DATA]
  
  * 특정 강좌의 과제를 담는 배열
  1.     temp_subject_assignmentName/ temp_subject_assignmentPeriond [해당 강좌 index] [과제DATA]
  
  * 교과 과목인지 비교과 과목인지 판단하는 필드들 (임시로 비교과까지 모두 담아둬서 가공하는 방식)
  1.     subject_title_temp / subject_link_temp / check_sub_label_array
------------------------------------------
  ##### SmartCampusTokenzier 클래스의 필드들
  * <img width="678" alt="SmartCampusTokenizer" src="https://user-images.githubusercontent.com/70988272/101142411-e875fa80-3658-11eb-9a1e-d91eba468f0e.PNG">
   * 현재 시간을 알려주는 String 객체
   1.     current_time
   
   * 이번주차에 시청하지 않은(X) 강의를 가공한 배열 (강의 과목명 / 이름 / 기간 / 지각 기간 / 길이)
   1.     if_notattendent_week_videoSubject / videoName / videoDate / videoLate / videoLength
   
   * 이번주차에 제출하지 않은(X) 과제를 가공한 배열 (과제 과목명 / 과제 이름 / 과제 기한)
   1.     if_notPassed_AssignedSubject / AssignedName / AssignedDate
  ------------------------------------------
  ##### SmartCampusOption 클래스의 필드들
  * <img width="678" alt="SmartCampusOption" src="https://user-images.githubusercontent.com/70988272/101139657-3688ff00-3655-11eb-8501-0b908764309f.PNG">
  * 미제출/미수강 강의가 있는 경우 하루 전날에 알려주기 위해서 (원래 기한 -1 )일을 담아둔 배열
  1.      assign_cal_date [과제]
  2.      video_cal_date [강의 인덱스][0 (강의 기한 기준)] , video_cal_date [강의 인덱스][0 (지각 기한 기준)]
  
  * 이번 주차를 알려주는 변수
  1.      thisWeek
  
  * 이번 주차에 미제출/미수강 된 강의를 알려주는 배열들 (checkVideo = 제출 여부)
  1.      thisweek_videoName / videoPeriod / videoLength / videoLate / checkVideo [해당 강좌 index] [DAta}
  ------------------------------------------
  
  ##### SSU Date 클래스의 필드들
  * <img width="675" alt="SSU 학사일정" src="https://user-images.githubusercontent.com/70988272/101139731-4c96bf80-3655-11eb-9c7e-fcf31220f9b2.PNG">
  * 학사 일정을 담은 배열
  1.       usaint_date [학사 일정 Data]
  2.       usaint_schedule[해당 학사 일정에 대한 제목 Data]
  
  * 학사일정을 스마트 캠퍼스 일정 형식으로 전환 (2020.00.00 00:00:00)
  1.      usaint_date_token [0 (시작 날짜) / 1(끝 날짜)] [스케쥴 Data]
  
  ------------------------------------------
  
  
  
  #### 멤버 함수들
  * 멤버 변수는 너무 많아 주요 메소드 들만 체크했습니다.
  *<img width="635" alt="exe" src="https://user-images.githubusercontent.com/70988272/101144395-9aaec180-365b-11eb-8c3f-714d8bd6a82d.PNG">
  
  * is_login(); | 로그인 함수
  * access_lecture_index();    | 강의 인덱스를 계산하는 함수
  * execution_crawling();      | 강의 안의 과제/강의들을 함꺼번에 크롤링하는 함수
  * video_assignment_divide(); | 강의와 과제를 분리하는 함수
  * current_time();       | 현재시간을 알려주는 함수
  * check_video_count();  | 강의를 들었는지 (o/x) 체크하는 함수
  * check_assign_count(); | 과제를 했는지 (제출/미제출) 체크하는 함수

 ------------------------------------------
 #### UI 부분
 * <img width="405" alt="ui 클래스 파일" src="https://user-images.githubusercontent.com/70988272/101276211-83540d80-37ee-11eb-8710-6d6c8d71ac96.PNG">
  * AddController.java        | 추가 기능 관련 이벤트 처리 
  * CalendarController.java   | 캘린더 이벤트 처리 
  * DeleteController.java     | 삭제 기능 이벤트 처리 
  * Explain_V_Controller.java | 상세정보 표시 이벤트 처리 
  * HelpController.java       | 도움말 기능 이벤트 처리 
  * LodingController.java     | 로딩창 이벤트 처리 
  * LoginController.java      | 로그인창 이벤트 처리 
  * Main.java                 | 프로그램 메인문 시작 함수 
  * NoticeController.java     | 공지사항 기능 이벤트 처리 
  * WarnController.java       | 하루전 알림 기능 이벤트 처리 
  * 
  * Add.fxml            | 추가 창 ui 구현 
  * Calendar.fxml       | 캘린더 창 ui 구현 
  * Delete.fxml         | 삭제 창 ui 구현 
  * Explain_V.fxml      | 상세정보 창 ui 구현 
  * Help.fxml           | 도움말 창 ui 구현 
  * Loding.fxml         | 로딩창 ui 구현 
  * Login.fxml          | 로그인 창 ui 구현 
  * Notice.fxml         | 공지사항 창 ui 구현 
  * Warn.fxml           | 하루전 알림 창 ui 구현 
  * app.png             | 프로그램 아이콘 파일
  * font.ttf            | 프로그램 폰트(경기천년제목 BOLD체 사용)

 ------------------------------------------




 # 설치 및 사용 메뉴얼
 ------------------------------------------
 ## 사용방법
  * 개발자용 : 개발자라면 우선 https://gluonhq.com/products/javafx/에 접속해 javafx SDK를 다운받아주세요!

  * 학생용 : 
 
------------------------------------------
 ## UI 부분
 프로그램을 설치하고 실행시키면 C 드라이브안에 SmartCampas 파일이 생성되고 그 안에 학번 파일이 생성되어 각 사용자의 정보들을 처리합니다.
이 정보들을 이용하여 사용자를 구분하고, 사용자의 스마트캠퍼스 데이터를 캘린더에 가져옵니다.

![c드라이브](https://user-images.githubusercontent.com/50694545/101164983-3864b980-3679-11eb-900b-ecd865177051.png)

 ------------------------------------------
 
 ### 로그인창
 로그인 UI에 비밀번호를 저장하는 것을 확인하는 체크박스가 있습니다.
해당 체크박스를 체크할 경우 암호화를 해주고 SmartCampas파일 안에 PASSW파일에 암호화된 비밀번호를 저장해줍니다.
스크롤바가 생겨 비밀번호가 저장되어있는 사용자의 학번을 띄워 고를 수 있게 해 아이디와 비밀번호를 치지 않아도 로그인이 가능합니다.
물음표 버튼을 누르면 이 프로젝트에 깃허브 창이 뜬다.

![자동로그인](https://user-images.githubusercontent.com/50694545/101165049-58947880-3679-11eb-88aa-d8370952482b.png)

 ------------------------------------------
 ### 로딩창
 최초 접속 시에는 갱신 버튼을 누르면 10초 정도의 로딩 후 스마트캠퍼스의 정보를 가져와 각 과목들에게 해당 번호를 할당해줍니다.
최초 접속 이후로 로그인을 하면 갱신을 하는 것이 아니라 기존의 데이터를 가져와 10초에서 1초로 로딩 시간을 단축했습니다. 
학생의 정보들이 맞다면 확인 버튼을 누르고, 확인 버튼을 누를 경우 캘린더 화면으로 넘어가게 됩니다.
 
 
![로딩](https://user-images.githubusercontent.com/50694545/101165194-92fe1580-3679-11eb-9563-d351025bafb9.png)

강의와 과제 마감 하루 전날 프로그램에 접속하면 아래 화면과 같이 알림창이 뜨게 됩니다.

![알림](https://user-images.githubusercontent.com/50694545/101239682-e7ae9880-372c-11eb-9493-197667e9c797.png)


------------------------------------------
 ### 캘린더 창
 저번달과 다음달 버튼이 있어서 해당 버튼을 누를 시 한달 전, 한달 후로 캘린더를 옮겨줍니다.
로딩창에서 가져온 데이터들을 변환시켜 창에서 띄워주게끔 해줍니다. 
일수를 나타내는 총 버튼 37개이고, 각 달이 29일인지 30일인지 시작요일이 무엇인지에 따라 상황에 맞게 버튼을 활성화시키고 비활성화시켜줍니다.

오른쪽 리스트에 각 과목들에게 할당 된 번호가 나타나 있고 캘린더 안에 각 과목들의 번호가 나타나 있어 그 요일에 어떤 과목의 강의나 과제가 있는지 확인 할 수 있습니다.
학사일정의 경우 #으로 나타냅니다.
번호는 '/' 구분자를 사용해 한 눈에 알아보기 쉽게 나타냈고 번호가 나타나있는 요일 버튼을 누를 경우 오른쪽 리스트에 해당 과목의 강의나 과제들이 나타납니다.
강의나 과목의 자세한 정보를 보기 원하면 오른쪽 리스트에 출력된 강의나 과제를 클릭하면 해당사항의 마감시간, 강의길이 등 자세한 정보가 새로운 창에 출력됩니다.  

![캘린더](https://user-images.githubusercontent.com/50694545/101165282-ba54e280-3679-11eb-9c2b-730405639563.png)

비대면 수업으로 진행이 되면서 교수님께서 미처 업로드하지 못 한 강의를 마감 기한이
임박하여 스마트캠퍼스에 올리시거나, 스마트캠퍼스의 기능 오류로 인해 강의 및 과제가
늦게 업로드되는 사례가 많았다. 이러한 오류로 인해 스마트캠퍼스 서버 점검도 자주
시행되었고, 지금은 많이 개선되었지만 학생들은 여전히 불편함을 호소하고 있습니다.  
"과탑을 향해서" 에서는 이러한 갑작스러운 사태를 대비할 수 있도록 
[과제 확인], [영상 확인] 기능을 구현하여, 
버튼을 누를 시 크롤링해온 사용자의 과제 제출 여부 사용자의 영상 시청 여부를 확인해주어 무엇을 제출하지 않았는지 무엇을 시청하지 않았는지를 리스트에 출력해 사용자가 파악하게 해줍니다. 
마감 기한이 임박한 강의 및 과제는 기한 전날 프로그램에서
알림 기능을 통해 사용자에게 알려줄 수 있도록 구현하였습니다.

![과제확인](https://user-images.githubusercontent.com/50694545/101165252-a90bd600-3679-11eb-823c-9eaf7c5c2334.png)

학교 주요 일정들을 알기 위해서는 학교 홈페이지 공지사항, 또는 각 학부 게시판을 확인
해야 한다. 하지만 주요 일정이 어디에 올라오는지 모르거나, 학교 홈페이지는 실질적으로
잘 이용하지 않기 때문에 확인하지 못 하는 학생들이 대다수이다. 이러한 불편함을
해소하기 위해 "과탑을 향해서" 프로그램에서는 [공지사항] 기능을 구현하였다. 
[공지사항] 버튼을 클릭하면 학교 공지사항 홈페이지로 연결해주어 주요 일정을
확인할 수 있고, 검색창 또한 구현되어 있어 학생들이 보다 편리하게 필요한 정보를 
얻을 수 있도록 하였다. 
공지 사항 버튼의 경우 웹뷰를 이용해 검색어를 입력하고 검색 버튼을 눌렀을 때 학교 공지사항에 연결이 될 수 있도록 만들었습니다.

![공지사항](https://user-images.githubusercontent.com/50694545/101165331-d193d000-3679-11eb-8db5-d5c40f1d153c.png)

추가 버튼을 두어서 사용자가 크롤링해온 스마트캠퍼스 내용 이외의 일정을 추가하고 싶을 경우 추가할 수 있습니다. 
추가 시 캘린더에는 '*'로 표시가 됩니다. 또 일 버튼을 클릭 시 오른쪽 리스트에 일정이 추가되어 표시 되는 것을 볼 수 있습니다.
아래 화면과 같이 추가버튼을 누르고 원하는 날짜와 일정을 적고 확인 버튼을 누르면 캘린더에 일정이 추가됩니다.

![추가](https://user-images.githubusercontent.com/50694545/101239684-e8dfc580-372c-11eb-8506-c3c0ee72de96.png)
![테스트](https://user-images.githubusercontent.com/50694545/101239685-ea10f280-372c-11eb-8dda-7a0e3f48dc76.png)
![추가표시](https://user-images.githubusercontent.com/50694545/101239686-eb421f80-372c-11eb-87a1-e9bc211d4085.png)

삭제 버튼은 일정들을 표시해주는 리스트에서 만약 그 일정을 지우고 싶다면 삭제버튼을 눌러서 해당 일정을 삭제할 수 있습니다.
그리고 일정을 저장 파일에서 지워주고 캘린더에 표시가 되지 않게 해주었습니다. 
아래 화면과 같이 이전에 저장해둔 일정을 삭제버튼으로 누르면 삭제창이 떠 확인을 누르면 캘린더에서 삭제됩니다.

![삭제](https://user-images.githubusercontent.com/50694545/101239689-ec734c80-372c-11eb-8296-5d5d3b9aacb4.png)

설정버튼을 눌러 프로그램에 대하여 버튼을 누르면 이 프로젝트에 깃허브창이 뜨게됩니다.
사용자의 비밀번호를 한번 더 확인하여 프로그램 삭제 버튼을 누르면 SmartCampas 파일이 삭제됩니다.

![설정](https://user-images.githubusercontent.com/50694545/101239767-abc80300-372d-11eb-818d-88eec394fa38.png)
 
 ------------------------------------------
 
 
 
 # 참고 서적과, URL, 내용들 , 개발자 정보들
------------------------------------------

  ### 크롤링 부분
     1. 참고 서적   : Do It! 자바 스크립트 + 제이쿼리 입문/정인용 지음/이지스 퍼블리싱 (2019 개정)
     2. 참고 유튜브 : [코딩러]Java로 구현한 Crawler #1 , #2 ,#3 / [https://www.youtube.com/watch?v=XGyt3DAfZTk&t=103s]
     3. 참고 블로그 : Jsoup을 활용한 크롤링(IT일상 크롤링) / [https://blog.naver.com/chae1789/221861915056]
    -----------------------------
   
  ### Javafx 부분
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
  ## 프로젝트 개발자 정보
     * 이정재 (소프트 19학번) : dlwjdwo00701@naver.com
     * 배준형 (컴퓨터 19학번) : baejh724@gmail.com
     * 장승헌 (소프트 19학번) : jangsh0422@naver.com
     * 이건욱 (소프트 19학번) : pingkiboos@naver.com
