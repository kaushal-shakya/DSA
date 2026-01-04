package sc.maths.prime;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        printPrimes(53);
    }
    
    public static void printPrimes(int n) {
        boolean[] sieve = new boolean[n+1]; // all false
        for (int i = 0; i <= n; i++) {
            sieve[i] = true;
        }

        for (int i = 2; i*i <= n; i++) {
            if(sieve[i]) {
                for(int j=i*i; j <= n; j=j+i) {
                    sieve[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if(sieve[i])
                System.out.print(i + " ");
        }
    }
}
