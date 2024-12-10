package mobile.listings;

import mobile.util.Manager;
import mobile.util.ManagerDistributor;

public class ListingManager extends Manager<Listing> {
    @Override
    public void add(Listing listing) {
        super.add(listing);

        ManagerDistributor.getSubscriptionManager()
                .notifyUsers(listing);
    }
}
