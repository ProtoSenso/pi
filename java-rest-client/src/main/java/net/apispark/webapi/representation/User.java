package net.apispark.webapi.representation;

import static com.fasterxml.jackson.annotation.JsonInclude.Include.NON_NULL;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(NON_NULL)
public class User implements java.io.Serializable {

	private static final long serialVersionUID = -1349540872013721594L;

	/** Default serial version ID. */

    private java.lang.Integer id;

    private java.lang.String firstName;

    private java.lang.String userlogin;

    private java.lang.String lastName;

    private java.lang.String email;

    private java.lang.String password;

    private java.lang.String phone;

    private java.lang.Integer userStatus;

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
     * Returns the value of property "firstName". 
     * 
     */
    public java.lang.String getFirstName() {
        return firstName;
    }

    /**
     * Updates the value of property "firstName". 
     */
    public void setFirstName(java.lang.String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the value of property "userlogin". 
     * 
     */
    public java.lang.String getUserlogin() {
        return userlogin;
    }

    /**
     * Updates the value of property "userlogin". 
     */
    public void setUserlogin(java.lang.String userlogin) {
        this.userlogin = userlogin;
    }

    /**
     * Returns the value of property "lastName". 
     * 
     */
    public java.lang.String getLastName() {
        return lastName;
    }

    /**
     * Updates the value of property "lastName". 
     */
    public void setLastName(java.lang.String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the value of property "email". 
     * 
     */
    public java.lang.String getEmail() {
        return email;
    }

    /**
     * Updates the value of property "email". 
     */
    public void setEmail(java.lang.String email) {
        this.email = email;
    }

    /**
     * Returns the value of property "password". 
     * 
     */
    public java.lang.String getPassword() {
        return password;
    }

    /**
     * Updates the value of property "password". 
     */
    public void setPassword(java.lang.String password) {
        this.password = password;
    }

    /**
     * Returns the value of property "phone". 
     * 
     */
    public java.lang.String getPhone() {
        return phone;
    }

    /**
     * Updates the value of property "phone". 
     */
    public void setPhone(java.lang.String phone) {
        this.phone = phone;
    }

    /**
     * Returns the value of property "userStatus". 
     * User Status
     */
    public java.lang.Integer getUserStatus() {
        return userStatus;
    }

    /**
     * Updates the value of property "userStatus". 
     */
    public void setUserStatus(java.lang.Integer userStatus) {
        this.userStatus = userStatus;
    }

}
