package com.knu.daeguhackathon.searchlog.service;

import com.knu.daeguhackathon.member.Member;
import com.knu.daeguhackathon.member.repository.MemberRepository;
import com.knu.daeguhackathon.searchlog.SearchLog;
import com.knu.daeguhackathon.searchlog.controller.dto.SearchLogResponse;
import com.knu.daeguhackathon.searchlog.repository.SearchLogRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SearchLogService {

    private SearchLogRepository searchLogRepository;
    private MemberRepository memberRepository;

    public SearchLogResponse.Logs getAllSearchLog(Long loginMemberId) {
        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        List<SearchLog> searchLogList = searchLogRepository.findAllByMember(loginMember);

        List<SearchLogResponse.Info> allSearchLogs = searchLogList.stream().map(
            searchLog -> SearchLogResponse.Info.builder()
                .startBuildingName(searchLog.getStartBuildingName())
                .endBuildingName(searchLog.getEndBuildingName())
                .build()
        ).toList();

        return SearchLogResponse.Logs.builder()
            .logs(allSearchLogs)
            .build();
    }

    public void deleteSearchLogById(Long logId) {
        SearchLog searchLog = searchLogRepository.findById(logId)
            .orElseThrow(() -> new RuntimeException("로그가 없습니다."));

        searchLogRepository.delete(searchLog);
    }

    public void deleteAllSearchLog(Long loginMemberId) {
        Member loginMember = memberRepository.findById(loginMemberId)
            .orElseThrow(() -> new RuntimeException("멤버가 존재하지않습니다."));
        searchLogRepository.deleteAllByMember(loginMember);
    }
}
