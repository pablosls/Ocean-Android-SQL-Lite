package ocean_android.com.br.ocean_07

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper (context: Context?)
    : SQLiteOpenHelper(context, "ocean_db", null, 1) {
    override fun onCreate(db: SQLiteDatabase?) {
        val sql = """
            CREATE TABLE contatos(
                id integer PRIMARY KEY,
                nome text,
                telefone text
            );
        """.trimIndent()

        db?.execSQL(sql)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }


}