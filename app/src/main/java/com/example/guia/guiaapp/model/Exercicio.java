package com.example.guia.guiaapp.model;

import java.sql.Blob;

/**
 * Created by samuel on 24/08/2017.
 */

public class Exercicio
{
    private Integer ID_exe;
    private String resposta_exe;
    private Temas tema_exe;

    public Integer getID_exe() {
        return ID_exe;
    }

    public void setID_exe(Integer ID_exe) {
        this.ID_exe = ID_exe;
    }

    public String getResposta_exe() {
        return resposta_exe;
    }

    public void setResposta_exe(String resposta_exe) {
        this.resposta_exe = resposta_exe;
    }

    public Temas getTema_exe() {
        return tema_exe;
    }

    public void setTema_exe(Temas tema_exe) {
        this.tema_exe = tema_exe;
    }
}
