/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rdcit.ocSync.model;

/**
 *
 * @author sa841
 */
public class ImproperStructure {

    Study study;
    StudyEvent event;
    StudyEventForm form;
    Item item;
    String improperType;

    public ImproperStructure(Study study, StudyEvent event, StudyEventForm form, Item item) {
        this.study = study;
        this.event = event;
        this.form = form;
        this.item = item;
        this.improperType = "Item";
    }

    public ImproperStructure(Study study, StudyEvent event, StudyEventForm form) {
        this.study = study;
        this.event = event;
        this.form = form;
        this.improperType = "StudyEventForm";
    }

    public ImproperStructure(Study study, StudyEvent event) {
        this.study = study;
        this.event = event;
        this.improperType = "StudyEvent";
    }

    public ImproperStructure(Study study) {
        this.study = study;
        this.improperType = "Study";
    }

}
