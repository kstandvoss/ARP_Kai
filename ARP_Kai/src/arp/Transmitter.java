package arp;

import org.jnetpcap.packet.JMemoryPacket;
import org.jnetpcap.packet.JPacket;

public class Transmitter extends Communicator implements Runnable {

	private int ip;

	public Transmitter(int ip) {
		super();
		this.ip = ip;
		

	}

	@Override
	public void run() {

		byte[] a = { (byte) ((int) Integer.parseInt("ff", 16)),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),
				(byte) (int) Integer.parseInt("ff", 16),

				(byte) (int) Integer.parseInt("24", 16),
				(byte) (int) Integer.parseInt("ec", 16),
				(byte) (int) Integer.parseInt("99", 16),
				(byte) (int) Integer.parseInt("ee", 16),
				(byte) (int) Integer.parseInt("aa", 16),
				(byte) (int) Integer.parseInt("ac", 16),

				(byte) 8, (byte) 6,

				(byte) 0, (byte) 1,

				(byte) 8, (byte) 0,

				(byte) 6,

				(byte) 4,

				(byte) 0, (byte) 1,

				(byte) (int) Integer.parseInt("24", 16),
				(byte) (int) Integer.parseInt("ec", 16),
				(byte) (int) Integer.parseInt("99", 16),
				(byte) (int) Integer.parseInt("ee", 16),
				(byte) (int) Integer.parseInt("aa", 16),
				(byte) (int) Integer.parseInt("ac", 16),

				(byte) 192, (byte) 168, (byte) 0, (byte) 25,

				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),
				(byte) (int) Integer.parseInt("00", 16),

				(byte) 192, (byte) 168, (byte) 0, (byte) ip };

		JPacket packet = new JMemoryPacket(a);

		pcap.sendPacket(packet);
		System.out.println("gesendet"+ip);

	}
}
