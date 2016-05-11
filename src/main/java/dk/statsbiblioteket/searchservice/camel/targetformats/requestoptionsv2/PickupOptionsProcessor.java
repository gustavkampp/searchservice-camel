/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;

import dk.statsbiblioteket.searchservice.common.wsgen.holding.RequestOptionsResponse;
import dk.statsbiblioteket.searchservice.common.wsgen.holding.RequestOptionsResponse.RequestOptionsData;
import dk.statsbiblioteket.searchservice.common.wsgen.holding.RequestOptionsResponse.RequestOptionsData.RequestOffers;
import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocation;
import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocations;
import dk.statsbiblioteket.searchservice.camel.sourceformats.summa.ShortRecord;
import static dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2.SetPreferredLocationAggregator.REQUESTOPTIONSV2PREF;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import org.apache.camel.Body;
import org.apache.camel.Exchange;
import org.apache.camel.Handler;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.Processor;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class PickupOptionsProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(PickupOptionsProcessor.class);

    /**
     * Populates the RequestOption object (required) in the msg body of
     *
     * @param original containing a
     * dk.statsbiblioteket.searchservice.targetformats.requestoptionsv2.RequestOption in the
     * Message Body
     * @return
     */
    @Override
    public void process(Exchange original) throws Exception {
        RequestOption output;
        try {
            output = original.getIn().getMandatoryBody(RequestOption.class);

            //Prepare requestoptions for easy lookup.
            RequestOptionsResponse requestoptions = original.getProperty(RequestOptionsAggregator.REQUESTOPTIONSV2, RequestOptionsResponse.class);
            String pref = original.getProperty(REQUESTOPTIONSV2PREF, String.class);
            HashMap<String, Object> requestoffers = new HashMap<String, Object>();
            for (Iterator<RequestOptionsData> iterator = requestoptions.getRequestOptionsData().iterator(); iterator.hasNext();) {
                RequestOptionsData next = iterator.next();
                for (Iterator<RequestOffers> iterator1 = next.getRequestOffers().iterator(); iterator1.hasNext();) {
                    RequestOffers next1 = iterator1.next();
                    requestoffers.put(next1.getPickupLocation(), next1);
                }

            }
            //The run through the Pickup options om the output. 
            for (Map.Entry<String, Object> entry : requestoffers.entrySet()) {
                String key = entry.getKey();
                PickupOption p = output.getPickupOptions().get(key);
                if (p != null) {
                    RequestOffers ro = (RequestOffers)entry.getValue();
                    p.getOptions().add(new Option(ro.getPickupLocation(), ro.getBarcode(), ro.isOnShelf(), ro.getPickupLocation().equals(pref), ro.getPickupTime().toString()));
                }
            }

            //now find the ones that has no offers.
            List<String> removables = new ArrayList<String>();
            for (Map.Entry<String, PickupOption> entry : output.getPickupOptions().entrySet()) {
                String key = entry.getKey();
                PickupOption value = entry.getValue();
                if(value.getOptions().isEmpty()){
                    removables.add(key);
                }
                
            }
            //and remove them
            for (Iterator<String> iterator = removables.iterator(); iterator.hasNext();) {
                String next = iterator.next();
                output.getPickupOptions().remove(next);
            }
            
        } catch (InvalidPayloadException ex) {
            java.util.logging.Logger.getLogger(RequestOptionsAggregator.class.getName()).log(Level.SEVERE, null, ex);
            original.setException(ex);
        }
    }

}
