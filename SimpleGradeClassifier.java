public class SimpleGradeClassifier {
    public static void main(String[] args) {
        int score = 85;

        System.out.println("Testing with score: " + score);
        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }

        score = 45;
        System.out.println("\nTesting with score: " + score);
        if (score >= 60) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");
        }
    }
}
