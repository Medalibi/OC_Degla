/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.model;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;

/**
 *
 * @author sa841
 */
@ManagedBean( name = "Subject")
public class Subject {

    String subjectId;
    String subjectUd;
    String subjectOID;
    String subjectGendre;
    String subjectDateOfBirth;
    List<StudyEvent> lSubjectstudyEvent;

    public Subject() {
    }
    
    

    public Subject(String subjectid, String subjectUD, String subjectGendre, String subjectDateOfBirth) {
        this.subjectId = subjectid;
        this.subjectUd = subjectUD;
        this.subjectGendre = subjectGendre;
        this.subjectDateOfBirth = subjectDateOfBirth;
        lSubjectstudyEvent = new ArrayList();
    }

    public String getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(String subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectUd() {
        return subjectUd;
    }

    public void setSubjectUd(String subjectUd) {
        this.subjectUd = subjectUd;
    }

    public String getSubjectGendre() {
        return subjectGendre;
    }

    public void setSubjectGendre(String subjectGendre) {
        this.subjectGendre = subjectGendre;
    }

    public String getSubjectDateOfBirth() {
        return subjectDateOfBirth;
    }

    public void setSubjectDateOfBirth(String subjectDateOfBirth) {
        this.subjectDateOfBirth = subjectDateOfBirth;
    }


    public void addSubjectStudyEvent(StudyEvent studyEvent) {
        this.lSubjectstudyEvent.add(studyEvent);
    }

    public List<StudyEvent> getlSubjectstudyEvent() {
        return lSubjectstudyEvent;
    }

    public void setlSubjectstudyEvent(List<StudyEvent> lSubjectstudyEvent) {
        this.lSubjectstudyEvent = lSubjectstudyEvent;
    }

    
    
/*    @Override
    public String toString() {
        return "Subject{" + "subjectId=" + subjectId + ", subjectUd=" + subjectUd + ", subjectGendre=" + subjectGendre + ", subjectDateOfBirth=" + subjectDateOfBirth + ", lSubjectstudyEvent=" + lSubjectstudyEvent.size() + '}';
    }
*/

    public String getSubjectOID() {
        return subjectOID;
    }

    public void setSubjectOID(String subjectOID) {
        this.subjectOID = subjectOID;
    }
}
