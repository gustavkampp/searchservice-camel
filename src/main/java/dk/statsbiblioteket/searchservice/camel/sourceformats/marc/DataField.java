/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.marc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.LinkedList;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@XStreamAlias(value = "datafield")
public class DataField{
    @XStreamAsAttribute
    String tag;
    @XStreamAsAttribute
    String ind1;
    @XStreamAsAttribute
    String ind2;
    @XStreamImplicit
    @XStreamAlias(value = "subfield")
    LinkedList<SubField> subfields;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getInd1() {
        return ind1;
    }

    public void setInd1(String ind1) {
        this.ind1 = ind1;
    }

    public String getInd2() {
        return ind2;
    }

    public void setInd2(String ind2) {
        this.ind2 = ind2;
    }

    public LinkedList<SubField> getSubfields() {
        return subfields;
    }

    public void setSubfields(LinkedList<SubField> subfields) {
        this.subfields = subfields;
    }
    
     
}
