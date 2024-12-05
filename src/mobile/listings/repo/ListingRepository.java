package mobile.listings.repo;

import mobile.listings.Listing;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ListingRepository {
    List<Listing> listings = new ArrayList<>();

    public void add(Listing listing) {
        listings.add(listing);
    }

    public Stream<Listing> getByID(int id) {
        return listings.stream()
                .filter(l -> l.id() == id)
                .findFirst().stream();
    }
}
