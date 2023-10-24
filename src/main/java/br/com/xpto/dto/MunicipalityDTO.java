package br.com.xpto.dto;

import java.io.Serializable;

public class MunicipalityDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long uf;
    private Long code;
    private String name;

    public Long getUf() {
        return uf;
    }

    public void setUf(Long uf) {
        this.uf = uf;
    }

    public Long getCode() {
        return code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
