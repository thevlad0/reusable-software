package mobile.util;

import mobile.listings.ListingManager;
import mobile.notification.SubscriptionManager;
import mobile.users.User;
import mobile.vehicle.Vehicle;

public class ManagerDistributor {
    private static final Manager<User> userManager = new Manager<>();
    private static final Manager<Vehicle> vehicleManager = new Manager<>();
    private static final ListingManager listingManager = new ListingManager();
    private static final SubscriptionManager subscriptionManager = new SubscriptionManager();

    @SuppressWarnings("unchecked")
    public static <T> Manager<T> getDefaultManager(Class<T> clazz) {
        if (clazz.equals(User.class)) {
            return (Manager<T>) userManager;
        }
        if (clazz.equals(Vehicle.class)) {
            return (Manager<T>) vehicleManager;
        }

        return null;
    }

    public static ListingManager getListingManager() {
        return listingManager;
    }

    public static SubscriptionManager getSubscriptionManager() {
        return subscriptionManager;
    }
}
