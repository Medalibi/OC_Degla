/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.view;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;
import org.rdcit.ocSync.map.Mapper;
import org.rdcit.ocSync.model.MissingStructure;

/**
 *
 * @author sa841
 */
@ManagedBean(name = "MissingStructureView")
public class MissingStructureView implements Serializable {

    List<MissingStructure> lMissingStructure;
    boolean disableButtonImportSubjects;
    @ManagedProperty(value = "#{Mapper}")
    Mapper mapper;

    @PostConstruct
    public void init() {
        lMissingStructure = (List<MissingStructure>) mapper.mapping()[3];
        if (lMissingStructure.isEmpty()) {
            setDisableButtonImportSubjects(false);
        } else {
            setDisableButtonImportSubjects(true);
            FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_FATAL, "Sorry", "but the two do not match. Please, be sure of uploading/selecting the right one(s).");
            FacesContext.getCurrentInstance().addMessage("importSubjectsMSG", message);
        }
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

    public boolean isDisableButtonImportSubjects() {
        return disableButtonImportSubjects;
    }

    public void setDisableButtonImportSubjects(boolean disableButtonImportSubjects) {
        this.disableButtonImportSubjects = disableButtonImportSubjects;
    }

}
