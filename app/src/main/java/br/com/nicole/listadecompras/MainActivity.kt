package br.com.nicole.listadecompras

import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import br.com.nicole.listadecompras.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val itemsAdapter = ItemsAdapter()
    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        val recyclerView = binding.recyclerView;

        recyclerView.adapter = itemsAdapter

        val button = binding.button
        val editText = binding.editText

        button.setOnClickListener {
            if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
            }

            val item = ItemModel(
                name = editText.text.toString(),
                onRemove = {
                    showConfirmationDialog(it)
                }
            )
            itemsAdapter.addItem(item)
            editText.text.clear()
        }
    }

    fun showConfirmationDialog(item: ItemModel) {
        AlertDialog.Builder(this)
            .setTitle("Deseja Excluir o Produto?")
            .setMessage("Essa ação não poderá ser desfeita")
            .setPositiveButton("Sim", DialogInterface.OnClickListener { dialogInterface, i ->
                itemsAdapter.removeItem(item)
            })
            .setNegativeButton("Não", DialogInterface.OnClickListener { dialogInterface, i ->
                dialogInterface.dismiss()
            })

            .create()
            .show()
    }

}