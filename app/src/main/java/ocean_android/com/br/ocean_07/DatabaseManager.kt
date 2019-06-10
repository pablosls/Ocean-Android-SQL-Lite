package ocean_android.com.br.ocean_07

import android.content.ContentValues

class DatabaseManager(val dbHelper: DatabaseHelper) {




    fun inserirContato(nome:String, telefone:String): Long {

        val db = dbHelper.writableDatabase

        val valores = ContentValues().apply{
            put("nome", nome)
            put("telefone", telefone)
        }

        val id = db.insert("contatos", null, valores)
        return id;

        /*
        valores.put("nome", nome)
        valores.put("telefone", telefone)
        */
    }

    fun selecionarContatos(): List<Contato>{

        val db = dbHelper.readableDatabase

        val sql = "SELECT * FROM contatos"

        val cursor = db.rawQuery(sql, null )

        var resultado = mutableListOf<Contato>()

        if(cursor.moveToFirst()){

            do {
                val nomeDB = cursor.getString(cursor.getColumnIndex("nome"))
                val telefoneDB = cursor.getString(cursor.getColumnIndex("telefone"))
                resultado.add(Contato(nomeDB, telefoneDB))
            }while(cursor.moveToNext())
            cursor.close()
        }

        return resultado;

    }
}