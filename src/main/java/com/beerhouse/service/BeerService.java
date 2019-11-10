package com.beerhouse.service;

import java.util.List;

import com.beerhouse.model.Beer;

public interface BeerService {

	List<Beer> searchAllBeer();

	Beer searchBeer(Integer id);

	Beer createNewBeer(Beer newBeer);

	Boolean deleteBeer(Integer id);

	Beer updateBeer(Integer id, Beer beer);

}
