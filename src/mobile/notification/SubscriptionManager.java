package mobile.notification;

import mobile.filters.Filter;
import mobile.notification.notifier.NotifierType;

import java.util.ArrayList;
import java.util.List;

public class SubscriptionManager {
    private static List<Subscription<?>> subscriptions = new ArrayList<>();

    public void addSubscription(String userID, List<Filter<?>> filters, NotifierType type) {
        subscriptions.add(new Subscription<>(userID, filters, type));
    }

    public void notifySubscribers() {
        for (Subscription subscription : subscriptions) {

        }
    }
}
