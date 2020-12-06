package com.quanlybanhang.dto;

import java.util.ArrayList;
import java.util.List;
import com.quanlybanhang.entites.ItemEntity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderDTO extends AbstractDTO {

    @NotBlank
    private String fullName;

    @NotBlank
    private Integer phoneNumber;

    @NotBlank
    private String address;

    private String note;

    @NotBlank
    private Integer status;

    private List<ItemDTO> items = new ArrayList<>();
}
