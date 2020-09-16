package com.dao;

import com.usuario.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAOpostgres implements DAO {

    public static Connection cn=null;


    public DAOpostgres(){
        try {
            String url="jdbc:postgresql://192.168.56.2/empresa";
            String user="postgres";
            String clave="abc";
            cn = DriverManager.getConnection( url,user,clave);
            System.out.println("Conexión establecida.");
        } catch (SQLException e) {
            System.out.println("Error: " + e.toString());
        }
    }


    @Override
    public List<Usuario> loadUsuarios() throws SQLException{

        List<Usuario> usuarios=new ArrayList<>();
        Statement sentencia=this.cn.createStatement();
        String sql= "SELECT * FROM usertable";
        ResultSet result=sentencia.executeQuery(sql);

        while(result.next()){
            Usuario u = new Usuario(result.getInt("id"),
                    result.getString("nombre"),
                    result.getString("apellidos"),
                    result.getString("departamento"),
                    result.getString("sede"));

            usuarios.add(u);
        }
        sentencia.close();
        return usuarios;
    }

    @Override
    public String insertUsuario(Usuario usuario)throws SQLException{

        String nombre=usuario.getNombre();
        String apellido=usuario.getApellido();
        String departamento=usuario.getDepartamento();
        String sede=usuario.getSede();

        Statement sentencia=this.cn.createStatement();
        String sql="INSERT INTO usertable(nombre,apellidos,departamento,sede) VALUES('"+nombre+"','"+apellido+"','"+departamento+"','"+sede+"')";
        int result;

        result=sentencia.executeUpdate(sql);

        String resultado="Se han insertado "+result+" filas, creando el usuario: "+usuario.getNombre()+" "+ usuario.getApellido();

        sentencia.close();
        return resultado;
    }

    @Override
    public String removeUsuario(int id) throws SQLException{
        Statement sentencia=this.cn.createStatement();
        String sql="DELETE FROM usertable WHERE id="+id;
        int result;

        result=sentencia.executeUpdate(sql);
        String resultado="Se han borrado "+result+" filas";

        sentencia.close();
        return resultado;
    }
}
