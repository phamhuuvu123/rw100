package org.example.dto.context;

import org.example.entity.DePartment;

import java.util.Map;

public class DepartmentContext {
    private Map<String, DePartment> mapBydepartmentName;

    public DepartmentContext(Map<String, DePartment> mapBydepartmentName) {
        this.mapBydepartmentName = mapBydepartmentName;
    }

    public Map<String, DePartment> getMapBydepartmentName() {
        return mapBydepartmentName;
    }

    public void setMapBydepartmentName(Map<String, DePartment> mapBydepartmentName) {
        this.mapBydepartmentName = mapBydepartmentName;
    }
}
