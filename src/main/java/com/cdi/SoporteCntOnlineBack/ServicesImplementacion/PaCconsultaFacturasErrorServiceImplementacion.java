package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCconsultaFacturasErrorEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCconsultaFacturasErrorService;
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
public class PaCconsultaFacturasErrorServiceImplementacion implements PaCconsultaFacturasErrorService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<PaCconsultaFacturasErrorEntity> ConsErrorFac(Integer NumeroFactura, Integer IdCol, String NitEmpresa, String Prefijo) {
        try {
            StoredProcedureQuery conxmlpdf = repositorio.createNamedStoredProcedureQuery("PaCconsultaFacturasError");
            conxmlpdf.registerStoredProcedureParameter("NumeroFactura", Integer.class, ParameterMode.IN);
            conxmlpdf.registerStoredProcedureParameter("IdCol", Integer.class, ParameterMode.IN);
            conxmlpdf.registerStoredProcedureParameter("NitEmpresa", String.class, ParameterMode.IN);
            conxmlpdf.registerStoredProcedureParameter("Prefijo", String.class, ParameterMode.IN);

            conxmlpdf.setParameter("NumeroFactura", NumeroFactura);
            conxmlpdf.setParameter("IdCol", IdCol);
            conxmlpdf.setParameter("NitEmpresa", NitEmpresa);
            conxmlpdf.setParameter("Prefijo", Prefijo);
            return conxmlpdf.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCconsultaFacturasError");
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
