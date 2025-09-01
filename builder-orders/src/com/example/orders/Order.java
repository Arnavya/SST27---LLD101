package com.example.orders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent;
    private final boolean expedited;
    private final String notes;

    private Order(Builder b) {
        this.id = b.id;
        this.customerEmail = b.customerEmail;
        this.lines = Collections.unmodifiableList(new ArrayList<>(b.lines)); // defensive copy
        this.discountPercent = b.discountPercent;
        this.expedited = b.expedited;
        this.notes = b.notes;
    }

    // getters
    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { return lines; }
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    // calculations
    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }

    // ----------------- Builder -----------------
    public static class Builder {
        private final String id;
        private final String customerEmail;
        private final List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, List<OrderLine> initialLines) {
            this.id = id;
            this.customerEmail = customerEmail;
            if (initialLines != null) this.lines.addAll(initialLines);
        }

        public Builder discountPercent(Integer d) {
            this.discountPercent = d;
            return this;
        }

        public Builder expedited(boolean e) {
            this.expedited = e;
            return this;
        }

        public Builder notes(String n) {
            this.notes = n;
            return this;
        }

        public Builder addLine(OrderLine l) {
            if (l != null) lines.add(l);
            return this;
        }

        public Order build() {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email");
            }
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount");
            }
            if (lines.isEmpty()) {
                throw new IllegalArgumentException("At least one order line required");
            }
            return new Order(this);
        }
    }
}
