package com.cdi.ServicesFeNe.Controller;

import com.cdi.ServicesFeNe.Entity.EnvioSmsItCloudEntity;
import com.cdi.ServicesFeNe.Services.EnvioSmsItCloudServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(value = "/", produces = "application/json", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})

public class Controller {
    @Autowired
    EnvioSmsItCloudServices serviceEnvioSmsItCloudServices;
    
    
    @PostMapping("/enviosmsitcloud")
    public String EnvioSms(
            @RequestBody EnvioSmsItCloudEntity entidad) {
        return serviceEnvioSmsItCloudServices.EnvioSms(entidad);
    }
}
