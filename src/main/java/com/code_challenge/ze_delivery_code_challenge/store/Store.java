package com.code_challenge.ze_delivery_code_challenge.store;

import com.code_challenge.ze_delivery_code_challenge.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.geo.GeoJsonPoint;
import org.springframework.data.mongodb.core.geo.GeoJsonPolygon;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexType;
import org.springframework.data.mongodb.core.index.GeoSpatialIndexed;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE, name = "coverageArea_2dSphere")
    private GeoJsonPolygon coverageArea;
    @GeoSpatialIndexed(type = GeoSpatialIndexType.GEO_2DSPHERE, name = "address_2Sphere")
    private GeoJsonPoint address;
    @DBRef
    private User user;
}
