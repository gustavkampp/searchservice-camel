/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.handler.summastorage;

import dk.statsbiblioteket.searchservice.common.wsgen.sstorage.GetRecords;
import java.util.ArrayList;
import java.util.List;
import org.apache.camel.Handler;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class GetRecordRequest {
    public static Logger logger = LoggerFactory.getLogger(GetRecordRequest.class);
    @Handler
    public GetRecords.Ids prepareCall(@Header("recordid") String recordid){
        logger.info("PREPPING REQUEST with recordid: " + recordid);
        GetRecords r = new GetRecords();
        GetRecords.Ids recordids = new GetRecords.Ids();
        
        recordids.getId().add(recordid);
        return recordids;
    }
    
}
