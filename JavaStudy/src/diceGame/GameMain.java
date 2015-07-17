package diceGame;
/*
 * 5. 메인(GameMain)

- 메인메소드가 존재하며 여기서 프로그램이 실행됩니다.

- 플레이어의 이름을 정할 수 있습니다.

- 주사위는 5번 던지는것으로 하겠습니다.
 */
public class GameMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//게임을 시작하기 위한 심판(Judge)객체를 만든다.
		Judge judge = new Judge();
		if(!judge.equals(null))
		{
			//심판 객체가 제대로 생성되었으면, 심판 객체를 통해 게임을 시작한다.
			judge.gameStart();
			
		}
		else
		{
			System.out.println("Failed to start Game! ; Failed Generate Judge");
		}
	}

	
}
