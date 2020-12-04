# to_the_top Project
## [과탑을 향해서] Description
 * 저희 "과탑을 향해서" 프로젝트 팀은 비대면 강의가 활성화 되면서 LMS에 없는 기능인 강의/과제 마감 날짜, 유세인트 학사일정 등을 캘린더에 자동으로 동기화를 
 동기화 해주어, 학우분들이 편리하게 학교 일정을 관리할 수 있도록 하여 학우분들의 학업 성량 증가와 성적 향상을 목적으로 시작한 프로젝트 입니다.
------------------------------------------


## 사용 방법
* 설명 문서 (개발자용) : [[과탑을 향하여] 설명서(개발자용).pdf](https://github.com/dlwjdwo00701/to_the_top/files/5641721/default.pdf)
* 설명 문서 (사용자용) : 
  1. 
------------------------------------------



## 프로젝트를 진행하며 추가하고 디버그 한 기록들.
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
   * 7~10주차 : 이번 프로젝트에 맞는 캘린더 UI제작.
   * 11주차   : 캘린더 버튼 꼬임에 대한 디버깅 완료
   * 12주차   : (긴급)자동 로그인에 대한 방안설정 -> 보안상 취약할 수 있으므로, 이용자에게 확인 후 비밀번호를 해시화하여 로그인 기능 구현
   * 12주차2  : 캘린더에 표시할 방법 논의        -> 강의인덱스(1~마지막 번호)를 보여준 후 강의 마감일(결석,지각)에 인덱스를 표기하는 방식
   * 13주차   : 캘린더에 현재주차까지 듣지않은 강의/과제 버튼 구현
   * 13주차2  : javafx,jsoup을 담은 .exe파일 추출
 ------------------------------------------
   
   
  ## Program Field/Method (멤버 변수/멤버 함수) Description
   ------------------------------------------
  ### 크롤링 부분
  #### 멤버 변수들
  ##### SmartCampusMain 클래스의 필드들
  ------------------------------------------
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
   
   * 이번주차에 제출하지 않은(X) 과제를 가공한 배열 (강의 과목명 / 이름 / 기간 / 지각 기간 / 길이)
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
  * check_assign_count(); | 과제를 했는지 

 ------------------------------------------
 #### UI 부분
 
 ------------------------------------------
 
  ## 작업 브랜치 목록
     1. Main   : 프로젝트 입구 간판 (이름과 현재까지 완성된 세부내용만 기록)
     2. Master : 정보 크롤링 담당 브랜치(배준형,이정재)
     3. ui_    : 캘린더 UI,css및 크롤링 데이터를 실질적으로 다루는 브랜치 (이정재,김승헌,이건욱)
     4. read   : 조원 역할들이 수록되어있음.
 ------------------------------------------
     
  ## 참고 서적과, URL, 내용들
  ### 크롤링 부분
     1. 참고 서적   : Do It! 자바 스크립트 + 제이쿼리 입문/정인용 지음/이지스 퍼블리싱 (2019 개정)
     2. 참고 유튜브 : [코딩러]Java로 구현한 Crawler #1 , #2 ,#3 / [https://www.youtube.com/watch?v=XGyt3DAfZTk&t=103s]
     3. 참고 블로그 : Jsoup을 활용한 크롤링(IT일상 크롤링) / [https://blog.naver.com/chae1789/221861915056]
     
  ### UI부분
     1. : 추가바람
 ------------------------------------------

     
  ## 프로젝트 개발자 정보
     * 이정재 (소프트 19학번) : dlwjdwo00701@naver.com
     * 배준형 (컴퓨터 19학번) : baejh724@gmail.com
     * 김승헌 (소프트 19학번) : 추가바람
     * 이건욱 (소프트 19학번) : 추가바람
