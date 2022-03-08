package com.sideproject.characterCreator.daos;

import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

public class MemoryClassDAO implements ClassDao {

    private RestTemplate restTemplate = new RestTemplate();

    public List<Class> getAllClasses() {
        List<Class> classes = new ArrayList<>();
        classes.add(getClass("barbarian"));
        classes.add(getClass("bard"));
        classes.add(getClass("cleric"));
        classes.add(getClass("druid"));
        classes.add(getClass("fighter"));
        classes.add(getClass("monk"));
        classes.add(getClass("paladin"));
        classes.add(getClass("ranger"));
        classes.add(getClass("rogue"));
        classes.add(getClass("sorcerer"));
        classes.add(getClass("warlock"));
        classes.add(getClass("wizard"));
        return classes;
    }

    public Class getClass(String name) {
        String url = "https://www.dnd5eapi.co/api/classes/" + name;
        return restTemplate.getForObject(url, Class.class);
    }
}
