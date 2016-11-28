package Builder;

import java.util.Random;

public class Letter {
	String letter; //letter and is a string cause of QU
	int score; //score for each letter
	
	//constructor that generates random letter for letter 
	//and generates the score automatically based on the random letter
	public Letter(){
		letter = randLetter();
		score = scoreFor(letter);
	}
	
	//constructor if we want to generate the letters ourselves
	public Letter(String input){
			letter = input;
			score = scoreFor(letter);
	}
	
	
	String getLetter(){
		return this.letter;
	}
	
	
	int getScore(){
		return this.score;
	}
	
	
	boolean setLetter(String input){
		this.letter = input;
		return true;
	}
	
	
	boolean setScore(int input){
		this.score = score;
		return true;
	}
	
	//return the random letter based on the frequency table
		String randLetter(){
			Random random = new Random();
			int rand = random.nextInt(101); //random numbers upto 100
			if (rand<12){
				return "E";
			}
			else if (rand<19){
				return "T";
			}
			else if (rand<26){
				return "A";
			}
			else if (rand<33){
				return "O";
			}
			else if (rand<40){
				return "I";
			}
			else if (rand<47){
				return "N";
			}
			else if (rand<54){
				return "S";
			}
			else if (rand<60){
				return "H";
			}
			else if (rand<63){
				return "R";
			}
			else if (rand<66){
				return "D";
			}
			else if (rand<69){
				return "L";
			}
			else if (rand<72){
				return "C";
			}
			else if (rand<75){
				return "U";
			}
			else if (rand<78){
				return "M";
			}
			else if (rand<81){
				return "W";
			}
			else if (rand<84){
				return "F";
			}
			else if (rand<87){
				return "G";
			}
			else if (rand<89){
				return "Y";
			}
			else if (rand<91){
				return "P";
			}
			else if (rand<93){
				return "B";
			}
			else if (rand<95){
				return "V";
			}
			else if (rand<96){
				return "K";
			}
			else if (rand<97){
				return "J";
			}
			else if (rand<98){
				return "X";
			}
			else if (rand<99){
				return "Qu";
			}
			else if (rand<100){
				return "Z";
			}
			else{
				return "random value is out of bounds";
			}
		}
	
	//returns the score for given letter
	int scoreFor(String input) {
			switch(input.charAt(0)){
			case 'E':
				return 1;
			case 'T':
				return 1;
			case 'A':
				return 2;
			case 'O':
				return 2;
			case 'I':
				return 2;
			case 'N':
				return 2;
			case 'S':
				return 2;
			case 'H':
				return 2;
			case 'R':
				return 2;
			case 'D':
				return 3;
			case 'L':
				return 3;
			case 'C':
				return 3;
			case 'U':
				return 3;
			case 'M':
				return 3;
			case 'W':
				return 3;
			case 'F':
				return 4;
			case 'G':
				return 4;
			case 'Y':
				return 4;
			case 'P':
				return 4;
			case 'B':
				return 4;
			case 'V':
				return 5;
			case 'K':
				return 5;
			case 'J':
				return 7;
			case 'X':
				return 7;
			case 'Q':
				return 11;
			case 'Z':
				return 8;
			default:
				return -1;
			}
	}

}
