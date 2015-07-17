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
	static Player player1, player2;
	Scanner scanner;
	public int maxRound = 5; //초기치 5번까지만 던질 수 있음을 나타냄.

	//게임 시작을 준비한다. 여기서는 다음과 같은 행동을 한다. 
	//1. 두 선수 생성
	//2. 기록원(Recorder) 초기화
	void initGame(){
		//Greeting!
		System.out.println("Welcome to Bola's Dice Game!");
		//Start init Process
		initPlayer();
		initRecorder();
		initNumberOfRound();
		}
	
	//선수생성 및 초기화. 사용자에게 선수 2의 이름을 입력받고, 선수 2명을 생성한다.
	void initPlayer(){
		//선수들의 이름을 받을 스캐너, 스트링 객체들 생성한다.
		scanner = new Scanner(System.in);
		String playerName1, playerName2;
		System.out.println("Please Type Player1's name and Press Enter");
		playerName1 = scanner.nextLine();
		System.out.println("Plaese Type Player2's name and Press Enter");
		playerName2 = scanner.nextLine();
		//입력받은 이름으로 선수들을 생성한다.
		player1 = new Player(playerName1);
		player2 = new Player(playerName2);

	};
	
	//기록원(Recorder)초기화. 기록원은 선수 2명의 이름과 점수를 저장하고 있는다. 
	boolean initRecorder()
	{
		recorder = new Recorder();	
		if(recorder == null) return false;
		return true;
	}
	
	void initNumberOfRound()
	{
	System.out.println("How many round do you want for this game?");	
	maxRound = scanner.nextInt();
	}
	
	
	//게임 초기 과정을 마치고, 게임을 시작한다. 
	public void gameStart(){

		int round=0; //라운드 번호를 만든다.
		initGame(); //게임을 위한 초기화를 한다.
		while(round != maxRound)
		{
			player1.tossDice(); //플레이어 1이 주사위를 던진다.
			player2.tossDice(); //플레이어 2가 주사위를 던진다.
			recorder.recordGame(player1, player2); //기록관이 이 둘의 이름, 점수를 기록한다. 그리고 출력한다
			round++;
		}

		gameResult();
		playAgain();
		
	}; 

	 void judgeWinner(){
		 if(player1.getScore() > player2.getScore()){
			 System.out.println(player1.getName() + " Won!!");
		 }
		 else if(player1.getScore() == player2.getScore())
		 {
			 System.out.println("Draw!");
		 }
		 else
		 {
			 System.out.println(player2.getName() + " Won!!");
		 }
		 
	 };
	 //게임을 정산하고 누가 위너인지 말해준다.
	 void gameResult(){
		 judgeWinner();
	 };
		//다시 한 번 게임을 진행할 지 물어본다.
	 void playAgain(){
		 System.out.println("Would you like to play again??\n(players will not be changed.)");
	 };

	 public static int getScore(Player player)
	 {
		 if(player.equals(player1)) return player2.getScore();
		 else return player1.getScore();
	 }
}
