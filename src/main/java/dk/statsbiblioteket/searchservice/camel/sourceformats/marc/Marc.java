/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.marc;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.LinkedList;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@XStreamAlias(value = "record")
public class Marc {
@XStreamAlias(value = "leader")
    Leader leader;
@XStreamImplicit
@XStreamAlias(value = "datafield")
    LinkedList<DataField> datafields;

    public Leader getLeader() {
        return leader;
    }

    public void setLeader(Leader leader) {
        this.leader = leader;
    }

    public LinkedList<DataField> getDatafields() {
        return datafields;
    }

    public void setDatafields(LinkedList<DataField> datafields) {
        this.datafields = datafields;
    }



}
