package br.com.nicole.listadecompras

data class ItemModel(val name: String, val onRemove: (ItemModel) -> Unit)