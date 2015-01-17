package firstSteps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import static dates.LocalDateManager.*;
import static java.time.temporal.TemporalAdjusters.firstDayOfMonth;


public class CalendarManager {
	private static int currDisplayMonth;
	private static JFrame frame;
	private static LocalDate selectedDate, startDt, endDt;

	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				createAndShowGUI(LocalDate.now().format(dtf2).toString());
			}
		});

	}
	
	private static void createAndShowGUI(String label) {
		frame = new JFrame(label);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		LocalDate today = LocalDate.now();
		addComponentsToPane(frame.getContentPane(), today);
		
		frame.pack();
		frame.setVisible(true);
	}
	private static void updateGUI(String label, LocalDate date) {
		frame.dispose();
		frame = new JFrame(label);
		addComponentsToPane(frame.getContentPane(), date);
		frame.pack();
		frame.setVisible(true);
	}
	
	public static void addComponentsToPane(Container pane, LocalDate today) {
		pane.setLayout(new GridBagLayout());
//		LocalDate today = LocalDate.now();
		int day = today.getDayOfMonth();
		currDisplayMonth = today.getMonthValue();
		ArrayList<LocalDate> displayLs = getDisplayDates(today);
		
		JButton button;
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.BOTH;
		c.gridwidth = 1;
		c.weightx = 0.1;
		int x = 0;
		int y = 0;
		JTextField textField = new JTextField();
		textField.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		for(LocalDate date : displayLs) {
			button = new JButton(date.getDayOfMonth()+"");
			button.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
			if(date.getDayOfMonth() == day && date.getMonthValue() == currDisplayMonth)
				button.setBorder(new LineBorder(Color.BLACK,2));
			if(!isWorkingDay(date))
				button.setForeground(Color.RED);
			if(date.getMonthValue() != currDisplayMonth)
				button.setForeground(Color.GRAY);
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					// TODO Auto-generated method stub
					textField.setText(date.format(dtf2).toString());
					selectedDate = date;
				}
			});
			c.gridx = x;
			c.gridy = y;
			x++;
			if(x>6)
				y++;
			x=x%7;
			pane.add(button, c);
		}
		c.gridwidth = 3;
		button = new JButton("Previous");
		button.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		c.gridy = ++y;
		c.gridx = 0;
		pane.add(button, c);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LocalDate toDisplay = today.with(firstDayOfMonth()).minusMonths(1);
				updateGUI(toDisplay.format(dtf2).toString(), toDisplay);
			}
		});
		button = new JButton("Next");
		button.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		c.gridx = 4;
		pane.add(button, c);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				LocalDate toDisplay = today.with(firstDayOfMonth()).plusMonths(1);
				updateGUI(toDisplay.format(dtf2).toString(), toDisplay);
			}
		});
		
		c.gridx = 0;
		c.gridy = ++y;
		pane.add(textField, c);
		
		JTextField start = new JTextField(), end = new JTextField(), workingDays = new JTextField();
		start.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		end.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		workingDays.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		
		c.gridwidth = 2;
		button = new JButton("Set Start");
		button.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		c.gridx = 3;
		pane.add(button, c);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				start.setText(textField.getText());
				startDt = selectedDate;
				updateWorkingDays(workingDays);
			}
		});
		button = new JButton("Set End");
		button.setFont(new Font(Font.SERIF, Font.PLAIN, 35));
		c.gridx = 5;
		pane.add(button, c);
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				end.setText(textField.getText());
				endDt = selectedDate;
				updateWorkingDays(workingDays);
//				workingDays.setText(LocalDateManager.getNumWorkingDays(startDt, endDt)+"");
			}
		});
		
		
		c.gridx = 0;
		c.gridy = ++y;
		c.gridwidth = 3;
		pane.add(start, c);
		c.gridx = 3;
		pane.add(end, c);
		
		c.gridwidth = 1;
		c.gridx = 6;
		pane.add(workingDays, c);
		
		updateSelectedDates(textField, selectedDate);
		updateSelectedDates(start, startDt);
		updateSelectedDates(end, endDt);
		updateWorkingDays(workingDays);
	}
	
	private static void updateWorkingDays(JTextField workingDays) {
		if(startDt == null && endDt == null) {
			workingDays.setText("0");
		} else if (startDt == null || endDt == null) {
			workingDays.setText("1");
		} else {
			workingDays.setText(getNumWorkingDays(startDt, endDt)+"");
		}
	}
	
	private static void updateSelectedDates(JTextField textField, LocalDate date) {
		if(textField.getText().equals("") && date != null) {
			textField.setText(date.format(dtf2).toString());
		}
	}
}
