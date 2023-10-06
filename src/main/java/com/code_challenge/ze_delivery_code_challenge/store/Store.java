package com.code_challenge.ze_delivery_code_challenge.store;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonMultiPolygon;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@Document("stores")
public class Store {
    @Id
    private String id;
    private String tradingName;

    @Indexed(unique = true)
    private String document;
    private GeoJsonMultiPolygon coverageArea;
    private GeoJsonPoint Address;

}
