package com.hotmoka.examples.swing.slider;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;

public class SliderFrame extends JFrame {
	private StretchableImage stretchableImage;
	private JSlider slider;
	private JRadioButton hor;

	public SliderFrame() {
		add(mkControls(), BorderLayout.NORTH);
		add(mkPicture(), BorderLayout.SOUTH);

		stretch();
	}

	private Component mkControls() {
		JPanel controls = new JPanel();
		controls.setLayout(new GridLayout(3, 1));
		slider = new JSlider();
		hor = new JRadioButton("stretch Pikachu image horizontally", true);
		JRadioButton ver = new JRadioButton("stretch Pikachu image vertically");
		ButtonGroup group = new ButtonGroup();
		group.add(hor);
		group.add(ver);
		controls.add(slider);
		controls.add(hor);
		controls.add(ver);
		slider.addChangeListener(event -> stretch());
		hor.addActionListener(event -> stretch());
		ver.addActionListener(event -> stretch());
	
		return controls;
	}

	private Component mkPicture() {
		JPanel picture = new JPanel();
		stretchableImage = new StretchableImage
				(new ImageIcon("img/pika.png").getImage());
		picture.add(stretchableImage);

		return picture;
	}

	private void stretch() {
		if (hor.isSelected()) {
			stretchableImage.setXScaleFactor(slider.getValue() / 50.0);
			stretchableImage.setYScaleFactor(1);
		}
		else {
			stretchableImage.setXScaleFactor(1);
			stretchableImage.setYScaleFactor(slider.getValue() / 50.0);
		}

		pack();
	}
}