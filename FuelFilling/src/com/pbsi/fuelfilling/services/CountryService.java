package com.pbsi.fuelfilling.services;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.pbsi.util.SearchParameter;


@Service
public class CountryService {
	
	private static final Logger logger = Logger.getLogger(CountryService.class);
	
	/**
	 * Get corresponding CountryJsons list based on searchParameter.
	 * 
	 * @param searchParameter <code>SearchParameter</code>
	 * @return List of <code>CountryJson</code>.
	 */
//	public List<CountryJson> getAllCountriesFind(SearchParameter searchParameter) {
//		logger.debug("getAllCountriesFind - START");
//		RestTemplate restTemplate = new RestTemplate();
//		HttpEntity<SearchParameter> entity = new HttpEntity<SearchParameter>(searchParameter);
//        ParameterizedTypeReference<List<CountryJson>> typeRef = new ParameterizedTypeReference<List<CountryJson>>() {
//        };
////        ResponseEntity<List<CountryJson>> result =  restTemplate.exchange(REST_WEBSERVICE_URL_KEY+"/getAllCountriesFind", HttpMethod.POST, entity, typeRef);
//        ResponseEntity<List<CountryJson>> result =  null;
//        List<CountryJson> countryJsonList = result.getBody();
//        result = null;
//        typeRef = null;
//        entity = null;
//        restTemplate = null;
//        searchParameter = null;
//		logger.debug("getAllCountriesFind - END");
//		return countryJsonList;
//	}
//

}
