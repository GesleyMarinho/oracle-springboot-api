package com.dimas.oracleapi.projetooraclexespringboot.ENUM;

public enum StatusRegistroPonto {

    ENTRADA(1),

    ALMOCO(2),

    VOLTA_ALMOCO(3),

    SAIDA(4);

    private final int codigo;

    StatusRegistroPonto(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }
}
