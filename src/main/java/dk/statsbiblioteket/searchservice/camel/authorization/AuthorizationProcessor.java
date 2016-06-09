/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.authorization;

import dk.statsbiblioteket.searchservice.camel.targetformats.circulation.*;
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
 *  Processor that verifies that a JWT is valid ( not expired ) and stores the 
 * JWT subject as property "borrowerid" on the exchange for later use.
 * 
 * 
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
public class AuthorizationProcessor implements Processor {

    Logger logger = LoggerFactory.getLogger(AuthorizationProcessor.class);

    @Override
    public void process(Exchange exchange) throws Exception {
        String auth = exchange.getIn().getHeader("Authorization", java.lang.String.class);
        logger.info("Content of Authorization header: " + auth);
        String token = null;
        for (StringTokenizer stringTokenizer = new StringTokenizer(auth, " "); stringTokenizer.hasMoreTokens();) {
            token = stringTokenizer.nextToken();
        }
//        try {
            Jwt jwt = Jwts.parser().setSigningKey("c29tZXNlY3JldA==").parse(token);
            Claims c = (Claims) jwt.getBody();
            exchange.setProperty("borrowerid", c.getSubject());
//        } catch (ExpiredJwtException e) {
//            logger.error("JWT Error", e);
//            exchange.getIn().setHeader(Exchange.HTTP_RESPONSE_CODE, "401");
//        } catch (IllegalArgumentException e) {
//            logger.error("JWT Error", e);
//            exchange.setException(e);
//        } catch (MalformedJwtException e) {
//            logger.error("JWT Error", e);
//            exchange.setException(e);
//        } catch (SignatureException e) {
//            logger.error("JWT Error", e);
//            exchange.setException(e);
//        }
    }

}
