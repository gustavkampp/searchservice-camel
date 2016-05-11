/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.requestoptionsv2;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import dk.statsbiblioteket.searchservice.common.wsgen.holding.RequestOptionsResponse;
import java.util.logging.Level;
import org.apache.camel.InvalidPayloadException;
/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class RequestOptionsAggregator implements AggregationStrategy {
    public static String REQUESTOPTIONSV2 = "RequestOptionsV2ForLater";
    Logger logger = LoggerFactory.getLogger(RequestOptionsAggregator.class);
    @Override
    public Exchange aggregate(Exchange original, Exchange additional) {
        RequestOptionsResponse newin = additional.getIn().getBody(RequestOptionsResponse.class);
        RequestOption output;
        try {
            output = original.getIn().getMandatoryBody(RequestOption.class);
            output.setDescription(newin.getRequestOptionsData().get(0).getDescription());
            if(output.getDescription().length()==0){
                output.setDescription("not found");
            }
            //Store the newin in the exhange context for later use.
            original.setProperty(REQUESTOPTIONSV2, newin);
        } catch (InvalidPayloadException ex) {
            java.util.logging.Logger.getLogger(RequestOptionsAggregator.class.getName()).log(Level.SEVERE, null, ex);
            original.setException(ex);
        }
        //Store newin on the exchange for use later ( it is needed later ) - perhaps...
        //copy data from one to the other.
        logger.info("Is something stored in the outpu out? " + original.hasOut());
        return original;
    }
    
}
