package com.company;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Game {

    boolean gameover = false;
    Div div;
    Player pl1 = new Player();
    Player pl2 = new Player();


    Game(Div div){
        this.div = div;
    }

    private Boolean gameOver(){

        int[][] area;
        Boolean over = false;

        area = div.getArea();

        for(int i=0;i<3;i++){
            if(area[i][0] == area[i][1] && area[i][1] == area[i][2] && area[i][0] != 0 ){
                over = true;
            }
            if(area[0][i] == area[1][i] && area[1][i] == area[2][i] && area[0][i] != 0 ){
                over = true;
            }
        }

        if(area[0][0] == area[1][1] && area[1][1] == area[2][2] && area[0][0] != 0){
            over = true;
        }else if(area[0][2] == area[1][1] && area[1][1] == area[2][0] && area[0][2] != 0){
            over = true;
        }
        
        return over;
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);

        int num = 1;

        System.out.println("Игрок 1 введите имя:");
        pl1.name = scanner.nextLine();

        System.out.println("Игрок 2 введите имя:");
        pl2.name = scanner.nextLine();

        System.out.println("Игрок 1 выберите крестик(введите 1) или нолик(введите 2):");
        int type = scanner.nextInt();
        if(type==1){pl1.type = false; pl2.type = true;}else{pl1.type = true; pl2.type = false;}

        Player pl = null;

        int count = 0;

        while(!gameover && count < 9){
            
            if(num%2!=0){
                System.out.print(pl1.name + " введите ход: ");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                div.setArea(x, y, pl1.type, num);
                num++;
                pl = pl1;
            }else{
                System.out.print(pl2.name + " введите ход: ");

                int x = scanner.nextInt();
                int y = scanner.nextInt();

                div.setArea(x, y, pl2.type, num);
                num--;
                pl = pl2;
            }

            gameover = gameOver();
            count++;
        }

        if(count == 9 && !gameover){
            System.out.println("Ничья. Отлично сыграно!");
        }else{
            System.out.println(pl.name + " победил!");
        }
    }
}
