package arp;

import models.Device;

public class Receiver extends Communicator {

	private int timeout;

	public Receiver(int time) {
		super();
		this.timeout = time;

	}

	@Override
	public void run() {
		System.out.println("vamos");
		pcap.loop(timeout, jpacketHandler, "jNetPcap rocks!");
		pcap.close();
		for (Device d : dispositivos) {
			System.out.println(d.getMac() + "    " + d.getIp());
		}
		System.out.println("acabamos");

	}

}
