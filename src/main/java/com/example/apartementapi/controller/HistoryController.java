package com.example.apartementapi.controller;

import com.example.apartementapi.model.History;
import com.example.apartementapi.service.HistoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@CrossOrigin
public class HistoryController {
    HistoryService historyService;

    @GetMapping("/history")
    public Page<History> getAllHistories(@RequestParam(name = "pageNumber") int page,
                                         @RequestParam(name = "pageSize") int pageSize){
        return historyService.getAllHistory(page,pageSize);
    }

    @PutMapping("/history")
    public String cleanHistory() {
        return historyService.deleteAllHistory();
    }
}
