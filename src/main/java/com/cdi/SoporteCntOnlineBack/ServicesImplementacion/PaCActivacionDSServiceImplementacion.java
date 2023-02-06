package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCActivacionDSEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCActivacionDSService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaCActivacionDSServiceImplementacion implements PaCActivacionDSService{
    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public String ActivacionDocumento(PaCActivacionDSEntity entidad) {
        try {
            StoredProcedureQuery ActivacionDS = repositorio.createNamedStoredProcedureQuery("PaCActivacionDS");
            ActivacionDS.registerStoredProcedureParameter("NumResolucionDS", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("PrefijoDS", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("RangoDS_D", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("RangoDS_H", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("FechaInicioDS", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("FechaFinDS", String.class, ParameterMode.IN);
            ActivacionDS.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            ActivacionDS.setParameter("NumResolucionDS", entidad.getRangoDS_D());
            ActivacionDS.setParameter("PrefijoDS", entidad.getPrefijoDS());
            ActivacionDS.setParameter("RangoDS_D", entidad.getRangoDS_D());
            ActivacionDS.setParameter("RangoDS_H", entidad.getRangoDS_H());
            ActivacionDS.setParameter("FechaInicioDS", entidad.getFechaInicioDS());
            ActivacionDS.setParameter("FechaFinDS", entidad.getFechaFinDS());
            ActivacionDS.setParameter("Nit", entidad.getNit());

            ActivacionDS.execute();
            return JSONObject.quote((String) ActivacionDS.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCActivacionNE Activacion Nomina electronica");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }
}
