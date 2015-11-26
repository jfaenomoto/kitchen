package com.kitchen

class RecipeService {

    def findByName(String name) {
        return Recipe.findByName(name)
    }
}
