package com.kitchen

class CookController {

    def recipeService
    
    def chefService
    
    def cook() {
        try {
            def recipe = recipeService.findByName (params.recipe)
            def meal = chefService.cook(recipe)
            response.status = 200
            render "Here is your ${meal.name}, sir/lady!"
        } catch (Exception e) {
            response.status = 500
            render "Bad, bad server, no donut for you!"
        }
    }
    
}
