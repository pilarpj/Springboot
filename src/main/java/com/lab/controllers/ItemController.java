package com.lab.controllers;

import com.lab.persistence.model.ItemModel;
import com.lab.persistence.service.ItemService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class ItemController {

    @Autowired
    ItemService itemService;

    
       int cont= 0;  

    
    @ResponseBody
    @RequestMapping(value = "/item",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemModel> item(@RequestBody ItemModel obj) throws Exception {
        System.out.println("Texto dirección mapper: " + obj.getNombre());
        List<ItemModel> x = itemService.itemService(obj);
       
        
      if(x.size() > 0)
      { 
          System.out.println("Text de vuelta mapper, itemcontroller: \n ID: " + x.get(0).getId() +"\n Nombre: "+ x.get(0).getNombre());
      } 

        return x;
    }
    

    
    @ResponseBody
    @RequestMapping(value = "/allItems",
            method = RequestMethod.POST,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ItemModel> allItems(@RequestBody ItemModel obj) throws Exception {
      
        List<ItemModel> x = itemService.AllItemService(obj);
     
        return x;
    }
    
    
    
}
