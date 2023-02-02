package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaConsultaEmpresasEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaConsultaEmpresasService;
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
public class PaConsultaEmpresasServiceImplementacion implements PaConsultaEmpresasService{
    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<PaConsultaEmpresasEntity> ConsEmpresas(String Nit, Integer IdCol, String Nombre) {
        try {
            StoredProcedureQuery consempresas = repositorio.createNamedStoredProcedureQuery("PaConsultaEmpresas");
            consempresas.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);
            consempresas.registerStoredProcedureParameter("IdCol", Integer.class, ParameterMode.IN);
            consempresas.registerStoredProcedureParameter("Nombre", String.class, ParameterMode.IN);
            
            consempresas.setParameter("Nit", Nit);
            consempresas.setParameter("IdCol", IdCol);
            consempresas.setParameter("Nombre", Nombre);
            return consempresas.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaConsultaEmpresas");
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
