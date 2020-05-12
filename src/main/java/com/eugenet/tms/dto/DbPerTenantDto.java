package com.eugenet.tms.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DbPerTenantDto {

    private String url;
    private String userName;
    private String userPassword;
    private String driverClassName;
    private boolean active;

}
