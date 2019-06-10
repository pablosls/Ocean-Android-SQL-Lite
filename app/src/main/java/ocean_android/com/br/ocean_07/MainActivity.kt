package ocean_android.com.br.ocean_07

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var databaseManager: DatabaseManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        databaseManager = DatabaseManager(DatabaseHelper(this))

        btSalvar.setOnClickListener {
            val nome = editNome.text.toString()
            val telefone = editTelefone.text.toString()
            salvarContato(nome, telefone)

        }

        selecionarContatos()
    }

    fun salvarContato(nome:String, telefone:String){

        databaseManager.inserirContato(nome, telefone)
        selecionarContatos();

    }

    fun selecionarContatos(){
        val contatos = databaseManager.selecionarContatos()

        linearContatos.removeAllViews()

        contatos.forEach {

            val textView = TextView(this)
            textView.text = it.nome
            textView.setOnClickListener { v-> // faz o it virar o v-
                Toast.makeText(this, "Telefone: ${it.telefone}", Toast.LENGTH_SHORT).show()
            }
            textView.setBackgroundColor(Color.BLUE);
            textView.setTextSize(20.0f)
            textView.setTextColor(Color.WHITE);


            linearContatos.addView(textView)

            //Toast.makeText(this, it.nome, Toast.LENGTH_SHORT).show()
        }
    }
}
