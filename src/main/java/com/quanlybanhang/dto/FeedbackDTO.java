package com.quanlybanhang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FeedbackDTO extends AbstractDTO {

    @NotBlank
    private String fullname;

    @NotBlank
    private Integer phoneNumber;

    @NotBlank
    private String email;

    @NotBlank
    private String content;
}
