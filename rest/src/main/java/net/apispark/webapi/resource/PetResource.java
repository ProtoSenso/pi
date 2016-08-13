package net.apispark.webapi.resource;

public interface PetResource {

    /**
     * Returns a single pet.
     *
     * @return  {@link net.apispark.webapi.representation.Pet} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Get
    net.apispark.webapi.representation.Pet getPetById();

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Delete
    void deletePet();

    /**
     * 
     *
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Post
    void updatePetWithForm();

}