/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectfour;

/**
 *
 * @author Yifan Dai
 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
public class Main implements ActionListener {

        //declaring everything,thing named blank are used for spacing
        JFrame frame;
        JPanel contentPane;
        JButton box1,box2,box3,box4,box5,box6,box7,box8;
        JButton newGame,nextRound,save,load;
        JButton[][] boxes = new JButton[8][8];
        JTextField red,blue;
        int redWins=0,blueWins=0;
        int count=1;
        int hc11=0,hc12=0;
        int hc21=0,hc22=0;
        int hc31=0,hc32=0;
        int hc41=0,hc42=0;
        int hc51=0,hc52=0;
        int hc61=0,hc62=0;
        int hc71=0,hc72=0;
        int hc81=0,hc82=0;
        int counter=0,counter2=0;
        int column1=7,column2=7,column3=7,column4=7,column5=7,column6=7,column7=7,column8=7;
    public Main(){

        //setting everything
        frame = new JFrame("connect four");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        contentPane = new JPanel();
        contentPane.setLayout(new GridLayout (10,8,0,5));
        contentPane.setBackground(Color.white);
        contentPane.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));

        box1 = new JButton ("place peice");
        box1.setActionCommand("place1");
        box1.addActionListener(this);
        contentPane.add(box1);
        box2 = new JButton ("place peice");
        box2.setActionCommand("place2");
        box2.addActionListener(this);
        contentPane.add(box2);
        box3 = new JButton ("place peice");
        box3.setActionCommand("place3");
        box3.addActionListener(this);
        contentPane.add(box3);
        box4 = new JButton ("place peice");
        box4.setActionCommand("place4");
        box4.addActionListener(this);
        contentPane.add(box4);
        box5 = new JButton ("place peice");
        box5.setActionCommand("place5");
        box5.addActionListener(this);
        contentPane.add(box5);
        box6 = new JButton ("place peice");
        box6.setActionCommand("place6");
        box6.addActionListener(this);
        contentPane.add(box6);
        box7 = new JButton ("place peice");
        box7.setActionCommand("place7");
        box7.addActionListener(this);
        contentPane.add(box7);
        box8 = new JButton ("place peice");
        box8.setActionCommand("place8");
        box8.addActionListener(this);
        contentPane.add(box8);

        for(int g=0;g<8;g++){
            for(int i=0; i<8;i++){
                boxes[g][i]=new JButton(" ");
                boxes[g][i].setText(" ");
                boxes[g][i].setBackground(Color.white);
                contentPane.add(boxes[g][i]);
            }
        }

        newGame = new JButton ("new game");
        newGame.setActionCommand("new");
        newGame.addActionListener(this);
        contentPane.add(newGame);

        nextRound = new JButton ("next round");
        nextRound.setActionCommand("next");
        nextRound.addActionListener(this);
        contentPane.add(nextRound);

        save = new JButton ("save score");
        save.setActionCommand("save");
        save.addActionListener(this);
        contentPane.add(save);

        load = new JButton ("load");
        load.setActionCommand("load");
        load.addActionListener(this);
        contentPane.add(load);

        red = new JTextField ("red: "+redWins);
        contentPane.add(red);

        blue = new JTextField ("blue: "+blueWins);
        contentPane.add(blue);

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setSize(300,200);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent event){
        String eventName = event.getActionCommand();
        String turn;

        File textFileReader = new File("score.txt");
        FileReader in;
        BufferedReader readFile;
        String reader;

        File textFileWriter = new File("score.txt");
        FileWriter out;
        BufferedWriter writeFile;
        String writer;

        if(count%2==1){
            turn=("red wins");
        }else{
            turn=("blue wins");
        }
        count++;

        if(eventName.equals("place1")){
            if(turn.equals("red wins")){
                boxes[column1][0].setBackground(Color.red);
                boxes[column1][0].setText("red wins");
                boxes[column1][0].setForeground(Color.red);
            }else{
                boxes[column1][0].setBackground(Color.blue);
                boxes[column1][0].setText("blue wins");
                boxes[column1][0].setForeground(Color.blue);
            }

            if(boxes[column1][0].getText().equals("red wins")){
                hc11++;
                hc12=0;
            }else if(boxes[column1][0].getText().equals("blue wins")){
                hc11=0;
                hc12++;
            }

            if(hc11>3){
                boxes[column1][0].setBackground(Color.green);
                boxes[column1+1][0].setBackground(Color.green);
                boxes[column1+2][0].setBackground(Color.green);
                boxes[column1+3][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc12>3){
                boxes[column1][0].setBackground(Color.green);
                boxes[column1+1][0].setBackground(Color.green);
                boxes[column1+2][0].setBackground(Color.green);
                boxes[column1+3][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            for(int r=0;r<4;r++){
                if(boxes[column1][r].getText().equals("red wins")){
                    counter++;
                }else if(boxes[column1][r].getText().equals("blue wins")){
                    counter2++;
                }
            }

            if(counter>3){
                boxes[column1][0].setBackground(Color.green);
                boxes[column1][1].setBackground(Color.green);
                boxes[column1][2].setBackground(Color.green);
                boxes[column1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(counter2>3){
                boxes[column1][0].setBackground(Color.green);
                boxes[column1][1].setBackground(Color.green);
                boxes[column1][2].setBackground(Color.green);
                boxes[column1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }
            counter=0;
            counter2=0;

            if(column1>2&&boxes[column1][counter].getText().equals("red wins")&& boxes[column1-1][counter+1].getText().equals("red wins")&& boxes[column1-2][counter+2].getText().equals("red wins")&& boxes[column1-3][counter+3].getText().equals("red wins")){
                    boxes[column1][counter].setBackground(Color.green);
                    boxes[column1-1][counter+1].setBackground(Color.green);
                    boxes[column1-2][counter+2].setBackground(Color.green);
                    boxes[column1-3][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(column1>2&&boxes[column1][counter].getText().equals("blue wins")&& boxes[column1-1][counter+1].getText().equals("blue wins")&& boxes[column1-2][counter+2].getText().equals("blue wins")&& boxes[column1-3][counter+3].getText().equals("blue wins")){
                    boxes[column1][counter].setBackground(Color.green);
                    boxes[column1-1][counter+1].setBackground(Color.green);
                    boxes[column1-2][counter+2].setBackground(Color.green);
                    boxes[column1-3][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
            counter=0;

            column1-=1;
            if(column1<0){
                box1.setVisible(false);
            }
        }
        if(eventName.equals("place2")){
            if(turn.equals("red wins")){
                boxes[column2][1].setBackground(Color.red);
                boxes[column2][1].setText("red wins");
                boxes[column2][1].setForeground(Color.red);
            }else{
                boxes[column2][1].setBackground(Color.blue);
                boxes[column2][1].setText("blue wins");
                boxes[column2][1].setForeground(Color.blue);
            }

            if(boxes[column2][1].getText().equals("red wins")){
                hc21++;
                hc22=0;
            }else if(boxes[column2][1].getText().equals("blue wins")){
                hc21=0;
                hc22++;
            }

            if(hc21>3){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][1].setBackground(Color.green);
                boxes[column2+2][1].setBackground(Color.green);
                boxes[column2+3][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc22>3){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][1].setBackground(Color.green);
                boxes[column2+2][1].setBackground(Color.green);
                boxes[column2+3][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column2][counter].getText().equals("red wins")&& boxes[column2][counter+1].getText().equals("red wins")&& boxes[column2][counter+2].getText().equals("red wins")&& boxes[column2][counter+3].getText().equals("red wins")){
                    boxes[column2][counter].setBackground(Color.green);
                    boxes[column2][counter+1].setBackground(Color.green);
                    boxes[column2][counter+2].setBackground(Color.green);
                    boxes[column2][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column2][counter].getText().equals("blue wins")&& boxes[column2][counter+1].getText().equals("blue wins")&& boxes[column2][counter+2].getText().equals("blue wins")&& boxes[column2][counter+3].getText().equals("blue wins")){
                    boxes[column2][counter].setBackground(Color.green);
                    boxes[column2][counter+1].setBackground(Color.green);
                    boxes[column2][counter+2].setBackground(Color.green);
                    boxes[column2][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;


            if(column2>2&&boxes[column2][1].getText().equals("red wins")&& boxes[column2-1][2].getText().equals("red wins")&& boxes[column2-2][3].getText().equals("red wins")&& boxes[column2-3][4].getText().equals("red wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2-1][2].setBackground(Color.green);
                boxes[column2-2][3].setBackground(Color.green);
                boxes[column2-3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(column2>2&&boxes[column2][1].getText().equals("blue wins")&& boxes[column2-1][2].getText().equals("blue wins")&& boxes[column2-2][3].getText().equals("blue wins")&& boxes[column2-3][4].getText().equals("blue wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2-1][2].setBackground(Color.green);
                boxes[column2-2][3].setBackground(Color.green);
                boxes[column2-3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column2<7&&column2>1&&boxes[column2][1].getText().equals("red wins")&&boxes[column2+1][0].getText().equals("red wins")&& boxes[column2-1][2].getText().equals("red wins")&& boxes[column2-2][3].getText().equals("red wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][0].setBackground(Color.green);
                boxes[column2-1][2].setBackground(Color.green);
                boxes[column2-2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column2<7&&column2>1&&boxes[column2][1].getText().equals("blue wins")&&boxes[column2+1][0].getText().equals("blue wins")&& boxes[column2-1][2].getText().equals("blue wins")&& boxes[column2-2][3].getText().equals("blue wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][0].setBackground(Color.green);
                boxes[column2-1][2].setBackground(Color.green);
                boxes[column2-2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column2<6&&column2>0&&boxes[column2][1].getText().equals("red wins")&&boxes[column2-1][0].getText().equals("red wins")&& boxes[column2+1][2].getText().equals("red wins")&& boxes[column2+2][3].getText().equals("red wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2-1][0].setBackground(Color.green);
                boxes[column2+1][2].setBackground(Color.green);
                boxes[column2+2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column2<6&&column2>0&&boxes[column2][1].getText().equals("blue wins")&&boxes[column2-1][0].getText().equals("blue wins")&& boxes[column2+1][2].getText().equals("blue wins")&& boxes[column2+2][3].getText().equals("blue wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2-1][0].setBackground(Color.green);
                boxes[column2+1][2].setBackground(Color.green);
                boxes[column2+2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column2<5&&boxes[column2][1].getText().equals("red wins")&&boxes[column2+1][2].getText().equals("red wins")&& boxes[column2+2][3].getText().equals("red wins")&& boxes[column2+3][4].getText().equals("red wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][2].setBackground(Color.green);
                boxes[column2+2][3].setBackground(Color.green);
                boxes[column2+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column2<5&&boxes[column2][1].getText().equals("blue wins")&&boxes[column2+1][2].getText().equals("blue wins")&& boxes[column2+2][3].getText().equals("blue wins")&& boxes[column2+3][4].getText().equals("blue wins")){
                boxes[column2][1].setBackground(Color.green);
                boxes[column2+1][2].setBackground(Color.green);
                boxes[column2+2][3].setBackground(Color.green);
                boxes[column2+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column2-=1;

            if(column2<0){
                box2.setVisible(false);
            }
        }
        if(eventName.equals("place3")){
            if(turn.equals("red wins")){
                boxes[column3][2].setBackground(Color.red);
                boxes[column3][2].setText("red wins");
                boxes[column3][2].setForeground(Color.red);
            }else{
                boxes[column3][2].setBackground(Color.blue);
                boxes[column3][2].setText("blue wins");
                boxes[column3][2].setForeground(Color.blue);
            }

            if(boxes[column3][2].getText().equals("red wins")){
                hc31++;
                hc32=0;
            }else if(boxes[column3][2].getText().equals("blue wins")){
                hc31=0;
                hc32++;
            }

            if(hc31>3){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][2].setBackground(Color.green);
                boxes[column3+2][2].setBackground(Color.green);
                boxes[column3+3][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc32>3){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][2].setBackground(Color.green);
                boxes[column3+2][2].setBackground(Color.green);
                boxes[column3+3][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column3][counter].getText().equals("red wins")&& boxes[column3][counter+1].getText().equals("red wins")&& boxes[column3][counter+2].getText().equals("red wins")&& boxes[column3][counter+3].getText().equals("red wins")){
                    boxes[column3][counter].setBackground(Color.green);
                    boxes[column3][counter+1].setBackground(Color.green);
                    boxes[column3][counter+2].setBackground(Color.green);
                    boxes[column3][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column3][counter].getText().equals("blue wins")&& boxes[column3][counter+1].getText().equals("blue wins")&& boxes[column3][counter+2].getText().equals("blue wins")&& boxes[column3][counter+3].getText().equals("blue wins")){
                    boxes[column3][counter].setBackground(Color.green);
                    boxes[column3][counter+1].setBackground(Color.green);
                    boxes[column3][counter+2].setBackground(Color.green);
                    boxes[column3][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;

            if(column3>2&&boxes[column3][2].getText().equals("red wins")&& boxes[column3-1][3].getText().equals("red wins")&& boxes[column3-2][4].getText().equals("red wins")&& boxes[column3-3][5].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                boxes[column3-2][4].setBackground(Color.green);
                boxes[column3-3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(column3>2&&boxes[column3][1].getText().equals("blue wins")&& boxes[column3-1][3].getText().equals("blue wins")&& boxes[column3-2][4].getText().equals("blue wins")&& boxes[column3-3][5].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                boxes[column3-2][4].setBackground(Color.green);
                boxes[column3-3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column3<7&&column3>1&&boxes[column3][2].getText().equals("red wins")&&boxes[column3+1][1].getText().equals("red wins")&& boxes[column3-1][3].getText().equals("red wins")&& boxes[column3-2][4].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][1].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                boxes[column3-2][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column3<7&&column3>1&&boxes[column3][2].getText().equals("blue wins")&&boxes[column3+1][1].getText().equals("blue wins")&& boxes[column3-1][3].getText().equals("blue wins")&& boxes[column3-2][4].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][1].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                boxes[column3-2][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column3<6&&column3>0&&boxes[column3][2].getText().equals("red wins")&&boxes[column3+1][1].getText().equals("red wins")&& boxes[column3+2][0].getText().equals("red wins")&& boxes[column3-1][3].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][1].setBackground(Color.green);
                boxes[column3+2][0].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column3<6&&column3>0&&boxes[column3][2].getText().equals("blue wins")&&boxes[column3+1][1].getText().equals("blue wins")&& boxes[column3+2][0].getText().equals("blue wins")&& boxes[column3-1][3].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][1].setBackground(Color.green);
                boxes[column3+2][0].setBackground(Color.green);
                boxes[column3-1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column3<7&&column3>1&&boxes[column3][2].getText().equals("red wins")&&boxes[column3+1][3].getText().equals("red wins")&& boxes[column3-1][1].getText().equals("red wins")&& boxes[column3-2][0].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3-1][1].setBackground(Color.green);
                boxes[column3-2][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column3<7&&column3>0&&boxes[column3][2].getText().equals("blue wins")&&boxes[column3+1][3].getText().equals("blue wins")&& boxes[column3-1][1].getText().equals("blue wins")&& boxes[column3-2][0].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3-1][1].setBackground(Color.green);
                boxes[column3-2][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column3<6&&column3>1&&boxes[column3][2].getText().equals("red wins")&&boxes[column3+1][3].getText().equals("red wins")&& boxes[column3+2][4].getText().equals("red wins")&& boxes[column3-1][1].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3+2][4].setBackground(Color.green);
                boxes[column3-1][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column3<6&&column3>1&&boxes[column3][2].getText().equals("blue wins")&&boxes[column3+1][3].getText().equals("blue wins")&& boxes[column3+2][4].getText().equals("blue wins")&& boxes[column3-1][1].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3+2][4].setBackground(Color.green);
                boxes[column3-1][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column3<5&&boxes[column3][2].getText().equals("red wins")&&boxes[column3+1][3].getText().equals("red wins")&& boxes[column3+2][4].getText().equals("red wins")&& boxes[column3+3][5].getText().equals("red wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3+2][4].setBackground(Color.green);
                boxes[column3+3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column3<5&&boxes[column3][2].getText().equals("blue wins")&&boxes[column3+1][3].getText().equals("blue wins")&& boxes[column3+2][4].getText().equals("blue wins")&& boxes[column3+3][5].getText().equals("blue wins")){
                boxes[column3][2].setBackground(Color.green);
                boxes[column3+1][3].setBackground(Color.green);
                boxes[column3+2][4].setBackground(Color.green);
                boxes[column3+3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column3-=1;
            if(column3<0){
                box3.setVisible(false);
            }
        }
        if(eventName.equals("place4")){
            if(turn.equals("red wins")){
                boxes[column4][3].setBackground(Color.red);
                boxes[column4][3].setText("red wins");
                boxes[column4][3].setForeground(Color.red);
            }else{
                boxes[column4][3].setBackground(Color.blue);
                boxes[column4][3].setText("blue wins");
                boxes[column4][3].setForeground(Color.blue);
            }

            if(boxes[column4][3].getText().equals("red wins")){
                hc41++;
                hc42=0;
            }else if(boxes[column4][3].getText().equals("blue wins")){
                hc41=0;
                hc42++;
            }

            if(hc41>3){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][3].setBackground(Color.green);
                boxes[column4+2][3].setBackground(Color.green);
                boxes[column4+3][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc42>3){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][3].setBackground(Color.green);
                boxes[column4+2][3].setBackground(Color.green);
                boxes[column4+3][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column4][counter].getText().equals("red wins")&& boxes[column4][counter+1].getText().equals("red wins")&& boxes[column4][counter+2].getText().equals("red wins")&& boxes[column4][counter+3].getText().equals("red wins")){
                    boxes[column4][counter].setBackground(Color.green);
                    boxes[column4][counter+1].setBackground(Color.green);
                    boxes[column4][counter+2].setBackground(Color.green);
                    boxes[column4][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column4][counter].getText().equals("blue wins")&& boxes[column4][counter+1].getText().equals("blue wins")&& boxes[column4][counter+2].getText().equals("blue wins")&& boxes[column4][counter+3].getText().equals("blue wins")){
                    boxes[column4][counter].setBackground(Color.green);
                    boxes[column4][counter+1].setBackground(Color.green);
                    boxes[column4][counter+2].setBackground(Color.green);
                    boxes[column4][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;

            if(column4>2&&boxes[column4][3].getText().equals("red wins")&& boxes[column4-1][4].getText().equals("red wins")&& boxes[column4-2][5].getText().equals("red wins")&& boxes[column4-3][6].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                boxes[column4-2][5].setBackground(Color.green);
                boxes[column4-3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(column4>2&&boxes[column4][3].getText().equals("blue wins")&& boxes[column4-1][4].getText().equals("blue wins")&& boxes[column4-2][5].getText().equals("blue wins")&& boxes[column4-3][6].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                boxes[column4-2][5].setBackground(Color.green);
                boxes[column4-3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<7&&column4>1&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][2].getText().equals("red wins")&& boxes[column4-1][4].getText().equals("red wins")&& boxes[column4-2][5].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                boxes[column4-2][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<7&&column4>1&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][2].getText().equals("blue wins")&& boxes[column4-1][4].getText().equals("blue wins")&& boxes[column4-2][5].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                boxes[column4-2][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][2].getText().equals("red wins")&& boxes[column4+2][1].getText().equals("red wins")&& boxes[column4-1][4].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4+2][1].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][2].getText().equals("blue wins")&& boxes[column4+2][1].getText().equals("blue wins")&& boxes[column4-1][4].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4+2][1].setBackground(Color.green);
                boxes[column4-1][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][2].getText().equals("red wins")&& boxes[column4+2][1].getText().equals("red wins")&& boxes[column4+3][0].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4+2][1].setBackground(Color.green);
                boxes[column4+3][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][2].getText().equals("blue wins")&& boxes[column4+2][1].getText().equals("blue wins")&& boxes[column4+3][0].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][2].setBackground(Color.green);
                boxes[column4+2][1].setBackground(Color.green);
                boxes[column4+3][0].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<7&&column4>1&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][4].getText().equals("red wins")&& boxes[column4-1][2].getText().equals("red wins")&& boxes[column4-2][1].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4-1][2].setBackground(Color.green);
                boxes[column4-2][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<7&&column4>1&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][4].getText().equals("blue wins")&& boxes[column4-1][2].getText().equals("blue wins")&& boxes[column4-2][1].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4-1][2].setBackground(Color.green);
                boxes[column4-2][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][4].getText().equals("red wins")&& boxes[column4+2][5].getText().equals("red wins")&& boxes[column4-1][2].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4+2][5].setBackground(Color.green);
                boxes[column4-1][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<6&&column4>0&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][4].getText().equals("blue wins")&& boxes[column4+2][5].getText().equals("blue wins")&& boxes[column4-1][2].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4+2][5].setBackground(Color.green);
                boxes[column4-1][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column4<5&&boxes[column4][3].getText().equals("red wins")&&boxes[column4+1][4].getText().equals("red wins")&& boxes[column4+2][5].getText().equals("red wins")&& boxes[column4+3][6].getText().equals("red wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4+2][5].setBackground(Color.green);
                boxes[column4+3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column4<5&&boxes[column4][3].getText().equals("blue wins")&&boxes[column4+1][4].getText().equals("blue wins")&& boxes[column4+2][5].getText().equals("blue wins")&& boxes[column4+3][6].getText().equals("blue wins")){
                boxes[column4][3].setBackground(Color.green);
                boxes[column4+1][4].setBackground(Color.green);
                boxes[column4+2][5].setBackground(Color.green);
                boxes[column4+3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column4-=1;
            if(column4<0){
                box4.setVisible(false);
            }
        }
        if(eventName.equals("place5")){
            if(turn.equals("red wins")){
                boxes[column5][4].setBackground(Color.red);
                boxes[column5][4].setText("red wins");
                boxes[column5][4].setForeground(Color.red);
            }else{
                boxes[column5][4].setBackground(Color.blue);
                boxes[column5][4].setText("blue wins");
                boxes[column5][4].setForeground(Color.blue);
            }

            if(boxes[column5][4].getText().equals("red wins")){
                hc51++;
                hc52=0;
            }else if(boxes[column5][4].getText().equals("blue wins")){
                hc51=0;
                hc52++;
            }

            if(hc51>3){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][4].setBackground(Color.green);
                boxes[column5+2][4].setBackground(Color.green);
                boxes[column5+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc52>3){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][4].setBackground(Color.green);
                boxes[column5+2][4].setBackground(Color.green);
                boxes[column5+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column5][counter].getText().equals("red wins")&& boxes[column5][counter+1].getText().equals("red wins")&& boxes[column5][counter+2].getText().equals("red wins")&& boxes[column5][counter+3].getText().equals("red wins")){
                    boxes[column5][counter].setBackground(Color.green);
                    boxes[column5][counter+1].setBackground(Color.green);
                    boxes[column5][counter+2].setBackground(Color.green);
                    boxes[column5][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column5][counter].getText().equals("blue wins")&& boxes[column5][counter+1].getText().equals("blue wins")&& boxes[column5][counter+2].getText().equals("blue wins")&& boxes[column5][counter+3].getText().equals("blue wins")){
                    boxes[column5][counter].setBackground(Color.green);
                    boxes[column5][counter+1].setBackground(Color.green);
                    boxes[column5][counter+2].setBackground(Color.green);
                    boxes[column5][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;

            if(column5>2&&boxes[column5][4].getText().equals("red wins")&& boxes[column5-1][5].getText().equals("red wins")&& boxes[column5-2][6].getText().equals("red wins")&& boxes[column5-3][7].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                boxes[column5-2][6].setBackground(Color.green);
                boxes[column5-3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(column5>2&&boxes[column5][4].getText().equals("blue wins")&& boxes[column5-1][6].getText().equals("blue wins")&& boxes[column5-2][6].getText().equals("blue wins")&& boxes[column5-3][7].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                boxes[column5-2][6].setBackground(Color.green);
                boxes[column5-3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<7&&column5>1&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][3].getText().equals("red wins")&& boxes[column5-1][5].getText().equals("red wins")&& boxes[column5-2][6].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                boxes[column5-2][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<7&&column5>1&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][3].getText().equals("blue wins")&& boxes[column5-1][5].getText().equals("blue wins")&& boxes[column5-2][6].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                boxes[column5-2][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][3].getText().equals("red wins")&& boxes[column5+2][2].getText().equals("red wins")&& boxes[column5-1][5].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5+2][2].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][3].getText().equals("blue wins")&& boxes[column5+2][2].getText().equals("blue wins")&& boxes[column5-1][5].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5+2][2].setBackground(Color.green);
                boxes[column5-1][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<5&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][3].getText().equals("red wins")&& boxes[column5+2][2].getText().equals("red wins")&& boxes[column5+3][1].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5+2][2].setBackground(Color.green);
                boxes[column5+3][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<5&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][3].getText().equals("blue wins")&& boxes[column5+2][2].getText().equals("blue wins")&& boxes[column5+3][1].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][3].setBackground(Color.green);
                boxes[column5+2][2].setBackground(Color.green);
                boxes[column5+3][1].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<7&&column5>1&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][5].getText().equals("red wins")&& boxes[column5-1][3].getText().equals("red wins")&& boxes[column5-2][2].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5-1][3].setBackground(Color.green);
                boxes[column5-2][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<7&&column5>1&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][5].getText().equals("blue wins")&& boxes[column5-1][3].getText().equals("blue wins")&& boxes[column5-2][2].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5-1][3].setBackground(Color.green);
                boxes[column5-2][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][5].getText().equals("red wins")&& boxes[column5+2][6].getText().equals("red wins")&& boxes[column5-1][3].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5+2][6].setBackground(Color.green);
                boxes[column5-1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][5].getText().equals("blue wins")&& boxes[column5+2][6].getText().equals("blue wins")&& boxes[column5-1][3].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5+2][6].setBackground(Color.green);
                boxes[column5-1][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("red wins")&&boxes[column5+1][5].getText().equals("red wins")&& boxes[column5+2][6].getText().equals("red wins")&& boxes[column5+3][7].getText().equals("red wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5+2][6].setBackground(Color.green);
                boxes[column5+3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column5<6&&column5>0&&boxes[column5][4].getText().equals("blue wins")&&boxes[column5+1][5].getText().equals("blue wins")&& boxes[column5+2][6].getText().equals("blue wins")&& boxes[column5+3][7].getText().equals("blue wins")){
                boxes[column5][4].setBackground(Color.green);
                boxes[column5+1][5].setBackground(Color.green);
                boxes[column5+2][6].setBackground(Color.green);
                boxes[column5+3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column5-=1;
            if(column5<0){
                box5.setVisible(false);
            }
        }
        if(eventName.equals("place6")){
            if(turn.equals("red wins")){
                boxes[column6][5].setBackground(Color.red);
                boxes[column6][5].setText("red wins");
                boxes[column6][5].setForeground(Color.red);
            }else{
                boxes[column6][5].setBackground(Color.blue);
                boxes[column6][5].setText("blue wins");
                boxes[column6][5].setForeground(Color.blue);
            }

            if(boxes[column6][5].getText().equals("red wins")){
                hc61++;
                hc62=0;
            }else if(boxes[column6][5].getText().equals("blue wins")){
                hc61=0;
                hc62++;
            }

            if(hc61>3){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][5].setBackground(Color.green);
                boxes[column6+2][5].setBackground(Color.green);
                boxes[column6+3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc62>3){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][5].setBackground(Color.green);
                boxes[column6+2][5].setBackground(Color.green);
                boxes[column6+3][5].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column6][counter].getText().equals("red wins")&& boxes[column6][counter+1].getText().equals("red wins")&& boxes[column6][counter+2].getText().equals("red wins")&& boxes[column6][counter+3].getText().equals("red wins")){
                    boxes[column6][counter].setBackground(Color.green);
                    boxes[column6][counter+1].setBackground(Color.green);
                    boxes[column6][counter+2].setBackground(Color.green);
                    boxes[column6][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column6][counter].getText().equals("blue wins")&& boxes[column6][counter+1].getText().equals("blue wins")&& boxes[column6][counter+2].getText().equals("blue wins")&& boxes[column6][counter+3].getText().equals("blue wins")){
                    boxes[column6][counter].setBackground(Color.green);
                    boxes[column6][counter+1].setBackground(Color.green);
                    boxes[column6][counter+2].setBackground(Color.green);
                    boxes[column6][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;

            if(column6<7&&column6>1&&boxes[column6][5].getText().equals("red wins")&&boxes[column6+1][4].getText().equals("red wins")&& boxes[column6-1][6].getText().equals("red wins")&& boxes[column6-2][7].getText().equals("red wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6-1][6].setBackground(Color.green);
                boxes[column6-2][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column6<7&&column6>1&&boxes[column6][5].getText().equals("blue wins")&&boxes[column6+1][4].getText().equals("blue wins")&& boxes[column6-1][6].getText().equals("blue wins")&& boxes[column6-2][7].getText().equals("blue wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6-1][6].setBackground(Color.green);
                boxes[column6-2][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column6<6&&column6>0&&boxes[column6][5].getText().equals("red wins")&&boxes[column6+1][4].getText().equals("red wins")&& boxes[column6+2][3].getText().equals("red wins")&& boxes[column6-1][6].getText().equals("red wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6+2][3].setBackground(Color.green);
                boxes[column6-1][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column6<6&&column6>0&&boxes[column6][5].getText().equals("blue wins")&&boxes[column6+1][4].getText().equals("blue wins")&& boxes[column6+2][3].getText().equals("blue wins")&& boxes[column6-1][6].getText().equals("blue wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6+2][3].setBackground(Color.green);
                boxes[column6-1][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column6<5&&boxes[column6][5].getText().equals("red wins")&&boxes[column6+1][4].getText().equals("red wins")&& boxes[column6+2][3].getText().equals("red wins")&& boxes[column6+3][2].getText().equals("red wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6+2][3].setBackground(Color.green);
                boxes[column6+3][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column6<5&&boxes[column6][5].getText().equals("blue wins")&&boxes[column6+1][4].getText().equals("blue wins")&& boxes[column6+2][3].getText().equals("blue wins")&& boxes[column6+3][2].getText().equals("blue wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][4].setBackground(Color.green);
                boxes[column6+2][3].setBackground(Color.green);
                boxes[column6+3][2].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column6<7&&column6>1&&boxes[column6][5].getText().equals("red wins")&&boxes[column6+1][6].getText().equals("red wins")&& boxes[column6-1][4].getText().equals("red wins")&& boxes[column6-2][3].getText().equals("red wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][6].setBackground(Color.green);
                boxes[column6-1][4].setBackground(Color.green);
                boxes[column6-2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column6<7&&column6>1&&boxes[column6][5].getText().equals("blue wins")&&boxes[column6+1][6].getText().equals("blue wins")&& boxes[column6-1][4].getText().equals("blue wins")&& boxes[column6-2][3].getText().equals("blue wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][6].setBackground(Color.green);
                boxes[column6-1][4].setBackground(Color.green);
                boxes[column6-2][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column6<6&&column6>0&&boxes[column6][5].getText().equals("red wins")&&boxes[column6+1][6].getText().equals("red wins")&& boxes[column6+2][7].getText().equals("red wins")&& boxes[column6-1][4].getText().equals("red wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][6].setBackground(Color.green);
                boxes[column6+2][7].setBackground(Color.green);
                boxes[column6-1][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column6<6&&column6>0&&boxes[column6][5].getText().equals("blue wins")&&boxes[column6+1][6].getText().equals("blue wins")&& boxes[column6+2][7].getText().equals("blue wins")&& boxes[column6-1][4].getText().equals("blue wins")){
                boxes[column6][5].setBackground(Color.green);
                boxes[column6+1][6].setBackground(Color.green);
                boxes[column6+2][7].setBackground(Color.green);
                boxes[column6-1][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column6-=1;
            if(column6<0){
                box6.setVisible(false);
            }
        }
        if(eventName.equals("place7")){
            if(turn.equals("red wins")){
                boxes[column7][6].setBackground(Color.red);
                boxes[column7][6].setText("red wins");
                boxes[column7][6].setForeground(Color.red);
            }else{
                boxes[column7][6].setBackground(Color.blue);
                boxes[column7][6].setText("blue wins");
                boxes[column7][6].setForeground(Color.blue);
            }

            if(boxes[column7][6].getText().equals("red wins")){
                hc71++;
                hc72=0;
            }else if(boxes[column7][6].getText().equals("blue wins")){
                hc71=0;
                hc72++;
            }

            if(hc71>3){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][6].setBackground(Color.green);
                boxes[column7+2][6].setBackground(Color.green);
                boxes[column7+3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc72>3){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][6].setBackground(Color.green);
                boxes[column7+2][6].setBackground(Color.green);
                boxes[column7+3][6].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            while(counter<5){
                if(boxes[column7][counter].getText().equals("red wins")&& boxes[column7][counter+1].getText().equals("red wins")&& boxes[column7][counter+2].getText().equals("red wins")&& boxes[column7][counter+3].getText().equals("red wins")){
                    boxes[column7][counter].setBackground(Color.green);
                    boxes[column7][counter+1].setBackground(Color.green);
                    boxes[column7][counter+2].setBackground(Color.green);
                    boxes[column7][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    redWins++;
                    red.setText(("red: "+redWins));
                }else if(boxes[column7][counter].getText().equals("blue wins")&& boxes[column7][counter+1].getText().equals("blue wins")&& boxes[column7][counter+2].getText().equals("blue wins")&& boxes[column7][counter+3].getText().equals("blue wins")){
                    boxes[column7][counter].setBackground(Color.green);
                    boxes[column7][counter+1].setBackground(Color.green);
                    boxes[column7][counter+2].setBackground(Color.green);
                    boxes[column7][counter+3].setBackground(Color.green);
                    box1.setVisible(false);
                    box2.setVisible(false);
                    box3.setVisible(false);
                    box4.setVisible(false);
                    box5.setVisible(false);
                    box6.setVisible(false);
                    box7.setVisible(false);
                    box8.setVisible(false);
                    counter=10;
                    blueWins++;
                    blue.setText(("blue: "+blueWins));
                }
                counter++;
            }
            counter=0;

            if(column7<6&&column7>0&&boxes[column7][6].getText().equals("red wins")&&boxes[column7+1][5].getText().equals("red wins")&& boxes[column7+2][4].getText().equals("red wins")&& boxes[column7-1][7].getText().equals("red wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][5].setBackground(Color.green);
                boxes[column7+2][4].setBackground(Color.green);
                boxes[column7-1][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column7<6&&column7>0&&boxes[column7][6].getText().equals("blue wins")&&boxes[column7+1][5].getText().equals("blue wins")&& boxes[column7+2][4].getText().equals("blue wins")&& boxes[column7-1][7].getText().equals("blue wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][5].setBackground(Color.green);
                boxes[column7+2][4].setBackground(Color.green);
                boxes[column7-1][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column7<5&&boxes[column7][6].getText().equals("red wins")&&boxes[column7+1][5].getText().equals("red wins")&& boxes[column7+2][4].getText().equals("red wins")&& boxes[column7+3][3].getText().equals("red wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][5].setBackground(Color.green);
                boxes[column7+2][4].setBackground(Color.green);
                boxes[column7+3][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column7<5&&boxes[column7][6].getText().equals("blue wins")&&boxes[column7+1][5].getText().equals("blue wins")&& boxes[column7+2][4].getText().equals("blue wins")&& boxes[column7+3][3].getText().equals("blue wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][5].setBackground(Color.green);
                boxes[column7+2][4].setBackground(Color.green);
                boxes[column7+3][3].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            if(column7<7&&column7>1&&boxes[column7][6].getText().equals("red wins")&&boxes[column7+1][7].getText().equals("red wins")&& boxes[column7-1][5].getText().equals("red wins")&& boxes[column7-2][4].getText().equals("red wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][7].setBackground(Color.green);
                boxes[column7-1][5].setBackground(Color.green);
                boxes[column7-2][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }
            if(column7<7&&column7>1&&boxes[column7][6].getText().equals("blue wins")&&boxes[column7+1][7].getText().equals("blue wins")&& boxes[column7-1][5].getText().equals("blue wins")&& boxes[column7-2][4].getText().equals("blue wins")){
                boxes[column7][6].setBackground(Color.green);
                boxes[column7+1][7].setBackground(Color.green);
                boxes[column7-1][5].setBackground(Color.green);
                boxes[column7-2][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            column7-=1;
            if(column7<0){
                box7.setVisible(false);
            }
        }
        if(eventName.equals("place8")){
            if(turn.equals("red wins")){
                boxes[column8][7].setBackground(Color.red);
                boxes[column8][7].setText("red wins");
                boxes[column8][7].setForeground(Color.red);
            }else{
                boxes[column8][7].setBackground(Color.blue);
                boxes[column8][7].setText("blue wins");
                boxes[column8][7].setForeground(Color.blue);
            }

            if(boxes[column8][7].getText().equals("red wins")){
                hc81++;
                hc82=0;
            }else if(boxes[column8][7].getText().equals("blue wins")){
                hc81=0;
                hc82++;
            }

            if(hc81>3){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8+1][7].setBackground(Color.green);
                boxes[column8+2][7].setBackground(Color.green);
                boxes[column8+3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(hc82>3){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8+1][7].setBackground(Color.green);
                boxes[column8+2][7].setBackground(Color.green);
                boxes[column8+3][7].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }

            for(int r=7;r>03;r--){
                if(boxes[column8][r].getText().equals("red wins")){
                    counter++;
                }else if(boxes[column8][r].getText().equals("blue wins")){
                    counter2++;
                }
            }

            if(counter>3){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8][6].setBackground(Color.green);
                boxes[column8][5].setBackground(Color.green);
                boxes[column8][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }else if(counter2>3){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8][6].setBackground(Color.green);
                boxes[column8][5].setBackground(Color.green);
                boxes[column8][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }
            counter=0;
            counter2=0;

            if(column8<5&&boxes[column8][7].getText().equals("red wins")&&boxes[column8+1][6].getText().equals("red wins")&& boxes[column8+2][5].getText().equals("red wins")&& boxes[column8+3][4].getText().equals("red wins")){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8+1][6].setBackground(Color.green);
                boxes[column8+2][5].setBackground(Color.green);
                boxes[column8+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                redWins++;
                red.setText(("red: "+redWins));
            }

            if(column8<5&&boxes[column8][7].getText().equals("blue wins")&&boxes[column8+1][6].getText().equals("blue wins")&& boxes[column8+2][5].getText().equals("blue wins")&& boxes[column8+3][4].getText().equals("blue wins")){
                boxes[column8][7].setBackground(Color.green);
                boxes[column8+1][6].setBackground(Color.green);
                boxes[column8+2][5].setBackground(Color.green);
                boxes[column8+3][4].setBackground(Color.green);
                box1.setVisible(false);
                box2.setVisible(false);
                box3.setVisible(false);
                box4.setVisible(false);
                box5.setVisible(false);
                box6.setVisible(false);
                box7.setVisible(false);
                box8.setVisible(false);
                blueWins++;
                blue.setText(("blue: "+blueWins));
            }
            column8-=1;
            if(column8<0){
                box8.setVisible(false);
            }
        }
        if(eventName.equals("new")){
            for(int g=0;g<8;g++){
                for(int i=0; i<8;i++){
                    boxes[g][i].setText(" ");
                    boxes[g][i].setBackground(Color.white);
                }
            }
            redWins=0;
            red.setText(("red: "+redWins));
            blueWins=0;
            blue.setText(("blue: "+blueWins));
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(true);
            box4.setVisible(true);
            box5.setVisible(true);
            box6.setVisible(true);
            box7.setVisible(true);
            box8.setVisible(true);
            counter=0;
            counter2=0;
            column1=7;
            column2=7;
            column3=7;
            column4=7;
            column5=7;
            column6=7;
            column7=7;
            column8=7;
            count=1;
            hc11=0;
            hc12=0;
            hc21=0;
            hc22=0;
            hc31=0;
            hc32=0;
            hc41=0;
            hc42=0;
            hc51=0;
            hc52=0;
            hc61=0;
            hc62=0;
            hc71=0;
            hc72=0;
            hc81=0;
            hc82=0;
        }

        if(eventName.equals("next")){
            for(int g=0;g<8;g++){
                for(int i=0; i<8;i++){
                    boxes[g][i].setText(" ");
                    boxes[g][i].setBackground(Color.white);
                }
            }
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(true);
            box4.setVisible(true);
            box5.setVisible(true);
            box6.setVisible(true);
            box7.setVisible(true);
            box8.setVisible(true);
            counter=0;
            counter2=0;
            column1=7;
            column2=7;
            column3=7;
            column4=7;
            column5=7;
            column6=7;
            column7=7;
            column8=7;
            count=1;
            hc11=0;
            hc12=0;
            hc21=0;
            hc22=0;
            hc31=0;
            hc32=0;
            hc41=0;
            hc42=0;
            hc51=0;
            hc52=0;
            hc61=0;
            hc62=0;
            hc71=0;
            hc72=0;
            hc81=0;
            hc82=0;
        }

        if(eventName.equals("load")){
            try{
                in = new FileReader(textFileReader);
                readFile = new BufferedReader(in);
                reader = readFile.readLine();
                int score = Integer.valueOf(reader);
                redWins=score;
                red.setText(("red: "+redWins));
                reader = readFile.readLine();
                score = Integer.valueOf(reader);
                blueWins=score;
                blue.setText(("blue: "+blueWins));
                readFile.close();
                in.close();
            }catch (FileNotFoundException e){
                System.out.println("file does not exist or could not be found");
                System.err.println("FileNotFoundException: "+e.getMessage());
            }catch(IOException e){
                System.out.println("problem reading file");
                System.err.println("IOException: "+e.getMessage());
            }
            for(int g=0;g<8;g++){
                for(int i=0; i<8;i++){
                    boxes[g][i].setText(" ");
                    boxes[g][i].setBackground(Color.white);
                }
            }
            box1.setVisible(true);
            box2.setVisible(true);
            box3.setVisible(true);
            box4.setVisible(true);
            box5.setVisible(true);
            box6.setVisible(true);
            box7.setVisible(true);
            box8.setVisible(true);
            counter=0;
            counter2=0;
            column1=7;
            column2=7;
            column3=7;
            column4=7;
            column5=7;
            column6=7;
            column7=7;
            column8=7;
            count=1;
            hc11=0;
            hc12=0;
            hc21=0;
            hc22=0;
            hc31=0;
            hc32=0;
            hc41=0;
            hc42=0;
            hc51=0;
            hc52=0;
            hc61=0;
            hc62=0;
            hc71=0;
            hc72=0;
            hc81=0;
            hc82=0;
        }

        if(eventName.equals("save")){
            String rw=" ",bw=" ";
            rw=String.valueOf(redWins);
            bw=String.valueOf(blueWins);
            try {
                out = new FileWriter(textFileWriter);
                writeFile = new BufferedWriter(out);
                writeFile.write(rw);
                writeFile.newLine();
                writeFile.write(bw);
                writeFile.newLine();
                writeFile.close();
                out.close();
            }catch (IOException e) {
                System.out.println("Problem writing to file.");
                System.err.println("IOException: " + e.getMessage());
            }
        }
    }
    //runs the program
    private static void runGUI(){
        JFrame.setDefaultLookAndFeelDecorated(true);
        Main play= new Main();
    }

    public static void main(String [] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                runGUI();
            }
        });
    }
}

