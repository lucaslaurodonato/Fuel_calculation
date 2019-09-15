package lucasdonato.lucasdonato.alcoolougasolina

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import java.math.BigDecimal
import java.math.RoundingMode

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

     fun btCalcular(view: View){

        //recupera valores digitados
        val precoAlcool = edit_preco_alcool.text.toString()
        val precoGasolina = edit_preco_gasolina.text.toString()


        val validaCampos = validarCampos( precoAlcool, precoGasolina )
        if( validaCampos ){
            calcularMelhorPreco( precoAlcool, precoGasolina )
        }else{
            text_resultado.setText("Preencha os preços primeiro!")
        }
    }

    fun validarCampos( precoAlcool: String, precoGasolina: String ) : Boolean {

        var camposValidados: Boolean = true

        if ( precoAlcool == null || precoAlcool.equals("") ){
            camposValidados = false
        }else if( precoGasolina == null || precoGasolina.equals("") ){
            camposValidados = false
        }

        return camposValidados
    }

    fun calcularMelhorPreco(precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina =  precoGasolina.toDouble()
        val resultadoPreco = valorAlcool / valorGasolina
        val porcentagem = BigDecimal(valorAlcool * 100 / valorGasolina).setScale(2, RoundingMode.HALF_EVEN)

        if( resultadoPreco >= 0.73){
            text_resultado.setText("Melhor usar Gasolina a porcentagem foi de $porcentagem!")
        } else {
            text_resultado.setText("Melhor usar Álcool a porcentagem foi de $porcentagem!")
        }
    }

    /*fun porcentagemTela (precoAlcool: String, precoGasolina: String){

        val valorAlcool = precoAlcool.toDouble()
        val valorGasolina =  precoGasolina.toDouble()

        val resultadoPorcentagem = valorAlcool * 100 / valorGasolina

        if (resultadoPorcentagem >= 0.73 ) {
            text_porcentagem.setText("PQPPPPPP")
        } else {
            text_porcentagem.setText("Vish")
        }
    }
*/
}