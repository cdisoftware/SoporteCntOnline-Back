package com.cdi.SoporteCntOnlineBack.Services;

import com.cdi.SoporteCntOnlineBack.Entity.PaCModEmpresasEntity;

public interface PaCModEmpresasService {
    public String InsertEmpresa(PaCModEmpresasEntity entidad);    
    public String UpdateEmpresa(PaCModEmpresasEntity entidad);
    public String ActFE(PaCModEmpresasEntity entidad);
    public String ActNE(PaCModEmpresasEntity entidad);
    public String ActDS(PaCModEmpresasEntity entidad);

}
