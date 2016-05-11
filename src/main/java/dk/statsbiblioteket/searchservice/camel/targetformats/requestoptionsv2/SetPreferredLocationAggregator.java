/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;
import dk.statsbiblioteket.searchservice.common.wsgen.uregistry.LookupUserAttributeResponse;
import dk.statsbiblioteket.searchservice.camel.sourceformats.summa.ShortRecord;
import java.util.logging.Level;
import org.apache.camel.Exchange;
import org.apache.camel.InvalidPayloadException;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.cxf.message.MessageContentsList;
import org.apache.cxf.service.model.MessagePartInfo;
/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class SetPreferredLocationAggregator implements AggregationStrategy {
    public static String REQUESTOPTIONSV2PREF = "RequestOptionsV2Preferred";

    Logger logger = LoggerFactory.getLogger(SetPreferredLocationAggregator.class);
    /**
     * Populates the RequestOption object (required) in the msg body of
     * @param original
     * @param additional containing a dk.statsbiblioteket.searchservice.sourceformats.summa.ShortRecord in the Message Body
     * @return 
     */
    @Override
    public Exchange aggregate(Exchange original, Exchange additional) {
       RequestOption output;
        try {
           MessageContentsList newin = additional.getIn().getMandatoryBody(MessageContentsList.class);
           String pref = ((LookupUserAttributeResponse)newin.get(0)).getAttributeValue();
           original.setProperty(REQUESTOPTIONSV2PREF, pref);
        } catch (InvalidPayloadException ex) {
            java.util.logging.Logger.getLogger(RequestOptionsAggregator.class.getName()).log(Level.SEVERE, null, ex);
            original.setException(ex);
        }
         return original;
    }
    
}
