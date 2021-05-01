package RegistroEstudiante;

import java.sql.SQLException;
import java.util.Scanner;

public class MenuPrincipal {
    
    public static void main(String[] args) throws SQLException {
        
        desplegarMenu();
    }
    
    public static void desplegarMenu() throws SQLException {
        
        Scanner leer = new Scanner(System.in);
        
        String opcionMenu = "";
        
        System.out.println("|=================================|");
        System.out.println("|     REGISTRO DE ESTUDIANTES     |");
        System.out.println("|=================================|");
        System.out.println("| Opciones:                       |");
        System.out.println("|      1. Registrar estudiante    |");
        System.out.println("|      2. Consultar registros     |");
        System.out.println("|      3. Actualizar registros    |");
        System.out.println("|      4. Eliminar registros      |");
        System.out.println("|      5. Salir                   |");
        System.out.println("|=================================|");
        System.out.println("Selecionar Opción");
        opcionMenu = leer.next();
        
        switch(opcionMenu){
            
            case "1":
                Create create = new Create();
                break;
            case "2":
                Read read = new Read();
                break;
            case "3":
                //Update update = new Update();
                break;
            case "4":
                //Delete delete = new Delete();
                break;
            case "5":
                System.exit(0);
                break;
            default:
                System.out.println("Opción Invalida");
                break;
        }
    }
}
