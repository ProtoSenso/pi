package net.apispark.webapi.representation;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class Order implements java.io.Serializable {
    /** Default serial version ID. */
    private static final long serialVersionUID = 1L;

    private java.lang.Integer id;

    private java.lang.Integer petId;

    private java.lang.Integer quantity;

    private java.lang.String status;

    private java.lang.String shipDate;

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
     * Returns the value of property "petId". 
     * 
     */
    public java.lang.Integer getPetId() {
        return petId;
    }

    /**
     * Updates the value of property "petId". 
     */
    public void setPetId(java.lang.Integer petId) {
        this.petId = petId;
    }

    /**
     * Returns the value of property "quantity". 
     * 
     */
    public java.lang.Integer getQuantity() {
        return quantity;
    }

    /**
     * Updates the value of property "quantity". 
     */
    public void setQuantity(java.lang.Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * Returns the value of property "status". 
     * Order Status
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

    /**
     * Returns the value of property "shipDate". 
     * 
     */
    public java.lang.String getShipDate() {
        return shipDate;
    }

    /**
     * Updates the value of property "shipDate". 
     */
    public void setShipDate(java.lang.String shipDate) {
        this.shipDate = shipDate;
    }

}
