// First push dev

package com.rawenterprises.rawapp.ui.activity

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.*
import com.parse.ParseException
import com.parse.ParseObject
import com.parse.ParseQuery
import com.rawenterprises.rawapp.R
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val query = ParseQuery.getQuery<ParseObject>("Avaliation")

        var result = query.getInBackground("yqFxoXb2KH");

        Log.d("PARSE", "${result.result}")

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

    // Eu posso ter dentro do data class um atributo que eu não quero gravar no DB, mas quero
    //carregar dentro do código. Nesse caso posso declará-lo normalmente aqui e usar o atributo
    // ignoredColumns = ['nome_da_var'] lá na anotação de Entity

    // Se eu quisesse colocar 'lá no BD' no nome dessa tabela como 'data_postagem', faria assim:
    // @ColumnInfo(name = "data_postagem")
    var data: String? = null
)

/** Data Access Object (DAO), Objeto responsável por operações
        dentro do banco de dados local.
 */

@Dao
interface ReviewDao {
    @Query("Select * from review")
    suspend fun getAllReviews(text: String) : List<Review> //Porque vai me devolver a lista de data classes

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertReview(r: Review)

    @Update
    suspend fun updateReview(r: Review)

    @Delete
    suspend fun deleteReview(r: Review)
}

@Database(entities = [Review::class], version=1) // Essa versão é a do DB. Ela corre 'paralela' ao app.
abstract class RawAppDatabase: RoomDatabase() {
    abstract fun getReviewDao(): ReviewDao // Pra cada tabela você cria uma linha dessas
}