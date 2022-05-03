package com.openwebinars.definicionlisteners.model

class CarModel(var brand: String, var id: String) : ISelectable {
    override var isSelected: Boolean = false
}