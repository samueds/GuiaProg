package com.example.guia.guiaapp.model;

/**
 * Created by samuel on 24/08/2017.
 */

public class Conteudos
{
    private Integer ID_con;

    private String nome_con;

    private String nome_pdf_con;
    private Temas tema_con;

    public Integer getID_con() {
        return ID_con;
    }

    public void setID_con(Integer ID_con) {
        this.ID_con = ID_con;
    }

    public String getNome_con() {
        return nome_con;
    }

    public void setNome_con(String nome_con) {
        this.nome_con = nome_con;
    }

    public String getNome_pdf_con() {
        return nome_pdf_con;
    }

    public void setNome_pdf_con(String nome_pdf_con) {
        this.nome_pdf_con = nome_pdf_con;
    }

    public Temas getTema_con() {
        return tema_con;
    }

    public void setTema_con(Temas tema_con) {
        this.tema_con = tema_con;
    }
}
