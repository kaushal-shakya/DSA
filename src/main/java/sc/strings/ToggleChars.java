package sc.strings;

public class ToggleChars {
    public static void main(String[] args) {
        char[] input = "patThAn".toCharArray();
        System.out.println(toggleChars(input));

        char ch = 65;

        System.out.println(ch);

        char ct = 'A' + 2;
        System.out.println(ct);
    }

    public static char[] toggleChars(char[] input)
    {
        for(int i = 0; i < input.length; i++ )
        {
            char ch = input[i];
            if(ch >= 'A' && ch <= 'Z')
            {
//                input[i] = ch + 32;
            }
            else if(ch >= 'a' && ch <= 'z')
            {
//                input[i] = ch - 32;
            }


        }
        return input;
    }
}
