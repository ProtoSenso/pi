package net.apispark.webapi.representation;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Tag implements java.io.Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;

    private java.lang.String name;

    /**
     * Returns the value of property "id". 
     * 
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

}
