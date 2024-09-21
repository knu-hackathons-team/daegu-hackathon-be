package com.knu.daeguhackathon.distance.repository;

import com.knu.daeguhackathon.distance.Distance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DistanceRepository extends JpaRepository<Distance, Long> {
}
