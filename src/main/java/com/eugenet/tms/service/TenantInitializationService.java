package com.eugenet.tms.service;

import com.eugenet.tms.api.TenantEndpoint;
import com.eugenet.tms.dto.DbPerTenantDto;
import java.util.HashMap;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;

import java.util.Map;

@RequiredArgsConstructor
public class TenantInitializationService {

    private final TenantEndpoint endpoint;

    @Value("${tenant-connection-resolver.db-name}")
    private String dbName;

    public Map<String, DbPerTenantDto> getDataSourcesByTenant() {
        return endpoint.getAllTenants()
                       .stream()
                       .collect(HashMap::new,
                               (m, dto) -> m.put(dto.getTenantId(), dto.getDbPertinentsDto()
                                                                       .stream()
                                                                       .filter(db -> db.getUrl().endsWith(dbName))
                                                                       .findFirst()
                                                                       .orElse(null)), HashMap::putAll);
    }
}
