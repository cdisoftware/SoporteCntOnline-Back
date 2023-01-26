package com.cdi.ServicesFeNe.Controller;

import com.cdi.ServicesFeNe.Entity.EnvioSmsItCloudEntity;
import com.cdi.ServicesFeNe.Entity.PaConsFacPendientePdfXmlEntity;
import com.cdi.ServicesFeNe.Services.EnvioSmsItCloudServices;
import com.cdi.ServicesFeNe.Services.PaConsFacPendientePdfXmlService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    
    @Autowired
    PaConsFacPendientePdfXmlService servicePaConsFacPendientePdfXmlService;
    
    
    @PostMapping("/enviosmsitcloud")
    public String EnvioSms(
            @RequestBody EnvioSmsItCloudEntity entidad) {
        return serviceEnvioSmsItCloudServices.EnvioSms(entidad);
    }
    
    @GetMapping("/consPdfXmlPendientes/{NitEmpresa}/{NitCliente}/{NumeroFactura}")
    public List<PaConsFacPendientePdfXmlEntity> ConsultaXmlPdfPend(
            @PathVariable String NitEmpresa,
            @PathVariable String NitCliente,
            @PathVariable String NumeroFactura) {
        return servicePaConsFacPendientePdfXmlService.ConsDocumentosPendientes(NitEmpresa, NitCliente, NumeroFactura);
    }
}
