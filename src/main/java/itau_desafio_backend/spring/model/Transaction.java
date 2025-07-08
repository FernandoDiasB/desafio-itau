package itau_desafio_backend.spring.model;

import java.time.OffsetDateTime;

public class Transaction {

    private Double valor;

    private OffsetDateTime dataHora;

    public Transaction(OffsetDateTime dataHora, Double valor) {
        this.dataHora = dataHora;
        this.valor = valor;
    }

    public OffsetDateTime getDataHora() {
        return dataHora;
    }

    public void setDataHora(OffsetDateTime dataHora) {
        this.dataHora = dataHora;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
