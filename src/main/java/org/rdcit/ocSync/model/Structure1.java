/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.model;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.rdcit.ocSync.map.Mapper;

/**
 *
 * @author sa841
 */
@ManagedBean (name = "Structure1")
public class Structure1 implements Serializable {
    
    List<Study> lStructure;
    @ManagedProperty (value = "#{Mapper}")
    Mapper mapper;
    
    @PostConstruct
   public void init(){
       lStructure = (List<Study>) mapper.mapping()[4];  
   }

    public List<Study> getlStructure() {
        return lStructure;
    }

    public void setlStructure(List<Study> lStructure) {
        this.lStructure = lStructure;
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public Structure1() {
    }

}
