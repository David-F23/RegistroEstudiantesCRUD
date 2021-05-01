package RegistroEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class Update {
    
    Update() throws SQLException{
        
        Scanner leer = new Scanner(System.in);
        Estudiante alumno = new Estudiante();
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<<  ACTUALIZAR REGISTROS  >>");
        
        String tabla = "tb_estudiante";
        String campo = "*";
        String condicion = "";
        
        utilerias.VerRegistros(tabla, campo, condicion);
        
        System.out.println("Ingresar el id del registro a modificar");
        alumno.setId_estudainte(leer.nextInt());
        
        System.out.println("Carnet:");
        alumno.setCarnet_estudiante(leer.next());
        
        System.out.println("Nombre:");
        alumno.setNom_estudiante(leer.next());
        
        System.out.println("Apellido:");
        alumno.setApe_estudiante(leer.next());
        
        System.out.println("Edad:");
        alumno.setEdad_estudante(leer.nextInt());
        
        String camposValoresNuevos = "carnet_estudiante = '" + alumno.getCarnet_estudiante() + "', nom_estudiante = '" + alumno.getNom_estudiante() + "', ape_estudiante = '" + alumno.getApe_estudiante() + "', edad_estudiante = '" + alumno.getEdad_estudante() + "'";
        String condicionBuscar = "id_estudiante = " + alumno.getId_estudainte();
        utilerias.Actualizar_Eliminar(tabla, camposValoresNuevos, condicionBuscar);
        
        System.out.println("Modificado Correctamente");
        
        MenuPrincipal.desplegarMenu();
    }
}
