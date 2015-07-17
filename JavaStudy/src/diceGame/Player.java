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

	String name;
	Dice dice;
	int score;
	
	//각각에 대한 get, set 메소드
	public String getName() {
		return name;
	}

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
		//일반 플레이어이므로 
		this.dice = new Dice();
	}
	
	
	void tossDice()
	{
		score += dice.toss();
	}
	
}

class FraudPlayer extends Player
{
	FraudDice dice;
	
	//FraudPlayer의 생성자. 점수는 
	FraudPlayer(String name) {
		this.name = name;
		this.dice = new FraudDice();
		// TODO Auto-generated constructor stub
	}

	void tossDice(){
		adjustFraudDiceLevel(Judge.getScore(this));
		score += dice.toss();
	}

	void adjustFraudDiceLevel(int othersScore)
	{
		if((score - othersScore) >= 6)
		{
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
	
	public FraudMode getDiceMode()
	{
		return dice.getMode();
	}
	
	void setDiceMode(FraudMode newMode)
	{
		dice.setMode(newMode);
	}
}