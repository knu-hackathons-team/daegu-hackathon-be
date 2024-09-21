package com.knu.daeguhackathon.searchlog.repository;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.searchlog.SearchLog;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {

    List<SearchLog> findAllByMember(Member member);

    void deleteAllByMember(Member member);
}
