package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaConsultaProyectosSoporteEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaConsultaProyectosSoporteService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaConsultaProyectosSoporteServiceImplementacion implements PaConsultaProyectosSoporteService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<PaConsultaProyectosSoporteEntity> ConsproyectosSoporte() {
        try {
            StoredProcedureQuery conproyectos = repositorio.createNamedStoredProcedureQuery("PaConsultaProyectosSoporte");
            return conproyectos.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaConsultaProyectosSoporte");
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
