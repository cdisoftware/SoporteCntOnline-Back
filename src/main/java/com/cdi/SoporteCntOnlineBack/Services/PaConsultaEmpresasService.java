package com.cdi.SoporteCntOnlineBack.Services;

import com.cdi.SoporteCntOnlineBack.Entity.PaConsultaEmpresasEntity;
import java.util.List;

public interface PaConsultaEmpresasService {
    public List<PaConsultaEmpresasEntity> ConsEmpresas(String Nit, Integer IdCol, String Nombre);
}
