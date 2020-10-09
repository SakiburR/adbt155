int[] c = {1, 0, -1, 0};
int[] e = {0, 1, 0, -1};
int[] r = {RIGHT, DOWN, LEFT, UP};
 
SFood F;

class SHead {
  int x;
  int y;
  int d;
  boolean growth = false;
  ArrayList<PVector> tail;
  int total = 0;

  SHead() {
    d= 0;
    tail = new ArrayList();
  }

  void draw() {
    fill(#09E507);
    noStroke();
    rect(x, y, 30, 30);
    for (int i =0; i<tail.size(); i = i+1)
    { 
      rect(tail.get(i).x, tail.get(i).y, 30, 30);
    }
  }
  void update() {
    tail.add( new PVector(x, y, d) );
    if ( growth ) {
      growth = false;
    } else {
      tail.remove(0);
    }
    x += 20*c[d];
    y += 20*e[d];
    x += width;
    y += height;
    x %= width;
    y %= height;
  }
  void grow() {
    growth = true;
  }
  
       
  void KeyPressed() {
    for ( int i = 0; i < r.length; i= i+1) {
      if ( key == CODED && keyCode == r[i] ) {
        d = i;
      }
    }
  
}
}
