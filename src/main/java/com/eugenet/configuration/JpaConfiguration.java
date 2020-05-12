package com.eugenet.configuration;

import static java.util.stream.Collectors.toMap;

import com.eugenet.converter.DbPerTenantDtoToDataSourceConverter;
import com.eugenet.routing.TenantAwareRoutingService;
import com.eugenet.tms.service.TenantInitializationService;
import java.util.Map;
import java.util.Map.Entry;
import javax.sql.DataSource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

@RequiredArgsConstructor
public class JpaConfiguration {

    private final TenantInitializationService initializationService;

    private final DbPerTenantDtoToDataSourceConverter converter;

    @Bean
    public DataSource dataSource() {
        AbstractRoutingDataSource dataSource = new TenantAwareRoutingService();

        Map<Object, Object> targetDataSources
                = initializationService.getDataSourcesByTenant()
                                       .entrySet()
                                       .stream()
                                       .collect(toMap(Entry::getKey, e -> converter.convert(e.getValue())));

        dataSource.setTargetDataSources(targetDataSources);

        dataSource.afterPropertiesSet();

        return dataSource;
    }
}
