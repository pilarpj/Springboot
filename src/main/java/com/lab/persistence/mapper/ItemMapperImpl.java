/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lab.persistence.mapper;

import com.lab.persistence.mapper.bbdd.BBDD;
import com.lab.persistence.model.ItemModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Mapper de ItemModel, recibe una cadena de objetos.
 *
 * @author Lenovo
 */
@Repository
public class ItemMapperImpl implements ItemMapper {

    //Inyecto la base de datos
    @Autowired
    BBDD db;

    //Metodo que recibe una lista de objetos
    @Override
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception {

        //Creo una lista de ItemModel vacía
        List<ItemModel> list = new ArrayList<>();
        
       
        
        /**
         * CONECTANDO A LA BBDD.
         */
        db.conecta();
        
//        tabla.setId(1);
//        tabla.setNombre("nombre");
//        tabla.setUrl("url");
        
         /**
         * Recorre las tablas dentro de la base de datos (Spring). 
         * Asi saco los nombres de las tablas.
         */
//        for (int i = 0; i < db.tablas().size(); i++) {
//            
//             tablaNombre.setNombre(db.tablas().get(i)); 
//        }
//        
//        System.out.println("mapper: " + tablaNombre.getNombre());
//                
//        
        //CONSULTA SQL, devuelve todo el contenido de la tabla items.
       // String sql = "SELECT * FROM ITEMS WHERE ID" + this.getId();
        
        
        String sql = "SELECT * FROM items where (nombre LIKE '%" + obj.getDatoBuscador() + "%')";
       
        System.out.println("Datos del datobuscador: " + obj.getDatoBuscador());
                
        
        //String sql = "SELECT " + db.columnas(table.getTable()).get(j) + " FROM "  + tablaNombre.getNombre();
      
        ResultSet rs = db.consulta(sql);
        while (rs.next())
        {
            ItemModel tabla = new ItemModel();
                 tabla.setId(rs.getInt("id"));
                 tabla.setNombre(rs.getString("nombre"));
                 tabla.setDescripcion(rs.getString("descripcion"));
                 tabla.setUrl(rs.getString("url"));
                 list.add(tabla);
        }

        
        
       
        
                
        
        
         /**
         * CONSULTA SQL
         */
         

         
//        String sql = "SELECT " + db.columnas(table.getTable()).get(j) + " FROM " + table.
//                     getTable();

      

        //Añado la tabla (obj) a la lista
        
        return list;
    }

}
