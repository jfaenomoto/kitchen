package com.kitchen

import grails.plugin.spock.IntegrationSpec

import com.google.protobuf.DescriptorProtos.FieldDescriptorProto.Type;
import com.kitchen.exception.IngredientNotAvailableException

class ChefServiceIntegrationSpec extends IntegrationSpec {

    def chefService

    def 'cook a Ratatouille if we have ingredients'() {
        given:
        def zucchini = new Ingredient(name : "Zucchini", type : IngredientType.VEGETABLE).save()
        def onion = new Ingredient(name : "Onion", type : IngredientType.VEGETABLE).save()
        def tomato = new Ingredient(name : "Tomato", type : IngredientType.VEGETABLE).save()

        and:
        new Storage(quantity : 1, ingredient: zucchini).save()
        new Storage(quantity : 2, ingredient: onion).save()
        new Storage(quantity : 3, ingredient: tomato).save()

        and:
        def recipe = new Recipe(name: "Ratatouille", ingredients : [zucchini, onion, tomato])

        when:
        def meal = chefService.cook(recipe)

        then:
        assert meal
        assert meal.name == "Ratatouille"
    }

    def 'warn us that we cant cook a recipe if one ingredient is missing'() {
        given:
        def zucchini = new Ingredient(name : "Zucchini", type : IngredientType.VEGETABLE).save()
        def onion = new Ingredient(name : "Onion", type : IngredientType.VEGETABLE).save()
        def tomato = new Ingredient(name : "Tomato", type : IngredientType.VEGETABLE).save()

        and:
        new Storage(quantity : 1, ingredient: zucchini).save()
        new Storage(quantity : 0, ingredient: onion).save()
        new Storage(quantity : 3, ingredient: tomato).save()

        and:
        def recipe = new Recipe(name: "Ratatouille", ingredients : [zucchini, onion, tomato])

        when:
        def meal = chefService.cook(recipe)

        then:
        thrown(IngredientNotAvailableException)
    }
}