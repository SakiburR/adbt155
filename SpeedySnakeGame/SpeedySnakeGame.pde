SHead Snake;

SFood Food;

SoundFile snakesong;

import processing.sound.*;

void setup() {
  size(1920, 1080);
  Snake = new SHead();
  Food = new SFood();
  
  snakesong = new SoundFile(this, "Snake III JAVA game theme song.mp3");
  snakesong.play();
}

void draw() {
  background(#818344);
    Snake.update();
    {
    if ( Food.eaten( Snake.x, Snake.y ) ) {
      Snake.grow();
      Food.score = Food.score+1;
    }
    
  }
  Food.draw();
  Snake.draw();
}

void keyPressed() {
  Snake.KeyPressed();
}
