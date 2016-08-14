package net.apispark.webapi.resource;

public interface PetListResource {

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void addPet(net.apispark.webapi.representation.Pet bean);

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Put
    void updatePet(net.apispark.webapi.representation.Pet bean);

}