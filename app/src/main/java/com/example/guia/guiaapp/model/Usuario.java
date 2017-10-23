package com.example.guia.guiaapp.model;

/**
 * Created by samuel on 24/08/2017.
 */

public class Usuario
{
    private Integer ID_usu;
    private String nome_usu;
    private String email_usu;
    private String senha_usu;

    public Integer getID_usu() {
        return ID_usu;
    }

    public void setID_usu(Integer ID_usu) {
        this.ID_usu = ID_usu;
    }

    public String getNome_usu() {
        return nome_usu;
    }

    public void setNome_usu(String nome_usu) {
        this.nome_usu = nome_usu;
    }

    public String getEmail_usu() {
        return email_usu;
    }

    public void setEmail_usu(String email_usu) {
        this.email_usu = email_usu;
    }

    public String getSenha_usu() {
        return senha_usu;
    }

    public void setSenha_usu(String senha_usu) {
        this.senha_usu = senha_usu;
    }
}
