package com.beerhouse.templates;

import com.beerhouse.model.Ingredient;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;
import br.com.six2six.fixturefactory.loader.TemplateLoader;

public class IngredientTemplate implements TemplateLoader {

	public static final String LABEL_INGREDIENT_VALID = "Ingredient valid";

	@Override
	public void load() {

		Fixture.of(Ingredient.class).addTemplate(LABEL_INGREDIENT_VALID, new Rule() {
			{

				add("id", 1);
				add("description", "Teste ingrediente");

			}
		});
	}

}
