package com.pbsi.fuelfilling.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pbsi.fuelfilling.bean.FuelFilling3Bean;
import com.pbsi.fuelfilling.bean.GridBean;
import com.pbsi.fuelfilling.bean.RadioButtonBean;
import com.pbsi.fuelfilling.grid.GridColumnsJson;
import com.pbsi.fuelfilling.grid.GridBuilder;
import com.pbsi.fuelfilling.grid.TypeOfField;
import com.pbsi.fuelfilling.json.FuelFiling3Json;

/**
 * 
 * @author Siva.Kurapati
 *
 */
@Controller
@RequestMapping("/FuelFilling3Controller")
public class FuelFilling3Controller {
	/**
	 * This is the first method to invoke when we call this controller.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @return
	 */
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession();
		FuelFilling3Bean fuelFilling3Bean = new FuelFilling3Bean();
		fuelFilling3Bean.setPaymentMode(0);

		clear(request, fuelFilling3Bean);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		session.setAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	/**
	 * This method is to clear all the field values and set the default mode for
	 * all the fields and buttons.
	 */
	public void clear(HttpServletRequest request, FuelFilling3Bean fuelFilling3Bean) {
		GridBean gridBean = new GridBean();
		gridBean.setCurrentRecord(0);
		gridBean.setCount(3);
		gridBean.getSortedColumnMap().clear();
		fuelFilling3Bean.setFuelFilling3GridBean(gridBean);
		List<FuelFiling3Json> fuelFiling3JsonList = new ArrayList<FuelFiling3Json>();
		fuelFilling3Bean.setFuelFiling3JsonList(fuelFiling3JsonList);
		// set the values for payment mode radio buttons
		List<RadioButtonBean> paymentModeList = new ArrayList<RadioButtonBean>();
		RadioButtonBean bean1 = new RadioButtonBean();
		bean1.setValue(0);
		bean1.setLabel("Cash");
		RadioButtonBean bean2 = new RadioButtonBean();
		bean2.setValue(1);
		bean2.setLabel("Credit");
		paymentModeList.add(bean1);
		paymentModeList.add(bean2);
		fuelFilling3Bean.setPaymentModeList(paymentModeList);
		// set the default values for all the fields
		fuelFilling3Bean.setMaximumFillings(0);
		fuelFilling3Bean.setDate("");
		fuelFilling3Bean.setPreviousReading(0.0f);
		fuelFilling3Bean.setPresentReading(0.0f);
		fuelFilling3Bean.setDistanceTraveled(0.0f);
		fuelFilling3Bean.setFuelCost(0.0f);
		fuelFilling3Bean.setFuelFilled(0.0f);
		fuelFilling3Bean.setTotalFillings(0);
		fuelFilling3Bean.setTotalFuelFilled(0.0f);
		fuelFilling3Bean.setTotalDistanceTravelled(0.0f);
		fuelFilling3Bean.setMileage(0.0f);
		fuelFilling3Bean.setAvgMileage(0.0f);
		fuelFilling3Bean.setCreditAvailable(0.0f);
		fuelFilling3Bean.setCreditAvailed(0.0f);
		fuelFilling3Bean.setCreditLimit(0.0f);
		fuelFilling3Bean.setNetAmount(0.0f);
		fuelFilling3Bean.setPaymentCreditAvailed(0.0f);
		fuelFilling3Bean.setAmountReceived(0.0f);
		fuelFilling3Bean.setAmountDue(0.0f);
		fuelFilling3Bean.setAmountToBeReturned(0.0f);
		// set the default style class for all the buttons
		fuelFilling3Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling3Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling3Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling3Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling3Bean.setClearBtnStyleClass("btn_gray");
		fuelFilling3Bean.setCancelBtnStyleClass("btn_login");
		fuelFilling3Bean.setAddBtnStyleClass("btn_gray");
		// set the default mode for all the buttons
		fuelFilling3Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setClearBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setCancelBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setAddBtnDisable(Boolean.TRUE);
		// set the default values for the payment pop-up values
		fuelFilling3Bean.setNetAmount(0.0f);
		fuelFilling3Bean.setAmountToBeReturned(0.0f);
		fuelFilling3Bean.setAmountReceived(0.0f);
		fuelFilling3Bean.setPaymentCreditAvailed(0.0f);
		fuelFilling3Bean.setAmountDue(0.0f);
		// set the default mode for all the fields
		fuelFilling3Bean.setMaximumFillingsDisable(Boolean.FALSE);
		fuelFilling3Bean.setDateDisable(Boolean.FALSE);
		fuelFilling3Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelFilledDisable(Boolean.FALSE);
		fuelFilling3Bean.setCreditLimitDisable(Boolean.FALSE);
		// set the grid list to zero
		gridInfoAction(request, fuelFilling3Bean);
		fuelFilling3Bean.setGridDiv(GridBuilder.developGridAction(null, fuelFilling3Bean.getGridColumnsJsonList(), 0, getCurrentPage(fuelFilling3Bean), fuelFilling3Bean.getFuelFilling3GridBean().getSortedColumnMap()));
	}

	/**
	 * This method is to perform add Next Operation
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param bean
	 * @return
	 */
	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "addNext")
	public String addNextAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		// set the style class for all the buttons
		fuelFilling3Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling3Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling3Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling3Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling3Bean.setClearBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddBtnStyleClass("btn_gray");
		// set the mode for all the buttons
		fuelFilling3Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setClearBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setAddBtnDisable(Boolean.TRUE);
		// set the value for the field values
		fuelFilling3Bean.setDate("");
		fuelFilling3Bean.setPreviousReading(fuelFilling3Bean.getPresentReading());
		fuelFilling3Bean.setPresentReading(0.0f);
		fuelFilling3Bean.setDistanceTraveled(0.0f);
		fuelFilling3Bean.setFuelCost(0.0f);
		fuelFilling3Bean.setFuelFilled(0.0f);
		// set the fields mode
		fuelFilling3Bean.setDateDisable(Boolean.FALSE);
		fuelFilling3Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelFilledDisable(Boolean.FALSE);
		// set the payment pop-up values
		fuelFilling3Bean.setAmountReceived(0.0f);
		fuelFilling3Bean.setAmountDue(0.0f);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	/**
	 * This method is to perform update Action.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling3Bean
	 * @return
	 */
	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "update")
	public String updateAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setErrorMessage("");
		// find out the empty fields to generate error messages

		// perform calculations for update Action
		fuelFilling3Bean.setTotalFillings(fuelFilling3Bean.getTotalFillings() + 1);
		fuelFilling3Bean.setTotalFuelFilled(fuelFilling3Bean.getTotalFuelFilled() + bean.getFuelFilled());
		fuelFilling3Bean.setTotalDistanceTravelled(fuelFilling3Bean.getTotalDistanceTravelled() + fuelFilling3Bean.getDistanceTraveled());
		fuelFilling3Bean.setMileage(fuelFilling3Bean.getDistanceTraveled() / bean.getFuelFilled());
		fuelFilling3Bean.setAvgMileage(fuelFilling3Bean.getTotalDistanceTravelled() / fuelFilling3Bean.getTotalFuelFilled());
		fuelFilling3Bean.setPresentReading(bean.getPresentReading());
		// fuelFilling3Bean.setDistanceTraveled(bean.getDistanceTraveled());
		fuelFilling3Bean.setFuelCost(bean.getFuelCost());
		fuelFilling3Bean.setFuelFilled(bean.getFuelFilled());
		if (bean.getMaximumFillings() != null) {
			fuelFilling3Bean.setMaximumFillings(bean.getMaximumFillings());
		}
		fuelFilling3Bean.setDate(bean.getDate());
		// set the style class for all the buttons
		fuelFilling3Bean.setPayBtnStyleClass("btn_login");
		fuelFilling3Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling3Bean.setUpdateBtnStyleClass("btn_gray");
		fuelFilling3Bean.setRefreshBtnStyleClass("btn_gray");
		fuelFilling3Bean.setRollBackBtnStyleClass("btn_login");
		fuelFilling3Bean.setClearBtnStyleClass("btn_login");
		fuelFilling3Bean.setAddBtnStyleClass("btn_gray");
		// set the mode for all the buttons
		fuelFilling3Bean.setPayBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setUpdateBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setRefreshBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setRollBackBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setClearBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setAddBtnDisable(Boolean.TRUE);
		// set the fields mode
		fuelFilling3Bean.setMaximumFillingsDisable(Boolean.TRUE);
		fuelFilling3Bean.setDateDisable(Boolean.TRUE);
		fuelFilling3Bean.setPresentReadingDisable(Boolean.TRUE);
		fuelFilling3Bean.setFuelCostDisable(Boolean.TRUE);
		fuelFilling3Bean.setFuelFilledDisable(Boolean.TRUE);
		fuelFilling3Bean.setCreditLimitDisable(Boolean.TRUE);
		if (fuelFilling3Bean.getPaymentMode().equals(1)) {
			// set the style class the add button
			fuelFilling3Bean.setAddBtnStyleClass("btn_login");
			// set the mode for the add button
			fuelFilling3Bean.setAddBtnDisable(Boolean.FALSE);
		}
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "refresh")
	public String refreshAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setDate("");
		fuelFilling3Bean.setPresentReading(0.0f);
		fuelFilling3Bean.setDistanceTraveled(0.0f);
		fuelFilling3Bean.setFuelCost(0.0f);
		fuelFilling3Bean.setFuelFilled(0.0f);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "rollBack")
	public String rollBackAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setErrorMessage("");
		// set the field values to previous values
		fuelFilling3Bean.setTotalFillings(fuelFilling3Bean.getTotalFillings() - 1);
		fuelFilling3Bean.setTotalFuelFilled(fuelFilling3Bean.getTotalFuelFilled() - fuelFilling3Bean.getFuelFilled());
		fuelFilling3Bean.setTotalDistanceTravelled(fuelFilling3Bean.getTotalDistanceTravelled() - fuelFilling3Bean.getDistanceTraveled());
		fuelFilling3Bean.setMileage(0f);
		fuelFilling3Bean.setAvgMileage(fuelFilling3Bean.getTotalDistanceTravelled() == 0 ? 0 : fuelFilling3Bean.getTotalDistanceTravelled() / fuelFilling3Bean.getTotalFuelFilled());
		fuelFilling3Bean.setPreviousReading(fuelFilling3Bean.getPresentReading() - fuelFilling3Bean.getDistanceTraveled());
		fuelFilling3Bean.setPresentReading(0f);
		fuelFilling3Bean.setDistanceTraveled(0f);
		fuelFilling3Bean.setFuelFilled(0f);
		fuelFilling3Bean.setDate("");
		fuelFilling3Bean.setFuelCost(0.0f);
		// set the mode of the fields
		fuelFilling3Bean.setDateDisable(Boolean.FALSE);
		fuelFilling3Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling3Bean.setFuelFilledDisable(Boolean.FALSE);
		// set the buttons styles
		fuelFilling3Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling3Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling3Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling3Bean.setRollBackBtnStyleClass("btn_gray");
		// set the buttons mode
		fuelFilling3Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setCreditAvailable((float) Math.round((fuelFilling3Bean.getCreditAvailable() - fuelFilling3Bean.getAmountReceived()) * 100) / 100);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "clear")
	public String clearAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		clear(request, fuelFilling3Bean);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "cancel")
	public String cancelAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		return "home";
	}

	@RequestMapping(value = "/addAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling3Bean addAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setErrorMessage("");
		// check the payment mode, if credit
		if (fuelFilling3Bean.getPaymentMode().equals(1)) {
			fuelFilling3Bean.setNetAmount(fuelFilling3Bean.getFuelFilled() * fuelFilling3Bean.getFuelCost());
			// check whether the bill amount <= credit available or not
			fuelFilling3Bean.setCreditAvailed((float) Math.round((fuelFilling3Bean.getCreditAvailed() + fuelFilling3Bean.getNetAmount()) * 100) / 100);
			fuelFilling3Bean.setCreditAvailable((float) Math.round((fuelFilling3Bean.getCreditAvailable() - fuelFilling3Bean.getNetAmount()) * 100) / 100);
			// fuelFilling3Bean.setCreditAvailable(creditAvailable);

		}
		// set the mode and styles of buttons
		fuelFilling3Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddNextBtnDisable(Boolean.FALSE);
		fuelFilling3Bean.setAddNextBtnStyleClass("btn_login");
		fuelFilling3Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling3Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddBtnStyleClass("btn_gray");
		fuelFilling3Bean.setAddBtnDisable(Boolean.TRUE);
		FuelFiling3Json json = new FuelFiling3Json();
		json.setDate(fuelFilling3Bean.getDate());
		json.setPreviousReading(fuelFilling3Bean.getPreviousReading());
		json.setPresentReading(fuelFilling3Bean.getPresentReading());
		json.setDistanceTraveled(fuelFilling3Bean.getDistanceTraveled());
		json.setFuelCost(fuelFilling3Bean.getFuelCost());
		json.setFuelFilled(fuelFilling3Bean.getFuelFilled());
		json.setBillAmount(fuelFilling3Bean.getNetAmount());
		json.setPayments(fuelFilling3Bean.getAmountReceived());
		// check whether the payment mode is cash or credit
		if (fuelFilling3Bean.getPaymentMode().equals(0)) {
			// cash Mode
			json.setAmountReturned(fuelFilling3Bean.getAmountToBeReturned());
		} else {
			// credit Mode
			json.setCreditLimit(fuelFilling3Bean.getCreditLimit());
			json.setCreditAvailed(fuelFilling3Bean.getCreditAvailed());
			json.setCreditAvailable(fuelFilling3Bean.getCreditAvailable());
		}
		List<FuelFiling3Json> list = fuelFilling3Bean.getFuelFiling3JsonList();
		list.add(json);
		fuelFilling3Bean.setFuelFiling3JsonList(list);

		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord(); i < ((fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord() + fuelFilling3Bean.getFuelFilling3GridBean().getCount()) > list.size() ? list.size()
				: (fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord() + fuelFilling3Bean.getFuelFilling3GridBean().getCount())); i++) {
			if (fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord() < list.size()) {
				fuelFilling3GridList.add(fuelFilling3Bean.getFuelFiling3JsonList().get(i));
			}
		}
		fuelFilling3Bean.setGridDiv(GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling3Bean.getGridColumnsJsonList(), list.size(), getCurrentPage(fuelFilling3Bean), fuelFilling3Bean.getFuelFilling3GridBean().getSortedColumnMap()));
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	@RequestMapping(value = "/onChangePresentReadingAction", method = RequestMethod.POST)
	public @ResponseBody FuelFilling3Bean onChangePresentReadingAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, FuelFilling3Bean bean) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setErrorMessage("");
		if (bean.getPresentReading() > fuelFilling3Bean.getPreviousReading()) {
			fuelFilling3Bean.setDistanceTraveled(bean.getPresentReading() - fuelFilling3Bean.getPreviousReading());
		} else {
			fuelFilling3Bean.setErrorMessage("Present Reading must be greater than Previous Reading");
		}
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	@RequestMapping(value = "/payBtnAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling3Bean payBtnAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setNetAmount(fuelFilling3Bean.getFuelFilled() * fuelFilling3Bean.getFuelCost());
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	@RequestMapping(value = "/paymentPopupOkAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling3Bean paymentPopupOkAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setPayMentPopupErrMsg(null);
		Float amountReceived = Float.parseFloat(request.getParameter("amountReceived"));
		// check the mode of the payment
		if (fuelFilling3Bean.getPaymentMode().equals(0)) {
			if (fuelFilling3Bean.getNetAmount() > amountReceived) {
				fuelFilling3Bean.setPayMentPopupErrMsg("Amount Received should be greater than or equal to Net Amount");
				return fuelFilling3Bean;
			}
		} else {
			if (fuelFilling3Bean.getNetAmount() > (amountReceived + fuelFilling3Bean.getCreditAvailable())) {
				fuelFilling3Bean.setPayMentPopupErrMsg("The sum of Amount Received and Credit Available amount should be greater than or equal to Net Amount");
				return fuelFilling3Bean;
			}
		}
		fuelFilling3Bean.setAmountReceived(amountReceived);
		fuelFilling3Bean.setAmountToBeReturned((float) Math.round((amountReceived - fuelFilling3Bean.getNetAmount()) * 100) / 100);
		// set the amount due value and credit available value to the bean
		// in credit payment mode
		fuelFilling3Bean.setAmountDue((float) Math.round(((fuelFilling3Bean.getAmountReceived() + fuelFilling3Bean.getCreditAvailable()) - fuelFilling3Bean.getNetAmount()) * 100) / 100);
		fuelFilling3Bean.setCreditAvailable((float) Math.round(((fuelFilling3Bean.getCreditAvailable() + fuelFilling3Bean.getAmountReceived())) * 100) / 100);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	@RequestMapping(value = "/onChangePaymentPopupAmtReceivedAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling3Bean onChangePaymentPopupAmtReceivedAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setPayMentPopupErrMsg(null);
		Float amountReceived = Float.parseFloat(request.getParameter("amountReceived"));
		// check the mode of the payment
		if (fuelFilling3Bean.getPaymentMode().equals(0)) {
			if (fuelFilling3Bean.getNetAmount() > amountReceived) {
				fuelFilling3Bean.setPayMentPopupErrMsg("Amount Received should be greater than or equal to Net Amount");
				return fuelFilling3Bean;
			}
		} else {
			if (fuelFilling3Bean.getNetAmount() > (amountReceived + fuelFilling3Bean.getCreditAvailable())) {
				fuelFilling3Bean.setPayMentPopupErrMsg("The sum of Amount Received and Credit Available amount should be greater than or equal to Net Amount");
				return fuelFilling3Bean;
			}
		}
		fuelFilling3Bean.setAmountReceived(amountReceived);
		fuelFilling3Bean.setAmountToBeReturned((float) Math.round((amountReceived - fuelFilling3Bean.getNetAmount()) * 100) / 100);
		// set the amount due value to the bean in credit mode
		fuelFilling3Bean.setAmountDue((float) Math.round(((fuelFilling3Bean.getAmountReceived() + fuelFilling3Bean.getCreditAvailable()) - fuelFilling3Bean.getNetAmount()) * 100) / 100);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	@RequestMapping(value = "/onChangePaymentModeRadioBtnAction/{selectedPaymentRadioBtn}", method = RequestMethod.GET)
	public String onChangePaymentModeRadioBtnAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable("selectedPaymentRadioBtn") Integer selectedPaymentRadioBtn) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setPaymentMode(selectedPaymentRadioBtn);
		clear(request, fuelFilling3Bean);
		gridInfoAction(request, fuelFilling3Bean);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return "fuelFilling3";
	}

	@RequestMapping(value = "/onChangeCreditLimitValueAction/{creditLimitValue:.+}", method = RequestMethod.GET)
	public @ResponseBody FuelFilling3Bean onChangeCreditLimitValueAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable("creditLimitValue") Float creditLimitValue) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		fuelFilling3Bean.setCreditLimit(creditLimitValue);
		fuelFilling3Bean.setCreditAvailable(creditLimitValue);
		model.addAttribute("fuelFilling3Bean", fuelFilling3Bean);
		return fuelFilling3Bean;
	}

	private void gridInfoAction(HttpServletRequest request, FuelFilling3Bean fuelFilling3Bean) {
		if (fuelFilling3Bean.getPaymentMode().equals(0)) {
			String[] grdColumnNames = { "Date", "Previous Reading", "Present Reading", "Distance Traveled", "Fuel Cost", "Fuel Filled", "Bill Amount", "Payments", "Amount Returned" };
			String[] grdFieldNames = { "date", "previousReading", "presentReading", "distanceTraveled", "fuelCost", "fuelFilled", "billAmount", "payments", "amountReturned" };
			String[] grdColumnWidths = { "10%", "10%", "10%", "10%", "10%", "10%", "10%", "10%", "10%" };
			TypeOfField[] grdColumnTypes = { TypeOfField.DATE, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER };
			List<GridColumnsJson> gridColumnsJsonList = new ArrayList<GridColumnsJson>();
			for (int i = 0; i < grdColumnNames.length; i++) {
				GridColumnsJson json = new GridColumnsJson();
				json.setContextPath(request.getContextPath());
				json.setColumnName(grdColumnNames[i]);
				json.setFieldName(grdFieldNames[i]);
				json.setColumnWidth(grdColumnWidths[i]);
				json.setTypeOfField(grdColumnTypes[i]);
				json.setIsNavigationBarRequired(Boolean.TRUE);
				json.setGridDivId("fuelFilling3GridId");
				json.setGridName("FuelFilling3Grid");
				json.setControllerName("FuelFilling3Controller");
				json.setIsSortingRequired(Boolean.TRUE);
				json.setGridWidth("90%");
				gridColumnsJsonList.add(json);
			}
			fuelFilling3Bean.setGridColumnsJsonList(gridColumnsJsonList);
			// fuelFilling3Bean.setGridDiv(GridDeveloper.developGridAction(null,
			// gridColumnsJsonList, 0));
		} else {
			String[] grdColumnNames = { "Date", "Previous Reading", "Present Reading", "Distance Traveled", "Fuel Cost", "Fuel Filled", "Bill Amount", "Payments", "Credit Limit", "Credit Availed", "Credit Available" };
			String[] grdFieldNames = { "date", "previousReading", "presentReading", "distanceTraveled", "fuelCost", "fuelFilled", "billAmount", "payments", "creditLimit", "creditAvailed", "creditAvailable" };
			String[] grdColumnWidths = { "9%", "9%", "9%", "9%", "9%", "9%", "9%", "9%", "9%", "9%", "9%" };
			TypeOfField[] grdColumnTypes = { TypeOfField.DATE, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER,
					TypeOfField.NUMBER };
			List<GridColumnsJson> gridColumnsJsonList = new ArrayList<GridColumnsJson>();
			for (int i = 0; i < grdColumnNames.length; i++) {
				GridColumnsJson json = new GridColumnsJson();
				json.setContextPath(request.getContextPath());
				json.setColumnName(grdColumnNames[i]);
				json.setFieldName(grdFieldNames[i]);
				json.setColumnWidth(grdColumnWidths[i]);
				json.setTypeOfField(grdColumnTypes[i]);
				json.setGridWidth("99%");
				json.setIsNavigationBarRequired(Boolean.TRUE);
				json.setGridDivId("fuelFilling3GridId");
				json.setGridName("FuelFilling3Grid");
				json.setIsSortingRequired(Boolean.TRUE);
				json.setControllerName("FuelFilling3Controller");
				gridColumnsJsonList.add(json);
			}
			fuelFilling3Bean.setGridColumnsJsonList(gridColumnsJsonList);
			// fuelFilling3Bean.setGridDiv(GridDeveloper.developGridAction(null,
			// gridColumnsJsonList, 0));
		}
	}

	@RequestMapping(value = "/onClickFuelFilling3GridNavigationAction/{id}")
	public @ResponseBody String onClickFuelFilling3GridNavigationAction(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id, ModelMap model) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		Integer count = fuelFilling3Bean.getFuelFilling3GridBean().getCount();
		Integer currentRecord = fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord();
		Integer listSize = fuelFilling3Bean.getFuelFiling3JsonList().size();
		Integer offSetValue = 0;
		// id.startsWith("f") ? 0 : id.startsWith("p") ? ((currentRecord -
		// count) < 0 ? 0 : (currentRecord - count)) : id.startsWith("n") ?
		// ((currentRecord + count) >= listSize ? currentRecord : (currentRecord
		// + count))
		// : (listSize - (listSize % count));

		if (id.startsWith("f")) {
			offSetValue = 0;
		} else if (id.startsWith("p")) {
			if ((currentRecord - count) < 0) {
				offSetValue = 0;
			} else {
				offSetValue = (currentRecord - count);
			}
		} else if (id.startsWith("n")) {
			if ((currentRecord + count) >= listSize) {
				offSetValue = currentRecord;
			} else {
				offSetValue = (currentRecord + count);
			}
		} else {
			offSetValue = listSize.equals(0) ? 0 : (listSize % count) == 0 ? (listSize - count) : (listSize - (listSize % count));
		}

		fuelFilling3Bean.getFuelFilling3GridBean().setCurrentRecord(offSetValue);
		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = offSetValue; i < ((offSetValue + count) > listSize ? listSize : (offSetValue + count)); i++) {
			if (offSetValue < listSize) {
				fuelFilling3GridList.add(fuelFilling3Bean.getFuelFiling3JsonList().get(i));
			}
		}
		String returnValue = GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling3Bean.getGridColumnsJsonList(), listSize, getCurrentPage(fuelFilling3Bean), fuelFilling3Bean.getFuelFilling3GridBean().getSortedColumnMap());
		fuelFilling3Bean.setGridDiv(returnValue);
		return returnValue;
	}

	public String getCurrentPage(FuelFilling3Bean fuelFilling3Bean) {
		Integer count = fuelFilling3Bean.getFuelFilling3GridBean().getCount();
		Integer listSize = fuelFilling3Bean.getFuelFiling3JsonList().size();
		Integer offSetValue = fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord();
		String currentRecordPage = listSize == 0 ? "" : "Page " + ((offSetValue / count) + 1) + " Of " + (listSize.equals(0) ? 1 : (listSize % count == 0) ? (listSize / count) : (listSize / count) + 1);
		return currentRecordPage;
	}

	@RequestMapping(value = "/onClickFuelFilling3GridSortingAction/{fieldValue}")
	public @ResponseBody String onClickSortingAction(HttpServletRequest request, HttpServletResponse response, @PathVariable("fieldValue") final String fieldValue, ModelMap model) {
		FuelFilling3Bean fuelFilling3Bean = (FuelFilling3Bean) request.getSession().getAttribute("fuelFilling3Bean");
		final Map<String, Integer> sortingMap = fuelFilling3Bean.getFuelFilling3GridBean().getSortingAscOrDescMap();
		if (sortingMap.get(fieldValue) == null) {
			sortingMap.put(fieldValue, 1);
		} else {
			sortingMap.put(fieldValue, sortingMap.get(fieldValue) + 1);
		}
		Collections.sort((List<FuelFiling3Json>) fuelFilling3Bean.getFuelFiling3JsonList(), new Comparator<FuelFiling3Json>() {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public int compare(FuelFiling3Json o1, FuelFiling3Json o2) {
				Field[] fields = FuelFiling3Json.class.getDeclaredFields();
				Field fieldName = null;
				for (Field field : fields) {
					field.setAccessible(true);
					if (field.getName().equalsIgnoreCase(fieldValue)) {
						fieldName = field;
						break;
					}
				}

				Comparable comparable1 = null;
				Comparable comparable2 = null;
				try {
					comparable1 = (Comparable) fieldName.get(o1);
					comparable2 = (Comparable) fieldName.get(o2);
				} catch (Exception e) {
					e.printStackTrace();
				}

				if (sortingMap.get(fieldValue) % 2 == 0) {
					return comparable1.compareTo(comparable2);
				} else {
					return comparable2.compareTo(comparable1);
				}
			}

		});
		Integer count = fuelFilling3Bean.getFuelFilling3GridBean().getCount();
		Integer listSize = fuelFilling3Bean.getFuelFiling3JsonList().size();
		Integer offSetValue = fuelFilling3Bean.getFuelFilling3GridBean().getCurrentRecord();
		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = offSetValue; i < ((offSetValue + count) > listSize ? listSize : (offSetValue + count)); i++) {
			if (offSetValue < listSize) {
				fuelFilling3GridList.add(fuelFilling3Bean.getFuelFiling3JsonList().get(i));
			}
		}
		fuelFilling3Bean.getFuelFilling3GridBean().getSortedColumnMap().clear();
		fuelFilling3Bean.getFuelFilling3GridBean().getSortedColumnMap().put(fieldValue, sortingMap.get(fieldValue));
		String returnValue = GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling3Bean.getGridColumnsJsonList(), fuelFilling3Bean.getFuelFiling3JsonList().size(), getCurrentPage(fuelFilling3Bean), fuelFilling3Bean.getFuelFilling3GridBean()
				.getSortedColumnMap());
		fuelFilling3Bean.setGridDiv(returnValue);
		return returnValue;
	}
}
