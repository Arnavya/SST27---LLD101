import com.example.profiles.*;

public class TryIt {
    public static void main(String[] args) {
        ProfileService svc = new ProfileService();

        // minimal profile
        UserProfile p1 = svc.createMinimal("u1", "a@b.com");
        System.out.println("Profile1: " + p1.getId() + ", " + p1.getEmail());

        // profile with display name
        UserProfile p2 = svc.createWithDisplayName("u2", "x@y.com", "Shray");
        System.out.println("Profile2: " + p2.getId() + ", " + p2.getDisplayName());

        // builder directly
        UserProfile p3 = new UserProfile.Builder("u3", "z@k.com")
                .phone("1234567890")
                .twitter("@shray")
                .github("github.com/shray")
                .build();
        System.out.println("Profile3: " + p3.getId() + ", " + p3.getTwitter());
    }
}
