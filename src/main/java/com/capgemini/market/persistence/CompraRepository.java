package com.capgemini.market.persistence;

import com.capgemini.market.domain.Purchase;
import com.capgemini.market.domain.repository.PurchaseRepository;
import com.capgemini.market.persistence.crud.CompraCrudRepository;
import com.capgemini.market.persistence.entity.Compra;
import com.capgemini.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CompraRepository implements PurchaseRepository {
    @Autowired
    private CompraCrudRepository compraCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<Purchase> getAll() {
        return mapper.toPurchases((List<Compra>) compraCrudRepository.findAll());
    }

    @Override
    public Optional<List<Purchase>> getByClient(String id) {
        return compraCrudRepository.findByIdCliente(id)
                .map(compras -> mapper.toPurchases(compras));
    }

    @Override
    public Purchase save(Purchase purchase) {
        Compra compra = mapper.toCompra(purchase);
        compra.getProductos().forEach(producto -> producto.setCompra(compra));
        return mapper.toPurchase(compraCrudRepository.save(compra));
    }

    @Override
    public void delete(Integer purchaseId) {
        compraCrudRepository.deleteById(purchaseId);
    }
}
