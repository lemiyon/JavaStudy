/**
 * 
 */
package diceGame;


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
	//게임에 참가하는 선수(플레이어)
	static Player player1, player2;
	//사용자의 입력을 받을 스캐너. 선수들의 이름과 라운드 회수를 받는다.
	Scanner scanner;
	//라운드 회수를 입력받는다. 음수와 0을 제외한 정수범위내로 라운드 수를 받는다.
	int maxRound; 

	//게임 시작을 준비한다. 여기서는 다음과 같은 행동을 한다. 
	//1. 두 선수 생성
	//2. 기록원(Recorder) 초기화
	//3. 주사위를 던질 라운드 수 묻
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
		player2 = new FraudPlayer(playerName2);

	};
	
	//기록원(Recorder)초기화. 기록원은 선수 2명의 이름과 점수를 저장하고 있는다. 
	boolean initRecorder()
	{
		recorder = new Recorder();	
		if(recorder == null) return false;
		return true;
	}
	
	//사용자에게 얼마나 많은 라운드의 게임을 실행할 지 물어본다.
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
			recorder.recordGame(player1, player2); //기록관이 이 둘의 이름, 점수를 기록한다.
			round++; //두 선수가 모두 주사위를 한번씩 던지고 나면, 라운드 회수를 증가시킨다.
		}

		gameResult();
		
	}; 
	
	 //게임을 정산하고 누가 승인지 말해준다.
	 void gameResult(){
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
	
	 
	 //FraudPlayer가 주사위를 던지기 전, 주사위의 레벨을 정하기 위해 상대방의 점수를 알아오기 위한 함 
	 public static int getScore(Player player)
	 {
		 if(player.equals(player1)) return player2.getScore();
		 else return player1.getScore();
	 }
}
