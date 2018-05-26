import java.awt.BorderLayout; //border manager
import java.awt.Color;    
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;   //replace with * is more intelligent XD
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
		

public class Tester {

	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 120;
	private static final int FIELD_WIDTH = 10;

	public static void main(String[] args) {
		JFrame frame = new JFrame();
		frame.setTitle("Sorting and Searching");
		frame.pack();
		
		
		JPanel borderPanel = new JPanel();
		borderPanel.setLayout(new BorderLayout(10,10));
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new GridLayout(2,2,5,5));
		JLabel sortLabel = new JLabel(" Please enter integer numbers:(use , to split each number)");
		JTextField sortingInput = new JTextField(FIELD_WIDTH);
		JLabel searchLabel = new JLabel(" if you want to search a number, enter here:");
		JTextField searchingInput = new JTextField(FIELD_WIDTH);
		inputPanel.add(sortLabel);
		inputPanel.add(sortingInput);
		inputPanel.add(searchLabel);
		inputPanel.add(searchingInput);
	    
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setPreferredSize(new Dimension(200,120));
		buttonPanel.setLayout(new GridLayout(2,2,5,5));
		JButton buttonB = new JButton("Bubble Sort");
		JButton buttonM = new JButton("Merge Sort");
		JButton buttonQ = new JButton("Quick Sort");
		JButton buttonS = new JButton("Search");
		buttonPanel.add(buttonB);
		buttonPanel.add(buttonM);
		buttonPanel.add(buttonQ);
		buttonPanel.add(buttonS);
		
		JPanel outputPanel = new JPanel();
		outputPanel.setPreferredSize(new Dimension(250,120));
		outputPanel.setLayout(new GridLayout(2,1,5,5));
		JTextField sortingOutput = new JTextField(FIELD_WIDTH);
		sortingOutput.setText("Sorting Output                                  ");
		JTextField searchingOutput = new JTextField(FIELD_WIDTH);
		searchingOutput.setText("Searching Output");
		outputPanel.add(sortingOutput);
		outputPanel.add(searchingOutput);
		
		
		
		borderPanel.add(inputPanel,BorderLayout.WEST);
		borderPanel.add(buttonPanel,BorderLayout.CENTER);
		borderPanel.add(outputPanel,BorderLayout.EAST);
		
		class BubbleSortListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = sortingInput.getText();
				String[] items = a.replaceAll("\\[", "").replaceAll("\\)", "").replaceAll("\\s","").split(",");
				
				int[] nums = new int[items.length];
				for(int i=0;i<items.length;i++)				
				nums[i]=Integer.parseInt(items[i]);
				
				
				
				BubbleSort b = new BubbleSort(nums);
				b.sort();
				String s = "";
				for(int i=0;i<items.length;i++)
					s = s + String.valueOf(nums[i]+",");
				sortingOutput.setText(s);
				sortingOutput.setBackground(Color.CYAN);
			}
		}
		class MergeSortListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = sortingInput.getText();
				String[] items = a.replaceAll("\\[", "").replaceAll("\\)", "").replaceAll("\\s","").split(",");
				
				int[] nums = new int[items.length];
				for(int i=0;i<items.length;i++)nums[i]=Integer.parseInt(items[i]);
				MergeSort b = new MergeSort(nums);
				b.sort();
				
				String s = "";
				for(int i=0;i<items.length;i++)s = s + String.valueOf(nums[i]+",");
				sortingOutput.setText(s);
				sortingOutput.setBackground(Color.MAGENTA);
			}
		}
		class QuickSortListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = sortingInput.getText();
				String[] items = a.replaceAll("\\[", "").replaceAll("\\)", "").replaceAll("\\s","").split(",");
				
				int[] nums = new int[items.length];
				for(int i=0;i<items.length;i++)nums[i]=Integer.parseInt(items[i]);
				QuickSort q = new QuickSort(nums);
				q.sort(0, nums.length - 1);
				
				String s = "";
				for(int i=0;i<items.length;i++)
					s = s + String.valueOf(nums[i]+",");
				sortingOutput.setText(s);
				sortingOutput.setBackground(Color.LIGHT_GRAY);
			}
		}
		class SearchListener implements ActionListener{
			@Override
			public void actionPerformed(ActionEvent arg0) {
				String a = sortingOutput.getText();
				String[] items = a.replaceAll("\\[", "").replaceAll("\\)", "").replaceAll("\\s","").split(",");	
				int[] nums = new int[items.length];
				for(int i=0;i<items.length;i++)nums[i]=Integer.parseInt(items[i]);
				
				Search s = new Search(nums);
				
				searchingOutput.setText("index:"+s.search(Integer.parseInt(searchingInput.getText())));
				sortingOutput.setBackground(Color.WHITE);
			}
		}

		ActionListener listenerB = new BubbleSortListener();
		ActionListener listenerM = new MergeSortListener();
		ActionListener listenerQ = new QuickSortListener();
		ActionListener listenerS = new SearchListener();
		buttonB.addActionListener(listenerB);
		buttonM.addActionListener(listenerM);
		buttonQ.addActionListener(listenerQ);
		buttonS.addActionListener(listenerS);
		
		frame.add(borderPanel);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		
	}
	
}
