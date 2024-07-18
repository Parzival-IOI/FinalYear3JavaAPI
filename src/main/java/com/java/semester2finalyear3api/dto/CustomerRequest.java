package com.java.semester2finalyear3api.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class CustomerRequest {
    private String firstname;
    private String lastname;
    private String phone;
}
