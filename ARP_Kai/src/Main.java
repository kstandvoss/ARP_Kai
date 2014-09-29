 import arp.Receiver;
import arp.Transmitter;
      
     
    public class Main {  
      
     
 
		public static void main(String[] args) { 
			
			Receiver r = new Receiver(100);
			System.out.println("hallo");
			r.start();
			for(int i=1;i<40;i++){
				Transmitter t =new Transmitter(i);
				t.start();
			}
			
		}

    }  
