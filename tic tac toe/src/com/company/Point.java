package com.company;

public class Point {

    private char[][] point = new char[3][3];

    Point(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.point[i][j] = '*';
            }
        }
    }

    public void set(boolean a, int y){//true - 0 0, false - 0

        for(int i = 0; i < 3; i++){

            for(int j = 0; j < 3; j++){
                if(i == y){
                    if(!a){
                        if(j%2 != 0){
                            point[i][j] = '0';
                        }else{
                            point[i][j] = ' ';
                        }
                    }else{
                        if(j%2 == 0){
                            point[i][j] = '0';
                        }else{
                            point[i][j] = ' ';
                        }
                    }
                }
            }

        }
    }

    public void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++) {
                System.out.print(this.point[i][j]);
            }
            
            System.out.print(" ");
        }
    }
}
