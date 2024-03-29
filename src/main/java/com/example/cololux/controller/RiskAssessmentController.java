package com.example.cololux.controller;


import com.example.cololux.dto.RiskAssessmentDto;
import com.example.cololux.entity.RiskAssessment;
import com.example.cololux.respository.RiskAssessmentRepository;
import com.example.cololux.service.RiskAssessmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class RiskAssessmentController {

    @Autowired
    private RiskAssessmentService riskAssessmentService;

    @Autowired
    private RiskAssessmentRepository riskAssessmentRepository;
    @GetMapping("/get/risk-assessment")
    public List<RiskAssessment> getRiskAssessment() {
        return riskAssessmentRepository.findAll();
    }

    @PostMapping("/create/rickAssessment")
    public ResponseEntity<RiskAssessmentDto> createRisk(@RequestBody RiskAssessmentDto riskAssessmentDto) {
        RiskAssessmentDto aDto = riskAssessmentService.saveRiskAssessment(riskAssessmentDto);
        return new ResponseEntity<>(aDto, HttpStatus.OK);
    }
}
