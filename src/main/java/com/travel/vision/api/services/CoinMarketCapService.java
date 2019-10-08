package com.travel.vision.api.services;

import org.apache.http.NameValuePair;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

public interface CoinMarketCapService {
    String getMarketCap(String uri, List<NameValuePair> parameters) throws URISyntaxException, IOException;
}
