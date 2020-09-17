package com.app;

import com.menu.MenuHelper;

import java.sql.SQLException;
import java.util.Scanner;

public class Aplicacion {

    MenuHelper menu=new MenuHelper();
    Scanner sc=new Scanner(System.in);

    public void ejecutar() throws SQLException {

        int seleccion=0;
        while(seleccion!=4){
            seleccion=showMenu();
            switch (seleccion) {
                case 1:
                    menu.showList();
                    break
                            ;
                case 2:
                    menu.addUsuario();
                    break
                            ;
                case 3:
                    menu.removeUsuario();
                    break
                            ;
            }
            System.out.println("Saliendo de la aplicación");
        }
    }

    public int showMenu(){
        System.out.println(" Elija una opción: \n" +
                "1. Mostrar lista de usuarios \n"+
                "2. Añadir usuario \n"+
                "3. Eliminar usuario \n"+
                "4. Salir");

        int opcion=sc.nextInt();
        return opcion;
    }
}
