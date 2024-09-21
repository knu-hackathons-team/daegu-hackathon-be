package com.knu.daeguhackathon.searchlog.repository;

import com.knu.daeguhackathon.searchlog.SearchLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SearchLogRepository extends JpaRepository<SearchLog, Long> {
}
