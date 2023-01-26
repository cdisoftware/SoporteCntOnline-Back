package com.cdi.ServicesFeNe.Services;

import com.cdi.ServicesFeNe.Entity.PaConsFacPendientePdfXmlEntity;
import java.util.List;

public interface PaConsFacPendientePdfXmlService {
    public List<PaConsFacPendientePdfXmlEntity> ConsDocumentosPendientes(String NitEmpresa,String NitCliente,String NumeroFactura);
}
