package com.kitchen

import grails.test.mixin.TestFor

import spock.lang.Specification

import com.kitchen.exception.*

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(ChefService)
class ChefServiceSpec extends Specification {

    def 'throw exception if attempt to cook null recipe'() {
        when:
        service.cook(null)

        then:
        thrown(IllegalArgumentException)
    }

    def 'do not throw exception if attempt to cook empty recipe'() {
        when:
        service.cook(new Recipe())

        then:
        notThrown(IllegalArgumentException)
    }

    def 'cook a recipe'() {
        given:
        def ingredients = [
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient(),
            new Ingredient()
        ]
        def recipe = new Recipe(name : "Frangão", ingredients : ingredients)
        service.kitchenStorageService.grab(_) >> new Ingredient()

        when:
        def meal = service.cook(recipe)

        then:
        assert meal != null
        assert meal.name == "Frangão"

        and:
        ingredients.size() * service.knifeService.cut(_)
    }

    def 'what happens when an ingredient is not available?'() {
        given:
        def recipe = new Recipe(ingredients : [
            new Ingredient(),
            new Ingredient()
        ])
        service.kitchenStorageService.grab(_) >> {
            throw new IngredientNotAvailableException()
        }

        when:
        service.cook(recipe)

        then:
        thrown(RecipeNotAvailableException)
    }

    def setup() {
        service.kitchenStorageService = Mock(KitchenStorageService)
        service.knifeService = Mock(KnifeService)
    }
}
