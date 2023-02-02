package com.cdi.SoporteCntOnlineBack.ServicesImplementacion;

import com.cdi.SoporteCntOnlineBack.Entity.ConsultaInfoUserEntity;
import com.cdi.SoporteCntOnlineBack.Entity.PaLogConsolaEntity;
import com.cdi.SoporteCntOnlineBack.Services.ConsultaInfoUserService;
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
public class ConsultaInfoUserServiceImplementacion implements ConsultaInfoUserService {

    @PersistenceContext
    private EntityManager repositorio;
    
    @Autowired
    private PaLogConsolaService service;

    @Override
    public List<ConsultaInfoUserEntity> ConUser(ConsultaInfoUserEntity entidad, Integer Bandera) {
        try {
            StoredProcedureQuery InfoUser = repositorio.createNamedStoredProcedureQuery("ConsultaInfoUser");
            InfoUser.registerStoredProcedureParameter("Bandera", Integer.class, ParameterMode.IN);
            InfoUser.registerStoredProcedureParameter("Usuario", String.class, ParameterMode.IN);
            InfoUser.registerStoredProcedureParameter("Pasword", String.class, ParameterMode.IN);

            InfoUser.setParameter("Bandera", Bandera);
            InfoUser.setParameter("Usuario", entidad.getUsuario());
            InfoUser.setParameter("Pasword", entidad.getPasword());

            return InfoUser.getResultList();
        } catch (Exception ex) {
            PaLogConsolaEntity entidadLog = new PaLogConsolaEntity();
            entidadLog.setComponente("ConsultaInfoUser");
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
