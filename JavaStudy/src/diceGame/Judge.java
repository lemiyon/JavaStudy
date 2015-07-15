/**
 * 
 */
package diceGame;

import java.util.List;
import java.util.Scanner;

/**
 * @author bola-kim
 *
 *
 3. 심판(Judge)

- 심판을 통해 선수등록을 할 수 있습니다.

- 심판을 통해 게임을 진행합니다. 주사위를 서로 몇번 던질것인지에 대해 지정할 수 있습니다.

- 심판은 기록원을 통해서 매 라운드마다 주사위 총합을 기록(출력)할 수 있으며, 모든 라운드가 종료되면 승자를 판정합니다.

 
 */
public class Judge {
	
//승패 판정시 필요한 판정원. 게임 당 하나만 있으면 된다.
	static Recorder recorder;
	//게임 시작을 준비한다. 여기서는 다음과 같은 행동을 한다. 
	//1. 두 선수 생성
	//2. 기록원(Recorder) 초기화
	public boolean prepareGame(){
		return false;}
	//선수등록함. 사용자에게 선수 2의 이름을 입력받고, 선수 2명을 생성한다.
	public void resisterPlayer(){
		//선수들의 이름을 받을 스캐너, 스트링 객체들 생
		Scanner scanner = new Scanner(System.in);
		String playerName1, playerName2;
		System.out.println("Type Player1's name");
		playerName1 = scanner.nextLine();
		System.out.println("Type Player2's name");
		playerName2 = scanner.nextLine();
		
		Player player1 = new Player(playerName1);
		Player player2 = new Player(playerName2);
	};
	//선수 등록등의 과정을 마치고, 게임을 시작한다. 
	public void gameStart(){
		recorder = new Recorder();
		resisterPlayer();
	}; 
	//다시 한 번 게임을 진행할 지 물어본다.
	public void playAgain(){};
	
}
