public class MultiTierDiscountSystem {
    public static void main(String[] args) {
        double purchaseAmount = 250.00;
        double discountPercentage;

        if (purchaseAmount >= 500) {
            discountPercentage = 0.20; // 20% discount
        } else if (purchaseAmount >= 200) {
            discountPercentage = 0.15; // 15% discount
        } else if (purchaseAmount >= 100) {
            discountPercentage = 0.10; // 10% discount
        } else if (purchaseAmount >= 50) {
            discountPercentage = 0.05; // 5% discount
        } else {
            discountPercentage = 0.00; // No discount
        }

        double discountAmount = purchaseAmount * discountPercentage;
        double finalPrice = purchaseAmount - discountAmount;

        System.out.println("Purchase Amount: $" + purchaseAmount);
        System.out.println("Assigned Discount Tier: " + (int)(discountPercentage * 100) + "%");
        System.out.println("Discount Savings: $" + discountAmount);
        System.out.println("Final Discounted Price: $" + finalPrice);
    }
}
