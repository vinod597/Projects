package com.pbsi.fuelfilling.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/CountryController")
public class CountryController {
//	@Autowired
//	private CountryService countryService;
//	
//	/**
//	 * Redirect to listCountries view.
//	 * 
//	 * @param response HttpServletResponse
//	 * @return ModelAndView consisting of listCountries view. 
//	 */
//	@RequestMapping(value = "/listCountries", method = RequestMethod.GET)
//	public ModelAndView listCountries(HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("country/listCountries");
//		return mv;
//	}
//	
//	/**
//	 * Redirect to addCountry view.
//	 * 
//	 * @param response HttpServletResponse
//	 * @return ModelAndView consisting of addCountry view. 
//	 */
//	@RequestMapping(value = "/newCountry", method = RequestMethod.GET)
//	public ModelAndView newCountry(HttpServletResponse response) {
//		ModelAndView mv = new ModelAndView("country/addCountry");
//		return mv;
//	}
//	
//	/**
//	 * Insert or Update Country and redirect to listCountries view.
//	 * 
//	 * @param response HttpServletResponse
//	 * @param request HttpServletRequest
//	 * @param countryBean CountryBean
//	 * @return ModelAndView consisting of listCountries view. 
//	 */
//	@RequestMapping(value = "/saveOrUpdateCountry", method = RequestMethod.POST)
//	public @ResponseBody
//	void saveOrUpdateCountry(HttpServletResponse response, HttpServletRequest request, CountryBean countryBean) {
//		String successMsg = "";
//		String errorMessage = "";
////		CountryJson countryJson = TransformBean.getCountryJson(countryBean);
////		HttpSession session = request.getSession();
////		Long loginUserId = (Long) session.getAttribute("LoginUserId");
////		if (countryBean != null) {
////			if (countryBean.getCountryId() != null && countryBean.getCountryId().toString().length() > 0) {
////				countryJson = codeService.getCountryByCountryNameorCodeExclude(countryJson);
////				if(countryJson != null){
////					errorMessage = (countryJson.getCountryCode().equalsIgnoreCase(countryBean.getCountryCode().trim()))?"Country code already exists":(countryJson.getCountryName().equalsIgnoreCase(countryBean.getCountryName().trim()))?"Country name already exists":"";
////				}else {
////					countryJson = TransformBean.getCountryJson(countryBean);
////					countryJson.setLastUpdatedBy(loginUserId.toString());
////					codeService.updateCountry(countryJson);
////					successMsg = "Successfully updated Country (" + countryBean.getCountryName() + ")";
////				}
////				countryJson = null;
////			} else {
////				countryJson = codeService.getCountryByCountryNameorCode(countryJson); 
////				if(countryJson != null){
////					errorMessage = (countryJson.getCountryCode().equalsIgnoreCase(countryBean.getCountryCode().trim()))?"Country code already exists":(countryJson.getCountryName().equalsIgnoreCase(countryBean.getCountryName().trim()))?"Country name already exists":"";
////				}else {
////					countryJson = TransformBean.getCountryJson(countryBean);
////					countryJson.setLastUpdatedBy(loginUserId.toString());
////					codeService.saveCountry(countryJson);
////					successMsg = "Successfully saved Country (" + countryBean.getCountryName() + ")";
////				}
////				countryJson = null;
////			}
////		}
//		countryBean = null;
//	}
//	
//	/**
//	 * Get PageJson consisting of Countries list.
//	 * 
//	 * @param response HttpServletResponse
//	 * @param request HttpServletRequest
//	 * @return PageJson consisting of List of <code>CountryJson</code>.
//	 */
//	@RequestMapping(value = "/getCountriesList", method = RequestMethod.GET)
//	public @ResponseBody
//	PageJson getCountriesList(HttpServletResponse response, HttpServletRequest request) {
//		SearchParameter searchParameter = getSeachParameters(request);
//		List<CountryJson> countries = countryService.getAllCountriesFind(searchParameter);
////		long numbers = this.getNumberOfCountryFind(searchParameter);
////		PageJson json = TransformToJson.getPageJson(searchParameter.getCurrentPage(), numbers, countries, searchParameter.getRecordsPerPage());
//		PageJson json = null;
//		countries = null;
//		searchParameter = null;
//		return json;
//
//	}
//	
//	
//	
//	
//	/**
//	 * Get corresponding SearchParameter for the HttpServletRequest.
//	 * 
//	 * @param request HttpServletRequest
//	 * @return SearchParameter consisting of jqGrid parameters.
//	 */
//	private SearchParameter getSeachParameters(HttpServletRequest request) {
//
//		SearchParameter searchParameter = new SearchParameter();
//		if(request.getParameter("page") != null){
//			searchParameter.setCurrentPage(new Integer(request.getParameter("page")));
//			searchParameter.setRecordsPerPage(new Integer(request.getParameter("rows")));
//		}
//		boolean searchRequired = Boolean.parseBoolean(request.getParameter("_search"));
//		String searchField = request.getParameter("searchField");
//		if (searchRequired == false) {
//			searchField = null;
//		}
//
//		String searchOperator = request.getParameter("searchOper");
//		String searchString = request.getParameter("searchString");
//
//		String sortColumn = request.getParameter("sidx");
//		String sortType = request.getParameter("sord");
//
//		searchParameter.setSearchField(searchField);
//		searchParameter.setSearchOperator(searchOperator);
//		searchParameter.setSearchString(searchString);
//
//		searchParameter.setSortColumn(sortColumn);
//		searchParameter.setSortType(sortType);
//		//Memory cleanup
//		sortType = null;
//		sortColumn = null;
//		searchString = null;
//		searchOperator = null;
//		searchField = null;
//		return searchParameter;
//	}
//	

}
