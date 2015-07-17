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

	//주사위를 던지면 나오는 . 1~6의 정수를 반환한다.
	public int toss()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}

//FraudPlayer가 사용하는 FraudDice. 주사위의 모드를 나타내는 enum을 갖고 있다. 
class FraudDice extends Dice{
	
	//FraudDice의 상태를 나타내는 Enum.
	public enum FraudMode{
		WEAK(1), NORMAL(0), STRONG(2);
		//사기 주사위의 모드를 나타내는 정수. 0은 일반, 1은 약함, 2는 강함 모드이며, 나머지는 오류 처리한다.
		int mode; 
		//Enum의 생성자.
		FraudMode(int i)
		{
			this.mode = i;
		}
		//Enum 객체의 mode(정수) 값을 반환한다. 상태를 알고 싶으면 Enum명.name()을 사용한다.
		public int getMode()
		{
			return mode;
		}
		
	};
	
	//주사위의 상태를 나타내는 Enum형 변
	FraudMode diceMode;
	
	//FraudDice의 생성자. 기본모드는 Normal이다.
	FraudDice(){
		diceMode = FraudMode.NORMAL;
	}
	
	//FraudDice의 던지는 동작. 
	public int toss()
	{
		//처음에는 그냥 던진다.
		int score = super.toss();
		
		//주사위 상태에 따라 나온 눈에 따라서, 주사위 상태에 따라 다시 던지기도 하고 말기도 한다.
		switch(diceMode.name())
		{
		case "NORMAL":
			//노말 모드인 경우 그냥 통과한다. 
			break;
		case "WEAK": //약함 모드이고, 주사위 눈 값이 5를 넘을 경우 다시 던진다.
			if(score >= 5)
			score = super.toss();
			break;
		case "STRONG": //강함 모드이고, 주사위 눈 값이 2이하일 경우 다시 던진다.
			if(score <= 2)
				score = super.toss();
			break;
		};
		
		return score;//최종적인 주사위 눈 값을 반환한다.
	}
	
	//주사위 상태 값을 반환한다.
	public FraudMode getMode(){
	
		return diceMode;
	
	}
	
	//주사위 상태를 변경한다.
	 void setMode(FraudMode newMode)
	{
		diceMode = newMode;
	}
}