package bn;
import java.net.Socket;
import java.util.List;

public class Game {

	private int jeuID; //permet d'identifier l'instance de jeu en cours 
	private static final String ADMIN_ID = "admin";
	private static final String ADMIN_PSWD = "admin";
	private static Socket admSocket ;
	private List<Player> players;
	private Plateau plateau;
	private boolean adminFinishedConfig = false;
	private Player playerPlaying;

	public Game(Socket admSocket ) {
		this.admSocket = admSocket;
	}



	private void gameLoop() {	
		while(!isGameIsFinished) {
			for() {

			}
		}
	}

	public boolean addNewPlayer(Player player) {
		
		for(Player p : players) {
			if(p.getName().equals(player.getName()))
				return false;
		}
		players.add(player);
		return true;
	}
	
	private boolean isGameIsFinished() {

		return plateau.isAllBoatFound();

	}

	public void AdminFinishedConfig() {
		adminFinishedConfig = true;
	}
	
	public boolean addSocketToUser(String name,Socket sock) {
		
		for(Player p : players) {
			if(p.getName().equals(name) & p.getSocket() == null) {
				p.setSocket(sock);
				return true;
			}
				
		}
		return false;
		
	}
}
