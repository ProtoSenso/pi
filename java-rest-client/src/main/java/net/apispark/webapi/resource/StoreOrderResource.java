package net.apispark.webapi.resource;

public interface StoreOrderResource {

    /**
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors.
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Delete
    void deleteOrder();

    /**
     * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions.
     *
     * @return  {@link net.apispark.webapi.representation.Order} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Get
    net.apispark.webapi.representation.Order getOrderById();

}