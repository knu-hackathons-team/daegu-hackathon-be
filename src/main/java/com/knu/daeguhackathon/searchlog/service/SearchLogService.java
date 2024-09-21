package com.knu.daeguhackathon.searchlog.service;

import com.knu.daeguhackathon.member.Member;
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

    public SearchLogResponse.Logs getAllSearchLog(Member loginMember) {
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

    public void deleteAllSearchLog(Member loginMember) {
        searchLogRepository.deleteAllByMember(loginMember);
    }
}
