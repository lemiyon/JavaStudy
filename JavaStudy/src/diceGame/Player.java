/*
 * 2. 플레이어(Player, FraudPlayer)

- 플레이어는 이름을 정할수 있고, 주사위를 들고있습니다. 또한 본인의 합계득점을 기억합니다.

- 플레이어도 일반 '플레이어'가 있으며, 사기주사위를 사용하는 '사기플레이어'가 있습니다.

- 사기플레이어는 지고있을경우 얍삽하게도 사기주사위 레벨을 높입니다(강함모드).

- 6점이상차이로 이기고 있는경우엔 거만해져서 사기주사위 레벨을 낮춥니다(약함모드).

- 위의 경우가 아닌경우엔 일반모드로 플레이합니다.
 */
package diceGame;

import diceGame.FraudDice.FraudMode;

public class Player {

	String name; //플레이어의 이름. 초기화 시에 받는다.
	Dice dice; //일반 플레이어의 주사
	int score;//점수의 합계를 저
	
	//이름을 반환한다.
	public String getName() {
		return name;
	}

	//점수를 반환한다.
	public int getScore() {
		return score;
	}
	//이름을 받지 않는 생성자. FraudPlayer와 Player의 공통 부분인 score초기화를 한다.
	Player(){
		this.score = 0;
	};

	//이름을 받는 생성자. Player객체의 이름, 주사위(dice) 초기화 한다.
	Player(String name){
		//사용자가 입력한 이름으로 이름을 만들어 준다.
		this(); //score를 0으로 초기화 한다.
		this.name = name;
		//일반 플레이어이므로 일반 주사위를 생성한다.
		this.dice = new Dice();
	}
	
	
	//주사위를 던져 그 결과를 합계점수에 더한다.
	void tossDice()
	{
		score += dice.toss();
	}
	
}

//
class FraudPlayer extends Player
{
	//사기꾼 플레이어는 사기 주사위 Fraud를 사용합니다.
	FraudDice dice;
	
	//FraudPlayer의 생성자. 점수는 상위 클래 생성자 player()에서 초기화 한다.
	FraudPlayer(String name) {
		this.name = name; //이름을 초기화 한다.
		this.dice = new FraudDice(); //사용하는 dice는  
		// TODO Auto-generated constructor stub
	}

	//주사위를 던진다. 다만, 던지기 전에 상대방 플레이어의 점수를 보고, 주사위 레벨을 조정한다.
	void tossDice(){
		//Judge객체를 통해 상대편의 점수를 얻는다.
		adjustFraudDiceLevel(Judge.getScore(this));
		score += dice.toss();

	}
	//주사위의 레벨을 조건에 맞춰 조한다.
	void adjustFraudDiceLevel(int othersScore)
	{
		if((score - othersScore) >= 6)
		{
			//주사위의 레벨을 조정한다.
			setDiceMode(FraudMode.WEAK);
		}
		else if((score - othersScore) < 0)
		{
			setDiceMode(FraudMode.STRONG);
		}
		else
		{
			setDiceMode(FraudMode.NORMAL);
		}
	}
	
	//기록원 객체를 위해 주사위의 모드를 반환한다.
	public FraudMode getDiceMode()
	{
		return dice.getMode();
	}
	
	//주사위의 모드를 조정한다.
	void setDiceMode(FraudMode newMode)
	{
		dice.setMode(newMode);
	}
}