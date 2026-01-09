package com.example.add2num.services;

import add2Num.MyBigNumber;
import com.example.add2num.dto.request.Add2NumRequest;
import com.example.add2num.dto.response.Add2NumResponse;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class Add2NumService {
    MyBigNumber myBigNumber;

    public Add2NumResponse calculate(Add2NumRequest request){

        String result = myBigNumber.sum(request.getStn1(), request.getStn2());

        return  Add2NumResponse.builder()
                .result(result)
                .step(myBigNumber.getStore())
                .build();
    }
}
