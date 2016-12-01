/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.view;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import org.rdcit.ocSync.map.Mapper;
import org.rdcit.ocSync.model.EmptyStructure;

/**
 *
 * @author sa841
 */
@ManagedBean(name = "EmptyStructureView")
public class EmptyStructureView {

    @ManagedProperty(value = "#{Mapper}")
    Mapper mapper;
    List<EmptyStructure> lEmptyStructure;

    @PostConstruct
    public void init() {
        lEmptyStructure = (List<EmptyStructure>) mapper.mapping()[2];
    }

    public Mapper getMapper() {
        return mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public List<EmptyStructure> getlEmptyStructure() {
        return lEmptyStructure;
    }

    public void setlEmptyStructure(List<EmptyStructure> lEmptyStructure) {
        this.lEmptyStructure = lEmptyStructure;
    }

}
