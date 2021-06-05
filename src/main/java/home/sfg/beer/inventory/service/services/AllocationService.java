package home.sfg.beer.inventory.service.services;

import home.sfg.brewery.model.BeerOrderDto;

public interface AllocationService {

  Boolean allocateOrder(BeerOrderDto beerOrderDto);
}
