package dk.statsbiblioteket.searchservice.common.faktultetsinfo;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocations;
import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocation;

public class xstreamTest {

	
	
	
    @Test
    public void testRoute() throws Exception {
    	
    	FacultyLocations l = new FacultyLocations();
    	l.setLocations(new ArrayList<FacultyLocation>());
    	
    	XStream xstream = new XStream();
    	xstream.processAnnotations(FacultyLocations.class);

//    	xstream.toXML(l, System.out);
    	xstream.ignoreUnknownElements();
    	FacultyLocations f = (FacultyLocations)xstream.fromXML(new URL("http://library.au.dk:80/fileadmin/www.bibliotek.au.dk/system/XMLfiler/ServiceLocationMaster.xml"));
    	
    	assertTrue(f.getLocations().size()>0);
    	
    	for (Iterator flocit = f.getLocations().iterator(); flocit.hasNext();) {
    		FacultyLocation type = (FacultyLocation) flocit.next();
			System.out.println(type.getFacultyID());
    		
			
		}
    	
    }

	
}
