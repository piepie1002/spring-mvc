package com.pie.mvc.dto;

import lombok.Data;

import java.util.List;

/**
 * @author LIN
 * @since JDK 1.8
 */
@Data
public class UserDto {
    private Integer id;
    private String username;
    private AddressDto address;
    private List<AddressDto>list;
}
