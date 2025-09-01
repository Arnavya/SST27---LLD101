import com.example.orders.*;
import java.util.List;

public class TryIt {
    public static void main(String[] args) {
        OrderLine l1 = new OrderLine("A", 1, 200);
        OrderLine l2 = new OrderLine("B", 3, 100);

        Order o = new Order.Builder("o2", "a@b.com", List.of(l1, l2))
                .discountPercent(10)
                .build();

        System.out.println("Before: " + o.totalAfterDiscount());

        // This line won't compile anymore because OrderLine is immutable:
        // l1.setQuantity(999);

        System.out.println("After:  " + o.totalAfterDiscount());
        System.out.println("=> In the solution, totals remain stable because lines are immutable + defensive copied.");
    }
}
