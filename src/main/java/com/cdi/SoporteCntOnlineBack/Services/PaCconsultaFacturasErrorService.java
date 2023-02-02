package com.cdi.SoporteCntOnlineBack.Services;

import com.cdi.SoporteCntOnlineBack.Entity.PaCconsultaFacturasErrorEntity;
import java.util.List;

public interface PaCconsultaFacturasErrorService {

    public List<PaCconsultaFacturasErrorEntity> ConsErrorFac(Integer NumeroFactura, Integer IdCol, String NitEmpresa, String Prefijo);
}
