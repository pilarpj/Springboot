
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
    
    
    for (int i = 0; i < x.size(); i++) {
               x.get(i).setNombre(x.get(i).getNombre().replaceAll("" + obj.getDatoBuscador() + 
                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
               x.get(i).setDescripcion(x.get(i).getDescripcion().replaceAll("" + obj.getDatoBuscador() + 
                        "","<span class=\"sub\">" + obj.getDatoBuscador() + "</span>"));
               
            }
      System.out.println("Contenido de X.SIZE: " + x.size());
             
    return x;
    
  }
   
//    private void itemReplace (ItemModel obj) throws Exception{
//  
//       List<ItemModel> x = itemMapper.itemMapper(obj);
//       obj.getDatoBuscador();
//            for (int i = 0; i < x.size(); i++) {
//                x.get(i).getNombre().replaceAll("" + obj.getDatoBuscador() + 
//                        "","<span class='sub'>" + obj.getDatoBuscador() + "<span>");
//            }
//        
//    }
  
  
  
/**
 * Servicio que devuelve un array de items por defecto
 * @param obj
 * @return
 * @throws Exception 
 */
    @Override
    public List<ItemModel> AllItemService(ItemModel obj) throws Exception {
       
           List<ItemModel> x = itemMapper.allItemsMapper(obj);
    return x;
    }

    
    /**
     * Servicio que recibe un objeto numerico
     * @param obj
     * @return
     * @throws Exception 
     */
    @Override
    public List<ItemModel> itemNum(ItemModel obj) throws Exception {
        
           List<ItemModel> x = itemMapper.itemNumMapper(obj);
    return x;
    }

   
}
