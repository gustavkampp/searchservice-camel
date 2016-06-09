/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.targetformats.circulation;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import dk.statsbiblioteket.searchservice.common.wsgen.circulation.GetLoansRequest;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwt;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.ExpiredJwtException;
import java.util.StringTokenizer;
import org.apache.camel.Header;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class PrepareGetLoansRequestProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(PrepareGetLoansRequestProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
            GetLoansRequest glr = new dk.statsbiblioteket.searchservice.common.wsgen.circulation.GetLoansRequest();
            glr.setUserIdentification(exchange.getProperty("borrowerid", String.class));
            exchange.getOut().setBody(glr);
    }

}
