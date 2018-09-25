package bn;
import java.net.*;
import java.util.ArrayList;
import java.util.List;
import java.io.*;

public class TCPServer implements iServerHandler {

	private List<Client> clients =  new ArrayList<Client>();
	private String command;
	private Game game;
	private iServerHandler serverHandler;
	private ServerSocket server;

	public static void main(String[] args) {

		new TCPServer().startServer();

	}

	public TCPServer() {
		serverHandler = this;

	}
	public void startServer() {
		try {
			server=new ServerSocket(8888);
			new Thread(){
				@Override
				public void run() {

					try{

						while (true) {

							Socket serverClient=server.accept();
							createNewClient(serverClient);
						}

					}catch(Exception e){
						System.out.println(e);
					}   

				}       
			}.start();

		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}


	}


	public void createNewClient(Socket socket) {
		new Thread(){
			@Override
			public void run() {
				clients.add(new Client(socket, serverHandler));

			}

		}.start();
	}



	@Override
	public void sendCommand(String cmd, Socket sck) {

		switch(cmd){
		case CommandesServeur.SEND_PLATEAU_TO_ADMIN: 

			break;
			
		case CommandesServeur.SEND_TAILLE_MAP:

			break;

		case CommandesServeur.TOUCHER:

			break;

		case CommandesServeur.COULER:
			break;

		case CommandesServeur.COUP_DANS_LEAU:

			break;
			
		case CommandesServeur.ERROR:
//envoie n'importe quelle 
			break;


		}

	}


	@Override
	public void sendCommandToAll(String cmd) {


	}

	@Override
	public boolean createPlayer(String name) {
		return game.addNewPlayer(new Player(name));
		
	}

	@Override
	public boolean addBoat(String name) {
		
		
	}

	@Override
	public boolean addSocket(String name, Socket socket) {
		return game.addSocketToUser(name, socket);
	}


}

interface iServerHandler{
	public void sendCommand(String cmd,Socket sck);
	public void sendCommandToAll(String cmd);
	public boolean createPlayer(String name);
	public boolean addBoat(String name);
	public boolean addSocket(String name, Socket socket);
}

