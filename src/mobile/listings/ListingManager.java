package mobile.listings;

import mobile.listings.repo.ListingRepository;

public record ListingManager() {
    private static final ListingRepository repo = new ListingRepository();

    public void add(Listing listing) {
        repo.add(listing);


    }

    public void getByID(int id) {
        repo.getByID(id);
    }
}
