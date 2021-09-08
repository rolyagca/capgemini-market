package com.capgemini.market.domain.repository;

import com.capgemini.market.domain.Purchase;

import java.util.List;
import java.util.Optional;

public interface PurchaseRepository {

    List<Purchase>  getAll();
    Optional<List<Purchase>> getByClient(String id);
    Purchase save(Purchase purchase);
    void delete(Integer purchaseId);

}
