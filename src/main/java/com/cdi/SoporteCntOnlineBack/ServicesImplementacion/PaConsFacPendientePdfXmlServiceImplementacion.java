package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaConsFacPendientePdfXmlEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaConsFacPendientePdfXmlService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaConsFacPendientePdfXmlServiceImplementacion implements PaConsFacPendientePdfXmlService{
    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;
    
    @Override
    public List<PaConsFacPendientePdfXmlEntity> ConsDocumentosPendientes(String NitEmpresa, String NitCliente, String NumeroFactura) {
        try {
            StoredProcedureQuery conxmlpdf = repositorio.createNamedStoredProcedureQuery("PaConsFacPendientePdfXml");
            conxmlpdf.registerStoredProcedureParameter("NitEmpresa", String.class, ParameterMode.IN);
            conxmlpdf.registerStoredProcedureParameter("NitCliente", String.class, ParameterMode.IN);
            conxmlpdf.registerStoredProcedureParameter("NumeroFactura", String.class, ParameterMode.IN);
            
            conxmlpdf.setParameter("NitEmpresa", NitEmpresa);
            conxmlpdf.setParameter("NitCliente", NitCliente);
            conxmlpdf.setParameter("NumeroFactura", NumeroFactura);
            return conxmlpdf.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaConsFacPendientePdfXml");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);
            
            List list = new ArrayList();
            list.add(0, JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia"));
            return list;
        }
    }
}
