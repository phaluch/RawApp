// First push dev

package com.rawenterprises.rawapp.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.rawenterprises.rawapp.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}


/** Entidades representam uma tabela no banco de dados local.
 * Os atributos e características podem ser alterados
 * através de anotações nos membros da classe. */
@Entity
data class Review(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,

    var stars: Int = 0,
    var texto: String? = null,

    // Se eu quisesse colocar 'lá no BD' no nome dessa tabela como 'data_postagem', faria assim:
    // @ColumnInfo(name = "data_postagem")
    var data: String? = null
)