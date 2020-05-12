package com.eugenet.tms.api;

import com.eugenet.tms.dto.TenantDto;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "TenantEndpoint", url = "${tenant-connection-resolver.url}")
public interface TenantEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    List<TenantDto> getAllTenants();
}
