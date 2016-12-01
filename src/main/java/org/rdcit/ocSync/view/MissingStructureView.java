/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.rdcit.ocSync.map.Mapper;
import org.rdcit.ocSync.model.MissingStructure;


/**
 *
 * @author sa841
 */
@ManagedBean(name = "MissingStructureView")
public class MissingStructureView implements Serializable {

    List<MissingStructure> lMissingStructure;
    @ManagedProperty(value = "#{Mapper}")
    Mapper mapper;

    @PostConstruct
    public void init() {
        lMissingStructure = (List<MissingStructure>) mapper.mapping()[3];
    }

    public List<MissingStructure> getlMissingStructure() {
        return lMissingStructure;
    }

    public void setlMissingStructure(List<MissingStructure> lMissingStructure) {
        this.lMissingStructure = lMissingStructure;
    }

   

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

}
