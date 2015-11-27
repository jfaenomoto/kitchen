package com.kitchen

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Recipe)
class RecipeSpec extends Specification {

    def 'check if recipe is ovo lacto'() {
        setup:
        def eggs = new Ingredient(name : "Eggs", type : IngredientType.ANIMAL_DERIVATIVE)
        def cheese = new Ingredient(name : "Cheese", type : IngredientType.ANIMAL_DERIVATIVE)
        def salt = new Ingredient(name : "Salt", type : IngredientType.SEASONING)
        def scrambledEggsWithCheese = new Recipe(ingredients : [eggs, cheese, salt])

        expect:
        scrambledEggsWithCheese.isOvoLacto()
    }

    def 'check if recipe is vegan'() {
        given:
        def lettuce = new Ingredient(name : "Lettuce", type : IngredientType.VEGETABLE)
        def cucumber = new Ingredient(name : "Cucumber", type : IngredientType.VEGETABLE)
        def soySauce = new Ingredient(name : "Soy sauce", type : IngredientType.SEASONING)
        def asianSalad = new Recipe(ingredients : [lettuce, cucumber, soySauce])

        when:
        def isVeganRecipe = asianSalad.isVegan()

        then:
        assert isVeganRecipe
    }
    
    def 'check added ingredients are on recipe'() {
        given:
        def pao = new Ingredient(name : "Pao", type : IngredientType.ANIMAL_DERIVATIVE)
        def eggs = new Ingredient(name : "Eggs", type : IngredientType.ANIMAL_DERIVATIVE)
        def paoComOvo = new Recipe()

        when:
        paoComOvo.addIngredient(pao)

        then:
        paoComOvo.ingredients.contains(pao)
        
        when:
        paoComOvo.addIngredient(eggs)

        then:
        paoComOvo.ingredients.contains(eggs)
    }
}