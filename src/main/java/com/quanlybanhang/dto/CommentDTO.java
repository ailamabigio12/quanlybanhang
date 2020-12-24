package com.quanlybanhang.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO extends AbstractDTO {

    @NotBlank
    @Size(min = 1, max = 255)
    private String name;

    private Integer phoneNumber;

    private String email;

    @NotBlank
    private String content;

    private Long itemId;

    @NotBlank
    private ItemDTO item;
}
