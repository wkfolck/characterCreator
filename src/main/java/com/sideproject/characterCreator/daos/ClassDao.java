package com.sideproject.characterCreator.daos;

import java.util.ArrayList;
import java.util.List;

public interface ClassDao {
    public List<Class> getAllClasses();
    public Class getClass(String name);
}
