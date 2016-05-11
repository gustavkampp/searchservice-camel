/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.summa;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */

@XStreamAlias(value = "Records")
public class Records {
    @XStreamAlias(value = "record")
    Record record;
    @XStreamAsAttribute
    long querytime;


    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public long getQuerytime() {
        return querytime;
    }

    public void setQuerytime(long querytime) {
        this.querytime = querytime;
    }
    
}
