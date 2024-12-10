package mobile.notification;

import mobile.filters.Filter;
import mobile.listings.Listing;

import java.util.List;
import java.util.function.Predicate;

public class SubscriptionValidator implements Predicate<Listing> {
    Predicate<Listing> validator;

    public SubscriptionValidator(List<Filter<Listing>> filters) {
        validator = listing -> filters.stream()
                .allMatch(f -> f.matches(listing));
    }
    public boolean test(Listing item) {
        return validator.test(item);
    }
}
