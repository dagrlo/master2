var context;
var estrellas = [];
var MAXESTRELLAS = 300;
var player1 = {x: 30, y: 240};
var enemy = {x: 0, y: 0, vivo: false};
var bala = {x: 0, y: 0};
var disparo = false;
var vidas;
var puntos;
var loop, loop2;
var p1Anim = [];
var shoot;
var malo;
var p1Frame;
var p1Dir = 0;
var p1Move = false;


function init(objeto) {
    context = objeto.getContext('2d');
    creaEstrellas();
    cargaP1();
    objeto.addEventListener("keydown", pulsaTecla, true);
    objeto.addEventListener("keyup", sueltaTecla, true);
    vidas = 3;
    p1Frame = 0;
    puntos = 0;
    loop = 0;
    creaMalo();
}



function sueltaTecla(e) {
    if ((e.keyCode == 38) || (e.keyCode == 40) || (e.keyCode == 32) || (e.keyCode == 37) || (e.keyCode == 39)) {
        p1Move = false;
        p1Frame = 0;
    }
}

function pulsaTecla(e) {
    //38 arriba =1
    //40 abajo =2
    //37 izquierda =3
    //39 derecha =4
    //32 espacio
    if (e.keyCode == 38) {
        p1Dir = 1;
        p1Move = true;
        p1Frame = 1;
    }
    if (e.keyCode == 40) {
        p1Dir = 2;
        p1Move = true;
        p1Frame = 2;
    }
    if (e.keyCode == 37) {
        p1Dir = 3;
        p1Move = true;
        p1Frame = 0;
    }
    if (e.keyCode == 39) {
        p1Dir = 4;
        p1Move = true;
        p1frame = 0;
    }
    if (e.keyCode == 32) {
        bala.x = player1.x + 15;
        bala.y = player1.y + 24;
        disparo = true;
    }

}

function cargaP1() {
    img = new Image();
    img2 = new Image();
    img3 = new Image();
    shoot = new Image();
    malo = new Image();
    img.src = "./gfx/player.png";
    p1Anim.push(img);

    img2.src = "./gfx/player_up.png";
    p1Anim.push(img2);

    img3.src = "./gfx/player_down.png";
    p1Anim.push(img3);

    shoot.src = "./gfx/tiro.png";
    malo.src = "./gfx/malor.png";
}


function pintaP1() {
    if (p1Move) {
        if (p1Dir == 1) {
            player1.y = player1.y - 10;
        }
        if (p1Dir == 2) {
            player1.y = player1.y + 10;
        }
        if (p1Dir == 3) {
            player1.x = player1.x - 10;
        }
        if (p1Dir == 4) {
            player1.x = player1.x + 10;
        }

    }

    context.drawImage(p1Anim[p1Frame], player1.x, player1.y);
}

function pintaBala() {
    if (disparo === true) {
        bala.x = bala.x + 20;
        context.drawImage(shoot, bala.x, bala.y);
        if (bala > 480) {
            disparo = false;
        }
        if (impactoMalo()) {
            enemy.vivo = false;
            disparo = false;
            calculaMalo();
        }
    }
}

function creaEstrellas() {

    for (var i = 0; i < MAXESTRELLAS; i++) {
        brillo = Math.floor((Math.random() * 0xff) + 1);
        color = "rgb(" + brillo + "," + brillo + "," + brillo + ")";
        posZ = brillo / 40;
        estrellas.push({x: Math.floor((Math.random() * 640) + 1), y: Math.floor((Math.random() * 480) + 1), z: posZ, color: color});
    }
}

function scrollEstrellas() {
    for (var i = 0; i < MAXESTRELLAS; i++) {
        estrellas[i].x = estrellas[i].x - estrellas[i].z;
        if (estrellas[i].x < 0) {
            estrellas[i].x = 640;
            estrellas[i].y = estrellas[i].y + Math.floor((Math.random() * 10) + 1) - Math.floor((Math.random() * 10) + 1);
        }
    }
}

function pintaEstrellas() {
    for (var i = 0; i < MAXESTRELLAS; i++) {
        context.fillStyle = estrellas[i].color;
        context.fillRect(estrellas[i].x, estrellas[i].y, 2, 2);
    }
}

function pintaFondo() {
    context.fillStyle = "black";
    context.fillRect(0, 0, 640, 480);
    pintaEstrellas();
    scrollEstrellas();
    pintaBala();
    pintaP1();
    if (chocar()===true){
        muere();
    }
    if (loop < 1000) {
        loop++;
    } else {
        loop = 0;
    }    
    pintaMalo();
}

function calculaMalo() {
    //if (loop % Math.floor((Math.random() * 1000) + 1) == 0) 
    {
        console.log("malo");
        creaMalo();
    }
}

function pintaMalo() {
    if (enemy.vivo === true) 
    {
        enemy.x--;
        enemy.y = enemy.y + 10 * Math.sin(loop / 5);
        context.drawImage(malo, enemy.x, enemy.y);
    }
}

function chocar(){
    result=false; //84*67    88*46
    if ((player1.x<enemy.x+84)&&(player1.x+88>enemy.x)&&(player1.y<enemy.y+67)&&(player1.y+46>enemy.y)){        
        result=true;
    }
    return result;
}

function muere(){
    
}

function impactoMalo() {
    result = false;
    context.beginPath();
    context.rect(enemy.x, enemy.y, 64, 67);
    if (context.isPointInPath(bala.x, bala.y)) {
        result = true;
    }
    return result;
}

function creaMalo() {
    if (enemy.vivo === false) {
        enemy.x = 600;
        enemy.y = Math.floor((Math.random() * 320) + 1) + 80;
        enemy.vivo = true;
    }

}
