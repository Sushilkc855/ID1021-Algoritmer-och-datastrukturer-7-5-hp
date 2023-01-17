package UppB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.crypto.Cipher;

public class Trie {
    public static void main(String[] args) {
    
        Trie foo = new Trie();
        foo.addWord("hello");
        foo.addWord("happy");
        foo.addWord("sad");
        foo.addWord("fell");
        //System.out.println(foo.numbersChar('6')); 
        foo.words("32445");
        
    }

    public static int charToCode(char character) {
        int temp =  character - 'a';
        if (temp > 15) {
            temp--; 
        }
        if (temp > 20) {
            temp--; 
        }/* 
        if (character == 'å') {
            return 24;
        }
        if (character == 'ä') {
            return 25;
        }
        if (character == 'ö') {
            return 26;
        }*/
        return temp;    
    }

    public static char codeToChar(int code) {
    /*     if (code == 24) {
            return 'å';
        }
        if (code == 25) {
            return 'ä';
        }
        if (code == 26) {
            return 'ö';
        }*/
        if (code > 15) {
            code++; 
        }
        if (code > 21) {
            code++; 
        }
        return (char) (code + 97);   
    }


    class Node {
        Node[] next;
        char character; 
        boolean word;
        
        public Node(char chr) {
            next = new Node[27];
            word = false;
            character = chr; 
        }
        public Node(){
            next = new Node[27];
            word = false;
        }

        public Node get(char c){
            int currIndex = charToCode(c);
            if (currIndex < 0 || currIndex > 26) {
                return null;
            }
            return next[currIndex];
        }


        public boolean add(char c)
        {
            int currIndex = charToCode(c);
            if (currIndex < 0 || currIndex > 26) {
                return false;
            }
            //System.out.println(currIndex);
            if (next[currIndex] != null){
                return true;
            } 
            next[currIndex] = new Node(c);
            return true;
        }

    }

    public static Node root;
    public Trie(){
        root = new Node();

    }
    public void addWord(String word){
        Node curr = root;
        char character;
        for (int i = 0; i < word.length() ; i++) {
            character = word.charAt(i);
            curr.add(character);
            curr = curr.get(character);
        }
        curr.word = true;
    } 
/* 
    static Character[][] numberToCharMap;
 
    private static List<String> printWords(int[] numbers, int len, int numcurrIndex, String s, Node curr)
    {
        if (len == numcurrIndex) {
            return new ArrayList<>(Collections.singleton(s));
        }
 
        List<String> stringList = new ArrayList<>();
 
        for (int i = 0; i < numberToCharMap[numbers[numcurrIndex]].length; i++) {
            String sCopy = String.copyValueOf(s.toCharArray());
            sCopy = sCopy.concat(curr.next[numberToCharMap[numbers[numcurrIndex]][i]].character);
            stringList.addAll(printWords(numbers, len, numcurrIndex + 1, sCopy, curr));
        }
        return stringList;
    }

    private static void printWords(int[] numbers)
    {
        Node curr = root;
        generateNumberToCharMap();
        List<String> stringList= printWords(numbers, numbers.length, 0, "", curr);
        stringList.stream().forEach(System.out::println);
    }

    public static void generateNumberToCharMap(){
        numberToCharMap = new Character[10][5];
        numberToCharMap[1]= new Character[] { 0*3, 0*3+1, 0*3+2 };
        numberToCharMap[2]= new Character[] { 1*3, 1*3+1, 1*3+2 };
        numberToCharMap[3]= new Character[] { 2*3, 2*3+1, 2*3+2 };
        numberToCharMap[4]= new Character[] { 3*3, 3*3+1, 3*3+2 };
        numberToCharMap[5]= new Character[] { 4*3, 4*3+1, 4*3+2 };
        numberToCharMap[6]= new Character[] { 5*3, 5*3+1, 5*3+2 };
        numberToCharMap[7]= new Character[] { 6*3, 6*3+1, 6*3+2 };
    }

    public static char[] numbers(int i){
        switch (i) {
            case 1:
                return new char[] {'a', 'b', 'c'};
            case 2:
                return new char[] {'d', 'e', 'f'};
            case 3:
                return new char[] {'g', 'h', 'i'};
            case '4':
                return new char[] {'j', 'k', 'l'};
            case '5':
                return new char[] {'m', 'n', 'o'};
            case '6':
                return new char[] {'p', 'r', 's'};
            case '7':
                return new char[] {'t', 'u', 'v'};
            case '8':
                return new char[] {'x', 'y', 'z'};
            case '9':
                //return new char[] {'å', 'ä', 'ö'};
            default:
                break;
        }
        return null; 
    }
*/
    public static char[] numberToChar(char character){
        switch (character) {
            case '1':
                return new char[] {'a', 'b', 'c'};
            case '2':
                return new char[] {'d', 'e', 'f'};
            case '3':
                return new char[] {'g', 'h', 'i'};
            case '4':
                return new char[] {'j', 'k', 'l'};
            case '5':
                return new char[] {'m', 'n', 'o'};
            case '6':
                return new char[] {'p', 'r', 's'};
            case '7':
                return new char[] {'t', 'u', 'v'};
            case '8':
                return new char[] {'x', 'y', 'z'};
            case '9':
                //return new char[] {'å', 'ä', 'ö'};
            default:
                break;
        }
        return null; 
    }

    public static List<String> stringList; 
    private void search(Node curr, String sequence, String currWord) {
        
        if(curr == null) // return if the tree is empty 
            return;


        int length = sequence.length();
        int currIndex = currWord.length();
        if(currIndex == length) {
            if(curr.word == true)
            System.out.println(currWord);
            stringList.add(currWord);
            return;
        }
            
        
        
        char[] chars = numberToChar(sequence.charAt(currIndex));// get the char at the specefic number

        System.out.println(chars);
        


        // we get the three charrecters and call them recursivly. 
        int a = charToCode(chars[0]); // get the index. 
        System.out.println(a + " " + chars[0]);
        int index1 = a;
        if (curr.next[index1] != null) {
            search(curr.next[index1], sequence, currWord + curr.next[index1].character);    
        }
        int index2 = a + 1;
        if (curr.next[index2] != null) {
            search(curr.next[index2], sequence, currWord + curr.next[index2].character);    
        }
        int index3 = a + 2;
        if (curr.next[index3] != null) {
            search(curr.next[index3], sequence, currWord + curr.next[index3].character);    
        }
        
    }   
    
    public List<String> words(String sequence) {
        //Create a new pointer to the root words Node
        Node cur = root;
        String wor= ""; 
 

        //Search for all possible words
        search(cur, sequence, wor );

        //Return the list content as array
        return null;
    }



}
 /*
        System.out.println(charToCode('a'));
        System.out.println(charToCode('b'));
        System.out.println(charToCode('c'));
        System.out.println(charToCode('d'));
        System.out.println(charToCode('e'));
        System.out.println(charToCode('f'));
        System.out.println(charToCode('g'));
        System.out.println(charToCode('h'));
        System.out.println(charToCode('i'));
        System.out.println(charToCode('j'));
        System.out.println(charToCode('k'));
        System.out.println(charToCode('l'));
        System.out.println(charToCode('m'));
        System.out.println(charToCode('n'));
        System.out.println(charToCode('o'));
        System.out.println(charToCode('p'));

        System.out.println(charToCode('r'));
        System.out.println(charToCode('s'));
        System.out.println(charToCode('t'));
        System.out.println(charToCode('u'));
        System.out.println(charToCode('v'));

        System.out.println(charToCode('x'));
        System.out.println(charToCode('y'));
        System.out.println(charToCode('z'));
        */
        /*
        for(int i =0; i < 27; i++){
            System.out.println(codeToChar(i));
        }
        */