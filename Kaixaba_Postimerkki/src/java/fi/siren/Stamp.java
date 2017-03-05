package fi.siren;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
 
/**
 *
 * @author c5msiren
 */
@Entity
@Table(name = "Postimerkit")
public class Stamp {
      
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    
    @Column(name = "asiasanat")
    private String tags;
     
    @Column(name = "ilmestymispäivä")
    private String releaseDate;
    
    @Column(name = "käytön_päättyminen")
    private String endDate;
    
    @Column(name = "nimellisarvo")
    private String value;
    
    @Column(name = "merkin_nimi")
    private String name;
    
    @Column(name = "merkin_väri")
    private String color;
    
    @Column(name = "painopaikka")
    private String printLocation;
    
    @Column(name = "painosmäärä")
    private String printAmount;
    
    @Column(name = "taiteilija")
    private String artist;
    
    @Column(name = "valuutta")
    private String currency;
    
    @Column(name = "kuvan_url")
    private String url;
    
    public Stamp() {}

    public Stamp(String tags, String releaseDate, String endDate, String value,
            String name, String color, String printLocation, String printAmount,
            String artist,String currency, String url) {
        this.tags = tags;
        this.releaseDate = releaseDate;
        this.endDate = endDate;
        this.value = value;
        this.name = name;
        this.color = color;
        this.printLocation = printLocation;
        this.printAmount = printAmount;
        this.artist = artist;
        this.currency = currency;
        this.url = url;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPrintLocation() {
        return printLocation;
    }

    public void setPrintLocation(String printLocation) {
        this.printLocation = printLocation;
    }

    public String getPrintAmount() {
        return printAmount;
    }

    public void setPrintAmount(String printAmount) {
        this.printAmount = printAmount;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
  
    public int getId() {
        return id;
    }
  
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return '{' + "id=" + id + ", tags=" + tags + ", releaseDate=" + 
                releaseDate + ", endDate=" + endDate + ", value=" + value + 
                ", name=" + name + ", color=" + color + ", printLocation=" + 
                printLocation + ", printAmount=" + printAmount + ", artist=" + 
                artist + ", currency=" + currency + ", url=" + url + '}';
    }
    
    public String toJson() {
        return "{" + "\"id\":" + id + ", \"tags\":\"" + tags + "\"}";
    }
}