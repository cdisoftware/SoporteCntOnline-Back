package com.cdi.SoporteCntOnlineBack.Services;

import com.cdi.SoporteCntOnlineBack.Entity.ConsultaInfoUserEntity;
import java.util.List;

public interface ConsultaInfoUserService {
    public List<ConsultaInfoUserEntity> ConUser(ConsultaInfoUserEntity entidad, Integer Bandera);
}
