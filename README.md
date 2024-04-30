# ListadeCompras

# Melhorias feitas no código 

## 1. Trocar o "findViewById" por "binding"

Realizamos essa troca pois o binding é uma maneira mais eficaz de acesso a todas as views em um layout.

<br>

## 2.  evitar inserir um texto vazio na lista 

Essa melhoria foi implementada para evitar a inserção de um item vazio na lista compras, garantindo assim a integridade e consistência dos dados inseridos.
	
kotlin
 if (editText.text.isEmpty()) {
                editText.error = "Preencha um valor"
                return@setOnClickListener
           }



<br>

## 3. Caixa de confirmação de exclusão de produto da lista
	
Esse melhoria foi adicionada com a intenção de evitar que o usuário exclua itens da lista acidentalmente.

kotlin
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
