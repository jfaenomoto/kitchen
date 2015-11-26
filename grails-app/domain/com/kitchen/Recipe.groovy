package com.kitchen

class Recipe {

    String name
    List ingredients

    static hasMany = [ ingredients : Ingredient ]

    def isOvoLacto() {
        for (def ingredient : ingredients) {
            if (!ingredient.isOvoLacto()) {
                return false
            }
        }
        return true
    }

    def isVegan() {
        for (def ingredient : ingredients) {
            if (!ingredient.isVegan()) {
                return false
            }
        }
        return true
    }

    def addIngredient(Ingredient ingredient) {
        this.ingredients.add(ingredient)
    }
}
