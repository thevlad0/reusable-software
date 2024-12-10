package mobile.listings;

import mobile.vehicle.Vehicle;

public record Listing(
        Vehicle product,
        String ownerId,
        String expiryDate,
        Boolean isVip,
        String description,
        Boolean isService) {

    @Override
    public String toString() {
        return product.toString() + ownerId;
    }
}
