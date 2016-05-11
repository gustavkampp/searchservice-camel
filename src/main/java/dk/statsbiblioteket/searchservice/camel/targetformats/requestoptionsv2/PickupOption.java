/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.ArrayList;
import java.util.List;

/**
 * This class represent the PickupOption as it is neededby the receiver (Frontend)
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class PickupOption {
    String fakultet;
    String info;
    List<Option> options = new ArrayList<Option>();

    public String getFakultet() {
        return fakultet;
    }

    public void setFakultet(String fakultet) {
        this.fakultet = fakultet;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<Option> getOptions() {
        return options;
    }

    public void setOptions(List<Option> options) {
        this.options = options;
    }
    
}
