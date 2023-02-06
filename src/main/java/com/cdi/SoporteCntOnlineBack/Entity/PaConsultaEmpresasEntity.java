package com.cdi.SoporteCntOnlineBack.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedStoredProcedureQueries;
import javax.persistence.NamedStoredProcedureQuery;
import lombok.Data;

@Entity
@Data
@NamedStoredProcedureQueries({
    @NamedStoredProcedureQuery(
            name = "PaConsultaEmpresas",
            procedureName = "PaConsultaEmpresas",
            resultClasses = PaConsultaEmpresasEntity.class)
})
public class PaConsultaEmpresasEntity {

    @Id
    @JsonProperty("Nit")
    public String Nit;
    
    @JsonProperty("Nombre")
    public String Nombre;
    
    @JsonProperty("Departamento")
    public String Departamento;
    
    @JsonProperty("Ciudad")
    public String Ciudad;
    
    @JsonProperty("Direccion")
    public String Direccion;
    
    @JsonProperty("Email")
    public String Email;
    
    @JsonProperty("Telefono")
    public String Telefono;
    
    @JsonProperty("NumResolucion")
    public String NumResolucion;
    
    @JsonProperty("Usuario")
    public String Usuario;
    
    @JsonProperty("Contrasena")
    public String Contrasena;
    
    @JsonProperty("Prefijo")
    public String Prefijo;
    
    @JsonProperty("RangoD")
    public String RangoD;
    
    @JsonProperty("RangoH")
    public String RangoH;
    
    @JsonProperty("RangoFecIni")
    public String RangoFecIni;
    
    @JsonProperty("RangoFecFin")
    public String RangoFecFin;
    
    @JsonProperty("TipoPersona")
    public String TipoPersona;
    
    @JsonProperty("Regimen")
    public String Regimen;
    
    @JsonProperty("CodPais")
    public String CodPais;
    
    @JsonProperty("CodDepto")
    public String CodDepto;
    
    @JsonProperty("NumMatMercantil")
    public String NumMatMercantil;
    
    @JsonProperty("ValCas53")
    public String ValCas53;
    
    @JsonProperty("ValCas54")
    public String ValCas54;
    
    @JsonProperty("PrefijoNC")
    public String PrefijoNC;
    
    @JsonProperty("RangoNCD")
    public String RangoNCD;
    
    @JsonProperty("RangoNCH")
    public String RangoNCH;
    
    @JsonProperty("NitCodVer")
    public String NitCodVer;
    
    @JsonProperty("CodMuni")
    public String CodMuni;
    
    @JsonProperty("NomPais")
    public String NomPais;
    
    @JsonProperty("CodPostal")
    public String CodPostal;
    
    @JsonProperty("ActEco")
    public String ActEco;
    
    @JsonProperty("PrefijoNE")
    public String PrefijoNE;
    
    @JsonProperty("RangoNED")
    public String RangoNED;
    
    @JsonProperty("RangoNEH")
    public String RangoNEH;
    
    @JsonProperty("ContrasenaNE")
    public String ContrasenaNE;
    
    @JsonProperty("PrefijoNA")
    public String PrefijoNA;
    
    @JsonProperty("NumResolucionDS")
    public String NumResolucionDS;
    
    @JsonProperty("PrefijoDS")
    public String PrefijoDS;
    
    @JsonProperty("RangoDS_D")
    public String RangoDS_D;
    
    @JsonProperty("RangoDS_H")
    public String RangoDS_H;
    
    @JsonProperty("FechaInicioDS")
    public String FechaInicioDS;
    
    @JsonProperty("FechaFinDS")
    public String FechaFinDS;
}
