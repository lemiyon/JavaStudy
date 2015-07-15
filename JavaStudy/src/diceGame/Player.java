/*
 * 2. 플레이어(Player, FraudPlayer)

- 플레이어는 이름을 정할수 있고, 주사위를 들고있습니다. 또한 본인의 합계득점을 기억합니다.

- 플레이어도 일반 '플레이어'가 있으며, 사기주사위를 사용하는 '사기플레이어'가 있습니다.

- 사기플레이어는 지고있을경우 얍삽하게도 사기주사위 레벨을 높입니다(강함모드).

- 6점이상차이로 이기고 있는경우엔 거만해져서 사기주사위 레벨을 낮춥니다(약함모드).

- 위의 경우가 아닌경우엔 일반모드로 플레이합니다.
 */
package diceGame;


public class Player {
	private String getName() {
		return name;
	}

	private void setName(String name) {
		this.name = name;
	}

	private Dice getDice() {
		return dice;
	}

	private void setDice(Dice dice) {
		this.dice = dice;
	}

	private int getScore() {
		return score;
	}

	private void setScore(int score) {
		this.score = score;
	}

	String name;
	Dice dice;
	int score;
	
	//이름을 받는 생성자. Player객체를 초기화 한다.
	Player(String name){
		//사용자가 입력한 이름으로 이름을 만들어 준다.
		this.name = name;
		//주사위를 만든다. 일반적인 주사위이다.
		dice = new Dice();
		score = 0;
	}
	
	int tossDice()
	{
		
		return 0;
	}
	
}

class FraudPlayer extends Player
{
	//이름을 받는 생성자. FraudPlayer객체를 초기화 한다.
	FraudPlayer(String name)
	{
		super(name);
	}
	
	
	int tossDice(){
		return 0;
	}

	int adjustFraudDiceLevel()
	{
		return 0;
	}
	
}