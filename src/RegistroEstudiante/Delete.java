package RegistroEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class Delete {
    
    Delete() throws SQLException{
        
        Scanner leer = new Scanner(System.in);
        ConexionCRUD utilerias = new ConexionCRUD();
        System.out.println("<<  ELIMINAR REGISTROS  >>");
        
        String registroEliminar;
        String tabla = "tb_estudiante";
        String campos = "*";
        String condicionBuscar = "";
         
        utilerias.VerRegistros(tabla, campos, condicionBuscar);
        
        System.out.println("Ingresar el id del registro a eliminar");
        registroEliminar = leer.next();
        
        System.out.println("<<  Presione X para continuar  >>");
        String confirmar = leer.next();
        
        String condicion = "id_estudiante = " + registroEliminar;
        if("x".equals(confirmar) || "X".equals(confirmar)){
            
            String camposValoresNuevos = "";
            utilerias.Actualizar_Eliminar(tabla, camposValoresNuevos, condicion);
            
            System.out.println("Registro eliminado correctamente");
        }
        
        MenuPrincipal.desplegarMenu();
    }
}
