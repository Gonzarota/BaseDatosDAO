package com.menu;

import com.constantes.Constantes;
import com.dao.DAO;
import com.dao.FactoryDAO;
import com.dominio.Usuario;

import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

public class MenuHelper {

    DAO dao;
    Scanner sc=new Scanner(System.in);
    Properties properties;

    public MenuHelper(){
        try {
            this.properties =  new Properties();
            properties.load(getClass().getResourceAsStream(Constantes.PROPERTIES_PATH));
            this.dao=FactoryDAO.createDAO(Constantes.DATABASES.valueOf(properties.getProperty("dao")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showList() throws SQLException {
        List<Usuario> listaUsuarios=dao.loadUsuarios();
        for(Usuario usuario:listaUsuarios){
            System.out.println(usuario.toString());
        }
    }

    public void addUsuario() throws SQLException {

        System.out.println("Introduce nombre:");
        String nombre= sc.next();

        System.out.println("Introduce apellido");
        String apellido=sc.next();

        System.out.println("Introduce el departamento");
        String departamento=sc.next();

        System.out.println("Introduce la sede");
        String sede=sc.next();

        Usuario usuario=new Usuario(nombre, apellido, departamento, sede);

        String mensaje=dao.insertUsuario(usuario);
        System.out.println(mensaje);
    }

    public void removeUsuario() throws SQLException {
        System.out.println("Introduce el id de la persona a borrar");
        int id=sc.nextInt();

        String mensaje=dao.removeUsuario(id);
        System.out.println(mensaje);

    }
}
