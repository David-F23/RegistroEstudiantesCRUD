package RegistroEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class Create {
    
    Create() throws SQLException{
        
        Scanner leer = new Scanner(System.in);
        Estudiante alumno = new Estudiante();
        
        System.out.println("<<  REGISTRAR ESTUDIANTE  >>");
        
        System.out.println("Carnet:");
        alumno.setCarnet_estudiante(leer.nextLine());
        
        System.out.println("Nombre:");
        alumno.setNom_estudiante(leer.nextLine());
        
        System.out.println("Apellido:");
        alumno.setApe_estudiante(leer.nextLine());
        
        System.out.println("Edad:");
        alumno.setEdad_estudante(leer.nextInt());
        
        String tabla = "tb_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'" + alumno.getCarnet_estudiante() + "','" + alumno.getNom_estudiante() + "','" + alumno.getApe_estudiante() + "','" + alumno.getEdad_estudante() + "'";
        
        ConexionCRUD utilerias = new ConexionCRUD();
        
        utilerias.Guardar(tabla, camposTabla, valoresCampos);
        
        MenuPrincipal.desplegarMenu();
    }
}
