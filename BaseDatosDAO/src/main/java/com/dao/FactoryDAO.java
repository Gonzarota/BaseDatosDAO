package com.dao;

import com.constantes.Constantes;

public class FactoryDAO {

    public static DAO createDAO(Constantes.DATABASES currenteDB){
        switch (currenteDB){

            case POSTGRES:
                return new DAOpostgres();
            case MYSQL:
                return new DAOmySQL();
        }

        return null;
    }
}
