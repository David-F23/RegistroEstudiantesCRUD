package RegistroEstudiante;

import java.sql.*;

public class ConexionCRUD {
    
    private final String servidor = "jdbc:mysql://127.0.0.1:3306/estudiante";
    
    private final String usuario = "root";
    
    private final String clave = "";
    
    private final String DriverConector = "com.mysql.jdbc.Driver";
    
    private static Connection conexion;
    
    
    public ConexionCRUD(){
        
        try{
            Class.forName(DriverConector);
            conexion = DriverManager.getConnection(servidor, usuario, clave);
            
        }catch(ClassNotFoundException | SQLException e){
            
            System.out.println("Error! Conexión Fallida " + e.getMessage());
        }
    }
    
    public Connection getConnection(){
        return conexion;
    }
    
    public static void Guardar(String tabla, String camposTabla, String valoresCampos){
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection conx = conectar.getConnection();
        
        try{
            String sqlQueryStat = "INSERT INTO " + tabla + "("+ camposTabla +") VALUES (" + valoresCampos + ");";
            
            Statement stat;
            stat = conx.createStatement();
            stat.executeUpdate(sqlQueryStat);
            
            stat.close();
            conx.close();
            
            System.out.println("Guardado Correctamente..!!!");
            
        }catch(Exception e){
            
            System.out.println(e.getMessage());
        }
    }
    
    //Este main se utiliza para hacer las pruebas.
    /*public static void main(String[] args) {
        
        String nombre = "David";
        String apellido = "Flores";
        String carnet = "DF2002";
        int edad = 19;
        
        String tabla = "tb_estudiante";
        String camposTabla = "carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCampos = "'" + carnet + "','" + nombre + "','" + apellido + "','" + edad + "'";
        
        Guardar(tabla, camposTabla, valoresCampos);
    }*/
    
    
}
