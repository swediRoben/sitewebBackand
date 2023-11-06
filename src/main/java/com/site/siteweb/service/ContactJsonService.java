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
import com.site.siteweb.dtoJson.Contact;

@Service
public class ContactJsonService {

    public Map<String, Object> getAlls() {
        Map<String, Object> map=new HashMap<>();
         List<Contact> c=readJsonData();
         map.put("content", c);
        return map;
    }

      public Map<String, Object> getByIdAndLangue(Integer id,Integer langue) {
          Map<String, Object> map=new HashMap<>();
              List<Contact> c=readJsonData();
              Contact contact=c.parallelStream().filter(emp->emp.getId().equals(id)&&emp.getLangue().equals(langue)).findAny().orElse(null); 
            map.put("content", contact); 
        return map;
    }

        public Map<String, Object> getById(Integer id) {
                Map<String, Object> map=new HashMap<>();
              List<Contact> c=readJsonData();
            //   Contact contact=c.parallelStream().filter(emp->emp.getId().equals(id)||emp.getTitre().equals("titre")).findAny().orElse(null); 
              Contact contact=c.parallelStream().filter(emp->emp.getId().equals(id)).findAny().orElse(null); 
           map.put("content", contact); 
        return map;
    }

    public boolean add(Contact dto) {
        boolean statut=true;
         List<Contact> c=readJsonData();
         Contact contact=null;
         if (c!=null)  
            contact=c.parallelStream().filter(emp->emp.getId().equals(dto.getId())&&emp.getLangue().equals(dto.getLangue())).findAny().orElse(null);
         else 
            c=new ArrayList<>();
            if (contact==null) {
                c.add(dto);
                statut=whriteJsonData(c);
                
            }
        return statut;
    }

    public boolean upDate(Integer id, Contact dto) {
         boolean statut=true;
         List<Contact> c=readJsonData();   
         c.removeIf(emp->emp.getId().equals(id)&&emp.getLangue().equals(dto.getLangue())); 
          c.add(dto);
          statut=whriteJsonData(c); 
        return statut;
    }

    public boolean delete(Integer id) {
        boolean statut=true;
         List<Contact> c=readJsonData();   
         c.removeIf(emp->emp.getId().equals(id));  
          statut=whriteJsonData(c); 
        return statut;
    }

    public List<Contact> readJsonData()
    {
        List<Contact> c=new ArrayList<>();
        try {
            String path=Files.readString(Path.of("src/main/resources/json/contact.json"));
            c=new Gson().fromJson(path, new TypeToken<List<Contact>>(){}.getType());
            return c;
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }

      public boolean whriteJsonData(List<Contact> c)
    {
        boolean statut=false; 
        try(FileWriter file=new FileWriter("src/main/resources/json/contact.json")){
            file.write(new Gson().toJson(c));
            file.flush();
            statut=true;
        } catch (Exception e) { 
            e.printStackTrace(); 
        }
        return statut;
    }


}
