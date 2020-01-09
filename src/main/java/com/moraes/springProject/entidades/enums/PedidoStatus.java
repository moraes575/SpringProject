package com.moraes.springProject.entidades.enums;

public enum PedidoStatus {

    AGUARDANDO_PAGAMENTO(1),
    PAGO(2),
    ENVIADO(3),
    ENTREGUE(4),
    CANCELADO(5);

    private int codigo;

    private PedidoStatus(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

    public static PedidoStatus valueOf(int codigo) {
        for (PedidoStatus valor : PedidoStatus.values()) {
            if (valor.getCodigo() == codigo) {
                return valor;
            }
        }
        throw new IllegalArgumentException("Código PedidoStatus inválido");
    }

}
