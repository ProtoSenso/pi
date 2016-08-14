package net.apispark.webapi.resource.client;

import net.apispark.webapi.resource.client.QueryParameterHelper;


public class UserClientResource {

    private final net.apispark.webapi.security.SecurityRuntimeConfigurator securityRuntimeConfigurator;

    private java.lang.String userlogin;

    private final java.lang.String absolutePath;

    /**
     * Constructor.
     * 
     * @param config
     *            Gathers configuration of the resource URI and security. 
     * @param userlogin
     *            name that need to be deleted
     */
    public UserClientResource(net.apispark.webapi.Config config, java.lang.String userlogin) {
        this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
        this.userlogin = userlogin;
        this.absolutePath = config.getBasePath() + "/user/{userlogin}";
    }

    /**
     * This can only be done by the logged in user.
     * 
     * @param bean
     *            Parameter "bean"
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public void updateUser(net.apispark.webapi.representation.User bean) {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("userlogin", this.userlogin);
        securityRuntimeConfigurator.configure(client);

        client.wrap(net.apispark.webapi.resource.UserResource.class).updateUser(bean);
    }

    /**
     * This can only be done by the logged in user.
     * 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public void deleteUser() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("userlogin", this.userlogin);
        securityRuntimeConfigurator.configure(client);

        client.wrap(net.apispark.webapi.resource.UserResource.class).deleteUser();
    }

    /**
     * 
     * 
     * @return {@link net.apispark.webapi.representation.User} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public net.apispark.webapi.representation.User getUserByName() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("userlogin", this.userlogin);
        securityRuntimeConfigurator.configure(client);

        return client.wrap(net.apispark.webapi.resource.UserResource.class).getUserByName();
    }

}
