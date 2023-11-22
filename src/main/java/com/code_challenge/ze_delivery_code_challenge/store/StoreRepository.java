package com.code_challenge.ze_delivery_code_challenge.store;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends MongoRepository<Store, String> {
    @Query("{ coverageArea: { $geoIntersects: { $geometry: { type: 'Point', coordinates: ?0 } } }, address: { $nearSphere: { $geometry: { type: 'Point', coordinates: ?0 } } } }")
    List<Store> findByCoverageAreaIntersects(List<Double> coordinates);
}
