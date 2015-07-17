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
		Judge judge = new Judge();
		if(!judge.equals(null))
		{
			judge.gameStart();
			
		}
		else
		{
			System.out.println("Failed to start Game! ; Failed Generate Judge");
		}
	}

	
}
