package com.disco.myfit.controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class MainController {
    @GetMapping("/health-check")
    public ResponseEntity<HttpStatus> healthCheck(HttpServletRequest request){
        return ResponseEntity.ok(HttpStatus.OK);
    }

    /// to-do: 멀티파트폼 이용하여 사진 요청 api 필요
}
