package desenhos;

import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class createMenu {
	private createImagem createI = new createImagem();
	private JLabel ing1, ing2, ing3, pt1, pt2, pt3, imgV;
	
	private int v1, v2, v3;
	
	private JTextField t1, t2, t3;
	private JTextField p1, p2, p3;
	
	private Insets margem = new Insets(0,0,0,0);
	
	private JButton create, save;
	
	private JFrame frame;
	private JPanel pan = new JPanel();
	
	public JFrame createWindow() {
		frame = new JFrame("Create Recipe Imagem");
        frame.setBounds(0, 0, 385, 300);
        frame.setLocationRelativeTo(null);;
        frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

		
		return frame;
	}
	
	public JPanel getPanel() {
		return pan;
	}
	
	public void addComponents() {
		createComponents();
		pan.add(ing1);
		pan.add(ing2);
		pan.add(ing3);
		
		pan.add(pt1);
		pan.add(pt2);
		pan.add(pt3);
		
		pan.add(t1);
		pan.add(t2);
		pan.add(t3);
		
		pan.add(p1);
		pan.add(p2);
		pan.add(p3);
		
		pan.add(create);
		pan.add(save);
		
		pan.add(imgV);
		
		pan.setLayout(null);
		
		frame.getContentPane().add(pan);
	}
	
	private void createComponents() {
		
		
		ing1 = new JLabel("Ingredient 1");
		ing1.setBounds(5, 0, 80, 30);
		
		ing2 = new JLabel("Ingredient 2");
		ing2.setBounds(130, 0, 80, 30);
		
		ing3 = new JLabel("Ingredient 3");
		ing3.setBounds(255, 0, 80, 30);
		
		pt1 = new JLabel("%");
		pt1.setBounds(90, 0, 80, 30);
		
		pt2 = new JLabel("%");
		pt2.setBounds(215, 0, 80, 30);
		
		pt3 = new JLabel("%");
		pt3.setBounds(345, 0, 80, 30);
		
		//textfields
		t1 = new JTextField("");
		t1.setToolTipText("Any");
		t1.setBounds(5, 27, 80, 30);
		
		t2 = new JTextField("");
		t2.setToolTipText("Any");
		t2.setBounds(130, 27, 80, 30);
		
		t3 = new JTextField("");
		t3.setToolTipText("Any");
		t3.setBounds(255, 27, 80, 30);
		//
		
		p1 = new JTextField();
		p1.setDocument(new JTextFieldLimit(2));
		p1.setBounds(90, 27, 20,30);
		p1.setText("");
		
		p2 = new JTextField();
		p2.setDocument(new JTextFieldLimit(2));
		p2.setBounds(215, 27, 20,30);
		p2.setText("");
		
		p3 = new JTextField();
		p3.setDocument(new JTextFieldLimit(2));
		p3.setBounds(345, 27, 20,30);
		p3.setText("");
		
		imgV = new JLabel();
		imgV.setBounds(30, 65, 300, 40);
		
		
		create = new JButton("Create Image");
		create.setMargin(margem);
		create.setBounds(80, 110, 100, 30);
		
		save = new JButton("Save Image");
		save.setMargin(margem);
		save.setBounds(190, 110, 100, 30);
		save.setEnabled(false);
		
		
		//limita��es para porcentagem ser apenas numeros
		p1.addKeyListener(new KeyAdapter() { //aceita apenas numeros
	         public void keyPressed(KeyEvent ke) {
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
	            		 || (ke.getKeyChar() == '\b') ) {
	            	 
	            	p1.setEditable(true);
	            	
	             } else {
	            	p1.setText("");
	            	p1.setEditable(false);
	             }
	          }
	      });
		
		p2.addKeyListener(new KeyAdapter() { //aceita apenas numeros
	         public void keyPressed(KeyEvent ke) {
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
	            		 || (ke.getKeyChar() == '\b') ) {
	            	 
	            	p1.setEditable(true);
	            	
	             } else {
	            	p1.setText("");
	            	p1.setEditable(false);
	             }
	          }
	      });
		
		p3.addKeyListener(new KeyAdapter() { //aceita apenas numeros
	         public void keyPressed(KeyEvent ke) {
	             if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9') 
	            		 || (ke.getKeyChar() == '\b') ) {
	            	 
	            	p1.setEditable(true);
	            	
	             } else {
	            	p1.setText("");
	            	p1.setEditable(false);
	             }
	          }
	      });
		
		create.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String i1 = new String(), i2 = new String(), i3 = new String();
				
				if(t1.getText().replaceAll(" ", "").equals("")) {
					i1 = "Any";
				}else{
					i1 = t1.getText();
				}
					
				if(t2.getText().replaceAll(" ", "").equals("")) {
					i2 = "Any";
				}else{
					i2 = t2.getText();
				}
					
				if(t3.getText().replaceAll(" ", "").equals("")) {
					i3 = "Any";
				}else{
					i3 = t3.getText();
				}
					
				if(!p1.getText().equals(""))
					v1 = (int) (244 * (Float.parseFloat(p1.getText())/100));
				else
					v1 = 0;
				
				if(!p2.getText().equals(""))
					v2 = (int) (244 * (Float.parseFloat(p2.getText())/100)) + v1;
				else
					v2 = 0;
				
				if(!p3.getText().equals(""))
					v3 = (int) (244 * (Float.parseFloat(p3.getText())/100)) + v2;
				else
					v3 = 0;
						
				createI.doLines(v1, v2, v3);
				createI.doFont(i1, i2, i3);
				
				imgV.setIcon(createI.getImage());
				save.setEnabled(true);
			}
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					createI.saveImage(new String(JOptionPane.showInputDialog(pan, "Name of imagem:")));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
	}
}


