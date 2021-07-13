package learn.dio.project.businesscard.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import learn.dio.project.businesscard.App
import learn.dio.project.businesscard.R
import learn.dio.project.businesscard.data.BusinessCard
import learn.dio.project.businesscard.databinding.ActivityAddBusinessCardAcitivtyBinding


class AddBusinessCardAcitivty : AppCompatActivity() {

    private val binding by lazy { ActivityAddBusinessCardAcitivtyBinding.inflate(layoutInflater)}

    private val mainViewModel: MainViewModel by viewModels {
        MainViewModelFactory((application as App).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        isnertListeners()

    }

    private fun isnertListeners(){
        binding.btnClose.setOnClickListener(){
            finish()
        }
        binding.btnConfirmar.setOnClickListener(){
        val businessCard = BusinessCard(
            nome = binding.tilNome.editText?.text.toString(),
            empresa = binding.tilEmpresa.editText?.text.toString(),
            telefone = binding.tilTelefone.editText?.text.toString(),
            email = binding.tilEmail.editText?.text.toString(),
            fundoPersonalizado = binding.tilCor.editText?.text.toString(),
        )
            mainViewModel.insert(businessCard)
            Toast.makeText(this, R.string.label_show_success, Toast.LENGTH_SHORT).show()
            finish()
        }
    }

}