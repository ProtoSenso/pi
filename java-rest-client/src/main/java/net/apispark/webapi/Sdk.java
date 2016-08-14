package net.apispark.webapi;

/**
 * Entry-point for API calls.
 */
public class Sdk {

    private final net.apispark.webapi.Config config = new net.apispark.webapi.Config();

    /**
     * Returns the SDK configuration.
     */
    public net.apispark.webapi.Config getConfig() {
        return config;
    }

    public net.apispark.webapi.resource.client.FindPetByTagsClientResource findPetByTags() {
        return new net.apispark.webapi.resource.client.FindPetByTagsClientResource(config);
    }

    public net.apispark.webapi.resource.client.PetClientResource pet(java.lang.String petId) {
        return new net.apispark.webapi.resource.client.PetClientResource(config, petId);
    }

    public net.apispark.webapi.resource.client.PetListClientResource petList() {
        return new net.apispark.webapi.resource.client.PetListClientResource(config);
    }

    public net.apispark.webapi.resource.client.FindPetByStatusClientResource findPetByStatus() {
        return new net.apispark.webapi.resource.client.FindPetByStatusClientResource(config);
    }

    public net.apispark.webapi.resource.client.StoreOrderClientResource storeOrder(java.lang.String orderId) {
        return new net.apispark.webapi.resource.client.StoreOrderClientResource(config, orderId);
    }

    public net.apispark.webapi.resource.client.StoreOrderListClientResource storeOrderList() {
        return new net.apispark.webapi.resource.client.StoreOrderListClientResource(config);
    }

    public net.apispark.webapi.resource.client.UserListClientResource userList() {
        return new net.apispark.webapi.resource.client.UserListClientResource(config);
    }

    public net.apispark.webapi.resource.client.CreateUsersWithArrayClientResource createUsersWithArray() {
        return new net.apispark.webapi.resource.client.CreateUsersWithArrayClientResource(config);
    }

    public net.apispark.webapi.resource.client.CreateUsersWithListClientResource createUsersWithList() {
        return new net.apispark.webapi.resource.client.CreateUsersWithListClientResource(config);
    }

    public net.apispark.webapi.resource.client.UserClientResource user(java.lang.String userlogin) {
        return new net.apispark.webapi.resource.client.UserClientResource(config, userlogin);
    }

}
