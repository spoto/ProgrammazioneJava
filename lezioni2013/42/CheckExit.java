import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class CheckExit extends JFrame {

	public CheckExit() {
		super("Are you sure?");

		this.setLayout(new BorderLayout());
		this.add(new JLabel("Sei sicuro di volere uscire?"), BorderLayout.NORTH);
		JPanel siNo = new JPanel();
		siNo.setLayout(new FlowLayout());

		JButton yes = new JButton("Sì");
		yes.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
			
		});

		siNo.add(yes);
		siNo.add(new JButton("no") {{
			addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
				
			});
		}}
		);

		this.add(siNo, BorderLayout.CENTER);

		this.setSize(400, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}