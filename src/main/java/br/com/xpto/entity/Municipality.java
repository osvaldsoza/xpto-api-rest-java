package br.com.xpto.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "municipio")
public class Municipality implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private Long codigo;
    private Long uf;
    private String name;

    public Long getUf() {
        return uf;
    }

    public void setUf(Long uf) {
        this.uf = uf;
    }

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
