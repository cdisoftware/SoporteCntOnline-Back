package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCdepartamentosEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCdepartamentosService;
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
public class PaCdepartamentosServiceImplementacion implements PaCdepartamentosService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<PaCdepartamentosEntity> ConsDepartamento(String CodPais) {
        try {
            StoredProcedureQuery condepartamentos = repositorio.createNamedStoredProcedureQuery("PaCdepartamentos");
            condepartamentos.registerStoredProcedureParameter("CodPais", String.class, ParameterMode.IN);
            
            condepartamentos.setParameter("CodPais", CodPais);
            return condepartamentos.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCdepartamentos");
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
