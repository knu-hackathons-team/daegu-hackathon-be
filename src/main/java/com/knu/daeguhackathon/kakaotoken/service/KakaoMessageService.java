package com.knu.daeguhackathon.kakaotoken.service;

import com.knu.daeguhackathon.kakaotoken.KakaoToken;
import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import java.net.URI;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KakaoMessageService {

    private final RestTemplate restTemplate;
    private final KakaoTokenService kakaoTokenService;
    private final MemberRepository memberRepository;

    public void sendResultMessage(Long memberId, String start, String end,
        Double estimatedTime, Double buildingDistance) {
        Member member = memberRepository.findById(memberId).orElseThrow(
            () -> new RuntimeException("id에 해당하는 멤버가 없습니다.")
        );
        KakaoToken kakaoToken = kakaoTokenService.getAccessTokenByMemberId(memberId);
        String url = "https://kapi.kakao.com/v2/api/talk/memo/default/send";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        headers.setBearerAuth(kakaoToken.getAccessToken());

        String templateObject = createTemplateObject(member.getNickName(), start, end,
            estimatedTime, buildingDistance);
        String encodedTemplateObject = URLEncoder.encode(templateObject, StandardCharsets.UTF_8);

        RequestEntity<String> request = new RequestEntity<>(
            "template_object=" + encodedTemplateObject,
            headers, HttpMethod.POST, URI.create(url));

        restTemplate.exchange(request, String.class);
    }

    private String createTemplateObject(String name, String start, String end,
        Double estimatedTime, Double buildingDistance) {
        return """
            {
                "object_type": "feed",
                "content": {
                    "title": "%s님의 길찾기 결과 입니다.",
                    "description": "WheelCampus 서비스를 이용해주셔서 감사드립니다.",
                    "image_url": "https://ifh.cc/g/8yS02n.png",
                    "image_width": 640,
                    "image_height": 640,
                    "link": {
                        "web_url": "https://wheelcampus.vercel.app",
                        "mobile_web_url": "https://wheelcampus.vercel.app"
                    }
                },
                "item_content": {
                    "items": [
                        {"item": "출발지", "item_op": "%s"},
                        {"item": "도착지", "item_op": "%s"},
                        {"item": "소요시간", "item_op": "%.1f분"},
                        {"item": "이동거리", "item_op": "%.1f m"}
                    ]
                },
                "buttons": [
                    {
                        "title": "자세히 보기",
                        "link": {
                            "web_url": "https://wheelcampus.vercel.app",
                            "mobile_web_url": "https://wheelcampus.vercel.app"
                        }
                    }
                ]
            }
        """.formatted(name, start, end, estimatedTime, buildingDistance, start, end, estimatedTime, buildingDistance);
    }

}
