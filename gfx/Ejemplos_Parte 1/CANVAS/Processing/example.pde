//	Processing.js example sketch

int fontsize = 24;
var posX = 100;
var posY = 100;

void setup() {
  size(200, 200);
  stroke(0);
  fill(0);
  textFont(createFont("Arial",fontsize));
  tamano = 1;
  // noLoop();
};

void mouseMoved() {
  posX = mouseX;
  posY = mouseY;
};

void draw() {
  background(125, 0, 0);
  String textstring = "source example";
  float twidth = textWidth(textstring);
  text(textstring, (width-twidth)/2, height/2);
  stroke(128);
  rect(0, 0, tamano, tamano);
  tamano += 1;
  tamano = tamano % width;
  arc(posX, posY, 20, 20, 0, (2*Math.PI))
};




