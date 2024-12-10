package mobile;

import mobile.filters.CaseInsensitiveFilter;
import mobile.filters.ExactValueFilter;
import mobile.filters.Filter;
import mobile.filters.RangeFilter;
import mobile.listings.Listing;
import mobile.notification.notifier.NotifierType;
import mobile.users.User;
import mobile.util.Manager;
import mobile.util.ManagerDistributor;
import mobile.vehicle.Car;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ManagerDistributor.getDefaultManager(User.class)
                .add(new User("unknown", "14", "randomID", "0"));

        Car car = new Car("Toyota", "Corolla", 2021, true);
        Car car2 = new Car("Bmw", "e60", 2000, false);

        List<Listing> listings = List.of(
                new Listing(car, "randomID", "RandomDate", true, "", false),
                new Listing(car2, "randomID", "RandomDate", false, "", false)
        );

        List<Filter<Listing>> filters = List.of(
                new ExactValueFilter<>(Listing::isVip, true)
        );

        ManagerDistributor.getSubscriptionManager()
                .add("randomID", filters, NotifierType.EMAIL);

        ManagerDistributor
                .getListingManager()
                .add(new Listing(car, "randomID", "RandomDate", true, "", false));

        ManagerDistributor
                .getListingManager()
                .add(new Listing(car, "randomID", "RandomDate", false, "", false));

//        // само колите от филтрите
//        List<Listing> matchingCars = filterListings(listings, filters);
//        System.out.println("Matching Listings:");
//        matchingCars.forEach(System.out::println);
    }

    // не му е мястото тук, само за демонстративни цели е
    private static List<Listing> filterListings(
            List<Listing> listings,
            List<Filter<Listing>> filters) {
        return listings.stream()
                .filter(car -> filters.stream().allMatch(filter -> filter.matches(car)))
                .toList();
    }
}