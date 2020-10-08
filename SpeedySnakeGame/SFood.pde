class SFood {
  int x;
  int score;
  int y;
  SFood() {
    newPos();
  }
  
  void setup(){
    score = 0;
  }
  void draw() {
    fill(255, 0, 0);
    noStroke();
    ellipse(x+10, y+10, 30, 30);
    textAlign(LEFT);
    textSize(25);
    fill(255);
    text("Score: "+ score, 10,10, width -20,50);
    
  }
  boolean eaten(int p, int o) {
    if ( x == p && y == o ) {
      newPos();
      return true;
    }
    return false;
    
    
  }
  void newPos() {
    x = 20 * int(random(width/30));
    y = 20 * int(random(height/30));
  }
}
