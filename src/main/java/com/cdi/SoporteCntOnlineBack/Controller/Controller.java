package com.cdi.SoporteCntOnlineBack.Controller;

import com.cdi.SoporteCntOnlineBack.Entity.ConsultaInfoUserEntity;
import com.cdi.SoporteCntOnlineBack.Entity.EnvioSmsItCloudEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaCModEmpresasEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaCconsultaFacturasErrorEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaConsFacPendientePdfXmlEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaConsultaEmpresasEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaConsultaProyectosSoporteEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.ConsultaInfoUserService;
import com.cdi.SoporteCntOnlineBack.Services.EnvioSmsItCloudServices;
import com.cdi.SoporteCntOnlineBack.Services.PaCconsultaFacturasErrorService;
import com.cdi.SoporteCntOnlineBack.Services.PaConsFacPendientePdfXmlService;
import com.cdi.SoporteCntOnlineBack.Services.PaConsultaEmpresasService;
import com.cdi.SoporteCntOnlineBack.Services.PaConsultaProyectosSoporteService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
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
import com.cdi.SoporteCntOnlineBack.Services.PaCModEmpresasService;


@RestController
@RequestMapping(value = "/", produces = "application/json", method = {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH})
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH, RequestMethod.DELETE})

public class Controller {
    @Autowired
    EnvioSmsItCloudServices serviceEnvioSmsItCloudServices;
    
    @Autowired
    PaConsFacPendientePdfXmlService servicePaConsFacPendientePdfXmlService;
    
    @Autowired
    ConsultaInfoUserService serviceConsultaInfoUserService;
    
    @Autowired
    PaConsultaProyectosSoporteService servicePaConsultaProyectosSoporteService;
    
    @Autowired
    PaLogConsolaService servicePaLogConsolaService;
    
    @Autowired
    PaCModEmpresasService servicePaCModEmpresasService;
    
    @Autowired
    PaConsultaEmpresasService servicePaConsultaEmpresasService;
    
    @Autowired
    PaCconsultaFacturasErrorService servicePaCconsultaFacturasErrorService;
    
    
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
    
    @PostMapping("/ConsInfoUser/{Bandera}")
    public List<ConsultaInfoUserEntity> InfoUser(
            @RequestBody ConsultaInfoUserEntity entidad,
            @PathVariable Integer Bandera) {
        return serviceConsultaInfoUserService.ConUser(entidad, Bandera);
    }
    
    @GetMapping("/consproyectos")
    public List<PaConsultaProyectosSoporteEntity> ConsultaProyectos() {
        return servicePaConsultaProyectosSoporteService.ConsproyectosSoporte();
    }
    
    @PostMapping("/InserLog/{Origen}")
    public String InsertLog(
            @RequestBody PaLogConsolaEntity entidad,
            @PathVariable Integer Origen) {
        return servicePaLogConsolaService.InserLog(entidad, Origen);
    }
    @GetMapping("/consEmpresas/{Nit}/{IdCol}/{Nombre}")
    public List<PaConsultaEmpresasEntity> Consempresas(
            @PathVariable String Nit,
            @PathVariable Integer IdCol,
            @PathVariable String Nombre) {
        return servicePaConsultaEmpresasService.ConsEmpresas(Nit, IdCol, Nombre);
    }
    @GetMapping("/consFacturasErr/{NumeroFactura}/{IdCol}/{NitEmpresa}/{Prefijo}")
    public List<PaCconsultaFacturasErrorEntity> ConsFacturasErr(
            @PathVariable Integer NumeroFactura,
            @PathVariable Integer IdCol,
            @PathVariable String NitEmpresa,
            @PathVariable String Prefijo) {
        return servicePaCconsultaFacturasErrorService.ConsErrorFac(NumeroFactura, IdCol, NitEmpresa, Prefijo);
    }
    
    //Inserta empresa
    @PostMapping("/InsertEmpresa")
    public String InsertEmpresa(
            @RequestBody PaCModEmpresasEntity entidad) {
        return servicePaCModEmpresasService.InsertEmpresa(entidad);
    }
    //Actualiza datos empresa
    @PostMapping("/updateEmpresa")
    public String UpdateEmpresa(
            @RequestBody PaCModEmpresasEntity entidad) {
        return servicePaCModEmpresasService.UpdateEmpresa(entidad);
    }
    //Actualiza datos FacturtacionElectronica
    @PostMapping("/FeModEmpresa")
    public String UpdateFE(
            @RequestBody PaCModEmpresasEntity entidad) {
        return servicePaCModEmpresasService.ActFE(entidad);
    }
    //Actualiza datos Nomina electronica
    @PostMapping("/NeModEmpresa")
    public String UpdateNE(
            @RequestBody PaCModEmpresasEntity entidad) {
        return servicePaCModEmpresasService.ActNE(entidad);
    }
    //Actualiza datos Documento soporte
    @PostMapping("/DsModEmpresa")
    public String UpdateDS(
            @RequestBody PaCModEmpresasEntity entidad) {
        return servicePaCModEmpresasService.ActDS(entidad);
    }
}
