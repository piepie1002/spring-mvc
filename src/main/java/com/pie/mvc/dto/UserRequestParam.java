package com.pie.mvc.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Data
public class UserRequestParam {
    private Integer id;
    private String username;
    private List<AddressDto> list;
}
