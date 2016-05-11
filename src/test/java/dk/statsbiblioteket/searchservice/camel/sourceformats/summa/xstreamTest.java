/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.summa;

import dk.statsbiblioteket.searchservice.camel.sourceformats.summa.Records;
import com.thoughtworks.xstream.XStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import org.junit.Assert;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */

public class xstreamTest {
//@Test
    public void testXstream() {
        XStream xstream = new XStream();
        xstream.processAnnotations(Records.class);

//    	xstream.toXML(l, System.out);
        xstream.ignoreUnknownElements();
        Records f = (Records) xstream.fromXML("");

        Assert.assertNotNull(f.getRecord());
        Assert.assertNotNull(f.getRecord().getContent());
        System.out.println("record: " + f.getRecord().base);
        System.out.println("content: " + f.getRecord().getContent().toString());
    }
}