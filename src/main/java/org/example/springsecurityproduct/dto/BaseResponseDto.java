package org.example.springsecurityproduct.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BaseResponseDto {

    private Object message;
    private Object data;

    public BaseResponseDto(Object message) {
        this.message = message;
    }


}
