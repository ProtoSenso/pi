package net.apispark.webapi.resource.client;

import net.apispark.webapi.resource.client.QueryParameterHelper;


public class StoreOrderClientResource {

    private final net.apispark.webapi.security.SecurityRuntimeConfigurator securityRuntimeConfigurator;

    private java.lang.String orderId;

    private final java.lang.String absolutePath;

    /**
     * Constructor.
     * 
     * @param config
     *            Gathers configuration of the resource URI and security. 
     * @param orderId
     *            ID of the order that needs to be deleted
     */
    public StoreOrderClientResource(net.apispark.webapi.Config config, java.lang.String orderId) {
        this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
        this.orderId = orderId;
        this.absolutePath = config.getBasePath() + "/store/order/{orderId}";
    }

    /**
     * For valid response try integer IDs with positive integer value. Negative or non-integer values will generate API errors.
     * 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public void deleteOrder() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("orderId", this.orderId);
        securityRuntimeConfigurator.configure(client);

        client.wrap(net.apispark.webapi.resource.StoreOrderResource.class).deleteOrder();
    }

    /**
     * For valid response try integer IDs with value >= 1 and <= 10. Other values will generated exceptions.
     * 
     * @return {@link net.apispark.webapi.representation.Order} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public net.apispark.webapi.representation.Order getOrderById() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("orderId", this.orderId);
        securityRuntimeConfigurator.configure(client);

        return client.wrap(net.apispark.webapi.resource.StoreOrderResource.class).getOrderById();
    }

}
