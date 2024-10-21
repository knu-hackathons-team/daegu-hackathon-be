# WheelCampus
> # 2024 대구를 빛내는 해커톤 대상 수상작 🥇
---
### 서비스 링크 : www.wheelcampus.world (현재 로그인 서버 닫혀있습니다 - 추후 재 오픈 예정)
---

<a href='https://ifh.cc/v-6PMsQD' target='_blank'>
    <img src='https://ifh.cc/g/8yS02n.png' width="200px;" style="display: block; margin: 0 auto;" border='0'>
</a>

---
### 프론트 깃허브 레포지토리 : https://github.com/knu-hackathons-team/daegu-hackathon-fe
### 백엔드 깃허브 레포지토리 : https://github.com/knu-hackathons-team/daegu-hackathon-be
---

## 서비스 요약
__WheelCampus - 휠체어를 사용하는 경북대학교 학생들을 위한 길찾기 서비스__

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

### [시연영상 보러가기](https://www.youtube.com/watch?v=aMVLtHDLiXQ&ab_channel=SinyoungPark)
https://www.youtube.com/watch?v=aMVLtHDLiXQ&ab_channel=SinyoungPark

## 서비스 소개
### 서비스 개요
- 휠체어 사용자가 출발지와 도착지를 선택하면 휠체어 다닐 수 있는 길의 최단 경로와 예상 시간 제공
- 본인의 휠체어 속도를 단계별로 선택 가능
- 결과는 카카오메시지로 저장 가능

### 타서비스와의 차별점
일반적인 지도 앱들은 휠체어 사용자를 위한 경로를 제공하지 않는 경우가 많음

휠체어 사용자를 위한 특화된 결과를 제공
### 구현 내용 및 결과물
1. 출발지, 도착지 선택 시 결과 제공
    - 지도상에서 출발지, 도착지 선택 가능
    - 선택시 선택한 위치의 건물 또는 상호명 자동 입력
    - 휠체어가 다닐 수 있는 경로의 최단경로 화면에 표시
    - 설정한 speed에 맞게 예상 소요시간 제공
    - 현재 본인의 위치로 이동 가능
    - 카카오 메시지로 결과 전송 가능 (비즈니스 인증 이슈로 나에게 보내기로 제공)
2. 마이페이지
   - 로그인은 카카오 Oauth 로그인
   - 닉네임 변경 가능
   - speed 변경 가능 (3단계)
  
### UseCase Diagram
<img width="833" alt="image" src="https://github.com/user-attachments/assets/4674f0fb-c3bb-4ac6-9678-ac0845b19e52">

  
---
### 구현 사진
<a href='https://ifh.cc/v-XFMZpd' target='_blank'><img src='https://ifh.cc/g/XFMZpd.jpg' width="300px;" border='0'></a>
<a href='https://ifh.cc/v-rG7nxv' target='_blank'><img src='https://ifh.cc/g/rG7nxv.png' width="300px;" border='0'></a>
<a href='https://ifh.cc/v-cf7OHZ' target='_blank'><img src='https://ifh.cc/g/cf7OHZ.png' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-JLCSDA' target='_blank'><img src='https://ifh.cc/g/JLCSDA.png' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-6FTCNk' target='_blank'><img src='https://ifh.cc/g/6FTCNk.png' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-NrqzPL' target='_blank'><img src='https://ifh.cc/g/NrqzPL.jpg' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-FmkLrX' target='_blank'><img src='https://ifh.cc/g/FmkLrX.jpg' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-LydHYb' target='_blank'><img src='https://ifh.cc/g/LydHYb.jpg' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-h2OY2T' target='_blank'><img src='https://ifh.cc/g/h2OY2T.jpg' width="300px;"  border='0'></a>
<a href='https://ifh.cc/v-54vTF7' target='_blank'><img src='https://ifh.cc/g/54vTF7.jpg' width="300px;"  border='0'></a>
#### 카카오 전송
![image](https://github.com/user-attachments/assets/10b648cc-f435-44e2-81e8-b64e02f2d8b3)


### 구현 방식
- 프론트 : typescript, react, emotion css, chakra ui
- 프론트 서버 : versel
- 백엔드 : Java, SpringBoot
- 백엔드 서버 : AWS
- 지도 api: Tmap API (JS)
- Oauth: Kakao
### 웹 서버 아키텍쳐
<img width="1355" alt="image" src="https://github.com/user-attachments/assets/30015d47-f652-4fcd-8460-19fc8c2aeb80">


## 향후 개선 혹은 발전 방안
- 비즈니스 인증을 받아 카카오 채널과 연동하여 메세지를 전송
- 휠체어 사용자 이외의 거동 불편자를 위한 맞춤 길찾기 정보 제공
- 본래 구현하고자 했던 추가 서비스
    - 시간표 기반 경로 제공 서비스
    - 사용자가 시간표를 검색하여 추가하면 시간표 폼에 맞게 수업 자동 삽입
    - 요일별로 사용자가 시간표를 선택 시, 해당 날짜의 이동 경로와 예상 시간 정보 제공
