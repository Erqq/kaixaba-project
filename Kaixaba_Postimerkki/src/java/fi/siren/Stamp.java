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

    public Stamp() {
    }

    /**
     * Makes the stamp with params.
     *
     * @param tags
     * @param releaseDate
     * @param endDate
     * @param value
     * @param name
     * @param color
     * @param printLocation
     * @param printAmount
     * @param artist
     * @param currency
     * @param url
     */
    public Stamp(String tags, String releaseDate, String endDate, String value,
            String name, String color, String printLocation, String printAmount,
            String artist, String currency, String url) {
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

    /**
     * Gets the tags.
     *
     * @return tags
     */
    public String getTags() {
        return tags;
    }

    /**
     * Sets the tags.
     *
     * @param tags
     */
    public void setTags(String tags) {
        this.tags = tags;
    }

    /**
     * Gets the releaseDate.
     *
     * @return releaseDate
     */
    public String getReleaseDate() {
        return releaseDate;
    }

    /**
     * Sets the releaseDate.
     *
     * @param releaseDate
     */
    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    /**
     * Gets the endDate.
     *
     * @return endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * Sets the endDate.
     *
     * @param endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Gets the value.
     *
     * @return value
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value.
     *
     * @param value
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the name.
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name.
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the color.
     *
     * @return color
     */
    public String getColor() {
        return color;
    }

    /**
     * Sets the color.
     *
     * @param color
     */
    public void setColor(String color) {
        this.color = color;
    }

    /**
     * Gets the printLocation.
     *
     * @return printLocation
     */
    public String getPrintLocation() {
        return printLocation;
    }

    /**
     * Sets the printLocation
     *
     * @param printLocation
     */
    public void setPrintLocation(String printLocation) {
        this.printLocation = printLocation;
    }

    /**
     * Gets the printAmount.
     *
     * @return printAmount
     */
    public String getPrintAmount() {
        return printAmount;
    }

    /**
     * Sets the printAmount.
     *
     * @param printAmount
     */
    public void setPrintAmount(String printAmount) {
        this.printAmount = printAmount;
    }

    /**
     * Gets the artist.
     *
     * @return artist.
     */
    public String getArtist() {
        return artist;
    }

    /**
     * Sets the artist.
     *
     * @param artist
     */
    public void setArtist(String artist) {
        this.artist = artist;
    }

    /**
     * Gets the currency.
     *
     * @return currency
     */
    public String getCurrency() {
        return currency;
    }

    /**
     * Sets the currency.
     *
     * @param currency
     */
    public void setCurrency(String currency) {
        this.currency = currency;
    }

    /**
     * Gets the url.
     *
     * @return url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets the url.
     *
     * @param url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets the id.
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the id.
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Returns stamp as a string.
     *
     * @return stamp to string.
     */
    @Override
    public String toString() {
        return '{' + "id=" + id + ", tags=" + tags + ", releaseDate="
                + releaseDate + ", endDate=" + endDate + ", value=" + value
                + ", name=" + name + ", color=" + color + ", printLocation="
                + printLocation + ", printAmount=" + printAmount + ", artist="
                + artist + ", currency=" + currency + ", url=" + url + '}';
    }

    /**
     * Returns stamp as Json.
     *
     * @return stamp to Json
     */
    public String toJson() {
        return "{" + "\"id\":" + id + ", \"tags\":\"" + tags + "\", "
                + "\"releaseDate\":\"" + releaseDate + "\", "
                + "\"endDate\":\"" + endDate + "\", "
                + "\"value\":" + value + ", "
                + "\"name\":\"" + name + "\", "
                + "\"color\":\"" + color + "\", "
                + "\"printLocation\":\"" + printLocation + "\", "
                + "\"printAmount\":" + printAmount + ", "
                + "\"artist\":\"" + artist + "\", "
                + "\"currency\":\"" + currency + "\", "
                + "\"url\":\"" + url + "\""
                + "}";
    }
}
