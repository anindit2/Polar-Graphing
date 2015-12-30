
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import javax.swing.JFrame;
import java.awt.*;
import java.util.ArrayList;

public class PolarGraph {

	public static void main(String[] args) {
		JFrame window = new JFrame("Polar Graph");
		Grapher content = new Grapher();
		window.getContentPane().add(content, BorderLayout.CENTER);
		// 3window.getContentPane().add(content, BorderLayout.EAST);
		window.setSize(1000, 722);
		window.setLocationRelativeTo(null);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		window.setVisible(true);

	}

}

class Grapher extends JPanel implements ActionListener {
	final double STEPS = 540;
	double ADJUST_STEP = STEPS;
	int slowfast = 0;
	int speed = 50;
	int t = 0;
	double theta;
	double maxTheta, minTheta;
	int pauseplay = 0;
	boolean Stop = false;
	Point[] points = new Point[(int) STEPS + 1];
	double[] radii = new double[(int) STEPS + 1];
	double max = 0;
	double min = 100000;
	JButton slow = new JButton("Slow");
	JButton medium = new JButton("Medium");
	JButton fast = new JButton("Fast");
	JButton stop = new JButton("STOP");
	JButton PLAY = new JButton("PAUSE/PLAY");
	JButton gEnter = new JButton("Draw Graph");
	JButton InstaGraph = new JButton("InstaGraph");

	JButton general = new JButton("General");
	JButton basicLeminiscate = new JButton("Leminiscate");
	JButton basicRoseCurve = new JButton("Rose Curve");
	JButton basicLimicon = new JButton("Limicon");

	JButton sine = new JButton("Sine");
	JButton cosine = new JButton("Cosine");

	JTextField gsinC = new JTextField();
	JTextField gcosC = new JTextField();
	JTextField gk = new JTextField();
	JTextField gCosPower = new JTextField();
	JTextField gSinPower = new JTextField();
	JTextField gstC = new JTextField();
	JTextField gctC = new JTextField();
	JTextField gstR = new JTextField();
	JTextField gctR = new JTextField();
	boolean g = true;

	JTextField blitrigC = new JTextField();
	JTextField blik = new JTextField();
	JTextField trigR = new JTextField();
	boolean bli = false;
	boolean cos = true;
	
	JTextField brctrigC = new JTextField();
	JTextField brck = new JTextField();
	JTextField brcR = new JTextField();
	JTextField brtC = new JTextField();
	boolean basicRose; 
	
	JTextField lemtrigC = new JTextField();
	JTextField lemk = new JTextField();
	JTextField lemR = new JTextField();
	JTextField lemtC = new JTextField();
	boolean leminiscate = false;
	
	double cCo, sCo, k, cP, sP, ctC, stC, ctR, stR;
	boolean graph = false;
	boolean graphing = false;
	boolean instaGraph = false;

	boolean play = true;

	ArrayList<Double> mins = new ArrayList<Double>();
	ArrayList<Double> maxs = new ArrayList<Double>();

	class BasicLimicon implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			bli = true;
			g = false;
			basicRose = false;
			blitrigC.setVisible(true);
			sine.setVisible(true);
			cosine.setVisible(true);
			blik.setVisible(true);
			gcosC.setVisible(false);
			gsinC.setVisible(false);
			gctC.setVisible(false);
			gstR.setVisible(false);
			gctR.setVisible(false);
			gstC.setVisible(false);
			gCosPower.setVisible(false);
			gSinPower.setVisible(false);
			gk.setVisible(false);
			trigR.setVisible(true);
			brctrigC.setVisible(false);
			brck.setVisible(false);
			brtC.setVisible(false);
			brcR.setVisible(false);
			lemtrigC.setVisible(false);
			lemk.setVisible(false);
			lemR.setVisible(false);
			lemtC.setVisible(false);

		}
	}

	class General implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g = true;
			bli  = false;
			basicRose = false;
			blitrigC.setVisible(false);
			blik.setVisible(false);
			gcosC.setVisible(true);
			gsinC.setVisible(true);
			gctC.setVisible(true);
			gstC.setVisible(true);
			gstR.setVisible(true);
			gctR.setVisible(true);
			gCosPower.setVisible(true);
			gSinPower.setVisible(true);
			gk.setVisible(true);
			sine.setVisible(false);
			cosine.setVisible(false);
			trigR.setVisible(false);
			brctrigC.setVisible(false);
			brck.setVisible(false);
			brtC.setVisible(false);
			brcR.setVisible(false);
			
			lemtrigC.setVisible(false);
			lemk.setVisible(false);
			lemR.setVisible(false);
			lemtC.setVisible(false);
			
			
		
		}
	}
	class Leminiscate implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			bli = false;
			g = false;
			basicRose = false;
			leminiscate = true;
			
			blitrigC.setVisible(false);
			sine.setVisible(true);
			cosine.setVisible(true);
			blik.setVisible(false);
			gcosC.setVisible(false);
			gsinC.setVisible(false);
			gctC.setVisible(false);
			gstR.setVisible(false);
			gctR.setVisible(false);
			gstC.setVisible(false);
			gCosPower.setVisible(false);
			gSinPower.setVisible(false);
			gk.setVisible(false);
			trigR.setVisible(false);
			brctrigC.setVisible(false);
			brck.setVisible(false);
			brtC.setVisible(false);
			brcR.setVisible(false);
			lemtrigC.setVisible(true);
			lemk.setVisible(true);
			lemR.setVisible(true);
			lemtC.setVisible(true);
		}
		
	}
	
	class BRC implements ActionListener{

		
		public void actionPerformed(ActionEvent e) {
			g = false;
			bli = false;
			basicRose = true;
			brctrigC.setVisible(true);
			brck.setVisible(true);
			brtC.setVisible(true);
			brcR.setVisible(true);
			blitrigC.setVisible(false);
			blik.setVisible(false);
			gcosC.setVisible(false);
			gsinC.setVisible(false);
			gctC.setVisible(false);
			gstC.setVisible(false);
			gstR.setVisible(false);
			gctR.setVisible(false);
			gCosPower.setVisible(false);
			gSinPower.setVisible(false);
			gk.setVisible(false);
			sine.setVisible(true);
			cosine.setVisible(true);
			trigR.setVisible(false);
			lemtrigC.setVisible(false);
			lemk.setVisible(false);
			lemR.setVisible(false);
			lemtC.setVisible(false);
		}
		
	}

	class Slow implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speed = 200;
		}
	}

	class Medium implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speed = 30;
		}
	}

	class Fast implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			speed = 1;
		}
	}

	class Stop implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			t = 0;
			graph = false;
			graphing = false;
			Stop = true;
		}
	}

	class Play implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (pauseplay % 2 == 0)
				play = false;
			else
				play = true;
			pauseplay++;

		}
	}

	
	class GEnter implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			instaGraph = false;
			getPoints();
		}
	}

	public class Insta implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			instaGraph = true;
			getPoints();
			

		}
	}

	
	public void getPoints(){
		if (graphing == false) {
			String cco, cp, ctc, sco, sp, stc, K, str, ctr;
			cco = cp = ctc = sco = sp = stc = K = str = ctr = "";
			t= 0;
			boolean worked = true;
			if (g){
				cco = gcosC.getText();
				cp = gCosPower.getText();
				ctc = gctC.getText();
				sco = gsinC.getText();
				sp = gSinPower.getText();
				stc = gstC.getText();
				K = gk.getText();
				str = gstR.getText();
				ctr = gctR.getText();
			}
			else if (bli){
				System.out.println("hfas");
				sP = 1;
				cP = 1;
				ctC = 1;
				stC = 1;
				sCo =  1;
				cCo = 1;
				stR = 0;
				ctR = 0;
				k = 0;
				
				if (cos) {
					sCo = 0;
					 cco = blitrigC.getText();
					 K = blik.getText();
					 ctr = trigR.getText();
				}
				else {
					cCo = 0;
					 sco = blitrigC.getText();
					 K = blik.getText();
					 str = trigR.getText();
					
				}
			}
			else if (basicRose){
				sP = 1;
				cP = 1;
				ctC = 1;
				stC = 1;
				sCo =  1;
				cCo = 1;
				stR = 0;
				ctR = 0;
				k = 0;
				if (cos) {
					sCo = 0;
					cco = brctrigC.getText();
					K = brck.getText();
					ctr = brcR.getText();
					ctc = brtC.getText();
				}
				else {
					cCo = 0;
					sco = brctrigC.getText();
					K = brck.getText();
					str = brcR.getText();
					stc = brtC.getText();
				}
			}
			try {
				if (g){
					cCo = Double.parseDouble(cco);
					cP = Integer.parseInt(cp);
					ctC = Double.parseDouble(ctc);
					sCo = Double.parseDouble(sco);
					sP = Integer.parseInt(sp);
					stC = Double.parseDouble(stc);
					k = Double.parseDouble(K);
					stR = Math.toRadians(Double.parseDouble(str));
					ctR = Math.toRadians(Double.parseDouble(ctr));
				}
				else if (bli){
					if (cos){
						cCo = Double.parseDouble(cco);
						ctR = Math.toRadians(Double.parseDouble(ctr));
						k = Double.parseDouble(K);
					}
					else {
						sCo = Double.parseDouble(sco);
						stR = Math.toRadians(Double.parseDouble(str));
						k = Double.parseDouble(K);
					}
				}
				else if (basicRose){
					if (cos){
						cCo = Double.parseDouble(cco);
						ctR = Math.toRadians(Double.parseDouble(ctr));
						k = Double.parseDouble(K);
						ctC = Double.parseDouble(ctc);
					}
					else {
						sCo = Double.parseDouble(sco);
						stR = Math.toRadians(Double.parseDouble(str));
						k = Double.parseDouble(K);
						stC = Double.parseDouble(stc);
					}
				}
				
			}catch (NumberFormatException e){
				makeErrorFrame();
				worked = false;
			}
			if (worked == true)
				graph = true;
			else
				graph = false;
			
			initializePoints();
		}
	}
	public void makeErrorFrame(){
		JFrame errorFrame = new JFrame("ERROR");
		errorFrame.setSize(200, 100);
		errorFrame.setLocationRelativeTo(null);
		errorFrame.setVisible(true);
		JLabel label = new JLabel(
				"Please Enter Integer Values Only!");
		errorFrame.getContentPane().add(label,
				BorderLayout.CENTER);
		label.setVisible(true);
	}
	public Grapher() {
		// a.setPoints(100,300, 50,110);
		setLayout(null);

		Timer time = new Timer(1, this);
		time.start();
		initializeSpeedButtons();
		initializeGEquation();
		initializeOptionButtons();
		initializeBliEquation();
		initializeBRC();
		add(gEnter);
		gEnter.setBounds(715, 102, 100, 39);
		gEnter.addActionListener(new GEnter());

		add(InstaGraph);
		InstaGraph.setBounds(820, 102, 100, 39);
		InstaGraph.addActionListener(new Insta());
	}
	
	public void initializeGEquation() {

		add(gcosC);
		gcosC.setBounds(745, 20, 30, 30);

		add(gCosPower);
		gCosPower.setBounds(800, 10, 23, 16);

		add(gctC);
		gctC.setBounds(830, 20, 30, 30);

		add(gsinC);
		gsinC.setBounds(790, 65, 30, 30);

		add(gSinPower);
		gSinPower.setBounds(842, 55, 23, 16);

		add(gstC);
		gstC.setBounds(870, 65, 30, 30);
		
		add(gstR);
		gstR.setBounds(923, 65, 50, 30);

		add(gk);
		gk.setBounds(965, 105, 30, 30);
		
		add(gctR);
		gctR.setBounds(900, 20, 50, 30);

	}

	class SineSwitch implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if(graphing == false){
				cos = false;
				repaint();
			}
		}

	}

	class CosSwitch implements ActionListener {

		public void actionPerformed(ActionEvent arg0) {
			if(graphing == false){
				cos = true;
				repaint();
			}
		}

	}

	public void initializeSpeedButtons() {
		add(stop);
		add(PLAY);

		add(slow);
		add(fast);
		add(medium);

		PLAY.addActionListener(new Play());
		stop.addActionListener(new Stop());

		slow.addActionListener(new Slow());
		medium.addActionListener(new Medium());
		fast.addActionListener(new Fast());

		PLAY.setBounds(720, 356, 110, 70);
		stop.setBounds(840, 356, 110, 70);

		slow.setBounds(720, 310, 70, 20);
		medium.setBounds(820, 310, 70, 20);
		fast.setBounds(920, 310, 70, 20);
	}

	public void initializePoints() {
		if (graph == true) {
			max = 0;
			min = 100000;
			for (int i = 0; i < STEPS + 1; i++) {
				theta = Math.toRadians(i * 360 / STEPS);
				double radius = cCo * Math.pow(Math.cos((theta + ctR )* ctC), cP) + sCo
						* Math.pow(Math.sin((theta + stR) * stC), sP) + k;
				radii[i] = radius;

			}
			for (int i = 0; i < 3600 + 1; i++) {
				theta = Math.toRadians((i) / 10);
				double radius = cCo * Math.pow(Math.cos((theta + ctR) * ctC), cP) + sCo
				* Math.pow(Math.sin((theta + stR) * stC), sP) + k;
				if (Math.abs(radius) > max) {
					max = Math.abs(radius);
					maxs.add(theta);
				}
				if (Math.abs(radius) < min) {
					min = Math.abs(radius);
					mins.add(theta);
				}
			}
			
			 
			
			for (int i = 0; i < maxs.size(); i++) {
				double testtheta = maxs.get(i);
				double testrad = cCo * Math.pow(Math.cos((testtheta + ctR) * ctC), cP) + sCo
				* Math.pow(Math.sin((testtheta + stR) * stC), sP) + k;
				if (testrad == max) {
					maxTheta = maxs.get(i);
					break;
				}
			}
			for (int i = 0; i < mins.size(); i++) {
				double testtheta = mins.get(i);

				double testrad = cCo * Math.pow(Math.cos((testtheta + ctR) * ctC), cP) + sCo
				* Math.pow(Math.sin((testtheta + stR) * stC), sP) + k;
				if (testrad == min) {
					minTheta = mins.get(i);
					System.out.println(mins.get(i) + " " + minTheta);
					break;
				}
			}
			maxs.clear();
			mins.clear();
			// double scaleFactor = 1;

			System.out.println(max);
			double scaleFactor = 350 / max;
			System.out.println(scaleFactor);
			for (int i = 0; i < STEPS + 1; i++) {
				theta = Math.toRadians(i) * (360 / STEPS);

				double radius = radii[i];

				radius = scaleFactor * radius;
				points[i] = new Point();
				points[i].setLocation(350 + radius * Math.cos(theta), 350
						- radius * Math.sin(theta));

			}
		}
	}

	public void initializeOptionButtons() {
		add(basicLeminiscate);
		basicLeminiscate.setBounds(712, 185, 140, 40);
		add(basicRoseCurve);
		basicRoseCurve.setBounds(860, 185, 140, 40);
		add(basicLimicon);
		basicLimicon.setBounds(712, 230, 140, 40);
		add(general);
		general.setBounds(860, 230, 140, 40);
		
		basicLimicon.addActionListener(new BasicLimicon());
		general.addActionListener(new General());
		basicRoseCurve.addActionListener(new BRC());
	}

	public void initializeBliEquation() {
		add(blik);
		blik.setBounds(745, 20, 30, 30);
		blik.setVisible(false);
		add(blitrigC);
		blitrigC.setBounds(800, 20, 30, 30);
		blitrigC.setVisible(false);
		sine.setBounds(740, 67, 40, 20);
		cosine.setBounds(800, 67, 50, 20);
		sine.setVisible(false);
		cosine.setVisible(false);
		add(sine);
		add(cosine);
		sine.addActionListener(new SineSwitch());
		cosine.addActionListener(new CosSwitch());
		add(trigR);
		trigR.setBounds(894, 20, 50, 30);
		trigR.setVisible(false);

	}
	public void initializeBRC(){
		add(brck);
		brck.setBounds(745, 20, 30, 30);
		brck.setVisible(false);
		add(brctrigC);
		brctrigC.setBounds(800, 20, 30, 30);
		brctrigC.setVisible(false);
		add(brcR);
		brcR.setBounds(924, 20, 50, 30);
		brcR.setVisible(false);
		add(brtC);
		brtC.setBounds(863, 20, 30, 30);
		brtC.setVisible(false);
		
	}
	public void actionPerformed(ActionEvent e) {
		if (Stop == true) {
			repaint();
			Stop = false;
		}
		// initializePoints();
		if (play == true && graph == true) {
			slowfast++;
			if (slowfast % speed == 0) {
				t++;
				if (t < STEPS + 1)
					repaint();
			}
		}
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setFont(new Font("Plain", Font.PLAIN, 17));
		if (leminiscate){
			//g.drawString("2", arg1, arg2)
		}
		g.drawString("r = ", 718, 40);
		
		
		drawGraphPaper(g);
		if (graph)
			drawGraph(g);
		// drawTheta(g);
		drawSpeedButtons(g);
		if (this.g)
			drawGEquation(g);
		else if (bli)
			drawBasicLimicon(g);
		else if (basicRose)
			drawBasicRoseCurve(g);

		drawSelectionButtons(g);
		drawGraphStats(g);

	}

	public void drawGraphPaper(Graphics g) {
		g.setColor(Color.red);
		g.drawLine(350, 0, 350, 700);
		g.drawLine(349, 0, 349, 700);
		g.drawLine(351, 0, 351, 700);
		g.drawLine(0, 349, 700, 349);
		g.drawLine(0, 350, 700, 350);
		g.drawLine(0, 351, 700, 351);
		for (int i = 0; i < 12; i++) {
			double theta = i * 30;
			if (theta % 90 != 0) {
				g.drawLine(350, 350,
						(int) (350 + 350 * Math.cos(Math.toRadians(theta))),
						(int) (350 - 350 * Math.sin(Math.toRadians(theta))));
			}

		}

		g.setColor(Color.green);
		for (int i = 1; i < 6; i++) {
			g.drawOval(350 - 70 * i, 350 - 70 * i, 140 * i, 140 * i);
		}

		g.setColor(Color.black);

		g.drawLine(710, 0, 710, 722);
		g.drawLine(710, 150, 1000, 150);
		g.drawLine(710, 151, 1000, 151);
		g.drawLine(711, 0, 711, 722);

	}

	public void drawGraph(Graphics g) {
		g.setColor(Color.black);
		if (t <= STEPS && instaGraph == false) {
			graphing = true;
			for (int i = 0; i < t + 1; i++) {
				if (i > 0)
					g.drawLine((int) points[i].getX(), (int) points[i].getY(),
							(int) points[i - 1].getX(),
							(int) points[i - 1].getY());

			}
			g.setColor(Color.BLUE);
			if (t < STEPS)
				g.drawLine(350, 350, (int) points[t].getX(),
						(int) points[t].getY());

			g.setColor(Color.black);
		} else if (instaGraph == true) {
			for (int i = 0; i < STEPS + 1; i++) {
				if (i > 0)
					g.drawLine((int) points[i].getX(), (int) points[i].getY(),
							(int) points[i - 1].getX(),
							(int) points[i - 1].getY());
			}
		} else
			graphing = false;

		g.setColor(Color.black);
		for (int i = 1; i < 6; i++) {
			String s;
			if (max > 10)
				s = i * (int) max / 5 + "";
			else {
				double value = i * max / 5 * 100;
				int val = (int) value;

				value = val / 100.0;
				s = value + "";
			}
			g.drawString(s, 334 + 70 * i, 350);
		}
	}

	public void drawGEquation(Graphics g) {
		g.setFont(new Font("Plain", Font.PLAIN, 17));

		g.drawString("cos", 775, 40);
		g.drawString("(", 822, 40);
		g.drawString("(",862, 40);
		g.drawOval(870, 23, 12, 20);
		g.drawLine(870, 33, 883, 33);
		g.drawString("+", 885, 40);
		g.drawString("))", 950, 40);
		//g.drawString(")", 877, 40);

		g.drawString("+ ", 777, 85);
		g.drawString("sin", 822, 85);
		g.drawString("(", 862, 85);
		g.drawString("(", 900, 85);
		g.drawOval(908, 68, 12, 20);
		g.drawLine(908, 78, 921, 78);
		g.drawString("))", 973, 85);

		g.drawString("+ ", 950, 125);
		// g.drawLine(710, 144, 1000, 144 );
		// g.drawLine(710, 145, 1000, 144);
	}

	public void drawSpeedButtons(Graphics g) {
		g.setColor(Color.black);
		g.setFont(new Font("Plain", Font.PLAIN, 17));
		g.drawString("Graphing Speed:", 718, 300);
		g.drawString("Pause/Play/Stop:", 718, 350);
		g.drawLine(710, 430, 1000, 430);
		g.drawLine(710, 431, 1000, 431);
	}

	public void drawSelectionButtons(Graphics g) {
		g.setColor(Color.black);
		g.drawString("Select Equation Entering Type:", 717, 175);
		g.drawLine(710, 275, 1000, 275);
		g.drawLine(710, 276, 1000, 276);
	}

	public void drawGraphStats(Graphics g) {
		g.drawString("Graph Statistics:", 720, 450);

		String s, s2, s3a, s4a, s3b, s4b;
		double MAX = max;
		int rounder3 = (int)(100*MAX);
		MAX = rounder3/100.0;
		double MIN = min;
		int rounder4 = (int)(100*MIN);
		MIN = rounder4/100.0;
		double MINTHETA = Math.toDegrees(minTheta);
		int rounder5 = (int)(100*MINTHETA);
		MINTHETA = rounder5/100.0;
		double MAXTHETA = Math.toDegrees(maxTheta);
		int rounder6 = (int)(100*MAXTHETA);
		MAXTHETA = rounder6/100.0;
		
		if (graph == false) {
			s = "theta = 0.0";
			s2 = "r = 0.0";
			s3a = "Maximum radius = -- which ";
			s3b = "first occurs at --  degrees";
			s4a = "Minumum radius = -- which";
			s4b = "first occurs at -- degrees";
		} else if (instaGraph == false) {
			double radius = 0;
			if (t < 541)
				radius = radii[t];
			double theta2 = t * (360 / STEPS);
			int rounder = (int) (100 * theta2);
			int rounder2 = (int) (radius * 100);
			theta2 = (double) rounder / 100;
			radius = (double) rounder2 / 100;
			s = "theta = " + theta2 + "";
			s2 = "r = " + radius;

			s3a = "Maximum radius = " + MAX + " which ";
			s3b = "first occurs at " + MAXTHETA + " degrees";
			s4a = "Minumum radius = " + MIN + " which";
			s4b = "first occurs at " + MINTHETA + " degrees";

		}

		else {
			s = "theta = --";
			s2 = "r = --";
			s3a = "Maximum radius = " + MAX + " which ";
			s3b = "first occurs at " + MAXTHETA + " degrees";
			s4a = "Minumum radius = " + MIN + " which";
			s4b = "first occurs at " + MINTHETA + " degrees";
		}
		g.drawString(s, 720, 480);
		g.drawString(s2, 880, 480);
		g.drawString(s3a, 720, 540);
		g.drawString(s3b, 720, 560);
		g.drawString(s4a, 720, 600);
		g.drawString(s4b, 720, 620);

	}

	public void drawBasicLimicon(Graphics g) {
		g.drawString(" + ", 775, 40);
		if (cos)
			g.drawString("cos(", 830, 40);
		else
			g.drawString("sin(", 835, 40);
		g.drawOval(867, 25, 10, 18);
		g.drawLine(867, 34, 877, 34);
		g.drawString("+", 881, 40);
		g.drawString(")", 944, 40);
	}
	
	public void drawBasicRoseCurve(Graphics g){
		g.drawString(" + ", 775, 40);
		if (cos)
			g.drawString("cos(", 830, 40);
		else
			g.drawString("sin(", 835, 40);
		g.drawString("(", 891, 40);
		g.drawOval(900, 25, 10, 18);
		g.drawLine(900, 34, 910, 34);
		g.drawString("+", 912, 40);
		g.drawString("))", 975, 40);
	}

	public void drawLeminiscae(Graphics g){
		
	}
}