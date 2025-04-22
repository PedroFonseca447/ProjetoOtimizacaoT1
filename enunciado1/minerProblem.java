
// public class minerProblem {

//     public static void main ( String args []){

//         String[] S = {"buy Amazon", "buy Google", "buy Apple", "buy Google", "buy Google", "buy NVIDIA"};
//         String[] S_line = {"buy Amazon", "buy Apple","buy Apple","buy Google","buy Google","buy Google"};
//         System.out.println(hasSubSequence(S, S_line)); // false

//     }
//     //notação O(n)
//     private static boolean hasSubSequence( String []S, String []sLine){

//         if(S.length == 0 || sLine.length == 0){
//             return false;
//         }
//              int j =0;

//        for(int i=0; i< S.length && j < sLine.length; i++){
//             if( S[i].equals(sLine[j]) ){
//                 j++;
//             }
//        }
       
//         return j == sLine.length;
//     }
// }