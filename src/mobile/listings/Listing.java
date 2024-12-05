package mobile.listings;

import mobile.vehicle.Vehicle;

public record Listing(
        Integer id,
        Vehicle product,
        String ownerId,
        String expiryDate,
        Boolean isVip,
        String description,
        Boolean isService) {

}
