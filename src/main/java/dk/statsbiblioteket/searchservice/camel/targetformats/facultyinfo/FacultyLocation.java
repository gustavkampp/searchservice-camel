package dk.statsbiblioteket.searchservice.camel.targetformats.facultyinfo;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import java.io.Serializable;

@XStreamAlias(value = "Betjeningssted")
public class FacultyLocation implements Serializable {
		@XStreamAsAttribute
		String id;
		@XStreamAsAttribute
		String facultyID;
		String Navn;
		String NavnEN;
		String Betjeningsstedsside;
		String BetjeningsstedssideEN;
		String adresse; //HTML formatteret
		String mailadresse;
		String telefonnummer;
		String FakultetsNavnDK;
		String FakultetsNavnEN;
		@XStreamOmitField
		private Object Facilteter;
		@XStreamOmitField
		private Object OpeningHours;
		@XStreamOmitField
		private Object ServiceHours;
		@XStreamOmitField
		private Object HolidayOpeningHours;
		@XStreamOmitField
		private Object HolidayOpeningHours2;
		@XStreamOmitField
		private Object ExeptionsOpeningHours;		
		
		public FacultyLocation() {
			// TODO Auto-generated constructor stub
		}
		
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getFacultyID() {
			return facultyID;
		}
		public void setFacultyID(String facultyID) {
			this.facultyID = facultyID;
		}
		public String getNavn() {
			return Navn;
		}
		public void setNavn(String navn) {
			Navn = navn;
		}
		public String getNavnEN() {
			return NavnEN;
		}
		public void setNavnEN(String navnEN) {
			NavnEN = navnEN;
		}
		public String getBetjeningsstedsside() {
			return Betjeningsstedsside;
		}
		public void setBetjeningsstedsside(String betjeningsstedsside) {
			Betjeningsstedsside = betjeningsstedsside;
		}
		public String getBetjeningsstedssideEN() {
			return BetjeningsstedssideEN;
		}
		public void setBetjeningsstedssideEN(String betjeningsstedssideEN) {
			BetjeningsstedssideEN = betjeningsstedssideEN;
		}
		public String getAdresse() {
			return adresse;
		}
		public void setAdresse(String adresse) {
			this.adresse = adresse;
		}
		public String getMailadresse() {
			return mailadresse;
		}
		public void setMailadresse(String mailadresse) {
			this.mailadresse = mailadresse;
		}
		public String getTelefonnummer() {
			return telefonnummer;
		}
		public void setTelefonnummer(String telefonnummer) {
			this.telefonnummer = telefonnummer;
		}
		public String getFakultetsNavnDK() {
			return FakultetsNavnDK;
		}
		public void setFakultetsNavnDK(String fakultetsNavnDK) {
			FakultetsNavnDK = fakultetsNavnDK;
		}
		public String getFakultetsNavnEN() {
			return FakultetsNavnEN;
		}
		public void setFakultetsNavnEN(String fakultetsNavnEN) {
			FakultetsNavnEN = fakultetsNavnEN;
		}
		
}
