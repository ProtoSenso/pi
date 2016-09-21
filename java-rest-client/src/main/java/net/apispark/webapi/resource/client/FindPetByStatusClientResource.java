package net.apispark.webapi.resource.client;

import net.apispark.webapi.resource.client.QueryParameterHelper;


public class FindPetByStatusClientResource {

    private final net.apispark.webapi.security.SecurityRuntimeConfigurator securityRuntimeConfigurator;

    private final java.lang.String absolutePath;

    /**
     * Constructor.
     * 
     * @param config
     *            Gathers configuration of the resource URI and security. 
     */
    public FindPetByStatusClientResource(net.apispark.webapi.Config config) {
        this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
        this.absolutePath = config.getBasePath() + "/pet/findByStatus";
    }

    /**
     * Multiple status values can be provided with comma separated strings.
     * 
     * @param status
     *            Status values that need to be considered for filter
     *            Required parameter.
     * @return {@link net.apispark.webapi.representation.PetList} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public net.apispark.webapi.representation.PetList findPetsByStatus(java.lang.String status) {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        QueryParameterHelper.addQueryParameter(client, "status", status);
        securityRuntimeConfigurator.configure(client);

        return client.wrap(net.apispark.webapi.resource.FindPetByStatusResource.class).findPetsByStatus();
    }

}
