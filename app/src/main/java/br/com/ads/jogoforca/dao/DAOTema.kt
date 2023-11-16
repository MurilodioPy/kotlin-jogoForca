package br.com.ads.jogoforca.dao

import android.content.Context
import android.util.Log
import br.com.ads.jogoforca.model.Tema
import com.google.firebase.Firebase
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import com.google.firebase.database.database
import com.google.gson.Gson

class DAOTema(contexto : Context) {

    val referencia : DatabaseReference
    val contexto : Context
    init{
        this.referencia = Firebase.database.reference
        this.contexto = contexto
    }
    fun inserirTemas() {

        val tema1 = Tema(1,"Esportes",arrayListOf("futebol", "basquete", "tênis", "natação", "ciclismo", "handebol", "vôlei", "rugby", "beisebol", "hóquei no gelo", "atletismo", "ginástica", "boxe", "luta livre", "golfe", "surfe", "mergulho", "vela", "remo", "canoagem", "esqui", "snowboard", "patinação no gelo", "curling", "bobsleigh", "caratê", "judô", "taekwondo", "aikido", "kung fu", "escalada", "montanhismo", "rapel", "paraquedismo", "balonismo", "League of Legends", "Counter-Strike: Global Offensive", "Dota 2", "Fortnite", "FIFA", "atletismo paralímpico", "natação paralímpica", "basquete em cadeira de rodas", "tênis em cadeira de rodas", "bocha"), 1)
        referencia.child(tema1.id.toString()).setValue(tema1)

        val tema2 = Tema(2,"Cidades",arrayListOf("Nova York", "Paris", "Tóquio", "Londres", "Rio de Janeiro", "Washington D.C.", "Berlim", "Roma", "Madrid", "Moscou", "Atenas", "Jerusalém", "Cairo", "Machu Picchu", "Barcelona", "Veneza", "Amsterdã", "Istambul", "Cidade do México", "Queenstown", "Kyoto", "Vancouver", "Reykjavik", "Ushuaia", "Cusco", "Chichén Itzá", "Tikal", "Angkor Wat", "Lyon", "São Paulo", "Tóquio", "Nova Orleans", "Taipé", "Berlim", "Barcelona", "Londres"), 2)
        referencia.child(tema2.id.toString()).setValue(tema2)

        val tema3 = Tema(3,"Países",arrayListOf("Brasil", "Estados Unidos", "China", "Índia", "Rússia", "Argentina", "México", "Chile", "Colômbia", "Peru", "Alemanha", "França", "Reino Unido", "Itália", "Espanha", "Nigéria", "Egito", "África do Sul", "Argélia", "Marrocos", "Japão", "Coréia do Sul", "Indonésia", "Turquia", "Paquistão", "Austrália", "Nova Zelândia", "Papua Nova Guiné", "Fiji", "Israel", "Vaticano", "Japão", "Arábia Saudita", "China"), 3)
        referencia.child(tema3.id.toString()).setValue(tema3)

        val tema4 = Tema(4,"Animais",arrayListOf("leão", "elefante", "girafa", "panda", "tigre", "gorila", "chimpanzé", "rinoceronte", "hipopótamo", "lobo", "águia", "falcão", "papagaio", "tucano", "beija-flor", "cobra", "lagartixa", "tartaruga", "jacaré", "crocodilo", "sapo", "rã", "salamandra", "tubarão", "baleia", "golfinho", "salmão", "atum", "panda gigante", "tigre siberiano", "orangotango", "gorila das montanhas", "rinoceronte branco", "canguru", "camelo", "panda vermelho", "elefante africano", "pinguim imperador", "coruja", "morcego", "gambá", "raposa"), 4)
        referencia.child(tema4.id.toString()).setValue(tema4)

        val tema5 = Tema(5,"Frutas",arrayListOf("maçã", "banana", "uva", "morango", "abacaxi", "laranja", "limão", "tangerina", "abacaxi", "kiwi", "morango", "framboesa", "cereja", "amora", "goiaba", "manga", "abacaxi", "maracujá", "coco", "cupuaçu", "graviola", "jabuticaba", "cajá", "caju", "uva-passa", "ameixa", "damasco", "figo", "tâmara"), 5)
        referencia.child(tema5.id.toString()).setValue(tema5)

        val tema6 = Tema(6,"Objetos",arrayListOf("computador", "livro", "chave", "copo", "cadeira", "cama", "mesa", "sofá", "fogão", "impressora", "caneta", "papel", "telefone", "prato", "copo", "talheres", "panela", "frigideira", "escova de dentes", "pasta de dente", "sabonete", "shampoo", "condicionador", "calça", "camisa", "sapato", "meia", "chapéu", "relógio", "óculos", "chave", "carteira", "celular", "televisão", "smartphone", "tablet", "videogame", "drone", "pintura", "escultura", "música", "dança", "teatro", "bola", "chuteira", "raquete", "bicicleta", "skate", "martelo", "prego", "furadeira", "serra", "chave de fenda"), 6)
        referencia.child(tema6.id.toString()).setValue(tema6)
    }

    fun mostrarTemas(){
        //Apresentação dos elementos.
        val listaTemas = ArrayList<Tema>()
        referencia.addValueEventListener(object : ValueEventListener
        {
            override fun onDataChange(snapshot: DataSnapshot)
            {
                if (snapshot.exists())
                {
                    var gson = Gson()
                    for (i in snapshot.children)
                    {
                        val json = gson.toJson(i.value)
                        val tema = gson.fromJson(json, Tema::class.java)
                        Log.i("Teste", "-------------------")
                        Log.i("Teste", "Id: ${tema.id}")
                        Log.i("Teste", "Nome: ${tema.nome}")
                        Log.i("Teste", "Cobertura: ${tema.listaPalavras}")
                        Log.i("Teste", "Preço: ${tema.imagem}")
                        Log.i("Teste", "-------------------")
                        listaTemas.add(Tema(tema.id,tema.nome,tema.listaPalavras,tema.imagem))
                    }
                    Log.i("Teste", "Array: ${listaTemas}")
                }
            }
            override fun onCancelled(error: DatabaseError) {
                Log.i("MENSAGEM", "Erro: $error")
            }
        })
    }

}