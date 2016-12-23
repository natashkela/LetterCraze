package Common;

import java.util.LinkedList;

public class Theme extends Level{
    String theme;//theme name
    LinkedList<String> themeWords;//
    Board initialBoard; 


    /** 
     * Constructs full theme level.
     * 
     * Initial value is given.
     * @param b    Arrangement of tiles in board
     * @param g    Goals for the theme level (Amount of words found)
     * @param theme Adds Theme description
     * @param validWords Adds valid words based on theme description
     */
    public Theme(Board initialBoard, StarThresholds starThresholds, String theme, LinkedList<String> themeWords) {
        super(initialBoard,starThresholds,"Theme");
        this.theme = theme;
        this.themeWords = themeWords;
        Tile[] tiles=new Tile[36];
        int i=0;
        for (int row=0;row<6;row++) {
            for (int col=0;col<6;col++) {
                if (initialBoard.getTile(row,col).isActive) {
                    tiles[i]=new Tile(initialBoard.getTile(col,row).coordinates, 
                    					initialBoard.getTile(col,row).isActive, 
                    					new Letter(initialBoard.getTile(col,row).recentLetter().letter));
                    //take care of this!
                }
                else {
                    tiles[i] = new Tile(initialBoard.getTile(col,row).coordinates, false);
                }
                i++;
            }
        }
        this.initialBoard = new Board(tiles);
    }

    public String getTheme() {
        return theme;
    }

    public LinkedList<String> getThemeWords() {
        return themeWords;
    }

    public Board getInitialBoard() {
        return initialBoard;
    }

    void initWordTable() {
        WordTable.loadWordTable(themeWords);
    }

    /**
     * Resets all entities in level.
     */
    @Override
    public void resetLevel() {
        Tile[] tiles=new Tile[36];
        int i=0;
        for (int row=0;row<6;row++) {
            for (int col=0;col<6;col++) {
                if (initialBoard.getTile(col,row).isActive){
                    tiles[i] = new Tile(initialBoard.getTile(col,row).coordinates, 
                    		initialBoard.getTile(col,row).isActive, 
                    		new Letter(initialBoard.getTile(col,row).recentLetter().letter));//????
                    //take care of this!!!
                }
                else {
                    tiles[i] = new Tile(initialBoard.getTile(col,row).coordinates, false);
                }
                i++;
            }
        }
        this.initialBoard = new Board(tiles);
        current = new Points(); //points set to 0 again
        moves.clear(); //??????
        foundWords.clear(); //?????
    }


}
