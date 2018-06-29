import javax.swing.*;
import java.awt.*;
import java.util.*;

class MasterMind{

   public static void main(String[] args){
      String reply = "go";
        DrawingPanel panel = new DrawingPanel (540,700);
        Graphics g = panel.getGraphics();
        panel.setBackground(new Color(255, 248, 203));
        g.setColor(new Color(160, 82, 45));
        g.fillRect(5,5,530,45);
        g.setColor(Color.BLACK);
        Font f = new Font("Stencil", Font.BOLD, 40);
        g.setFont(f);
        g.drawString("MASTERMIND", 150, 43);
        g.setColor(Color.WHITE);
        g.fillRect(5,55,240,65);
        g.fillRect(250,55,285,65);
        g.setColor(Color.BLACK);
        Font x = new Font("Text", Font.PLAIN, 12);
        g.setFont(x);
        g.drawString("Key", 15, 70);
        g.drawString("Green - Right", 15, 85);
        g.drawString("Yellow - Wrong Slot", 15, 100);
        g.drawString("Red - Wrong", 15, 115);
        g.drawString("Blue - 1", 140, 70);
        g.drawString("Purple - 2", 140, 85);
        g.drawString("Pink - 3", 140, 100);
        g.drawString("Orange - 4", 140, 115);
        int levelNum = 1; 
        ArrayList<Integer> guess = new ArrayList<Integer>();
        int totalGuess = 0;
      while(reply.equals("tryagain") || reply.equals("nextlevel") || reply.equals("go") || reply.equals("yes")){   
        boolean win = false;
        //create answer
        ArrayList<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < (levelNum+3); i++){
           int next = (int)( Math.random()*4)+1;
           ans.add(next);
        }
        //printing answer
        //for(int str:ans){
        //System.out.print(str+"");
        //}
        Scanner sc = new Scanner(System.in);
        int numGuess = 0;
        int num = 11111;
        String nextNum = "";
        while (win == false && numGuess<5){
          Font w = new Font("Text", Font.PLAIN,20);
          g.setFont(w);
          g.setColor(Color.WHITE);
          g.fillRect(250,60,285,60);
          g.setColor(Color.BLACK);
          g.drawString("Number of Guesses Left: " + (5-numGuess), 260, 75);
          g.drawString("Level: " + levelNum, 260, 105);
          //your guess
          guess.clear();
          System.out.println("Enter your guess(" + (levelNum+3) + " digits 1-4)");
          nextNum = sc.next();
          try{
            num = Integer.parseInt(nextNum);
            if(num/Math.pow(10,(levelNum+2)) <10 && num/Math.pow(10,(levelNum+2)) > 0){
              for(int j = 0; j<(levelNum+3); j++){            
                 int next = num%10;
                 num = num/10;
                 if(next>4 || next <1){
                     throw new NumberFormatException();
                 }
                 guess.add(0, next);
              }
              //print your guess
              for(int str:guess){
                 System.out.print(str+"");
              }
              System.out.println(" ");
              int numCorrect = 0;
              //Compare
              for(int i = 0; i<(levelNum+3); i++){
                 if(ans.get(i).equals(guess.get(i))){
                    System.out.println(guess.get(i) + ":Correct");
                    //outline
                    g.setColor(Color.BLACK);
                    g.fillOval(60*i + 2, numGuess*60+2+125, 56, 56);
                    //Status
                    g.setColor(Color.GREEN);
                    g.fillOval(60*i+5, numGuess*60+5+125, 50, 50);
                    //Guess
                    if (guess.get(i) == 1){               
                       g.setColor(Color.BLUE);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 2){               
                       g.setColor(new Color(128,0,128));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 3){               
                       g.setColor(Color.PINK);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 4){               
                       g.setColor(new Color(255,140,0));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    numCorrect++;
                 }
                 else if(ans.contains(guess.get(i))){
                    System.out.println(guess.get(i) + ":There, but not there");
                    //outline
                    g.setColor(Color.BLACK);
                    g.fillOval(60*i + 2, numGuess*60+2+125, 56, 56);
                    //Status
                    g.setColor(Color.YELLOW);
                    g.fillOval(60*i+5, numGuess*60+5+125, 50, 50);
                    //Guess
                    if (guess.get(i) == 1){               
                       g.setColor(Color.BLUE);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 2){               
                       g.setColor(new Color(128,0,128));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 3){               
                       g.setColor(Color.PINK);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 4){               
                       g.setColor(new Color(255,140,0));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                 }
                 else{
                    System.out.println(guess.get(i) + ":Wrong");
                    //outline
                    g.setColor(Color.BLACK);
                    g.fillOval(60*i + 2, numGuess*60+2+125, 56, 56);
                    //Status
                    g.setColor(Color.RED);
                    g.fillOval(60*i+5, numGuess*60+5+125, 50, 50);
                    //Guess
                    if (guess.get(i) == 1){               
                       g.setColor(Color.BLUE);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 2){               
                       g.setColor(new Color(128,0,128));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 3){               
                       g.setColor(Color.PINK);
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                    if (guess.get(i) == 4){               
                       g.setColor(new Color(255,140,0));
                       g.fillOval(60*i+10, 60*numGuess+10+125, 40, 40);
                    }
                 }
                 if (numCorrect == (levelNum+3)){
                    win = true;
                 }
              }
              numGuess++;
              totalGuess++;
           }
            else System.out.println("Try again with " + (levelNum+3) + " digits");
          }
           catch(NumberFormatException e){
          		System.out.println("Try again with "  + (levelNum+3) + " digits (1-4)");
          }
        }  
        if (win) {
          System.out.println("YOU WON!!");
          g.setColor(new Color(255, 248, 203));
          g.fillRect(0,120,750,750);
          g.setColor(Color.RED);
          g.fillOval(90, 200, 1000, 1000);
          g.setColor(new Color (255,140,0));
          g.fillOval(140, 250, 900, 900);
          g.setColor(Color.YELLOW);
          g.fillOval(190, 300, 800, 800);
          g.setColor(Color.GREEN);
          g.fillOval(240, 350, 700, 700);
          g.setColor(Color.BLUE);
          g.fillOval(290, 400, 600, 600);
          g.setColor(new Color (75,0,130));
          g.fillOval(340, 450, 500, 500);
          g.setColor(new Color (143,0,255));
          g.fillOval(390, 500, 400, 400);
          g.setColor(new Color(255, 248, 203));
          g.fillOval(440, 550, 300, 300);
          Font y = new Font("Text", Font.PLAIN, 80);
          g.setFont(y);
          g.setColor(Color.BLACK);
          g.drawString("YOU", 190, 250);
          g.drawString("WON!", 170, 350);
          Font z = new Font ("Text", Font.PLAIN, 40);
          g.setFont(z);
          g.drawString("Code:", 10, 400);
          g.drawString("Total Guesses: " + totalGuess, 10,520);
          for(int i = 0; i<(levelNum+3); i++){
            g.setColor(Color.BLACK);
            g.fillOval(60*i + 2, 422, 56, 56);
            g.setColor(Color.GREEN);
            g.fillOval(60*i+5, 425, 50, 50);
            if (guess.get(i) == 1){               
               g.setColor(Color.BLUE);
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (guess.get(i) == 2){               
               g.setColor(new Color(128,0,128));
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (guess.get(i) == 3){               
               g.setColor(Color.PINK);
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (guess.get(i) == 4){               
               g.setColor(new Color(255,140,0));
               g.fillOval(60*i+10, 430, 40, 40);
            }          
          }
          
        }  
        else {

          System.out.println("YOU LOSE");
          Font y = new Font("Text", Font.PLAIN, 80);
          g.setFont(y);
          g.setColor(new Color(255, 248, 203));
          g.fillRect(0,120,700,700);
          g.setColor(Color.BLACK);
          g.drawString("YOU", 190, 250);
          g.drawString("LOSE", 170, 350);
          g.setColor(Color.YELLOW);
          g.fillOval(150, 400, 300, 300);
          g.setColor(Color.BLACK);
          g.fillOval(200, 500, 50, 50);
          g.fillOval(350, 500, 50, 50);
          g.fillOval(225, 550, 150, 100);
          g.setColor(Color.YELLOW);
          g.fillOval(225, 560, 150, 150);
          g.setColor(Color.BLACK);
          Font z = new Font ("Text", Font.PLAIN, 40);
          g.setFont(z);
          g.drawString("Code:", 10, 400);
          
          for(int i = 0; i<(levelNum+3); i++){
            g.setColor(Color.BLACK);
            g.fillOval(60*i + 2, 422, 56, 56);
            g.setColor(Color.GREEN);
            g.fillOval(60*i+5, 425, 50, 50);
            if (ans.get(i) == 1){               
               g.setColor(Color.BLUE);
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (ans.get(i) == 2){               
               g.setColor(new Color(128,0,128));
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (ans.get(i) == 3){               
               g.setColor(Color.PINK);
               g.fillOval(60*i+10, 430, 40, 40);
            }
            if (ans.get(i) == 4){               
               g.setColor(new Color(255,140,0));
               g.fillOval(60*i+10, 430, 40, 40);
            }          
          }
         System.out.println("Do you want to restart? ('yes' or 'no')");
         reply = sc.next().toLowerCase();
         if (reply.equals("yes")){
            g.setColor(new Color(255, 248, 203));
            g.fillRect(0,120,700,700);
            System.out.println("NEW GAME");
            System.out.println("Level 1");
            levelNum = 1;
            totalGuess = 0;
         }  
         else{
            System.out.println("Thanks for playing!");
            System.exit(0);
         }
       }
        if(levelNum == 6 && win == true){
         System.out.println("You win Marathon Mode!");
         System.out.println("Do you want to play again? ('yes' or 'no')");
         reply = sc.next().toLowerCase();
         if (reply.equals("yes")){
            g.setColor(new Color(255, 248, 203));
            g.fillRect(0,120,700,700);
            totalGuess = 0;
            levelNum++;
         }       
         if (reply.equals("no")){
            System.out.println("Thanks for playing! Great job!");
            System.exit(0);
         }                 
        }
        if(levelNum<6 && win == true){
           System.out.println("Try Again, Next Level, or Exit? ('tryagain'/'nextlevel'/'exit')");
           reply = sc.next();
           if(!reply.equals("tryagain") && !reply.equals("nextlevel") && !reply.equals("exit")){
             System.out.println("Please enter 'tryagain', 'nextlevel', or 'exit'");
             reply = sc.next();
           }
           if(reply.equals("tryagain")){
             System.out.println("Restarting...");
             g.setColor(new Color(255, 248, 203));
             g.fillRect(0,120,700,700);
           }
           if(reply.equals("nextlevel")){
             levelNum++;
             g.setColor(new Color(255, 248, 203));
             g.fillRect(0,120,700,700);
             System.out.println("Level " + levelNum);
           }
           if(reply.equals("exit")){
             System.out.println("Thanks for playing!");
             System.exit(0);
           }

        }
        if(levelNum == 7){
         levelNum = 1;
         System.out.println("NEW GAME");
         System.out.println("Level 1");
        }
      } 
   }
}

