package com.example.add2num.controllers;

import com.example.add2num.services.Add2NumService;
import com.example.add2num.dto.ApiResponse;
import com.example.add2num.dto.request.Add2NumRequest;
import com.example.add2num.dto.response.Add2NumResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class Add2NumController {
    Add2NumService add2NumService;


    @PostMapping("/sum")
    ApiResponse<Add2NumResponse> calc(@RequestBody Add2NumRequest request){
        return ApiResponse.<Add2NumResponse>builder()
                .result(add2NumService.calculate(request))
                .build();

    }
}
