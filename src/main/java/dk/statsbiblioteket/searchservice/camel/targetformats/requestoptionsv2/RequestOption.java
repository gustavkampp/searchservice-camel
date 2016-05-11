/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Collection;
import java.util.HashMap;

/**
 * This class represent the RequestOption as it is neededby the receiver (Frontend)
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@JsonInclude(JsonInclude.Include.NON_NULL)

public class RequestOption {
    private String title;
    private String author;
    private String description;
    private boolean alreadyReserved;
    private HashMap<String, PickupOption> pickupOptions = new HashMap<String, PickupOption>();

    @JsonGetter("pickupOptions")
    public Collection<PickupOption> getPickupOptionsList(){
        return getPickupOptions().values();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAlreadyReserved() {
        return alreadyReserved;
    }

    public void setAlreadyReserved(boolean alreadyReserved) {
        this.alreadyReserved = alreadyReserved;
    }

    public HashMap<String, PickupOption> getPickupOptions() {
        return pickupOptions;
    }

    public void setPickupOptions(HashMap<String, PickupOption> pickupOptions) {
        this.pickupOptions = pickupOptions;
    }

}
