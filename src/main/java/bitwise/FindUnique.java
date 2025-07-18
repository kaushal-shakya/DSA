package bitwise;

class FindUnique
{
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 6, 3, 2, 4};
        System.out.println(findUnique(arr));
    }

    static int findUnique(int[] arr)
    {   int unique = 0;
        for(int i : arr){
           unique ^= i;
        }
        return unique;
    }

}