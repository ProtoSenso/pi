package net.apispark.webapi.resource.client;

import net.apispark.webapi.resource.client.QueryParameterHelper;


public class PetClientResource {

    private final net.apispark.webapi.security.SecurityRuntimeConfigurator securityRuntimeConfigurator;

    private java.lang.String petId;

    private final java.lang.String absolutePath;

    /**
     * Constructor.
     * 
     * @param config
     *            Gathers configuration of the resource URI and security. 
     * @param petId
     *            ID of pet that needs to be fetched
     */
    public PetClientResource(net.apispark.webapi.Config config, java.lang.String petId) {
        this.securityRuntimeConfigurator = config.getSecurityConfig().getSecurityRuntimeConfigurator();
        this.petId = petId;
        this.absolutePath = config.getBasePath() + "/pet/{petId}";
    }

    /**
     * Returns a single pet.
     * 
     * @return {@link net.apispark.webapi.representation.Pet} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public net.apispark.webapi.representation.Pet getPetById() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("petId", this.petId);
        securityRuntimeConfigurator.configure(client);

        return client.wrap(net.apispark.webapi.resource.PetResource.class).getPetById();
    }

    /**
     * 
     * 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public void deletePet() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("petId", this.petId);
        securityRuntimeConfigurator.configure(client);

        client.wrap(net.apispark.webapi.resource.PetResource.class).deletePet();
    }

    /**
     * 
     * 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    public void updatePetWithForm() {
        org.restlet.resource.ClientResource client = new org.restlet.resource.ClientResource(absolutePath);
        client.setAttribute("petId", this.petId);
        securityRuntimeConfigurator.configure(client);

        client.wrap(net.apispark.webapi.resource.PetResource.class).updatePetWithForm();
    }

}
