package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCActivacionFEEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaCActivacionFEService;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class PaCActivacionFEServiceImplementacion implements PaCActivacionFEService{
    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    @Override
    public String ActivacionFacturacion(PaCActivacionFEEntity entidad) {
        try {
            StoredProcedureQuery ActivacionFE = repositorio.createNamedStoredProcedureQuery("PaCActivacionFE");
            ActivacionFE.registerStoredProcedureParameter("NumResolucion", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("Contrasena", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("Prefijo", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoD", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoH", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoFecIni", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoFecFin", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("PrefijoNC", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoNCD", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("RangoNCH", String.class, ParameterMode.IN);
            ActivacionFE.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            ActivacionFE.setParameter("NumResolucion", entidad.getNumResolucion());
            ActivacionFE.setParameter("Usuario", entidad.getUsuario());
            ActivacionFE.setParameter("Contrasena", entidad.getContrasena());
            ActivacionFE.setParameter("Prefijo", entidad.getPrefijo());
            ActivacionFE.setParameter("RangoD", entidad.getRangoD());
            ActivacionFE.setParameter("RangoH", entidad.getRangoH());
            ActivacionFE.setParameter("RangoFecIni", entidad.getRangoFecIni());
            ActivacionFE.setParameter("RangoFecFin", entidad.getRangoFecFin());
            ActivacionFE.setParameter("PrefijoNC", entidad.getPrefijoNC());
            ActivacionFE.setParameter("RangoNCD", entidad.getRangoNCD());
            ActivacionFE.setParameter("RangoNCH", entidad.getRangoNCH());
            ActivacionFE.setParameter("Nit", entidad.getNit());

            ActivacionFE.execute();
            return JSONObject.quote((String) ActivacionFE.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCActivacionFE Activacion Facturacion");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }
}
