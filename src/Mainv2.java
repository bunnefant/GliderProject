public class Mainv2 {
    static int increment = 1;
    static int i = 0;
    static int i_max = 10;
    static int j = 0;
    static int j_max = 20;
    static int k = 0;
    static int k_max = 30;
    public static void main (String[] args) {
        while (i != i_max && j != j_max && k != k_max) {
            i += increment;
            if (i == i_max) {
                j += increment;
                i = 0;
            }
            if (j == j_max) {
                k += increment;
                j = 0;
            }
            System.out.println(Integer.toString(i) + " " + Integer.toString(j) + " " + Integer.toString(k));

        }
    }
}
