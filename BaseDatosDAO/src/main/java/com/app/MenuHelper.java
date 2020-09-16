package com.app;

import com.constantes.Constantes;
import com.dao.DAO;
import com.dao.FactoryDAO;
import com.usuario.Usuario;
import com.dao.DAOpostgres;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuHelper {

    DAO dao=FactoryDAO.createDAO(Constantes.CURRENT_DB);
    Scanner sc=new Scanner(System.in);

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
