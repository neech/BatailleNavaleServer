package bn;
import java.net.Socket;

public class Player {

	private String name;
	private Socket socket;
	private int score;

	public Player(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Socket getSocket() {
		return socket;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setSocket(Socket socket) {
		this.socket = socket;
	}

}
