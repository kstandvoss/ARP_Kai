package views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

import models.Device;

public class IconView extends JPanel {

	public IconView(int size) {
		this.setBackground(Color.WHITE);
		this.setLayout(new GridLayout(2, 2));

	}

	public void addIcon(Device d) {
		final Device device = d;
		try {

			BufferedImage pic = ImageIO.read(new File(device.getPath()));
			final JLabel picLabel = new JLabel("Bla", new ImageIcon(pic),
					JLabel.CENTER);
			picLabel.setVerticalTextPosition(JLabel.BOTTOM);
			picLabel.setHorizontalTextPosition(JLabel.CENTER);
			picLabel.addMouseListener(new MouseAdapter() {

				public void mouseClicked(MouseEvent e) {

					if (e.getButton() == MouseEvent.BUTTON1) {
						picLabel.setBorder(BorderFactory.createLineBorder(
								Color.yellow, 5));
						if (e.getClickCount() == 2) {
							JFrame frame = new JFrame(device.getMac());
							DeviceView view = new DeviceView(device);
							frame.setContentPane(view);
							view.setPreferredSize(new Dimension(400, 200));
							frame.setLocationRelativeTo(null);
							frame.pack();
							frame.setVisible(true);
						}

					}
					
					if(e.getButton() == MouseEvent.BUTTON2){
						 new PopupMenu() extends JPopupMenu{
					
							public void addItem(JMenuItem item){
								this.add(item);
							}
						};
						
						JPopupMenu menu =
						JMenuItem item1 = new JMenuItem("Change Type");
						JMenuItem item2 = new JMenuItem("Show");
						menu.addItem(item1);
						menu.addItem(item2);
					}
				}

			});
			this.add(picLabel);
		} catch (IOException e) {
			System.err.println("Error! " + e.getMessage());
		}

	}

}
