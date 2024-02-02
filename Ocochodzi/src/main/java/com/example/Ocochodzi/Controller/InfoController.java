package com.example.Ocochodzi.Controller;

import com.example.Ocochodzi.model.ProductsConfingurationProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class InfoController {
    @Autowired
    InfoController(final DataSourceProperties datasource, final ProductsConfingurationProperties myproperty) {
        this.datasource = datasource;
        this.myproperty = myproperty;
    }

    private DataSourceProperties datasource;

    private ProductsConfingurationProperties myproperty;

    @GetMapping("/info/url")
    String url(){
        return datasource.getUrl();
    }
    @GetMapping("/info/property")
    boolean myproperty(){
        return myproperty.getTemplate().isAllowToMultipleProducts();
    }
}
