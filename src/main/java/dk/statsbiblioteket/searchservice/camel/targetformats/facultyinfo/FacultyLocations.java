package dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import java.io.Serializable;

@XStreamAlias(value = "data")
public class FacultyLocations implements Serializable {
	@XStreamAlias(value = "Betjeningssteder")
	public List<FacultyLocation> locations;

	public FacultyLocations() {
		// TODO Auto-generated constructor stub
	}
	
	public List<FacultyLocation> getLocations() {
		return locations;
	}

	public void setLocations(List<FacultyLocation> locations) {
		this.locations = locations;
	}
	
}
