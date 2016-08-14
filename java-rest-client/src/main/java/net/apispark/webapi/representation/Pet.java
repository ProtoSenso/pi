package net.apispark.webapi.representation;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Pet implements java.io.Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;

    private net.apispark.webapi.representation.Category category;

    private java.lang.String name;

    private java.util.List<java.lang.String> photoUrls = new java.util.ArrayList<java.lang.String>();

    private java.util.List<net.apispark.webapi.representation.Tag> tags = new java.util.ArrayList<net.apispark.webapi.representation.Tag>();

    private java.lang.String status;

    /**
     * Returns the value of property "id". 
     * unique identifier for the pet
     */
    public java.lang.Integer getId() {
        return id;
    }

    /**
     * Updates the value of property "id". 
     */
    public void setId(java.lang.Integer id) {
        this.id = id;
    }

    /**
     * Returns the value of property "category". 
     * 
     */
    public net.apispark.webapi.representation.Category getCategory() {
        return category;
    }

    /**
     * Updates the value of property "category". 
     */
    public void setCategory(net.apispark.webapi.representation.Category category) {
        this.category = category;
    }

    /**
     * Returns the value of property "name". 
     * 
     */
    public java.lang.String getName() {
        return name;
    }

    /**
     * Updates the value of property "name". 
     */
    public void setName(java.lang.String name) {
        this.name = name;
    }

    /**
     * Returns the value of property "photoUrls". 
     * 
     */
    public java.util.List<java.lang.String> getPhotoUrls() {
        return photoUrls;
    }

    /**
     * Updates the value of property "photoUrls". 
     */
    public void setPhotoUrls(java.util.List<java.lang.String> photoUrls) {
        this.photoUrls = photoUrls;
    }

    /**
     * Returns the value of property "tags". 
     * 
     */
    public java.util.List<net.apispark.webapi.representation.Tag> getTags() {
        return tags;
    }

    /**
     * Updates the value of property "tags". 
     */
    public void setTags(java.util.List<net.apispark.webapi.representation.Tag> tags) {
        this.tags = tags;
    }

    /**
     * Returns the value of property "status". 
     * pet status in the store
     */
    public java.lang.String getStatus() {
        return status;
    }

    /**
     * Updates the value of property "status". 
     */
    public void setStatus(java.lang.String status) {
        this.status = status;
    }

}
