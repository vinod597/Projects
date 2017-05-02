package com.pbsi.fuelfilling.controller;

import java.util.Calendar;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbsi.fuelfilling.bean.FuelFilling1Bean;

/**
 * 
 * @author ashok.chalamala
 *
 */

@Controller
@RequestMapping("/FuelFilling1Controller")
public class FuelFilling1Controller {
	private Logger LOG = Logger.getLogger(FuelFilling1Controller.class);

	/**
	 * This is the first invocation method when we give the request as
	 * FuelFilling1Controller in the URL
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return view
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		long startTime = Calendar.getInstance().getTimeInMillis();
		LOG.info("init Method has started at:" + startTime);
		HttpSession session = request.getSession();
		FuelFilling1Bean fuelFilling1Bean = new FuelFilling1Bean();
		clearAction(fuelFilling1Bean);
		// adding the model(bean) to the ModelMap
		model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		session.setAttribute("fuelFilling1Bean", fuelFilling1Bean);
		long endTime = Calendar.getInstance().getTimeInMillis();
		LOG.info("init Method has Ended at:" + endTime);
		return "fuelFilling1";
	}

	/**
	 * This method is used to calculate distance traveled by using present
	 * Reading and previous reading
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/onchangeDistanceTravalled", method = RequestMethod.POST)
	public @ResponseBody FuelFilling1Bean onchangePresetnReadingAction(HttpServletRequest request, HttpServletResponse response, FuelFilling1Bean bean, ModelMap model) {
		LOG.info("onchangePresetnReadingAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			fuelFilling1Bean.setErrorMessage("");
			// checking the present reading with previous reading
			if (bean.getPresentReading() <= fuelFilling1Bean.getPreviousReading()) {
				fuelFilling1Bean.setErrorMessage("Present Reading must be greater than Previous Reading");
			} else {
				fuelFilling1Bean.setDistanceTraveled(bean.getPresentReading() - fuelFilling1Bean.getPreviousReading());
			}
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("onchangePresetnReadingAction Method has Ended:" + Calendar.getInstance().getTimeInMillis());
		return fuelFilling1Bean;
	}

	/**
	 * This Method is used to Perform AddNext Action By clicking on AddNext
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "addNext")
	public String fuelFillingAddNextAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean bean) {
		LOG.info("fuelFillingAddNextAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			fuelFilling1Bean.setErrorMessage("");
			// set the style class for buttons
			fuelFilling1Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling1Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling1Bean.setRefreshBtnStyleClass("btn_login");
			fuelFilling1Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling1Bean.setClearBtnStyleClass("btn_gray");
			// set the mode for buttons
			fuelFilling1Bean.setAddNextBtnDisable(true);
			fuelFilling1Bean.setUpdateBtnDisable(false);
			fuelFilling1Bean.setRefreshBtnDisable(false);
			fuelFilling1Bean.setRollBackBtnDisable(true);
			fuelFilling1Bean.setClearBtnDisable(true);
			// Update the fields data
			fuelFilling1Bean.setPreviousReading(fuelFilling1Bean.getPresentReading());
			fuelFilling1Bean.setPresentReading(0.0f);
			fuelFilling1Bean.setFuelFilled(0.0f);
			fuelFilling1Bean.setDistanceTraveled(0.0f);
			// set the PresentReading and FuelFilled fields mode to Enable
			fuelFilling1Bean.setPresentReadingDisable(false);
			fuelFilling1Bean.setFuelFilledDisable(false);
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingAddNextAction Method has ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling1";
	}

	/**
	 * This Method is used to Perfrom Update Action By clicking on Update
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */
	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "update")
	public String fuelFillingUpdateAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean bean) {
		LOG.info("fuelFillingUpdateAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			fuelFilling1Bean.setErrorMessage("");
			// Checking the validations
			if (fuelFilling1Bean.getTotalFillings() >= 10) {
				fuelFilling1Bean.setErrorMessage("No.of fillings should not exceed 10");
				model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
				request.getSession().setAttribute("fuelFilling1Bean", fuelFilling1Bean);
				return "fuelFilling1";
			}
			fuelFilling1Bean.setPresentReading(bean.getPresentReading());
			fuelFilling1Bean.setFuelFilled(bean.getFuelFilled());
			// set the style class for buttons
			fuelFilling1Bean.setAddNextBtnStyleClass("btn_login");
			fuelFilling1Bean.setUpdateBtnStyleClass("btn_gray");
			fuelFilling1Bean.setRefreshBtnStyleClass("btn_gray");
			fuelFilling1Bean.setClearBtnStyleClass("btn_login");
			fuelFilling1Bean.setRollBackBtnStyleClass("btn_login");
			// set the mode for buttons
			fuelFilling1Bean.setAddNextBtnDisable(false);
			fuelFilling1Bean.setUpdateBtnDisable(true);
			fuelFilling1Bean.setRefreshBtnDisable(true);
			fuelFilling1Bean.setClearBtnDisable(false);
			fuelFilling1Bean.setRollBackBtnDisable(false);
			// set the mode for textFields
			fuelFilling1Bean.setPresentReadingDisable(true);
			fuelFilling1Bean.setFuelFilledDisable(true);
			// performing the calculations
			fuelFilling1Bean.setTotalFillings(fuelFilling1Bean.getTotalFillings() + 1);
			fuelFilling1Bean.setTotalFuelFilled(fuelFilling1Bean.getTotalFuelFilled() + bean.getFuelFilled());
			fuelFilling1Bean.setTotalDistanceTravelled(fuelFilling1Bean.getTotalDistanceTravelled() + fuelFilling1Bean.getDistanceTraveled());
			fuelFilling1Bean.setMileage(fuelFilling1Bean.getDistanceTraveled() / bean.getFuelFilled());
			fuelFilling1Bean.setAvgMileage(fuelFilling1Bean.getTotalDistanceTravelled() / fuelFilling1Bean.getTotalFuelFilled());
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingUpdateAction Method has ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling1";
	}

	/**
	 * This Method is used to Perfrom Refresh Action By clicking on Refresh
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "refresh")
	public String fuelFillingRefreshAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean bean) {
		LOG.info("fuelFillingRefreshAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			fuelFilling1Bean.setErrorMessage("");
			// set the mode for textFields
			fuelFilling1Bean.setPresentReading(0.0f);
			fuelFilling1Bean.setFuelFilled(0.0f);
			fuelFilling1Bean.setDistanceTraveled(0.0f);
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		LOG.info("fuelFillingRefreshAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling1";
	}

	/**
	 * This Method is used to Perform RollBack Action By clicking on RollBack
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "rollBack")
	public String fuelFillingRollBackAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean bean) {
		LOG.info("fuelFillingRollBackAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			fuelFilling1Bean.setErrorMessage("");
			// set the style class for buttons
			fuelFilling1Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling1Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling1Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling1Bean.setRefreshBtnStyleClass("btn_login");
			// set the mode for buttons
			fuelFilling1Bean.setRollBackBtnDisable(true);
			fuelFilling1Bean.setAddNextBtnDisable(true);
			fuelFilling1Bean.setUpdateBtnDisable(false);
			fuelFilling1Bean.setRefreshBtnDisable(false);
			// set the mode for textFields
			fuelFilling1Bean.setPresentReadingDisable(false);
			fuelFilling1Bean.setFuelFilledDisable(false);
			// performing the calculations
			fuelFilling1Bean.setTotalFillings(fuelFilling1Bean.getTotalFillings() - 1);
			fuelFilling1Bean.setTotalFuelFilled(fuelFilling1Bean.getTotalFuelFilled() - fuelFilling1Bean.getFuelFilled());
			fuelFilling1Bean.setTotalDistanceTravelled(fuelFilling1Bean.getTotalDistanceTravelled() - fuelFilling1Bean.getDistanceTraveled());
			fuelFilling1Bean.setMileage(0.0f);
			fuelFilling1Bean.setAvgMileage(fuelFilling1Bean.getTotalDistanceTravelled() == 0 ? 0 : fuelFilling1Bean.getTotalDistanceTravelled() / fuelFilling1Bean.getTotalFuelFilled());
			fuelFilling1Bean.setPreviousReading(fuelFilling1Bean.getPresentReading() - fuelFilling1Bean.getDistanceTraveled());
			fuelFilling1Bean.setPresentReading(0.0f);
			fuelFilling1Bean.setDistanceTraveled(0.0f);
			fuelFilling1Bean.setFuelFilled(0.0f);
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		LOG.info("fuelFillingRollBackAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling1";
	}

	/**
	 * This Method is used to Perfrom Clear Action By clicking on Clear button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "clear")
	public String fuelFillingClearAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean bean) {
		LOG.info("fuelFillingClearAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean) request.getSession().getAttribute("fuelFilling1Bean");
		try {
			// This method is used to set all the fields to their default values
			clearAction(fuelFilling1Bean);
			// Refresh Button is Deactivated
			fuelFilling1Bean.setRefreshBtnStyleClass("btn_gray");
			fuelFilling1Bean.setRefreshBtnDisable(true);
			model.addAttribute("fuelFilling1Bean", fuelFilling1Bean);
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}
		LOG.info("fuelFillingClearAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling1";
	}

	/**
	 * This Method is used to Perform Cancel Action By clicking on Cancel
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling1Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "cancel")
	public String fuelFillingCancelAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling1Bean fuelFilling1Bean) {
		// returning the view
		return "home";
	}

	/**
	 * This Method is used to clear the fields data on the screen.
	 * 
	 * @param fuelFilling1Bean
	 */
	public void clearAction(FuelFilling1Bean fuelFilling1Bean) {
		LOG.info("clearAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		// FuelFilling1Bean fuelFilling1Bean = (FuelFilling1Bean)
		// request.getSession().getAttribute("fuelFilling1Bean");
		try {
			// set the style class for buttons
			fuelFilling1Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling1Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling1Bean.setRefreshBtnStyleClass("btn_login");
			fuelFilling1Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling1Bean.setClearBtnStyleClass("btn_gray");
			// set the mode for buttons
			fuelFilling1Bean.setAddNextBtnDisable(true);
			fuelFilling1Bean.setUpdateBtnDisable(false);
			fuelFilling1Bean.setRefreshBtnDisable(false);
			fuelFilling1Bean.setRollBackBtnDisable(true);
			fuelFilling1Bean.setClearBtnDisable(true);
			// set the mode for text fields
			fuelFilling1Bean.setPresentReadingDisable(false);
			fuelFilling1Bean.setFuelFilledDisable(false);
			// set the default values for fields
			fuelFilling1Bean.setPresentReading(0.0f);
			fuelFilling1Bean.setPreviousReading(0.0f);
			fuelFilling1Bean.setFuelFilled(0.0f);
			fuelFilling1Bean.setDistanceTraveled(0.0f);
			fuelFilling1Bean.setTotalFillings(0);
			fuelFilling1Bean.setTotalDistanceTravelled(0.0f);
			fuelFilling1Bean.setTotalFuelFilled(0.0f);
			fuelFilling1Bean.setMileage(0.0f);
			fuelFilling1Bean.setAvgMileage(0.0f);
			fuelFilling1Bean.setErrorMessage("");
		} catch (Exception e) {
			LOG.error(e);
			e.printStackTrace();
		}

		LOG.info("clearAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
	}

}
