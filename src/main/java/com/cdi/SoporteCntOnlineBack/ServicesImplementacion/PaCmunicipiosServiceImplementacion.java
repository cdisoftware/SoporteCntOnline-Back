package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCmunicipiosEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCmunicipiosService;
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
public class PaCmunicipiosServiceImplementacion implements PaCmunicipiosService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<PaCmunicipiosEntity> ConsMuni(String CodDepartamento) {
        try {
            StoredProcedureQuery consmuni = repositorio.createNamedStoredProcedureQuery("PaCmunicipios");
            consmuni.registerStoredProcedureParameter("CodDepartamento", String.class, ParameterMode.IN);
            
            consmuni.setParameter("CodDepartamento", CodDepartamento);
            return consmuni.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCmunicipios cons");
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
