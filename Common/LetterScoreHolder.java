package Common;

import java.util.HashMap;


public class LetterScoreHolder{
    static HashMap<String, Integer> scores;
  //JavaDoc!
    public static int getScores(String letter) {
        if (scores==null) {
            assignScores();
        }
        System.out.println(letter);
        return scores.get(letter).intValue();
    }
    public static void assignScores(){
        scores = new HashMap<String, Integer>();
        scores.put("E", 1);
        scores.put("T", 1);
        scores.put("A", 2);
        scores.put("O", 2);
        scores.put("I", 2);
        scores.put("N", 2);
        scores.put("S", 2);
        scores.put("H", 2);
        scores.put("R", 2);
        scores.put("D", 3);
        scores.put("L", 3);
        scores.put("C", 3);
        scores.put("U", 3);
        scores.put("M", 3);
        scores.put("W", 3);
        scores.put("F", 4);
        scores.put("G", 4);
        scores.put("Y", 4);
        scores.put("P", 4);
        scores.put("B", 4);
        scores.put("V", 5);
        scores.put("K", 5);
        scores.put("J", 7);
        scores.put("X", 7);
        scores.put("QU", 11); 
        scores.put("Z", 8);
        scores.put("", 0);
    }
}