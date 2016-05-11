/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.marc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class Content extends dk.statsbiblioteket.searchservice.camel.sourceformats.summa.Content{
    @XStreamAsAttribute
    String type;
    Marc record;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Marc getRecord() {
        return record;
    }

    public void setRecord(Marc record) {
        this.record = record;
    }


    
    
}
