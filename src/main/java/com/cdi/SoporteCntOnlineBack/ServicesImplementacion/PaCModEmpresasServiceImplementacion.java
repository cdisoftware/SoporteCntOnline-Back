package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.PaCModEmpresasEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.PaLogConsolaService;
import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cdi.SoporteCntOnlineBack.Services.PaCModEmpresasService;

@Service
public class PaCModEmpresasServiceImplementacion implements PaCModEmpresasService {

    @PersistenceContext
    private EntityManager repositorio;

    @Autowired
    private PaLogConsolaService service;

    public String ModEmpresa(PaCModEmpresasEntity entidad, Integer Bandera) {
        try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("IdCol", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nombre", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Departamento", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Ciudad", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Direccion", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Email", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Telefono", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NombreSoft", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("TipoPersona", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Regimen", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodPais", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodDepto", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NumMatMercantil", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas53", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas54", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NitCodVer", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodMuni", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NomPais", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodPostal", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ActEco", String.class, ParameterMode.IN);

            modempresa.registerStoredProcedureParameter("NumResolucion", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Contrasena", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Prefijo", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoD", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoH", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoFecIni", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoFecFin", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoNC", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNCD", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNCH", String.class, ParameterMode.IN);

            modempresa.registerStoredProcedureParameter("PrefijoNE", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNED", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNEH", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ContrasenaNE", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoNA", String.class, ParameterMode.IN);

            modempresa.registerStoredProcedureParameter("NumResolucionDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoDS_D", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoDS_H", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("FechaInicioDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("FechaFinDS", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", Bandera);
            modempresa.setParameter("IdCol", entidad.getIdCol());
            modempresa.setParameter("Nombre", entidad.getNombre());
            modempresa.setParameter("Nit", entidad.getNit());
            modempresa.setParameter("Departamento", entidad.getDepartamento());
            modempresa.setParameter("Ciudad", entidad.getCiudad());
            modempresa.setParameter("Direccion", entidad.getDireccion());
            modempresa.setParameter("Email", entidad.getEmail());
            modempresa.setParameter("Telefono", entidad.getTelefono());
            modempresa.setParameter("NombreSoft", entidad.getNombreSoft());
            modempresa.setParameter("TipoPersona", entidad.getTipoPersona());
            modempresa.setParameter("Regimen", entidad.getRegimen());
            modempresa.setParameter("CodPais", entidad.getCodPais());
            modempresa.setParameter("CodDepto", entidad.getCodDepto());
            modempresa.setParameter("NumMatMercantil", entidad.getNumMatMercantil());
            modempresa.setParameter("ValCas53", entidad.getValCas53());
            modempresa.setParameter("ValCas54", entidad.getValCas54());
            modempresa.setParameter("NitCodVer", entidad.getNitCodVer());
            modempresa.setParameter("CodMuni", entidad.getCodMuni());
            modempresa.setParameter("NomPais", entidad.getNomPais());
            modempresa.setParameter("CodPostal", entidad.getCodPostal());
            modempresa.setParameter("ActEco", entidad.getActEco());

            modempresa.setParameter("NumResolucion", entidad.getNumResolucion());
            modempresa.setParameter("Usuario", entidad.getUsuario());
            modempresa.setParameter("Contrasena", entidad.getContrasena());
            modempresa.setParameter("Prefijo", entidad.getPrefijo());
            modempresa.setParameter("RangoD", entidad.getRangoD());
            modempresa.setParameter("RangoH", entidad.getRangoH());
            modempresa.setParameter("RangoFecIni", entidad.getRangoFecIni());
            modempresa.setParameter("RangoFecFin", entidad.getRangoFecFin());
            modempresa.setParameter("PrefijoNC", entidad.getPrefijoNC());
            modempresa.setParameter("RangoNCD", entidad.getRangoNCD());
            modempresa.setParameter("RangoNCH", entidad.getRangoNCH());

            modempresa.setParameter("PrefijoNE", entidad.getPrefijoNE());
            modempresa.setParameter("RangoNED", entidad.getRangoNED());
            modempresa.setParameter("RangoNEH", entidad.getRangoNEH());
            modempresa.setParameter("ContrasenaNE", entidad.getContrasenaNE());
            modempresa.setParameter("PrefijoNA", entidad.getPrefijoNA());

            modempresa.setParameter("NumResolucionDS", entidad.getNumResolucionDS());
            modempresa.setParameter("PrefijoDS", entidad.getPrefijoDS());
            modempresa.setParameter("RangoDS_D", entidad.getRangoDS_D());
            modempresa.setParameter("RangoDS_H", entidad.getRangoDS_H());
            modempresa.setParameter("FechaInicioDS", entidad.getFechaInicioDS());
            modempresa.setParameter("FechaFinDS", entidad.getFechaFinDS());

            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }

    @Override
    public String InsertEmpresa(PaCModEmpresasEntity entidad) {
        try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("IdCol", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nombre", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Departamento", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Ciudad", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Direccion", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Email", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Telefono", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NombreSoft", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("TipoPersona", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Regimen", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodPais", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodDepto", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NumMatMercantil", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas53", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas54", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NitCodVer", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodMuni", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NomPais", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodPostal", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ActEco", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", 1);
            modempresa.setParameter("IdCol", entidad.getIdCol());
            modempresa.setParameter("Nombre", entidad.getNombre());
            modempresa.setParameter("Nit", entidad.getNit());
            modempresa.setParameter("Departamento", entidad.getDepartamento());
            modempresa.setParameter("Ciudad", entidad.getCiudad());
            modempresa.setParameter("Direccion", entidad.getDireccion());
            modempresa.setParameter("Email", entidad.getEmail());
            modempresa.setParameter("Telefono", entidad.getTelefono());
            modempresa.setParameter("NombreSoft", entidad.getNombreSoft());
            modempresa.setParameter("TipoPersona", entidad.getTipoPersona());
            modempresa.setParameter("Regimen", entidad.getRegimen());
            modempresa.setParameter("CodPais", entidad.getCodPais());
            modempresa.setParameter("CodDepto", entidad.getCodDepto());
            modempresa.setParameter("NumMatMercantil", entidad.getNumMatMercantil());
            modempresa.setParameter("ValCas53", entidad.getValCas53());
            modempresa.setParameter("ValCas54", entidad.getValCas54());
            modempresa.setParameter("NitCodVer", entidad.getNitCodVer());
            modempresa.setParameter("CodMuni", entidad.getCodMuni());
            modempresa.setParameter("NomPais", entidad.getNomPais());
            modempresa.setParameter("CodPostal", entidad.getCodPostal());
            modempresa.setParameter("ActEco", entidad.getActEco());

            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas Insert Empresa");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }

    @Override
    public String UpdateEmpresa(PaCModEmpresasEntity entidad) {
      try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nombre", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Departamento", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Ciudad", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Direccion", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Email", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Telefono", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("TipoPersona", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Regimen", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NumMatMercantil", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas53", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ValCas54", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NitCodVer", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("CodPostal", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ActEco", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", 2);
            modempresa.setParameter("Nombre", entidad.getNombre());
            modempresa.setParameter("Departamento", entidad.getDepartamento());
            modempresa.setParameter("Ciudad", entidad.getCiudad());
            modempresa.setParameter("Direccion", entidad.getDireccion());
            modempresa.setParameter("Email", entidad.getEmail());
            modempresa.setParameter("Telefono", entidad.getTelefono());
            modempresa.setParameter("TipoPersona", entidad.getTipoPersona());
            modempresa.setParameter("Regimen", entidad.getRegimen());
            modempresa.setParameter("NumMatMercantil", entidad.getNumMatMercantil());
            modempresa.setParameter("ValCas53", entidad.getValCas53());
            modempresa.setParameter("ValCas54", entidad.getValCas54());
            modempresa.setParameter("NitCodVer", entidad.getNitCodVer());
            modempresa.setParameter("CodPostal", entidad.getCodPostal());
            modempresa.setParameter("ActEco", entidad.getActEco());
            modempresa.setParameter("Nit", entidad.getNit());

            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas updateEmpresa");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }   
    }

    @Override
    public String ActFE(PaCModEmpresasEntity entidad) {
       try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NumResolucion", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Contrasena", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Prefijo", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoD", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoH", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoFecIni", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoFecFin", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoNC", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNCD", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNCH", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", 3);
            modempresa.setParameter("NumResolucion", entidad.getNumResolucion());
            modempresa.setParameter("Usuario", entidad.getUsuario());
            modempresa.setParameter("Contrasena", entidad.getContrasena());
            modempresa.setParameter("Prefijo", entidad.getPrefijo());
            modempresa.setParameter("RangoD", entidad.getRangoD());
            modempresa.setParameter("RangoH", entidad.getRangoH());
            modempresa.setParameter("RangoFecIni", entidad.getRangoFecIni());
            modempresa.setParameter("RangoFecFin", entidad.getRangoFecFin());
            modempresa.setParameter("PrefijoNC", entidad.getPrefijoNC());
            modempresa.setParameter("RangoNCD", entidad.getRangoNCD());
            modempresa.setParameter("RangoNCH", entidad.getRangoNCH());
            modempresa.setParameter("Nit", entidad.getNit());
            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas ActivacionFE");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        } 
    }

    @Override
    public String ActNE(PaCModEmpresasEntity entidad) {
        try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoNE", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNED", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoNEH", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("ContrasenaNE", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoNA", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", 4);
            modempresa.setParameter("PrefijoNE", entidad.getPrefijoNE());
            modempresa.setParameter("RangoNED", entidad.getRangoNED());
            modempresa.setParameter("RangoNEH", entidad.getRangoNEH());
            modempresa.setParameter("ContrasenaNE", entidad.getContrasenaNE());
            modempresa.setParameter("PrefijoNA", entidad.getPrefijoNA());
            modempresa.setParameter("Nit", entidad.getNit());

            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas ActivacionDSNE");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }

    @Override
    public String ActDS(PaCModEmpresasEntity entidad) {
       try {
            StoredProcedureQuery modempresa = repositorio.createNamedStoredProcedureQuery("PaCModEmpresas");
            modempresa.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("NumResolucionDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("PrefijoDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoDS_D", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("RangoDS_H", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("FechaInicioDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("FechaFinDS", String.class, ParameterMode.IN);
            modempresa.registerStoredProcedureParameter("Nit", String.class, ParameterMode.IN);

            modempresa.setParameter("Bandera", 5);
            modempresa.setParameter("NumResolucionDS", entidad.getNumResolucionDS());
            modempresa.setParameter("PrefijoDS", entidad.getPrefijoDS());
            modempresa.setParameter("RangoDS_D", entidad.getRangoDS_D());
            modempresa.setParameter("RangoDS_H", entidad.getRangoDS_H());
            modempresa.setParameter("FechaInicioDS", entidad.getFechaInicioDS());
            modempresa.setParameter("FechaFinDS", entidad.getFechaFinDS());
            modempresa.setParameter("Nit", entidad.getNit());

            modempresa.execute();
            return JSONObject.quote((String) modempresa.getOutputParameterValue("Respuesta"));
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("PaCModEmpresas ActivacionDS");
            entidadLog.setTipo("Error");
            entidadLog.setMensaje(ex.getMessage());
            entidadLog.setIdUser(0);
            service.InserLog(entidadLog, 1);

            return JSONObject.quote("No fue posible ejecutar los datos, verifique el Log para validar la inconsistencia");
        }
    }

}
