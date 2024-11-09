package com.yazilimsokagi.YazilimSokagiBackend.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponseDTO {

    private int code;
    private String message;

}
