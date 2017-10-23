package com.example.guia.guiaapp.model;

/**
 * Created by samuel on 19/10/2017.
 */

public class Exercicio_por_Usuario
{

    private Integer ID_exe_por_usu;
    private Exercicio exe_exe_por_usu;
    private Usuario usu_exe_por_usu;

    private Boolean resolvido_exe_por_usu;

    private Integer tentativas_exe_por_usu;


    public Integer getID_exe_por_usu() {
        return ID_exe_por_usu;
    }

    public void setID_exe_por_usu(Integer ID_exe_por_usu) {
        this.ID_exe_por_usu = ID_exe_por_usu;
    }

    public Exercicio getExe_exe_por_usu() {
        return exe_exe_por_usu;
    }

    public void setExe_exe_por_usu(Exercicio exe_exe_por_usu) {
        this.exe_exe_por_usu = exe_exe_por_usu;
    }

    public Usuario getUsu_exe_por_usu() {
        return usu_exe_por_usu;
    }

    public void setUsu_exe_por_usu(Usuario usu_exe_por_usu) {
        this.usu_exe_por_usu = usu_exe_por_usu;
    }

    public Boolean getResolvido_exe_por_usu() {
        return resolvido_exe_por_usu;
    }

    public void setResolvido_exe_por_usu(Boolean resolvido_exe_por_usu) {
        this.resolvido_exe_por_usu = resolvido_exe_por_usu;
    }

    public Integer getTentativas_exe_por_usu() {
        return tentativas_exe_por_usu;
    }

    public void setTentativas_exe_por_usu(Integer tentativas_exe_por_usu) {
        this.tentativas_exe_por_usu = tentativas_exe_por_usu;
    }
}
