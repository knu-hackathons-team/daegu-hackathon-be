package com.knu.daeguhackathon.kakaotoken.repository;

import com.knu.daeguhackathon.kakaotoken.KakaoToken;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KakaoTokenRepository extends JpaRepository<KakaoToken, Long> {
}
