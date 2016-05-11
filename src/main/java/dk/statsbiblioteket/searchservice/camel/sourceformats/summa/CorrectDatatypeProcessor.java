/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.summa;

import java.util.HashMap;
import java.util.Map;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.cxf.jaxws.context.WrappedMessageContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class CorrectDatatypeProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
//        Logger logger = LoggerFactory.getLogger(CorrectDatatypeProcessor.class);
//        Map<String, Object> e = exchange.getProperties();
//        logger.info("Found: " + exchange.getProperties().entrySet().size() + " exchange properties.");
//        for (Map.Entry<String, Object> en : e.entrySet()) {
//            Object key = en.getKey();
//            Object value = en.getValue();
//            logger.info("key: " + key.toString() + " value: " + value.toString());
//        }
//        exchange.setProperty("GUSTAVTESTER", "SUPERFEDT!");
//        Map<String,Object> myprops = new HashMap<String,Object>();
//        myprops.putAll(e);
//        logger.info("################# << MYPROPS: ####################");
//        for (Map.Entry<? extends String, ? extends Object> entry : myprops.entrySet()) {
//            String key = entry.getKey();
//            Object value = entry.getValue();
//            logger.info("key: " + key.toString() + " value: " + value.toString());
//            
//        }
//        logger.info("################# MYPROPS >> ####################");
        
        WrappedMessageContext rc = exchange.getProperty("RequestContext", WrappedMessageContext.class);
        if(rc != null && rc.containsKey("org.apache.camel.component.cxf.DataFormat")){
            rc.remove("org.apache.camel.component.cxf.DataFormat");
        }
    }

}
