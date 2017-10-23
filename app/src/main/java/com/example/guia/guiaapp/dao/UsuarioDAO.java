package com.example.guia.guiaapp.dao;


import com.example.guia.guiaapp.model.Usuario;
import com.example.guia.guiaapp.utils.Utils;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Vector;

public class UsuarioDAO
{

    private static  final String URL = "http://192.168.0.108:8080/GuiaAppWS/services/UsuarioDAO?wsdl";
    private static  final String NAMESPACE = "http://webservices";

    private static final String INSERIR = "inserirUsuario";
    private static final String BUSCAR_TODOS = "buscarTodos";

    public static Integer inserirUsuario(Usuario u) throws Exception
    {

        SoapObject inserirUsuario = new SoapObject(NAMESPACE, INSERIR);
        SoapObject usr = new SoapObject(NAMESPACE, "u");

        usr.addProperty("email_usu", u.getEmail_usu());
        usr.addProperty("id_usu", u.getID_usu());
        usr.addProperty("nome_usu", u.getNome_usu());
        usr.addProperty("senha_usu", Utils.toMD5(u.getSenha_usu()));


        inserirUsuario.addSoapObject(usr);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.setOutputSoapObject(inserirUsuario);

        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);

        try {
            http.call("urn:" + INSERIR, envelope);

            SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

            return Integer.parseInt(resposta.toString());

        } catch (IOException e ) {
            e.printStackTrace();

            return 3;
        }
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
            return  3;
        }
    }


    public static ArrayList<Usuario> buscarTodosUsuarios() throws java.lang.NullPointerException
    {
        ArrayList<Usuario> lista = new ArrayList<Usuario>();

        SoapObject buscaUsuarios = new SoapObject(NAMESPACE,BUSCAR_TODOS);

        SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);

        envelope.implicitTypes = true;

        HttpTransportSE http = new HttpTransportSE(URL);


        try {

            http.call("urn:" + BUSCAR_TODOS,envelope);


            Vector<SoapObject> resposta = (Vector<SoapObject>)envelope.getResponse();


            for(SoapObject s : resposta)
            {

                Usuario usr = new Usuario();


                usr.setNome_usu((s.getProperty("nome_usu").toString()));
                usr.setID_usu(Integer.parseInt(s.getProperty("ID_usu").toString()));
                usr.setEmail_usu(s.getProperty("email_usu").toString());

                usr.setSenha_usu((s.getProperty("senha_usu").toString()));

                lista.add(usr);

            }

        } catch (IOException e ) {
            e.printStackTrace();

            return null;
        }
        catch (XmlPullParserException e)
        {
            e.printStackTrace();
            return  null;
        }
        return lista;
    }


}