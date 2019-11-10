package com.beerhouse.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.beerhouse.exception.NonExistentObjectException;
import com.beerhouse.model.Beer;
import com.beerhouse.repository.BeerRepository;
import com.beerhouse.service.BeerService;

@Component
public class BeerServiceImpl implements BeerService {

	@Autowired
	BeerRepository beerRepository;

	@Override
	public List<Beer> searchAllBeer() {
		return beerRepository.findAll();
	}

	@Override
	public Beer searchBeer(Integer id) {
		return beerRepository.findOne(id);
	}

	@Override
	public Beer createNewBeer(Beer newBeer) {

		beerRepository.save(newBeer);
		return newBeer;

	}

	@Override
	public Boolean deleteBeer(Integer id) {
		if (beerRepository.exists(id))
			beerRepository.delete(id);
		else
			throw new NonExistentObjectException("Beer not found!");

		return true;
	}

	@Override
	public Beer updateBeer(Integer id, Beer beer) {
		if (beerRepository.exists(id)){
			beer.setId(id);
			beerRepository.save(beer);
		}else {
			throw new NonExistentObjectException("Beer not found!");
		}
	
		return beer;
	}

}
