//package sc.arrays.binarybeyondsortedarrays;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class SearchSuggestionSystem {
//
//    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        List<String> input = new ArrayList<>(Arrays.asList(products));
//        Collections.sort(input);
////        System.out.println(input);
//        int mid = 0;
//        for (int i = 0; i < searchWord.length(); i++) {
//            String ch = searchWord.substring(0,i+1);
//
//            int start = 0;
//            int end = products.length-1;
//
//            while (start <= end) {
//                mid = start + (end-start)/2;
//                String s = products[mid];
//
//                //Check -> is s starting from ch ?
//                if(ch.compareTo(s.substring(0,i+1)) < 0) {
//                    end = mid-1;
//                } else if (ch.compareTo(s.substring(0,i+1)) > 0) {
//                    start = mid+1;
//                } else {
//                    end = mid-1;
//                }
//            }
//
//            List<String> temp = new ArrayList<>();
//
//            while (start < )
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String[] products = {"aobile","mouse","moneypot","monitor","mousepad"};
//        String searchWord = "mouse";
//
//        suggestedProducts(products, searchWord);
//    }
//}
//package sc.arrays.binarybeyondsortedarrays;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class SearchSuggestionSystem {
//
//    public static List<List<String>> suggestedProducts(String[] products, String searchWord) {
//        List<String> input = new ArrayList<>(Arrays.asList(products));
//        Collections.sort(input);
////        System.out.println(input);
//        int mid = 0;
//        for (int i = 0; i < searchWord.length(); i++) {
//            String ch = searchWord.substring(0,i+1);
//
//            int start = 0;
//            int end = products.length-1;
//
//            while (start <= end) {
//                mid = start + (end-start)/2;
//                String s = products[mid];
//
//                //Check -> is s starting from ch ?
//                if(ch.compareTo(s.substring(0,i+1)) < 0) {
//                    end = mid-1;
//                } else if (ch.compareTo(s.substring(0,i+1)) > 0) {
//                    start = mid+1;
//                } else {
//                    end = mid-1;
//                }
//            }
//
//            List<String> temp = new ArrayList<>();
//
//            while (start < )
//        }
//
//        return null;
//    }
//
//    public static void main(String[] args) {
//        String[] products = {"aobile","mouse","moneypot","monitor","mousepad"};
//        String searchWord = "mouse";
//
//        suggestedProducts(products, searchWord);
//    }
//}
