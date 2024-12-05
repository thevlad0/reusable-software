package mobile.notification;

import mobile.filters.Filter;
import mobile.notification.notifier.EmailNotifier;
import mobile.notification.notifier.NotifierType;
import mobile.notification.notifier.PigeonNotifier;
import mobile.notification.notifier.SMSNotifier;
import mobile.users.User;
import mobile.users.repo.UserRepository;

import java.util.List;

public record Subscription<T>(
        String userID,
        List<Filter<T>> filters,
        NotifierType notifierType
) {

    public boolean isActive(T item) {
        return filters.stream()
                .allMatch(filter -> filter.matches(item));
    }

    public void send() {
        User u = UserRepository.getByID(userID);
        switch (notifierType) {
            case EMAIL -> new EmailNotifier().sendEmail(u.email(), "New Notification", "New Notification");
            case PIGEON -> new PigeonNotifier().sendPigeon(u.address(), 0, "New notification");
            case SMS -> new SMSNotifier().sendSms(u.phone(), "New notification");
        }
    }
}
