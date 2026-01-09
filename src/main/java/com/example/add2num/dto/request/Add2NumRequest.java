package com.example.add2num.dto.request;

import lombok.*;
import lombok.experimental.FieldDefaults;

@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Add2NumRequest {
    String stn1;
    String stn2;
}
