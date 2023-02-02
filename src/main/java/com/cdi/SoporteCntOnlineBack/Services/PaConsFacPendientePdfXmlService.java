package com.cdi.SoporteCntOnlineBack.Services;

import com.cdi.SoporteCntOnlineBack.Entity.PaConsFacPendientePdfXmlEntity;
import java.util.List;

public interface PaConsFacPendientePdfXmlService {
    public List<PaConsFacPendientePdfXmlEntity> ConsDocumentosPendientes(String NitEmpresa,String NitCliente,String NumeroFactura);
}
