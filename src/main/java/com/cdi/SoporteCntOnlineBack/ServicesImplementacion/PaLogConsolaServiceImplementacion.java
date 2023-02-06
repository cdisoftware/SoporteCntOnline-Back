package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.springframework.stereotype.Service;

@Service
public class PaLogConsolaServiceImplementacion implements PaLogConsolaService{
    @PersistenceContext
    private EntityManager repositorio;

    @Override
    public String InserLog(PaLogConsolaEntity entidad, Integer Origen) {
        try {
            StoredProcedureQuery InsertLog = repositorio.createNamedStoredProcedureQuery("PaLogConsola");
            InsertLog.registerStoredProcedureParameter("Componente", String.class, ParameterMode.IN);
            InsertLog.registerStoredProcedureParameter("Tipo", String.class, ParameterMode.IN);
            InsertLog.registerStoredProcedureParameter("Mensaje", String.class, ParameterMode.IN);
            InsertLog.registerStoredProcedureParameter("Origen", Integer.class, ParameterMode.IN);
            InsertLog.registerStoredProcedureParameter("IdUser", Integer.class, ParameterMode.IN);

            InsertLog.setParameter("Componente", entidad.getComponente());
            InsertLog.setParameter("Tipo", entidad.getTipo());
            InsertLog.setParameter("Mensaje", entidad.getMensaje());
            InsertLog.setParameter("Origen", Origen);
            InsertLog.setParameter("IdUser", entidad.getIdUser());

            InsertLog.execute();
            return "Log Insertado";
        } catch (Exception ex) {
            return "Fallo valide su información";
        }
    }
}
