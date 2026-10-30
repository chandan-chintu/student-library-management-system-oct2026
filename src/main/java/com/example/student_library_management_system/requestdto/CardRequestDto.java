package com.example.student_library_management_system.requestdto;

import lombok.Data;

@Data
public class CardRequestDto {

    private String cardStatus;
    private String expiryDate;

    private Long studentId;
}
