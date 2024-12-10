package mobile.users;

public record User(
        String name,
        String address,
        String email,
        String phone
) {
    @Override
    public String toString() {
        return email;
    }
}
