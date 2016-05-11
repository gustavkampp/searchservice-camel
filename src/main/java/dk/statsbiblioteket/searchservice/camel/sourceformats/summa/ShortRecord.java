/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dk.statsbiblioteket.searchservice.camel.sourceformats.summa;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamImplicit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * <shortrecord><rdf:RDF><rdf:Description><dc:title>Hest</dc:title><dc:creator>Katie
 * Dicker</dc:creator><dc:type xml:lang="da">bog</dc:type><dc:type xml:lang="en">book</dc:type><dc:date>2014</dc:date><dc:identifier>ISBN
 * 9788762721074</dc:identifier></rdf:Description></rdf:RDF></shortrecord>
 *
 *
 * @author Gustav Sverre Kampp <gsk@statsbiblioteket.dk>
 */
@JsonInclude(Include.NON_NULL)
@XStreamAlias("Description")
public class ShortRecord {

    String title;

    @XStreamImplicit
    @XStreamAlias("creator")
    List<String> creator = new ArrayList<String>();

    String date;

    @XStreamImplicit
    @XStreamAlias("identifier")
    List<String> identifier = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("edition")
    List<String> edition = new ArrayList<String>();

    @XStreamImplicit
    LinkedList<ShortRecordType> type;

    @XStreamImplicit
    @XStreamAlias("contributor")
    List<String> contributor = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("coverage")
    List<String> coverage = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("description")
    List<String> description = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("format")
    List<String> format = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("language")
    List<String> language = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("publisher")
    List<String> publisher = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("relation")
    List<String> relation = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("rights")
    List<String> rights = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("source")
    List<String> source = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("subject")
    List<String> subject = new ArrayList<String>();

    @XStreamImplicit
    @XStreamAlias("issn")
    List<String> issn = new ArrayList<String>();

    @JsonGetter("creator")
    public String getCreators() {
        String out = null;
        if (getCreator() != null) {
            out = "";
            for (Iterator<String> iterator = getCreator().iterator(); iterator.hasNext();) {
                out += iterator.next();
                if (iterator.hasNext()) {
                    out += ",";
                }
            }
        }
        return out;

    }

    @JsonGetter("identifier")
    public String getIdentifiers() {
        String out = null;
        if (getIdentifier() != null) {
            out = "";
            for (Iterator<String> iterator = getIdentifier().iterator(); iterator.hasNext();) {
                out += iterator.next();
                if (iterator.hasNext()) {
                    out += ",";
                }
            }
        }
        return out;

    }

    @JsonGetter("edition")
    public String getEditions() {
        String out = null;
        if (getEdition() != null) {
            out = "";
            for (Iterator<String> iterator = getEdition().iterator(); iterator.hasNext();) {
                out += iterator.next();
                if (iterator.hasNext()) {
                    out += ",";
                }
            }
        }
        return out;

    }

    @JsonGetter("source")
    public String getSources() {
        String out = null;
        if (getSource() != null) {
            out = "";
            for (Iterator<String> iterator = getSource().iterator(); iterator.hasNext();) {
                out += iterator.next();
                if (iterator.hasNext()) {
                    out += ",";
                }
            }
        }
        return out;

    }

    @JsonGetter("issn")
    public String getIssns() {
        String out = null;
        if (getIssn() != null) {
            out = "";
            for (Iterator<String> iterator = getIssn().iterator(); iterator.hasNext();) {
                out += iterator.next();
                if (iterator.hasNext()) {
                    out += ",";
                }
            }
        }
        return out;

    }

    public List<String> getEdition() {
        return edition;
    }

    public void setEdition(List<String> edition) {
        this.edition = edition;
    }

    public void setCreator(List<String> creator) {
        this.creator = creator;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public List<String> getIdentifier() {
        return identifier;
    }

    public void setIdentifier(List<String> identifier) {
        this.identifier = identifier;
    }

    public LinkedList<ShortRecordType> getType() {
        return type;
    }

    public void setType(LinkedList<ShortRecordType> type) {
        this.type = type;
    }

    public List<String> getContributor() {
        return contributor;
    }

    public void setContributor(List<String> contributor) {
        this.contributor = contributor;
    }

    public List<String> getCoverage() {
        return coverage;
    }

    public void setCoverage(List<String> coverage) {
        this.coverage = coverage;
    }

    public List<String> getDescription() {
        return description;
    }

    public void setDescription(List<String> description) {
        this.description = description;
    }

    public List<String> getFormat() {
        return format;
    }

    public void setFormat(List<String> format) {
        this.format = format;
    }

    public List<String> getLanguage() {
        return language;
    }

    public void setLanguage(List<String> language) {
        this.language = language;
    }

    public List<String> getPublisher() {
        return publisher;
    }

    public void setPublisher(List<String> publisher) {
        this.publisher = publisher;
    }

    public List<String> getRelation() {
        return relation;
    }

    public void setRelation(List<String> relation) {
        this.relation = relation;
    }

    public List<String> getRights() {
        return rights;
    }

    public void setRights(List<String> rights) {
        this.rights = rights;
    }

    public List<String> getSource() {
        return source;
    }

    public void setSource(List<String> source) {
        this.source = source;
    }

    public List<String> getSubject() {
        return subject;
    }

    public void setSubject(List<String> subject) {
        this.subject = subject;
    }

    public List<String> getIssn() {
        return issn;
    }

    public void setIssn(List<String> issn) {
        this.issn = issn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getCreator() {
        return creator;
    }

}
