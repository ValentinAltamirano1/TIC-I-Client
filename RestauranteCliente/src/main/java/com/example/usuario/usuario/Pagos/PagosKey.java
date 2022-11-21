package com.example.usuario.usuario.Pagos;


import com.example.usuario.usuario.CentrosDeportivos.CentroDeportivo;
import com.example.usuario.usuario.Empresas.Empresa;

import java.io.Serializable;


public class PagosKey implements Serializable {

    private Empresa empresas;


    public Empresa getEmpresas() {
        return empresas;
    }

    public void setEmpresas(Empresa empresas) {
        this.empresas = empresas;
    }

    private CentroDeportivo centrosDeportivos;

    public CentroDeportivo getCentrosDeportivos() {
        return centrosDeportivos;
    }

    public void setCentrosDeportivos(CentroDeportivo centrosDeportivos) {
        this.centrosDeportivos = centrosDeportivos;
    }

    public PagosKey(Empresa empresas, CentroDeportivo centrosDeportivos) {
        this.empresas = empresas;
        this.centrosDeportivos = centrosDeportivos;
    }

    public PagosKey() {

    }
}
