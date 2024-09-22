package com.knu.daeguhackathon.distance.service;

import com.knu.daeguhackathon.distance.Distance;
import com.knu.daeguhackathon.distance.controller.dto.DistanceRequest;
import com.knu.daeguhackathon.distance.repository.DistanceRepository;
import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import com.knu.daeguhackathon.searchlog.SearchLog;
import com.knu.daeguhackathon.searchlog.repository.SearchLogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DistanceService {

    private final DistanceRepository distanceRepository;
    private final SearchLogRepository searchLogRepository;
    private final MemberRepository memberRepository;

    public void saveDistance(Long loginMemberId, DistanceRequest.Info request) {

        Member loginMember = memberRepository.findById(loginMemberId).orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));

        Distance distance = Distance.builder()
                .startBuildingName(request.startBuildingName())
                .endBuildingName(request.endBuildingName())
                .buildingDistance(request.buildingDistance())
                .estimatedTime(request.estimatedTime())
                .imageUrl(request.imageUrl())
                .build();

        distanceRepository.save(distance);

        SearchLog searchLog = SearchLog.builder()
            .member(loginMember)
            .startBuildingName(distance.getStartBuildingName())
            .endBuildingName(distance.getEndBuildingName())
            .build();
        searchLogRepository.save(searchLog);

    }
}
