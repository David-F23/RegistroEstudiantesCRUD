package RegistroEstudiante;

import java.sql.SQLException;

public class Read {
    
    public Read() throws SQLException{
        
        System.out.println("<< REGISTROS ALMACENADOS >>");
        mostrarRegistros();
        
    }
    
    private void mostrarRegistros() throws SQLException{
        
        try{
            ConexionCRUD utilerias = new ConexionCRUD();
            String tabla = "tb_estudiante";
            String camposTabla = "*";
            String condicionBusqueda = "";
            
            utilerias.VerRegistros(tabla, camposTabla, condicionBusqueda);
            
        }catch(SQLException ex){
            
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
            
        }finally{
            
            MenuPrincipal.desplegarMenu();
        }
    }
}
