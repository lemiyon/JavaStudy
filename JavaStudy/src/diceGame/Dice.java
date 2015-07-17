/**
 * 
 */
package diceGame;

import java.util.Random;

/**
 * @author bola - kim
 * 1. 주사위(Dice, FraudDice)

- 주사위를 던지면 1~6 사이의 정수가 랜덤하게 나옵니다.

- 주사위는 아무 특징이 없는 일반 '주사위'와 '사기주사위'가 있습니다. 2종류입니다.

- 사기주사위에는 세기(레벨?)를 정할수 있습니다. 일반모드, 약함모드, 강함모드

- 사기주사위의 특징입니다

일반모드 : 보통 주사위와 동일합니다.

약함모드 : 5이상의 눈금이 나오면 다시 던집니다.

강함모드 : 2이하의 눈금이 나오면 다시 던집니다.

 
 *
 */
public  class Dice {

	public int toss()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}

class FraudDice extends Dice{
	 //사기 주사위의 모드를 나타내는 정수. 0은 일반, 1은 약함, 2는 강함 모드이며, 나머지는 오류 처리한다.
	public enum FraudMode{
		WEAK(1), NORMAL(0), STRONG(2);
		
		int mode;
		FraudMode(int i)
		{
			this.mode = i;
		}
		public int getMode()
		{
			return mode;
		}
		
	};
	
	FraudMode diceMode;
	
	FraudDice(){
		diceMode = FraudMode.NORMAL;
	}
	
	public int toss()
	{
		int score = super.toss();
		
		switch(diceMode.name())
		{
		case "NORMAL":
			break;
		case "WEAK":
			if(score >= 5)
			score = super.toss();
			break;
		case "STRONG":
			if(score <= 2)
				score = super.toss();
			break;
		};
		
		return score;
	}
	
	public FraudMode getMode(){
	
		return diceMode;
	
	}
	
	void setMode(FraudMode newMode)
	{
		diceMode = newMode;
	}
}