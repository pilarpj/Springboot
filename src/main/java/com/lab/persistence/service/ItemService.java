
package com.lab.persistence.service;
import com.lab.persistence.model.ItemModel;
import java.util.List;
 
/**
 * Servicios de la clase Item
 * @author Lenovo
 */
public interface ItemService {
    
    public List<ItemModel> itemService(ItemModel obj) throws Exception;
            
        
    public List<ItemModel> AllItemService(ItemModel obj) throws Exception;
            
    
    
    
}
