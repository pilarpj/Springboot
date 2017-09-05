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

    //Metodo que recibe una lista de objetos y la devuelve dependiendo del nombre
    //escrito por teclado.
    @Override
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception {

        //Creo una lista de ItemModel vacía
        List<ItemModel> lista = new ArrayList<>();

        /**
         * CONECTANDO A LA BBDD.
         */
        db.conecta();

        /**
         * Consulta que selecciona de la tabla items dependiendo de los datos en
         * el buscador. Busca tanto en la columna "nombre" como en
         * "descripcion".
         */
        String sql = "SELECT * "
                + "FROM items "
                + "WHERE (nombre LIKE '%" + obj.getDatoBuscador() + "%')"
                + "OR (descripcion LIKE '%" + obj.getDatoBuscador() + "%')";

        System.out.println("Datos del datobuscador: " + obj.getDatoBuscador());

        ResultSet rs = db.consulta(sql);
        while (rs.next()) {
            ItemModel tabla = new ItemModel();
            tabla.setId(rs.getInt("id"));
            tabla.setNombre(rs.getString("nombre"));
            tabla.setDescripcion(rs.getString("descripcion"));
            tabla.setUrl(rs.getString("url"));
            lista.add(tabla);

        }

        db.desconecta();
        return lista;
    }

    /**
     * Metodo que selecciona todo de la tabla items.
     *
     * @param obj
     * @return list
     * @throws Exception
     */
    @Override
    public List<ItemModel> allItemsMapper(ItemModel obj) throws Exception {

        List<ItemModel> lista = new ArrayList<>();
       // System.out.println("Entra en el allitems mapper");
        db.conecta();
        String sql = "SELECT * FROM items";

        ResultSet rs = db.consulta(sql);
        while (rs.next()) {
            ItemModel tabla = new ItemModel();
            tabla.setId(rs.getInt("id"));
            tabla.setNombre(rs.getString("nombre"));
            tabla.setDescripcion(rs.getString("descripcion"));
            tabla.setUrl(rs.getString("url"));
            lista.add(tabla);

        }
        System.out.println("Contenido lista:" + lista);
        db.desconecta();
        return lista;
    }

    /**Metodo que recoge un objeto numerico y lo va a devolver en una
     * consulta anidada que lo devuelve por peso.
     *
     * @param obj
     * @return
     * @throws Exception
     */
    @Override
    public List<ItemModel> itemNumMapper(ItemModel obj) throws Exception {
    
        List<ItemModel> lista = new ArrayList<>();

        db.conecta();
        
      
          String sql = "SELECT * "
                       + " FROM items "
                       + "WHERE id " 
                         + " IN "
                             + "(SELECT iditems " 
                              + " FROM pesoitems "
                                  + " WHERE peso = 500)" ;
          
         ResultSet rs = db.consulta(sql);
        while (rs.next()) {
            ItemModel tabla = new ItemModel();
            tabla.setId(rs.getInt("id"));
            tabla.setNombre(rs.getString("nombre"));
            tabla.setDescripcion(rs.getString("descripcion"));
            tabla.setUrl(rs.getString("url"));
            lista.add(tabla);

        }

        db.desconecta();
        return lista;
    }
}



 /**
         * Recorre las tablas dentro de la base de datos (Spring). Asi saco los
         * nombres de las tablas.
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

