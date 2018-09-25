package bn;

import java.net.Socket;

public class Client {
	private iServerHandler serverHandler;

	private Socket socket;

	public Client(Socket socket, iServerHandler serverHandler) {
		this.socket = socket;
		this.serverHandler = serverHandler;
	}

	public void Receivecommand(){
		while(true) {
			String command = "";
			switch(command){
			case  CommandesServeur.ADMIN_ADD_PLAYER:
				if(!serverHandler.createPlayer(name))
					//envoyerErreur
				break;

			case  CommandesServeur.USER_CONNECTION:
				if(!serverHandler.userConnexion()) {
					//envoyerErreur
					socket.close();
				}	
				else
					serverHandler.sendCommand(CommandesServeur.SEND_TAILLE_MAP, socket);
	
				break;

			case CommandesServeur.ADMON_ADD_BOAT:
				if(!serverHandler.addBoat(name)) {
					//envoyerErreur
				}else
					serverHandler.sendCommand(CommandesServeur.SEND_PLATEAU_TO_ADMIN, socket);
				break;

			case  CommandesServeur.ADMIN_FINISH_CONF:

				break;

			case CommandesServeur.USER_PLAY: 

				break;

			}  
		}
	}



}
