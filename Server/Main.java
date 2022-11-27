import java.io.*;
import java.net.*;


/*

	Client Hello 
	Server Hello 

	Keyexchange Done !!

*/


class Main {

	public static void main(String[] args){

		new Server(3000).start();

	}

}

class Server extends Thread{

	int PORT ;

	static int  clientCount =0;

	Server(int PORT){

		this.PORT  = PORT ;
	}

	public void run() {
		
		try {
			
			ServerSocket s = new ServerSocket(PORT) ;
			
			System.out.println("Started Listening at "+PORT);

			while(true){

				Socket sock = s.accept();

				try {
					new ServerUnit(sock);
				}
				catch(Exception err){
					System.out.println(err.getMessage());
				}

			}

			

		}
		catch(Exception err){
			System.out.println(err.getMessage());
		}
		
	}

	synchronized static void IncreaseCount(){
		
		clientCount++ ;

		System.out.println("CLient count:" + clientCount );

	}
	
	synchronized static void DecreaseCount(){

		clientCount-- ;

		System.out.println("CLient count:" + clientCount );

	}

}


class ServerUnit extends Thread{

	Socket s ; 

	DataInputStream din ;

	DataOutputStream dout ;

	ServerUnit(Socket s) throws Exception{

		this.s = s ;

		din = new DataInputStream(s.getInputStream());

		dout = new DataOutputStream(s.getOutputStream());

		this.start();

		Server.IncreaseCount();

	}	

	

	public void run(){

		while(true){

			try {

				String str = (String)(din.readUTF()) ;

				System.out.println("Client : "+ str);

				String s = new String("HTTP/1.1 \r\n200 OK\r\n\r\n");

				dout.writeUTF(s);

				dout.flush();

			}

			catch(Exception err) {

				break ;

			}

			finally{

				try {
					
					s.close(); 

					Server.DecreaseCount(); 

				}
				catch(Exception err) {

				}
			}

			

		}

	}

}