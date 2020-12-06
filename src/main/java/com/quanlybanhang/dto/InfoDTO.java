package com.quanlybanhang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InfoDTO extends AbstractDTO {

    @NotBlank
    private String company;

    private float weight;

    @NotBlank
    private Integer romPhone;

    @NotBlank
    private Integer ramPhone;

    @NotBlank
    private float screenSize;

    @NotBlank
    private String systemVersion;

    private String chipset;

    private Integer pinPhone;

    private Long itemid;
}
