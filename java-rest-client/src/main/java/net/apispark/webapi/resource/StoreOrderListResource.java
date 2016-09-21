package net.apispark.webapi.resource;

public interface StoreOrderListResource {

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void placeOrder(net.apispark.webapi.representation.Order bean);

}