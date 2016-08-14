package net.apispark.webapi.resource;

public interface FindPetByStatusResource {

    /**
     * Multiple status values can be provided with comma separated strings.
     *
     * @return  {@link net.apispark.webapi.representation.PetList} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Get
    net.apispark.webapi.representation.PetList findPetsByStatus();

}