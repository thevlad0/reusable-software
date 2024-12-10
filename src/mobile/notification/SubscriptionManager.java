package mobile.notification;

import mobile.filters.Filter;
import mobile.listings.Listing;
import mobile.notification.notifier.NotifierType;
import mobile.util.Manager;

import java.util.List;

public class SubscriptionManager extends Manager<Subscription<?>> {

    public void add(String userID, List<Filter<Listing>> filters, NotifierType notifierType) {
        super.add(new Subscription<>(userID, filters, notifierType));
    }

    public void notifyUsers(Listing listing) {
        for (var subscription : repo) {
            if (subscription.isActive(listing)) {
                subscription.send();
            }
        }
    }
}
