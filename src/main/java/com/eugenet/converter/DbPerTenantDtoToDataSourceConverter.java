package com.eugenet.converter;

import com.eugenet.tms.dto.DbPerTenantDto;
import javax.sql.DataSource;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;

public class DbPerTenantDtoToDataSourceConverter {

    public DataSource convert(DbPerTenantDto dto) {
        return DataSourceBuilder.create()
                                .driverClassName(dto.getDriverClassName())
                                .username(dto.getUserName())
                                .password(dto.getUserPassword())
                                .url(dto.getUrl())
                                .build();
    }
}
