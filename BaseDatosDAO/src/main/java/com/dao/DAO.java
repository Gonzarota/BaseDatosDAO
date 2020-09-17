package com.dao;

import com.dominio.Usuario;

import java.sql.SQLException;
import java.util.List;

public interface DAO {

    public List<Usuario> loadUsuarios() throws SQLException;
    public String insertUsuario(Usuario usuario) throws SQLException;
    public String removeUsuario(int id) throws SQLException;
}
