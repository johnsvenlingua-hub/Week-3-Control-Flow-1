public class ATMTransactionAuthorizer {

    public static void processTransaction(String inputUsername, int inputPin, double accountBalance, double withdrawalAmount) {
        String correctUsername = "john_doe";
        int correctPin = 1234;

        System.out.println("=== ATM TRANSACTION AUTHORIZATION ===");
        System.out.println("User: " + inputUsername + " | Balance: $" + accountBalance + " | Withdrawal Request: $" + withdrawalAmount);

        if (inputUsername.equals(correctUsername)) {
            if (inputPin == correctPin) {
                
                String tier;
                double dailyLimit;

                if (accountBalance >= 50000) {
                    tier = "Platinum";
                    dailyLimit = 5000.00;
                } else if (accountBalance >= 10000) {
                    tier = "Gold";
                    dailyLimit = 2500.00;
                } else if (accountBalance >= 2500) {
                    tier = "Silver";
                    dailyLimit = 1000.00;
                } else {
                    tier = "Bronze";
                    dailyLimit = 500.00;
                }

                System.out.println("Account Tier: " + tier + " (Daily Withdrawal Limit: $" + dailyLimit + ")");

                double feePercentage;
                switch (tier) {
                    case "Platinum":
                        feePercentage = 0.00; // 0% fee
                        break;
                    case "Gold":
                        feePercentage = 0.01; // 1% fee
                        break;
                    case "Silver":
                        feePercentage = 0.02; // 2% fee
                        break;
                    case "Bronze":
                    default:
                        feePercentage = 0.03; // 3% fee
                        break;
                }

                double transactionFee = withdrawalAmount * feePercentage;
                double totalDeduction = withdrawalAmount + transactionFee;

                if (withdrawalAmount <= dailyLimit) {
                    if (totalDeduction <= accountBalance) {
                        double remainingBalance = accountBalance - totalDeduction;
                        System.out.println("STATUS: APPROVED");
                        System.out.println("Withdrawal Amount: $" + withdrawalAmount);
                        System.out.println("Transaction Fee (" + (int)(feePercentage * 100) + "%): $" + transactionFee);
                        System.out.println("Total Amount Deducted: $" + totalDeduction);
                        System.out.println("New Remaining Balance: $" + remainingBalance + "\n");
                    } else {
                        System.out.println("STATUS: DENIED");
                        System.out.println("Reason: Insufficient account balance to cover withdrawal amount plus transaction fee ($" + totalDeduction + " required).\n");
                    }
                } else {
                    System.out.println("STATUS: DENIED");
                    System.out.println("Reason: Requested amount exceeds the daily limit ($" + dailyLimit + ") for " + tier + " tier.\n");
                }

            } else {
                System.out.println("STATUS: DENIED");
                System.out.println("Reason: Invalid 4-digit PIN.\n");
            }
        } else {
            System.out.println("STATUS: DENIED");
            System.out.println("Reason: Invalid username.\n");
        }
    }

    public static void main(String[] args) {
        // Test Case 1: Invalid PIN Denial
        processTransaction("john_doe", 9999, 5000.00, 200.00);

        // Test Case 2: Exceeding Daily Limit Denial (Silver Tier Limit = $1000)
        processTransaction("john_doe", 1234, 3000.00, 1500.00);

        // Test Case 3: Insufficient Funds for Fee Denial
        processTransaction("john_doe", 1234, 500.00, 490.00);

        // Test Case 4: Approved Transaction (Gold Tier)
        processTransaction("john_doe", 1234, 15000.00, 2000.00);
    }
}
