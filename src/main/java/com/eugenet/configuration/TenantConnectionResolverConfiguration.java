package com.eugenet.configuration;

import com.eugenet.converter.DbPerTenantDtoToDataSourceConverter;
import com.eugenet.tms.api.TenantEndpoint;
import com.eugenet.tms.service.TenantInitializationService;
import com.eugenet.web.TenantRequestInterceptor;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@EnableFeignClients(clients = TenantEndpoint.class)
@Import(value = {JpaConfiguration.class, TenantConnectionResolverWebMvcConfigurer.class})
public class TenantConnectionResolverConfiguration {

    @Bean
    public DbPerTenantDtoToDataSourceConverter converter() {
        return new DbPerTenantDtoToDataSourceConverter();
    }

    @Bean
    public TenantInitializationService initializationService(TenantEndpoint endpoint) {
        return new TenantInitializationService(endpoint);
    }

    @Bean
    public TenantRequestInterceptor requestInterceptor() {
        return new TenantRequestInterceptor();
    }
}
