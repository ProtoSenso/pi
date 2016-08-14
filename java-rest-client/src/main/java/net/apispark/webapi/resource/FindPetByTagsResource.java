package net.apispark.webapi.resource;

public interface FindPetByTagsResource {

    /**
     * Multiple tags can be provided with comma separated strings. Use tag1, tag2, tag3 for testing.
     *
     * @return  {@link net.apispark.webapi.representation.PetList} 
     * @throws org.restlet.resource.ResourceException if the call to the API fails
     */
    @org.restlet.resource.Get
    net.apispark.webapi.representation.PetList findPetsByTags();

}