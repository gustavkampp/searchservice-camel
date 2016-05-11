package dk.statsbiblioteket.searchservice.common.faktultetsinfo;

import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocations;
import dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo.FacultyLocation;
import java.awt.List;
import java.net.URL;
import java.util.ArrayList;
import org.junit.Test;

import com.thoughtworks.xstream.XStream;

public class RouteTest {
	

    @Test
    public void testRoute() throws Exception {
        // the route is timer based, so every 5th second a message is send
        // we should then expect at least one message
//        getMockEndpoint("mock:result").expectedMinimumMessageCount(1);

        // assert expectations
//        assertMockEndpointsSatisfied();
    	
    	FacultyLocations l = new FacultyLocations();
    	l.setLocations(new ArrayList<FacultyLocation>());
    	
    	XStream xstream = new XStream();
    	xstream.processAnnotations(FacultyLocations.class);
    	xstream.toXML(l, System.out);
    	
    	//xstream.fromXML(new URL("http://library.au.dk:80/fileadmin/www.bibliotek.au.dk/system/XMLfiler/ServiceLocationMaster.xml"));
    	
    	
    	
    }

}
