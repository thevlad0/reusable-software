package mobile.notification;

import mobile.filters.Filter;
import mobile.listings.Listing;
import mobile.notification.notifier.EmailNotifier;
import mobile.notification.notifier.NotifierType;
import mobile.notification.notifier.PigeonNotifier;
import mobile.notification.notifier.SMSNotifier;
import mobile.users.User;
import mobile.util.Manager;
import mobile.util.ManagerDistributor;

import java.util.List;

public class Subscription<T> {

    private final String userID;
    private final SubscriptionValidator validator;
    NotifierType notifierType;

    public Subscription(String userID, List<Filter<Listing>> filters, NotifierType notifierType) {
        this.userID = userID;
        this.validator = new SubscriptionValidator(filters);
        this.notifierType = notifierType;
    }

    public boolean isActive(Listing item) {
        return validator.test(item);
    }

    public void send() {
        User u = ManagerDistributor.getDefaultManager(User.class).get(userID);
        switch (notifierType) {
            case EMAIL -> new EmailNotifier().sendEmail(u.email(), "New Notification", "New Notification");
            case PIGEON -> new PigeonNotifier().sendPigeon(u.address(), 0, "New notification");
            case SMS -> new SMSNotifier().sendSms(u.phone(), "New notification");
        }
    }
}
