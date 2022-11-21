package com.example.usuario.usuario.Pagos;



public class Pagos {

    private long gasto;

    private PagosKey pagosKey;


    public long getGasto() {
        return gasto;
    }

    public void setGasto(long gasto) {
        this.gasto = gasto;
    }

    public PagosKey getPagosKey() {
        return pagosKey;
    }

    public void setPagosKey(PagosKey pagosKey) {
        this.pagosKey = pagosKey;
    }

    public Pagos(long gasto, PagosKey pagosKey) {
        this.gasto = gasto;
        this.pagosKey = pagosKey;
    }
    public Pagos() {

    }

}
