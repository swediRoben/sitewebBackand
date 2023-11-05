package com.site.siteweb.service;

import java.io.File;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.site.siteweb.dtoJson.Contact;

public class ContactJsonService {

    public Map<String, Object> getAlls() {
        return null;
    }

    public boolean add(Contact dto) {
        return false;
    }

    public boolean upDate(Long id, Contact dto) {
        return false;
    }

    public boolean delete(Long id) {
        return false;
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
