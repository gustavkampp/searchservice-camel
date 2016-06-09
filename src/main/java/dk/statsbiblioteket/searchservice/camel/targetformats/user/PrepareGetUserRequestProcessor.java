/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.user;

import dk.statsbiblioteket.searchservice.camel.targetformats.user.*;
import dk.statsbiblioteket.searchservice.common.wsgen.uregistry.FindUserAccountRequest;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class PrepareGetUserRequestProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(PrepareGetUserRequestProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
            FindUserAccountRequest glr = new FindUserAccountRequest();
            glr.setAccountId(exchange.getProperty("borrowerid", String.class));
            exchange.getOut().setBody(glr);
    }

}
