
package com.lab.persistence.mapper;

import com.lab.persistence.model.ItemModel;
import java.util.List;
/**
 * Interfaz mapper de ItemModel, recibe una cadena de objetos.
 * @author Lenovo
 */
public interface ItemMapper {
    
    public List<ItemModel> itemMapper(ItemModel obj) throws Exception;
    
}
