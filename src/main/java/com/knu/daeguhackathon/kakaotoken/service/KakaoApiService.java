package com.knu.daeguhackathon.kakaotoken.service;

import com.knu.daeguhackathon.config.KakaoProperties;
import com.knu.daeguhackathon.kakaotoken.dto.KakaoTokenResponse;
import com.knu.daeguhackathon.kakaotoken.dto.KakaoUserResponse;
import java.net.URI;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class KakaoApiService {

    private final RestTemplate restTemplate;
    private final KakaoProperties kakaoProperties;

    public String getAuthorizationUrl() {
        return "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="
            + kakaoProperties.getClientId() + "&redirect_uri=" + kakaoProperties.getRedirectUri();
    }

    public KakaoTokenResponse getAccessToken(String authorizationCode) {
        String url = "https://kauth.kakao.com/oauth/token";
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_FORM_URLENCODED_VALUE);
        LinkedMultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "authorization_code");
        body.add("client_id", kakaoProperties.getClientId());
        body.add("redirect_uri", kakaoProperties.getRedirectUri());
        body.add("code", authorizationCode);

        RequestEntity<LinkedMultiValueMap<String, String>> request = new RequestEntity<>(body,
            headers, HttpMethod.POST, URI.create(url));

        ResponseEntity<KakaoTokenResponse> response = restTemplate.exchange(request,
            KakaoTokenResponse.class);

        return response.getBody();
    }

    public Map<String, Object> refreshAccessToken(String refreshToken) {
        String url = "https://kauth.kakao.com/oauth/token";

        String body = "grant_type=refresh_token&client_id=" + kakaoProperties.getClientId()
            + "&refresh_token=" + refreshToken;

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        HttpEntity<String> entity = new HttpEntity<>(body, headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.POST, entity,
            Map.class);

        return response.getBody();
    }

    public KakaoUserResponse getUserInfo(String accessToken) {
        String url = "https://kapi.kakao.com/v2/user/me";
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        headers.setBearerAuth(accessToken);

        MultiValueMap<String, String> params = new LinkedMultiValueMap<>();
        params.add("property_keys", "[\"kakao_account.email\", \"kakao_account.profile\"]");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(params, headers);

        ResponseEntity<KakaoUserResponse> response = restTemplate.exchange(
            url, HttpMethod.POST, request, KakaoUserResponse.class);

        return response.getBody();
    }


}
