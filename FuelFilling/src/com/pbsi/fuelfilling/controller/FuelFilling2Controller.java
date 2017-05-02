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

import com.pbsi.fuelfilling.bean.FuelFilling2Bean;

@Controller
@RequestMapping("/FuelFilling2Controller")
public class FuelFilling2Controller {
	private Logger LOG = Logger.getLogger(FuelFilling2Controller.class);

	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		LOG.info("init Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = new FuelFilling2Bean();
		HttpSession session = request.getSession();
		clearAction(fuelFilling2Bean);
		model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		session.setAttribute("fuelFilling2Bean", fuelFilling2Bean);
		LOG.info("init Method has ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	/**
	 * This Method is used to calculate distancetravelled by using present
	 * Reading and previous reading
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "/onchangeDistanceTravalled", method = RequestMethod.POST)
	public @ResponseBody FuelFilling2Bean onchangePresetnReadingAction(HttpServletRequest request, HttpServletResponse response, FuelFilling2Bean bean, ModelMap model) {
		LOG.info("onchangePresetnReadingAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			fuelFilling2Bean.setErrorMessage("");
			// checking the present reading with previous reading
			if (bean.getPresentReading() <= fuelFilling2Bean.getPreviousReading()) {
				fuelFilling2Bean.setErrorMessage("Present Reading must be greater than Previous Reading");
			} else {
				fuelFilling2Bean.setDistanceTraveled(bean.getPresentReading() - fuelFilling2Bean.getPreviousReading());
			}
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
			LOG.info(fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("onchangePresetnReadingAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return fuelFilling2Bean;
	}

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "addNext")
	public String fuelFillingAddNextAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		LOG.info("fuelFillingAddNextAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			fuelFilling2Bean.setErrorMessage("");
			fuelFilling2Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling2Bean.setAddNextBtnDisable(true);
			fuelFilling2Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling2Bean.setUpdateBtnDisable(false);
			fuelFilling2Bean.setRefreshBtnStyleClass("btn_login");
			fuelFilling2Bean.setRefreshBtnDisable(false);
			fuelFilling2Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling2Bean.setRollBackBtnDisable(true);
			fuelFilling2Bean.setClearBtnStyleClass("btn_gray");
			fuelFilling2Bean.setClearBtnDisable(true);
			fuelFilling2Bean.setPreviousReading(fuelFilling2Bean.getPresentReading());
			fuelFilling2Bean.setPresentReading(0f);
			fuelFilling2Bean.setFuelFilled(0f);
			fuelFilling2Bean.setFuelCost(0f);
			fuelFilling2Bean.setPresentReadingDisable(false);
			fuelFilling2Bean.setFuelFilledDisable(false);
			fuelFilling2Bean.setFuelCostDisable(false);
			fuelFilling2Bean.setDistanceTraveled(0.0f);
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingAddNextAction Method has ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "update")
	public String fuelFillingUpdateAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		LOG.info("fuelFillingUpdateAction Method has started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			if (bean.getMaximumFillings() == null) {
				bean.setMaximumFillings(fuelFilling2Bean.getMaximumFillings());
			}
			if (bean.getCreditLimit() == null) {
				bean.setCreditLimit(fuelFilling2Bean.getCreditLimit());
			}
			Float billAmount = bean.getFuelCost() * bean.getFuelFilled();
			if (fuelFilling2Bean.getCreditAvailable() == 0.0 && fuelFilling2Bean.getTotalFillings() == 0) {
				fuelFilling2Bean.setCreditAvailable(bean.getCreditLimit());
			}
			fuelFilling2Bean.setMaximumFillings(bean.getMaximumFillings());
			fuelFilling2Bean.setCreditLimit(bean.getCreditLimit());
			fuelFilling2Bean.setPresentReading(bean.getPresentReading());
			fuelFilling2Bean.setFuelFilled(bean.getFuelFilled());
			fuelFilling2Bean.setFuelCost(bean.getFuelCost());
			fuelFilling2Bean.setAddNextBtnStyleClass("btn_login");
			fuelFilling2Bean.setAddNextBtnDisable(false);
			fuelFilling2Bean.setUpdateBtnStyleClass("btn_gray");
			fuelFilling2Bean.setUpdateBtnDisable(true);
			fuelFilling2Bean.setRefreshBtnStyleClass("btn_gray");
			fuelFilling2Bean.setRefreshBtnDisable(true);
			fuelFilling2Bean.setClearBtnStyleClass("btn_login");
			fuelFilling2Bean.setClearBtnDisable(false);
			fuelFilling2Bean.setRollBackBtnStyleClass("btn_login");
			fuelFilling2Bean.setRollBackBtnDisable(false);
			fuelFilling2Bean.setPresentReadingDisable(true);
			fuelFilling2Bean.setFuelFilledDisable(true);
			fuelFilling2Bean.setFuelCostDisable(true);
			fuelFilling2Bean.setMaximumFillingsDisable(true);
			fuelFilling2Bean.setCreditLimitDisable(true);
			fuelFilling2Bean.setTotalFillings(fuelFilling2Bean.getTotalFillings() + 1);
			fuelFilling2Bean.setTotalFuelFilled(fuelFilling2Bean.getTotalFuelFilled() + fuelFilling2Bean.getFuelFilled());
			fuelFilling2Bean.setTotalDistanceTravelled(fuelFilling2Bean.getTotalDistanceTravelled() + fuelFilling2Bean.getDistanceTraveled());
			fuelFilling2Bean.setMileage(fuelFilling2Bean.getDistanceTraveled() / fuelFilling2Bean.getFuelFilled());
			fuelFilling2Bean.setAvgMileage(fuelFilling2Bean.getTotalDistanceTravelled() / fuelFilling2Bean.getTotalFuelFilled());
			fuelFilling2Bean.setCreditAvailed(fuelFilling2Bean.getCreditAvailed() + billAmount);
			fuelFilling2Bean.setCreditAvailable(fuelFilling2Bean.getCreditLimit() - fuelFilling2Bean.getCreditAvailed());
			if (fuelFilling2Bean.getTotalFillings() >= 10) {
				fuelFilling2Bean.setAddNextBtnStyleClass("btn_gray");
				fuelFilling2Bean.setAddNextBtnDisable(true);
			}
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingUpdateAction Method has ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	/**
	 * This Method is used to Perfrom Refresh Action By clicking on Refresh
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling2Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "refresh")
	public String fuelFillingRefreshAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		LOG.info("fuelFillingRefreshAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			fuelFilling2Bean.setErrorMessage("");
			fuelFilling2Bean.setPresentReading(0f);
			fuelFilling2Bean.setFuelFilled(0f);
			fuelFilling2Bean.setFuelCost(0f);
			fuelFilling2Bean.setDistanceTraveled(0f);
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);

		}
		LOG.info("fuelFillingRefreshAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	/**
	 * This Method is used to Perfrom RollBack Action By clicking on RollBack
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling2Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "rollBack")
	public String fuelFillingRollBackAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		LOG.info("fuelFillingRollBackAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			fuelFilling2Bean.setErrorMessage("");
			fuelFilling2Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling2Bean.setRollBackBtnDisable(true);
			fuelFilling2Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling2Bean.setAddNextBtnDisable(true);
			fuelFilling2Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling2Bean.setUpdateBtnDisable(false);
			fuelFilling2Bean.setRefreshBtnStyleClass("btn_login");
			fuelFilling2Bean.setRefreshBtnDisable(false);
			fuelFilling2Bean.setPresentReadingDisable(false);
			fuelFilling2Bean.setFuelFilledDisable(false);
			fuelFilling2Bean.setFuelCostDisable(false);
			Float billAmount = fuelFilling2Bean.getFuelCost() * fuelFilling2Bean.getFuelFilled();
			fuelFilling2Bean.setTotalFillings(fuelFilling2Bean.getTotalFillings() - 1);
			fuelFilling2Bean.setTotalFuelFilled(fuelFilling2Bean.getTotalFuelFilled() - fuelFilling2Bean.getFuelFilled());
			fuelFilling2Bean.setTotalDistanceTravelled(fuelFilling2Bean.getTotalDistanceTravelled() - fuelFilling2Bean.getDistanceTraveled());
			fuelFilling2Bean.setMileage(0f);
			fuelFilling2Bean.setAvgMileage(fuelFilling2Bean.getTotalDistanceTravelled() == 0 ? 0 : fuelFilling2Bean.getTotalDistanceTravelled() / fuelFilling2Bean.getTotalFuelFilled());
			fuelFilling2Bean.setPreviousReading(fuelFilling2Bean.getPresentReading() - fuelFilling2Bean.getDistanceTraveled());
			fuelFilling2Bean.setPresentReading(0f);
			fuelFilling2Bean.setDistanceTraveled(0f);
			fuelFilling2Bean.setFuelFilled(0f);
			fuelFilling2Bean.setCreditAvailed(fuelFilling2Bean.getCreditAvailed() - billAmount);
			fuelFilling2Bean.setCreditAvailable(fuelFilling2Bean.getCreditLimit() - fuelFilling2Bean.getCreditAvailed());
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingRollBackAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	/**
	 * This Method is used to Perfrom Clear Action By clicking on Clear button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling2Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "clear")
	public String fuelFillingClearAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		LOG.info("fuelFillingClearAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		FuelFilling2Bean fuelFilling2Bean = (FuelFilling2Bean) request.getSession().getAttribute("fuelFilling2Bean");
		try {
			clearAction(fuelFilling2Bean);
			fuelFilling2Bean.setRefreshBtnStyleClass("btn_gray");
			fuelFilling2Bean.setRefreshBtnDisable(true);
			model.addAttribute("fuelFilling2Bean", fuelFilling2Bean);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.error(e);
		}
		LOG.info("fuelFillingClearAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
		return "fuelFilling2";
	}

	/**
	 * This Method is used to Perfrom Cancel Action By clicking on Cancel
	 * button.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling2Bean
	 * @return
	 */

	@RequestMapping(value = "/fuelFillingAction", method = RequestMethod.POST, params = "cancel")
	public String fuelFillingCancelAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling2Bean bean) {
		return "home";
	}

	/**
	 * This Method is used to clear the fields data on the screen.
	 * 
	 * @param fuelFilling2Bean
	 */
	public void clearAction(FuelFilling2Bean fuelFilling2Bean) {
		LOG.info("clearAction Method has Started at:" + Calendar.getInstance().getTimeInMillis());
		try {
			fuelFilling2Bean.setAddNextBtnStyleClass("btn_gray");
			fuelFilling2Bean.setAddNextBtnDisable(true);
			fuelFilling2Bean.setUpdateBtnStyleClass("btn_login");
			fuelFilling2Bean.setUpdateBtnDisable(false);
			fuelFilling2Bean.setRefreshBtnStyleClass("btn_login");
			fuelFilling2Bean.setRefreshBtnDisable(false);
			fuelFilling2Bean.setRollBackBtnStyleClass("btn_gray");
			fuelFilling2Bean.setRollBackBtnDisable(true);
			fuelFilling2Bean.setClearBtnStyleClass("btn_gray");
			fuelFilling2Bean.setClearBtnDisable(true);
			fuelFilling2Bean.setPresentReadingDisable(false);
			fuelFilling2Bean.setFuelFilledDisable(false);
			fuelFilling2Bean.setFuelCostDisable(false);
			fuelFilling2Bean.setPresentReading(0f);
			fuelFilling2Bean.setPreviousReading(0f);
			fuelFilling2Bean.setFuelFilled(0f);
			fuelFilling2Bean.setDistanceTraveled(0f);
			fuelFilling2Bean.setTotalFillings(0);
			fuelFilling2Bean.setTotalDistanceTravelled(0f);
			fuelFilling2Bean.setTotalFuelFilled(0f);
			fuelFilling2Bean.setMileage(0f);
			fuelFilling2Bean.setAvgMileage(0f);
			fuelFilling2Bean.setErrorMessage("");
			fuelFilling2Bean.setMaximumFillings(0);
			fuelFilling2Bean.setCreditLimit(0f);
			fuelFilling2Bean.setCreditAvailable(0f);
			fuelFilling2Bean.setCreditAvailed(0f);
			fuelFilling2Bean.setFuelCost(0f);
			fuelFilling2Bean.setMaximumFillingsDisable(false);
			fuelFilling2Bean.setCreditLimitDisable(false);
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info(e);
		}
		LOG.info("clearAction Method has Ended at:" + Calendar.getInstance().getTimeInMillis());
	}

}
