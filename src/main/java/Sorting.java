public class Sorting {

    static void bubble(int[] input)
    {
        for(int i = 0; i < input.length; i++)
        {  // (0, 5)
            for(int j = 0; j < input.length - 1; j++)
            {
                if(j < input.length && input[j] > input[j+1])
                {
                   Utility.swap(input, j, j+1);
                }
            }
        }
    }

    static void selection(int[] input){

        for(int i = 0; i < input.length-1; i++)
        {
            int index = 0;
            for( int j = 0; j < input.length-i; j++)
            {
                if(input[j] > input[index])
                {
                    index = j;
                }
            }
            Utility.swap(input, index, input.length-i-1);
        }
    }

    public static void main(String[] args) {
        int[] arr = {5,8,9,89,5,3,2,1};

        System.out.println("Before Sorting : ");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

//        bubble(arr);
//        System.out.println("Bubble Sorting : " );
//        for (int i = 0; i < arr.length; i++) {
//            System.out.print(arr[i] + " ");
//        }
//        System.out.println();
//
        selection(arr);
        System.out.println("Selection Sorting : " );
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
