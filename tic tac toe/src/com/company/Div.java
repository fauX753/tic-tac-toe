package com.company;

public class Div {
    private Point[][] div = new Point[3][3];
    private int[][] area = new int[3][3];

    public void print(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.div[i][j].print();
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("-----------");
    }

    public void setArea(int i, int j, Boolean a, int num) {
        setPoint(a, i, j);
        print();
        this.area[i][j] = num;
    }

    public int[][] getArea() {
        return area;
    }

    public void setPoint(boolean a, int x, int y){//true - 0, false - x

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(i==x){
                    if(j%2==0){
                        div[i][j].set(!a,y);
                    }else{
                        div[i][j].set(a,y);
                    }
                }
            }
        }

    }

    Div(){

        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                this.div[i][j] = new Point();
                this.area[i][j] = 0;
            }
        }

        print();
    }
}
