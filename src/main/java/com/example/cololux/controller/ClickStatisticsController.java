package com.example.cololux.controller;


import com.example.cololux.dto.ClickStatisticsDto;
import com.example.cololux.entity.ClickStatistics;
import com.example.cololux.respository.ClickStatisticsRepository;
import com.example.cololux.service.ClickStatisticsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ClickStatisticsController {
    @Autowired
    private ClickStatisticsService clickStatisticsService;

    @Autowired
    private ClickStatisticsRepository clickStatisticsRepository;

    @PostMapping("/click")
    public ResponseEntity<ClickStatisticsDto> clickStatistics(@RequestBody ClickStatisticsDto clickStatisticsDto) {
        ClickStatisticsDto aDto = clickStatisticsService.saveOrUpdateClick(clickStatisticsDto);
        return new ResponseEntity<>(aDto, HttpStatus.OK);
    }

    @GetMapping("/getClick")
    public List<ClickStatistics> getClickStatistics() {
        return clickStatisticsRepository.findAll();
    }
}
