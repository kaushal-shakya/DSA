package sc.maths.prime;

public class Sieve {

    private static void sieve(int n) {
        boolean[] sieve = new boolean[n+1];
        for (int i = 2; i < n; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i*i <= n ; i++) {
            if(sieve[i]) {
                for (int j = 2; i*j <=n ; j++) {
                    sieve[i*j] = false;
                }
            }
        }

        for (int i = 1; i <= n; i++) {
            System.out.println(i + " " + sieve[i]);
        }
    }

    public static void main(String[] args) {
        sieve(26);
    }
}
