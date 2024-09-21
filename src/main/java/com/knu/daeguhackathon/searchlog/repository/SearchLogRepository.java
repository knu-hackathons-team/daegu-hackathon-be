package com.knu.daeguhackathon.searchlog.repository;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.searchlog.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {
    List<SearchLog> findAllByMember(Member member);

    void deleteAllByMember(Member member);
}
