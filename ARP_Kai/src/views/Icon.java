package views;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import models.Device;

public class Icon extends JLabel {
	
	Device device;
	public Icon(String s,ImageIcon image, Device d,int horizontalAlignment){
		super(s,image,horizontalAlignment);
		device = d;
	}
}
