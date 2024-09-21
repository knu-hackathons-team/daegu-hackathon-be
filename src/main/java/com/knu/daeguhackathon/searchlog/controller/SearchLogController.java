package com.knu.daeguhackathon.searchlog.controller;

import com.knu.daeguhackathon.global.dto.GlobalResponse;
import com.knu.daeguhackathon.searchlog.controller.dto.SearchLogResponse;
import com.knu.daeguhackathon.searchlog.service.SearchLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/searchlog")
public class SearchLogController {

    private final SearchLogService searchLogService;

    @GetMapping("")
    public SearchLogResponse.Logs getAllSearchLogs() {
        // TODO getAllSearchLogs()
        return null;

    }

    @DeleteMapping("/{logId}")
    public GlobalResponse deleteSearchLog(
        @RequestParam(name = "logId") Long logId
    ) {
        searchLogService.deleteSearchLogById(logId);
        return GlobalResponse.builder()
            .message("로그 삭제가 완료되었습니다.")
            .build();
    }

    @DeleteMapping("/all")
    public GlobalResponse deleteAllSearchLog(
    ) {
        //TODO searchLogService.deleteAllSearchLog()
        return GlobalResponse.builder()
            .message("전체 로그 삭제가 완료되었습니다.")
            .build();
    }
}
