package com.socks.api;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Config.Sources;

@Sources({"classpath:config.properties"})
public interface ProjectConfig extends Config {

//    If we have different env settings -> add test.baseUrl, prod.baseUrl variables in config.properties ->
//    create String env(); -> add annotation @Key("{env}.baseUrl") to
//    String baseUrl(); => then we run test from command line with -Denv=test or -Denv=prod
//
//    String env();
//
//    @Key("{env}.baseUrl")
//    String baseUrl();

    String baseUrl();

    @DefaultValue("de")
    String locale();

    Boolean logging();
}
