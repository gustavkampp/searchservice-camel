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
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class FacultyInfoAggregator implements AggregationStrategy {

    Logger logger = LoggerFactory.getLogger(FacultyInfoAggregator.class);

    /**
     * Populates the RequestOption object (required) in the msg body of
     *
     * @param original
     * @param additional containing a
     * dk.statsbiblioteket.searchservice.sourceformats.summa.ShortRecord in the
     * Message Body
     * @return
     */
    @Override
    public Exchange aggregate(Exchange original, Exchange additional) {
        RequestOption output;
        try {
            
            Map<String, Object> p1 = original.getProperties();
            
            FacultyLocations newin = additional.getIn().getMandatoryBody(FacultyLocations.class);
            output = original.getIn().getMandatoryBody(RequestOption.class);
            
            for (Iterator<FacultyLocation> iterator = newin.getLocations().iterator(); iterator.hasNext();) {
                FacultyLocation next = iterator.next();
                PickupOption p = new PickupOption();
                p.setFakultet(next.getFacultyID());
                p.setInfo(next.getNavn());

                output.getPickupOptions().put(next.getId(), p);
            }
        } catch (InvalidPayloadException ex) {
            java.util.logging.Logger.getLogger(RequestOptionsAggregator.class.getName()).log(Level.SEVERE, null, ex);
            original.setException(ex);
        }
        return original;
    }

}
