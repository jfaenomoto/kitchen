package com.kitchen

class Ingredient {
    
    String name
    IngredientType type
    
    def isOvoLacto() {
        return [IngredientType.SEASONING, IngredientType.VEGETABLE, IngredientType.ANIMAL_DERIVATIVE].contains(type)
    }
    
    def isVegan() {
        return [IngredientType.SEASONING, IngredientType.VEGETABLE].contains(type)
    }
    
}
