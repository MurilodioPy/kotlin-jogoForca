package br.com.ads.jogoforca.sampledata

import br.com.ads.jogoforca.R
import br.com.ads.jogoforca.model.Tema

object DataProvider {
    val tema1 = Tema(1,"Esportes",arrayListOf("futebol", "basquete", "tênis", "natação", "ciclismo", "handebol", "vôlei", "rugby", "beisebol", "hóquei no gelo", "atletismo", "ginástica", "boxe", "luta livre", "golfe", "surfe", "mergulho", "vela", "remo", "canoagem", "esqui", "snowboard", "patinação no gelo", "curling", "bobsleigh", "caratê", "judô", "taekwondo", "aikido", "kung fu", "escalada", "montanhismo", "rapel", "paraquedismo", "balonismo", "League of Legends", "Counter-Strike: Global Offensive", "Dota 2", "Fortnite", "FIFA", "atletismo paralímpico", "natação paralímpica", "basquete em cadeira de rodas", "tênis em cadeira de rodas", "bocha"), R.drawable.esporte)
    val tema2 = Tema(2,"Cidades",arrayListOf("Nova York", "Paris", "Tóquio", "Londres", "Rio de Janeiro", "Washington D.C.", "Berlim", "Roma", "Madrid", "Moscou", "Atenas", "Jerusalém", "Cairo", "Machu Picchu", "Barcelona", "Veneza", "Amsterdã", "Istambul", "Cidade do México", "Queenstown", "Kyoto", "Vancouver", "Reykjavik", "Ushuaia", "Cusco", "Chichén Itzá", "Tikal", "Angkor Wat", "Lyon", "São Paulo", "Tóquio", "Nova Orleans", "Taipé", "Berlim", "Barcelona", "Londres"), R.drawable.cidades)
    val tema3 = Tema(3,"Países",arrayListOf("Brasil", "Estados Unidos", "China", "Índia", "Rússia", "Argentina", "México", "Chile", "Colômbia", "Peru", "Alemanha", "França", "Reino Unido", "Itália", "Espanha", "Nigéria", "Egito", "África do Sul", "Argélia", "Marrocos", "Japão", "Coréia do Sul", "Indonésia", "Turquia", "Paquistão", "Austrália", "Nova Zelândia", "Papua Nova Guiné", "Fiji", "Israel", "Vaticano", "Japão", "Arábia Saudita", "China"), R.drawable.paises)
    val tema4 = Tema(4,"Animais",arrayListOf("leão", "elefante", "girafa", "panda", "tigre", "gorila", "chimpanzé", "rinoceronte", "hipopótamo", "lobo", "águia", "falcão", "papagaio", "tucano", "beija-flor", "cobra", "lagartixa", "tartaruga", "jacaré", "crocodilo", "sapo", "rã", "salamandra", "tubarão", "baleia", "golfinho", "salmão", "atum", "panda gigante", "tigre siberiano", "orangotango", "gorila das montanhas", "rinoceronte branco", "canguru", "camelo", "panda vermelho", "elefante africano", "pinguim imperador", "coruja", "morcego", "gambá", "raposa"), R.drawable.animais)
    val tema5 = Tema(5,"Frutas",arrayListOf("maçã", "banana", "uva", "morango", "abacaxi", "laranja", "limão", "tangerina", "abacaxi", "kiwi", "morango", "framboesa", "cereja", "amora", "goiaba", "manga", "abacaxi", "maracujá", "coco", "cupuaçu", "graviola", "jabuticaba", "cajá", "caju", "uva-passa", "ameixa", "damasco", "figo", "tâmara"), R.drawable.frutas)
    val tema6 = Tema(6,"Objetos",arrayListOf("computador", "livro", "chave", "copo", "cadeira", "cama", "mesa", "sofá", "fogão", "impressora", "caneta", "papel", "telefone", "prato", "copo", "talheres", "panela", "frigideira", "escova de dentes", "pasta de dente", "sabonete", "shampoo", "condicionador", "calça", "camisa", "sapato", "meia", "chapéu", "relógio", "óculos", "chave", "carteira", "celular", "televisão", "smartphone", "tablet", "videogame", "drone", "pintura", "escultura", "música", "dança", "teatro", "bola", "chuteira", "raquete", "bicicleta", "skate", "martelo", "prego", "furadeira", "serra", "chave de fenda"), R.drawable.objetos)

    val temas = arrayListOf(
        tema1,
        tema2,
        tema3,
        tema4,
        tema5,
        tema6
    )
}