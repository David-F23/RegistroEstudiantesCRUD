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
    
    public void Guardar(String tabla, String camposTabla, String valoresCampos){
        
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
    
    
    
    public void Actualizar_Eliminar(String tabla, String valoresCamposNuevos, String condicion){
        
        ConexionCRUD conectar = new ConexionCRUD();
        Connection conx = conectar.getConnection();
        
        try{
            String sqlQueryStat;
            Statement stat;
            
            if(valoresCamposNuevos.isEmpty()){
                
                sqlQueryStat = "DELETE FROM " + tabla + " WHERE " + condicion + ";";
                
            }else{
                
                sqlQueryStat = "UPDATE " + tabla + " SET " + valoresCamposNuevos + " WHERE " + condicion + ";";
            }
            
            stat = conx.createStatement();
            stat.executeUpdate(sqlQueryStat);
            stat.close();
            conx.close();
            
        }catch(SQLException ex){
            
            System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
        }
    }
    
    
    public void VerRegistros(String tablaBuscar, String campoBuscar, String condicionBuscar) throws SQLException{
        
       ConexionCRUD conectar = new ConexionCRUD();
       Connection conx = conectar.getConnection();
       
       try{
           Statement stat;
           String sqlQueryStat;
           
           if(condicionBuscar.equals("")){
               
               sqlQueryStat = "SELECT " + campoBuscar + " FROM " + tablaBuscar + ";";
               
           }else{
               
               sqlQueryStat = "SELECT " + campoBuscar + " FROM " + tablaBuscar + " WHERE " + condicionBuscar;
               
           }
           
           stat = conx.createStatement();
           stat.executeQuery(sqlQueryStat);
           
           try(ResultSet miResultSet = stat.executeQuery(sqlQueryStat)){
               
               if(miResultSet.next()){
                   
                   ResultSetMetaData metaData = miResultSet.getMetaData();
                   int numColumnas = metaData.getColumnCount();
                   
                   System.out.println("<<  REGISTROS ALMACENADOS  >>");
                   System.out.println();
                   
                   for(int i = 1; i <= numColumnas; i++){
                       
                       System.out.printf("%-20s\t", metaData.getColumnName(i));
                   }
                   System.out.println();
                   
                   do{
                       for(int i = 1; i <= numColumnas; i++){
                           
                           System.out.printf("$-20s\t",miResultSet.getObject(i));
                       }
                       System.out.println();
                       
                   }while(miResultSet.next());
                   System.out.println();
                   
               }else{
                   
                   System.out.println("No se encontraron Registros.");
                   
               }
               
               miResultSet.close();
               
           }finally{
               
               stat.close();
               conx.close();
           }
           
       }catch(SQLException ex){
           
           System.out.println("Ha ocurrido el siguiente error: " + ex.getMessage());
       }
    }
    
    //Este main se utiliza para hacer las pruebas.
    /*public static void main(String[] args) {
        
        String id = "1002";
        String nombre = "Juan";
        String apellido = "Lopez";
        String carnet = "tg3456";
        int edad = 30;
        
        String tabla = "tb_estudiante";
        String camposTabla = "id_estudiante, carnet_estudiante, nom_estudiante, ape_estudiante, edad_estudiante";
        String valoresCamposNuevos = "";
        String condicion = "id_estudiante = " + id;
        
        Actualizar_Eliminar(tabla, valoresCamposNuevos, condicion);
    }*/
}
