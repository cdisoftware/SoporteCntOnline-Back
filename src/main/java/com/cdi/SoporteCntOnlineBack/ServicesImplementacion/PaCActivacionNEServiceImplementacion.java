package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCActivacionNEEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCActivacionNEService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaCActivacionNEServiceImplementacion implements PaCActivacionNEService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public String ActivacionNominaElectronica(PaCActivacionNEEntity entidad) {
        try {
            StoredProcedureQuery ActivacionNE = repositorio.createNamedStoredProcedureQuery("PaCActivacionNE");
            ActivacionNE.registerStoredProcedureParameter("PrefijoNE", String.class, ParameterMode.IN);
            ActivacionNE.registerStoredProcedureParameter("RangoNED", String.class, ParameterMode.IN);
            ActivacionNE.registerStoredProcedureParameter("RangoNEH", String.class, ParameterMode.IN);
            ActivacionNE.registerStoredProcedureParameter("ContrasenaNE", String.class, ParameterMode.IN);
            ActivacionNE.registerStoredProcedureParameter("PrefijoNA", String.class, ParameterMode.IN);
            ActivacionNE.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            ActivacionNE.setParameter("PrefijoNE", entidad.getPrefijoNE());
            ActivacionNE.setParameter("RangoNED", entidad.getRangoNED());
            ActivacionNE.setParameter("RangoNEH", entidad.getRangoNEH());
            ActivacionNE.setParameter("ContrasenaNE", entidad.getContrasenaNE());
            ActivacionNE.setParameter("PrefijoNA", entidad.getPrefijoNA());
            ActivacionNE.setParameter("Nit", entidad.getNit());

            ActivacionNE.execute();
            return JSONObject.quote((String) ActivacionNE.getOutputParameterValue("Respuesta"));
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
