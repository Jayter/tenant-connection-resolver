package com.eugenet.tms.dto;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TenantDto {

    private String tenantId;
    private String tenantAlias;
    private String description;
    private boolean active;

    private List<DbPerTenantDto> dbPertinentsDto;
}
