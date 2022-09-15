package com.example.apartementapi.service;

import com.example.apartementapi.model.History;
import com.example.apartementapi.model.House;
import com.example.apartementapi.repository.HistoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class HistoryService {
    HistoryRepository historyRepository;

    public Page<History> getAllHistory(int page, int pageSize){
        Pageable pageable = PageRequest.of(page - 1, pageSize);
        return historyRepository.findAll(pageable);
    }

    public String deleteAllHistory() {
        historyRepository.deleteAll();
        return "Clean Succeful";
    }
}
