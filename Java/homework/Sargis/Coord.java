public class Coord {
    int x;
    int y;
    int level;
    public Coord(int x, int y, int level){
        this.x=x;
        this.y=y;
       this.level=level;
    }
    public Coord(int x, int y){
        this.x=x;
        this.y=y;
        this.level = 0;
    }
    public int getLevel(){
        return this.level;
   }
   public void setLevel(int a){
       level = a;
   }
   public int getX(){
       return this.x;
   }
   public int getY(){
       return this.y;
   }
}
