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
import javax.faces.bean.ViewScoped;
import org.rdcit.ocSync.model.Study;
import org.rdcit.ocSync.ocOdm.CollectingClinicalData;

/**
 *
 * @author sa841
 */
@ManagedBean (name = "StudyView")
@ViewScoped
public class StudySubjectView implements Serializable {
   List<Study> lStudy;

    public StudySubjectView() {
    }
    
    @PostConstruct
    public void init(){
    CollectingClinicalData collectingClinicalData = new CollectingClinicalData();
    lStudy = collectingClinicalData.collectingClinicalData();
    System.out.println("@@@@@@@@@@@@@@@ lStudy Subject " + lStudy.size());
    }

    public List<Study> getlStudy() {
        return lStudy;
    }

    public void setlStudy(List<Study> lStudy) {
        this.lStudy = lStudy;
    }
    
}