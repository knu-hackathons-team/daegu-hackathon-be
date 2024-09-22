# 사군자팀 - WheelCampus
<a href='https://ifh.cc/v-6PMsQD' target='_blank'>
    <img src='https://ifh.cc/g/6PMsQD.jpg' width="200px;" style="display: block; margin: 0 auto;" border='0'>
</a>

## 서비스 요약
WheelCampus - 휠체어를 사용하는 경북대학교 학생들을 위한 시간표 기반 길찾기 서비스

## 주제 구분
-	E타입 경북대에 다니는 다양한 배경의 학우들을 위한 서비스

## 팀원 소개
<table>
<tbody>
    <td align="center">
        <img src="https://ifh.cc/g/QkXhsw.jpg" alt="이지호" border="0" width="86px;" alt=""/></a>
        <br /><sub><b>이지호 - BE</b></sub>
    </td>
    <td align="center">
        <img src="https://ifh.cc/g/NjmafX.jpg" alt="김건" border="0" width="90px;" alt=""/></a>
        <br /><sub><b>김건 - BE</b></sub>
    </td>
    <td align="center">
        <img src="https://ifh.cc/g/XS4qyq.jpg" alt="박신영" border="0" width="105px;" /></a>
        <br /><sub><b>박신영 - FE</b></sub>
    </td>
    <td align="center">
        <img src="https://ifh.cc/g/KPoovL.jpg" alt="최기영" border="0" width="100px;" alt=""/></a>
        <br /><sub><b>최기영 - FE</b></sub>
    </td>
</tbody>
</table>


## 시연 영상
(필수) Youtube 링크
(선택) Github Repository 페이지에서 바로 볼 수 있도록 넣어주셔도 좋습니다.

## 서비스 소개
### 서비스 개요
- 휠체어 사용자가 출발지와 도착지를 선택하면 휠체어 다닐 수 있는 길의 최단 경로와 예상 시간 제공
- 본인의 휠체어 속도를 단계별로 선택 가능
- 시간표를 입력하고 요일별로 선택시 당일의 예상 경로와 예상 시간을 제공
- 결과는 카카오메시지로 저장 가능

### 타서비스와의 차별점
일반적인 지도 앱들은 휠체어 사용자를 위한 경로를 제공하지 않는 경우가 많음

시간표와 연동하여 사용자가 실제 사용하기 용이한 결과를 제공

### 구현 내용 및 결과물
1. 출발지, 도착지 선택 시 결과 제공
    - 지도상에서 출발지, 도착지 선택 가능
    - 선택시 선택한 위치의 건물 또는 상호명 자동 입력
    - 휠체어가 다닐 수 있는 경로의 최단경로 화면에 표시
    - 설정한 speed에 맞게 예상 소요시간 제공
    - 현재 본인의 위치로 이동 가능
2. 시간표 기반 경로 제공 서비스
    - 사용자가 시간표를 검색하여 추가하면 시간표 폼에 맞게 수업 자동 삽입
    - 요일별로 사용자가 시간표를 선택 시, 해당 날짜의 이동 경로와 예상 시간 정보 제공
    - 결과 카카오 메시지로 전송 가능 (비즈니스 인증 이슈로 나에게 보내기로 제공)
3. 마이페이지
   - 로그인은 카카오 Oauth 로그인
   - 닉네임 변경 가능
   - speed 변경 가능

### 구현 방식
- 프론트 : typescript, react, emotion css, chakra ui
- 프론트 서버 : versel
- 백엔드 : Java, SpringBoot
- 백엔드 서버 : AWS
- 지도 api: Tmap API (JS)
- Oauth: Kakao

## 향후 개선 혹은 발전 방안
- 비즈니스 인증을 받아 카카오 채널과 연동하여 메세지를 전송
- 경북대학교 시간표에 한정하지 않고 타 학교나 기관으로 서비스 제공 영역 확장
- 휠체어 사용자 이외의 거동 불편자를 위한 맞춤 길찾기 정보 제공
