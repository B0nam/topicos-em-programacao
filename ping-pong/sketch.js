let pos_x = 1;
let pos_y = 1;
let direcao_x = 1;
let direcao_y = 1;
const diametro = 20;
const velocidade = 2;
const larguraTela = 600;
const alturaTela = 400;

const larguraPlataforma = 10;
const alturaPlataforma = 100;
let pos_plataformaEsquerda_y = alturaTela / 2 - alturaPlataforma / 2;
let pos_plataformaDireita_y = alturaTela / 2 - alturaPlataforma / 2;

let pontosJogadorEsquerdo = 0;
let pontosJogadorDireito = 0;

function setup() {
    createCanvas(larguraTela, alturaTela);
}

function draw() {
    background(220);

    textSize(24);
    textAlign(CENTER, TOP);
    text(pontosJogadorEsquerdo + " | " + pontosJogadorDireito, larguraTela / 2, 10);

    circle(pos_x, pos_y, diametro);
    rect(0, pos_plataformaEsquerda_y, larguraPlataforma, alturaPlataforma); // Plataforma esquerda
    rect(larguraTela - larguraPlataforma, pos_plataformaDireita_y, larguraPlataforma, alturaPlataforma); // Plataforma direita

    movimentoHorizontal();
    movimentoVertical();

    movimentoPlataformaEsquerda();
    movimentoPlataformaDireita();

    verificarColisaoComPlataformas();

    verificarLimiteDaTela();
}

function movimentoHorizontal() {
    if (direcao_x == 1) {
        moverParaDireita();
    } else {
        moverParaEsquerda();
    }
}

function movimentoVertical() {
    if (direcao_y == 1) {
        moverParaBaixo();
    } else {
        moverParaCima();
    }
}

function moverParaDireita() {
    if (pos_x < larguraTela - diametro / 2) {
        moverHorizontal(velocidade, direcao_x);
    } else if (pos_x >= larguraTela - diametro / 2) {
        direcao_x = -1;
        moverHorizontal(velocidade, direcao_x);
    }
}

function moverParaEsquerda() {
    if (pos_x > 0 + diametro / 2) {
        moverHorizontal(velocidade, direcao_x);
    } else if (pos_x <= 0 + diametro / 2) {
        direcao_x = 1;
        moverHorizontal(velocidade, direcao_x);
    }
}

function moverParaBaixo() {
    if (pos_y < alturaTela - diametro / 2) {
        moverVertical(velocidade, direcao_y);
    } else if (pos_y >= alturaTela - diametro / 2) {
        direcao_y = -1;
        moverVertical(velocidade, direcao_y);
    }
}

function moverParaCima() {
    if (pos_y > 0 + diametro / 2) {
        moverVertical(velocidade, direcao_y);
    } else if (pos_y <= 0 + diametro / 2) {
        direcao_y = 1;
        moverVertical(velocidade, direcao_y);
    }
}

function moverHorizontal(velocidade, direcao_x) {
    pos_x += velocidade * direcao_x;
}

function moverVertical(velocidade, direcao_y) {
    pos_y += velocidade * direcao_y;
}

function movimentoPlataformaEsquerda() {
    if (keyIsDown(87)) {  // Tecla "W"
        pos_plataformaEsquerda_y = max(pos_plataformaEsquerda_y - 5, 0);  // Limita para não sair da tela
    }
    if (keyIsDown(83)) {  // Tecla "S"
        pos_plataformaEsquerda_y = min(pos_plataformaEsquerda_y + 5, alturaTela - alturaPlataforma);  // Limita para não sair da tela
    }
}

function movimentoPlataformaDireita() {
    if (keyIsDown(UP_ARROW)) {
        pos_plataformaDireita_y = max(pos_plataformaDireita_y - 5, 0);  // Limita para não sair da tela
    }
    if (keyIsDown(DOWN_ARROW)) {
        pos_plataformaDireita_y = min(pos_plataformaDireita_y + 5, alturaTela - alturaPlataforma);  // Limita para não sair da tela
    }
}

function verificarColisaoComPlataformas() {
    if (pos_x - diametro / 2 <= larguraPlataforma && 
        pos_y >= pos_plataformaEsquerda_y && 
        pos_y <= pos_plataformaEsquerda_y + alturaPlataforma) {
        direcao_x = 1;
    }

    if (pos_x + diametro / 2 >= larguraTela - larguraPlataforma && 
        pos_y >= pos_plataformaDireita_y && 
        pos_y <= pos_plataformaDireita_y + alturaPlataforma) {
        direcao_x = -1;
    }
}

function verificarLimiteDaTela() {
    if (pos_x - diametro / 2 <= 0) {
        pontosJogadorDireito++;
        respawnBola();
    }

    if (pos_x + diametro / 2 >= larguraTela) {
        pontosJogadorEsquerdo++;
        respawnBola();
    }
}

function respawnBola() {
    pos_x = larguraTela / 2;
    pos_y = alturaTela / 2;
    direcao_x = random() > 0.5 ? 1 : -1;
    direcao_y = random() > 0.5 ? 1 : -1;
}
