
package com.lab.persistence.service;
import com.lab.persistence.mapper.ItemMapper;
import com.lab.persistence.model.ItemModel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Servicios que recibirá la clase Item. 
 * @author Lenovo
 */
@Service
public class ItemServiceImpl implements ItemService{
    
  @Autowired
  ItemMapper itemMapper;

/**
 * Servicio que recibe una lista de objetos de ItemModel,
 * y devuelve una copia usando el mapper.
 * @param obj
 * @return
 * @throws Exception 
 */
  @Override
  public List<ItemModel> itemService(ItemModel obj) throws Exception
  {
    List<ItemModel> x = itemMapper.itemMapper(obj);
    return x;
  }

   
}