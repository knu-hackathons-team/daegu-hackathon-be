package com.knu.daeguhackathon.member.repository;

import com.knu.daeguhackathon.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
