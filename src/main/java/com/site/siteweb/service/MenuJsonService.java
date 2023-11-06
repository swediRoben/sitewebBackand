package com.site.siteweb.service;
 
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.site.siteweb.dtoJson.Menu;

@Service
public class MenuJsonService {

    public Map<String, Object> getAlls() {
        Map<String, Object> map=new HashMap<>();
         List<Menu> c=readJsonData();
         map.put("content", c);
        return map;
    }

      public Map<String, Object> getByIdAndLangue(Integer id,Integer langue) {
          Map<String, Object> map=new HashMap<>();
              List<Menu> c=readJsonData();
              Menu d=c.parallelStream().filter(emp->emp.getId().equals(id)&&emp.getLangue().equals(langue)).findAny().orElse(null); 
            map.put("content", d); 
        return map;
    }

        public Map<String, Object> getById(Integer id) {
                Map<String, Object> map=new HashMap<>();
              List<Menu> c=readJsonData();
            //   Menu Menu=c.parallelStream().filter(emp->emp.getId().equals(id)||emp.getTitre().equals("titre")).findAny().orElse(null); 
              Menu d=c.parallelStream().filter(emp->emp.getId().equals(id)).findAny().orElse(null); 
           map.put("content", d); 
        return map;
    }

    public boolean add(Menu dto) {
        boolean statut=true;
         List<Menu> c=readJsonData();
         Menu d=null;
         if (c!=null)  
            d=c.parallelStream().filter(emp->emp.getId().equals(dto.getId())&&emp.getLangue().equals(dto.getLangue())).findAny().orElse(null);
         else 
            c=new ArrayList<>();
            if (d==null) {
                c.add(dto);
                statut=whriteJsonData(c);
                
            }
        return statut;
    }

    public boolean upDate(Integer id, Menu dto) {
         boolean statut=true;
         List<Menu> c=readJsonData();   
         c.removeIf(emp->emp.getId().equals(id)&&emp.getLangue().equals(dto.getLangue())); 
          c.add(dto);
          statut=whriteJsonData(c); 
        return statut;
    }

    public boolean delete(Integer id) {
        boolean statut=true;
         List<Menu> c=readJsonData();   
         c.removeIf(emp->emp.getId().equals(id));  
          statut=whriteJsonData(c); 
        return statut;
    }

    public List<Menu> readJsonData()
    {
        List<Menu> c=new ArrayList<>();
        try {
            String path=Files.readString(Path.of("src/main/resources/json/menu.json"));
            c=new Gson().fromJson(path, new TypeToken<List<Menu>>(){}.getType());
            return c;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

      public boolean whriteJsonData(List<Menu> c)
    {
        boolean statut=false; 
        try(FileWriter file=new FileWriter("src/main/resources/json/menu.json")){
            file.write(new Gson().toJson(c));
            file.flush();
            statut=true;
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return statut;
    }


}
