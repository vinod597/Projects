package com.pbsi.fuelfilling.controller;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
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

import com.pbsi.fuelfilling.bean.FuelFilling4Bean;
import com.pbsi.fuelfilling.bean.GridBean;
import com.pbsi.fuelfilling.bean.RadioButtonBean;
import com.pbsi.fuelfilling.grid.GridColumnsJson;
import com.pbsi.fuelfilling.grid.GridBuilder;
import com.pbsi.fuelfilling.grid.TypeOfField;
import com.pbsi.fuelfilling.json.FuelFiling3Json;
import com.pbsi.fuelfilling.json.FuelFiling4Json;

@Controller
@RequestMapping("/FuelFilling4Controller")
public class FuelFilling4Controller {
	@RequestMapping(method = RequestMethod.GET)
	public String init(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		HttpSession session = request.getSession();
		FuelFilling4Bean fuelFilling4Bean = new FuelFilling4Bean();
		fuelFilling4Bean.setPaymentMode(0);
		clear(request, fuelFilling4Bean);

		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		session.setAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	/**
	 * This method is to clear all the field values and set the default mode for
	 * all the fields and buttons.
	 */
	public void clear(HttpServletRequest request, FuelFilling4Bean fuelFilling4Bean) {
		GridBean gridBean = new GridBean();
		gridBean.setCurrentRecord(0);
		gridBean.setCount(3);
		gridBean.getSortedColumnMap().clear();
		fuelFilling4Bean.setFuelFilling3GridBean(gridBean);
		List<FuelFiling4Json> fuelFiling3JsonList = new ArrayList<FuelFiling4Json>();
		Map<String, List<FuelFiling3Json>> yearWiseRecordsMap = new HashMap<String, List<FuelFiling3Json>>();
		fuelFilling4Bean.setYearWiseRecordsMap(yearWiseRecordsMap);
		fuelFilling4Bean.setFuelFiling4JsonList(fuelFiling3JsonList);
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
		fuelFilling4Bean.setPaymentModeList(paymentModeList);
		// set the default values for all the fields
		fuelFilling4Bean.setMaximumFillings(0);
		fuelFilling4Bean.setDate("");
		fuelFilling4Bean.setPreviousReading(0.0f);
		fuelFilling4Bean.setPresentReading(0.0f);
		fuelFilling4Bean.setDistanceTraveled(0.0f);
		fuelFilling4Bean.setFuelCost(0.0f);
		fuelFilling4Bean.setFuelFilled(0.0f);
		fuelFilling4Bean.setTotalFillings(0);
		fuelFilling4Bean.setTotalFuelFilled(0.0f);
		fuelFilling4Bean.setTotalDistanceTravelled(0.0f);
		fuelFilling4Bean.setMileage(0.0f);
		fuelFilling4Bean.setAvgMileage(0.0f);
		fuelFilling4Bean.setCreditAvailable(0.0f);
		fuelFilling4Bean.setCreditAvailed(0.0f);
		fuelFilling4Bean.setCreditLimit(0.0f);
		fuelFilling4Bean.setNetAmount(0.0f);
		fuelFilling4Bean.setPaymentCreditAvailed(0.0f);
		fuelFilling4Bean.setAmountReceived(0.0f);
		fuelFilling4Bean.setAmountDue(0.0f);
		fuelFilling4Bean.setAmountToBeReturned(0.0f);
		// set the default style class for all the buttons
		fuelFilling4Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling4Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling4Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling4Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling4Bean.setClearBtnStyleClass("btn_gray");
		fuelFilling4Bean.setCancelBtnStyleClass("btn_login");
		fuelFilling4Bean.setAddBtnStyleClass("btn_gray");
		fuelFilling4Bean.setDiscountBtnStyleClass("btn_login");
		// set the default mode for all the buttons
		fuelFilling4Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setClearBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setCancelBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setAddBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setDiscountBtnDisable(Boolean.FALSE);
		// set the default values for the payment pop-up values
		fuelFilling4Bean.setBillAmount(0.0f);
		fuelFilling4Bean.setAmountToBeReturned(0.0f);
		fuelFilling4Bean.setAmountReceived(0.0f);
		fuelFilling4Bean.setPaymentCreditAvailed(0.0f);
		fuelFilling4Bean.setAmountDue(0.0f);
		// set the default mode for all the fields
		fuelFilling4Bean.setMaximumFillingsDisable(Boolean.FALSE);
		fuelFilling4Bean.setDateDisable(Boolean.FALSE);
		fuelFilling4Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelFilledDisable(Boolean.FALSE);
		fuelFilling4Bean.setCreditLimitDisable(Boolean.FALSE);
		// set the grid list to zero
		gridInfoAction(request, fuelFilling4Bean);
		fuelFilling4Bean.setGridDiv(GridBuilder.developGridAction(fuelFilling4Bean.getFuelFiling4JsonList(), fuelFilling4Bean.getGridColumnsJsonList(), fuelFilling4Bean.getFuelFiling4JsonList().size(), getCurrentPage(fuelFilling4Bean), fuelFilling4Bean
				.getFuelFilling3GridBean().getSortedColumnMap()));

		fuelFilling4Bean.setMaxDiscountAllowed(0.0f);
		fuelFilling4Bean.setBillAmountExceeds(0.0f);
		fuelFilling4Bean.setAllowDiscount(0.0f);
		fuelFilling4Bean.setMonthlyBillAmountExceeds(0.0f);
		fuelFilling4Bean.setMonthlyDiscount(0.0f);
		fuelFilling4Bean.setYearlyBillAmountExceeds(0.0f);
		fuelFilling4Bean.setYearlyDiscount(0.0f);
		fuelFilling4Bean.setTotalDiscount(0.0f);

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
	public String addNextAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		// set the style class for all the buttons
		fuelFilling4Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling4Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling4Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling4Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling4Bean.setClearBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddBtnStyleClass("btn_gray");
		// set the mode for all the buttons
		fuelFilling4Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setClearBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setAddBtnDisable(Boolean.TRUE);
		// set the value for the field values
		fuelFilling4Bean.setDate("");
		fuelFilling4Bean.setPreviousReading(fuelFilling4Bean.getPresentReading());
		fuelFilling4Bean.setPresentReading(0.0f);
		fuelFilling4Bean.setDistanceTraveled(0.0f);
		fuelFilling4Bean.setFuelCost(0.0f);
		fuelFilling4Bean.setFuelFilled(0.0f);
		// set the fields mode
		fuelFilling4Bean.setDateDisable(Boolean.FALSE);
		fuelFilling4Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelFilledDisable(Boolean.FALSE);
		// set the payment pop-up values
		fuelFilling4Bean.setAmountReceived(0.0f);
		fuelFilling4Bean.setAmountDue(0.0f);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	/**
	 * This method is to perform update Action.
	 * 
	 * @param request
	 * @param response
	 * @param model
	 * @param fuelFilling4Bean
	 * @return
	 */
	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "update")
	public String updateAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setErrorMessage("");
		// find out the empty fields to generate error messages

		// perform calculations for update Action
		fuelFilling4Bean.setTotalFillings(fuelFilling4Bean.getTotalFillings() + 1);
		fuelFilling4Bean.setTotalFuelFilled(fuelFilling4Bean.getTotalFuelFilled() + bean.getFuelFilled());
		fuelFilling4Bean.setTotalDistanceTravelled(fuelFilling4Bean.getTotalDistanceTravelled() + fuelFilling4Bean.getDistanceTraveled());
		fuelFilling4Bean.setMileage(fuelFilling4Bean.getDistanceTraveled() / bean.getFuelFilled());
		fuelFilling4Bean.setAvgMileage(fuelFilling4Bean.getTotalDistanceTravelled() / fuelFilling4Bean.getTotalFuelFilled());
		fuelFilling4Bean.setPresentReading(bean.getPresentReading());
		// fuelFilling4Bean.setDistanceTraveled(bean.getDistanceTraveled());
		fuelFilling4Bean.setFuelCost(bean.getFuelCost());
		fuelFilling4Bean.setFuelFilled(bean.getFuelFilled());
		if (bean.getMaximumFillings() != null) {
			fuelFilling4Bean.setMaximumFillings(bean.getMaximumFillings());
		}
		fuelFilling4Bean.setDate(bean.getDate());
		// set the style class for all the buttons
		fuelFilling4Bean.setPayBtnStyleClass("btn_login");
		fuelFilling4Bean.setAddNextBtnStyleClass("btn_gray");
		fuelFilling4Bean.setUpdateBtnStyleClass("btn_gray");
		fuelFilling4Bean.setRefreshBtnStyleClass("btn_gray");
		fuelFilling4Bean.setRollBackBtnStyleClass("btn_login");
		fuelFilling4Bean.setClearBtnStyleClass("btn_login");
		fuelFilling4Bean.setAddBtnStyleClass("btn_gray");
		// set the mode for all the buttons
		fuelFilling4Bean.setPayBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setAddNextBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setUpdateBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setRefreshBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setRollBackBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setClearBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setAddBtnDisable(Boolean.TRUE);
		// set the fields mode
		fuelFilling4Bean.setMaximumFillingsDisable(Boolean.TRUE);
		fuelFilling4Bean.setDateDisable(Boolean.TRUE);
		fuelFilling4Bean.setPresentReadingDisable(Boolean.TRUE);
		fuelFilling4Bean.setFuelCostDisable(Boolean.TRUE);
		fuelFilling4Bean.setFuelFilledDisable(Boolean.TRUE);
		fuelFilling4Bean.setCreditLimitDisable(Boolean.TRUE);
		if (fuelFilling4Bean.getPaymentMode().equals(1)) {
			// set the style class the add button
			fuelFilling4Bean.setAddBtnStyleClass("btn_login");
			// set the mode for the add button
			fuelFilling4Bean.setAddBtnDisable(Boolean.FALSE);
		}
		fuelFilling4Bean.setBillAmount(fuelFilling4Bean.getFuelFilled() * fuelFilling4Bean.getFuelCost());
		fuelFilling4Bean.setNetAmount(getNetAmountAfterDiscount(fuelFilling4Bean));
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "refresh")
	public String refreshAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setDate("");
		fuelFilling4Bean.setPresentReading(0.0f);
		fuelFilling4Bean.setDistanceTraveled(0.0f);
		fuelFilling4Bean.setFuelCost(0.0f);
		fuelFilling4Bean.setFuelFilled(0.0f);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "rollBack")
	public String rollBackAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setErrorMessage("");
		// set the field values to previous values
		fuelFilling4Bean.setTotalFillings(fuelFilling4Bean.getTotalFillings() - 1);
		fuelFilling4Bean.setTotalFuelFilled(fuelFilling4Bean.getTotalFuelFilled() - fuelFilling4Bean.getFuelFilled());
		fuelFilling4Bean.setTotalDistanceTravelled(fuelFilling4Bean.getTotalDistanceTravelled() - fuelFilling4Bean.getDistanceTraveled());
		fuelFilling4Bean.setMileage(0f);
		fuelFilling4Bean.setAvgMileage(fuelFilling4Bean.getTotalDistanceTravelled() == 0 ? 0 : fuelFilling4Bean.getTotalDistanceTravelled() / fuelFilling4Bean.getTotalFuelFilled());
		fuelFilling4Bean.setPreviousReading(fuelFilling4Bean.getPresentReading() - fuelFilling4Bean.getDistanceTraveled());
		fuelFilling4Bean.setPresentReading(0f);
		fuelFilling4Bean.setDistanceTraveled(0f);
		fuelFilling4Bean.setFuelFilled(0f);
		fuelFilling4Bean.setDate("");
		fuelFilling4Bean.setFuelCost(0.0f);
		// set the mode of the fields
		fuelFilling4Bean.setDateDisable(Boolean.FALSE);
		fuelFilling4Bean.setPresentReadingDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelCostDisable(Boolean.FALSE);
		fuelFilling4Bean.setFuelFilledDisable(Boolean.FALSE);
		// set the buttons styles
		fuelFilling4Bean.setUpdateBtnStyleClass("btn_login");
		fuelFilling4Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling4Bean.setRefreshBtnStyleClass("btn_login");
		fuelFilling4Bean.setRollBackBtnStyleClass("btn_gray");
		// set the buttons mode
		fuelFilling4Bean.setUpdateBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setRefreshBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setCreditAvailable(fuelFilling4Bean.getCreditAvailable() - fuelFilling4Bean.getAmountReceived());
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "clear")
	public String clearAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		clear(request, fuelFilling4Bean);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	@RequestMapping(value = "/submitAction", method = RequestMethod.POST, params = "cancel")
	public String cancelAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		return "home";
	}

	@RequestMapping(value = "/addAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling4Bean addAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @ModelAttribute FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setErrorMessage("");
		// check the payment mode, if credit
		if (fuelFilling4Bean.getPaymentMode().equals(1)) {
			// fuelFilling4Bean.setNetAmount(fuelFilling4Bean.getFuelFilled() *
			// fuelFilling4Bean.getFuelCost());
			// check whether the bill amount <= credit available or not
			fuelFilling4Bean.setCreditAvailed((float) Math.round((fuelFilling4Bean.getCreditAvailed() + fuelFilling4Bean.getNetAmount()) * 100) / 100);
			fuelFilling4Bean.setCreditAvailable((float) Math.round((fuelFilling4Bean.getCreditAvailable() - fuelFilling4Bean.getNetAmount()) * 100) / 100);
			// fuelFilling4Bean.setCreditAvailable(creditAvailable);

		}
		// set the mode and styles of buttons
		fuelFilling4Bean.setRollBackBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setRollBackBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddNextBtnDisable(Boolean.FALSE);
		fuelFilling4Bean.setAddNextBtnStyleClass("btn_login");
		fuelFilling4Bean.setPayBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setPayBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddBtnStyleClass("btn_gray");
		fuelFilling4Bean.setAddBtnDisable(Boolean.TRUE);
		FuelFiling4Json json = new FuelFiling4Json();
		json.setDate(fuelFilling4Bean.getDate());
		json.setPreviousReading(fuelFilling4Bean.getPreviousReading());
		json.setPresentReading(fuelFilling4Bean.getPresentReading());
		json.setDistanceTraveled(fuelFilling4Bean.getDistanceTraveled());
		json.setFuelCost(fuelFilling4Bean.getFuelCost());
		json.setFuelFilled(fuelFilling4Bean.getFuelFilled());
		json.setBillAmount(fuelFilling4Bean.getBillAmount());
		json.setPayments(fuelFilling4Bean.getAmountReceived());
		json.setNetAmount(fuelFilling4Bean.getNetAmount());
		json.setDiscounts(fuelFilling4Bean.getTotalDiscount());
		String[] selectedDateinStringArray = fuelFilling4Bean.getDate().split("/");

		if (fuelFilling4Bean.getYearWiseRecordsMap().get(selectedDateinStringArray[2]) != null) {
			fuelFilling4Bean.getYearWiseRecordsMap().get(selectedDateinStringArray[2]).add(json);
		} else {
			List<FuelFiling3Json> cashdtoList = new ArrayList<FuelFiling3Json>();
			cashdtoList.add(json);
			fuelFilling4Bean.getYearWiseRecordsMap().put(selectedDateinStringArray[2], cashdtoList);
		}

		// check whether the payment mode is cash or credit
		if (fuelFilling4Bean.getPaymentMode().equals(0)) {
			// cash Mode
			json.setAmountReturned(fuelFilling4Bean.getAmountToBeReturned());
		} else {
			// credit Mode
			json.setCreditLimit(fuelFilling4Bean.getCreditLimit());
			json.setCreditAvailed(fuelFilling4Bean.getCreditAvailed());
			json.setCreditAvailable(fuelFilling4Bean.getCreditAvailable());
		}
		List<FuelFiling4Json> list = fuelFilling4Bean.getFuelFiling4JsonList();
		list.add(json);
		fuelFilling4Bean.setFuelFiling4JsonList(list);
		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord(); i < ((fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord() + fuelFilling4Bean.getFuelFilling3GridBean().getCount()) > list.size() ? list.size()
				: (fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord() + fuelFilling4Bean.getFuelFilling3GridBean().getCount())); i++) {
			if (fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord() < list.size()) {
				fuelFilling3GridList.add(fuelFilling4Bean.getFuelFiling4JsonList().get(i));
			}
		}
		fuelFilling4Bean.setGridDiv(GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling4Bean.getGridColumnsJsonList(), list.size(), getCurrentPage(fuelFilling4Bean), fuelFilling4Bean.getFuelFilling3GridBean().getSortedColumnMap()));
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/onChangePresentReadingAction", method = RequestMethod.POST)
	public @ResponseBody FuelFilling4Bean onChangePresentReadingAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, FuelFilling4Bean bean) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setErrorMessage("");
		if (bean.getPresentReading() > fuelFilling4Bean.getPreviousReading()) {
			fuelFilling4Bean.setDistanceTraveled(bean.getPresentReading() - fuelFilling4Bean.getPreviousReading());
		} else {
			fuelFilling4Bean.setErrorMessage("Present Reading must be greater than Previous Reading");
		}
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/payBtnAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling4Bean payBtnAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/paymentPopupOkAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling4Bean paymentPopupOkAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setPayMentPopupErrMsg(null);
		Float amountReceived = Float.parseFloat(request.getParameter("amountReceived"));
		// check the mode of the payment
		if (fuelFilling4Bean.getPaymentMode().equals(0)) {
			if (fuelFilling4Bean.getNetAmount() > amountReceived) {
				fuelFilling4Bean.setPayMentPopupErrMsg("Amount Received should be greater than or equal to Net Amount");
			}
		} else {
			if (fuelFilling4Bean.getNetAmount() > (amountReceived + fuelFilling4Bean.getCreditAvailable())) {
				fuelFilling4Bean.setPayMentPopupErrMsg("Amount Received + Credit Available amount should be greater than or equal to Net Amount");
			}
		}
		fuelFilling4Bean.setAmountReceived(amountReceived);
		fuelFilling4Bean.setAmountToBeReturned((float) Math.round((amountReceived - fuelFilling4Bean.getNetAmount()) * 100) / 100);
		// set the amount due value and credit available value to the bean
		// in credit payment mode
		fuelFilling4Bean.setAmountDue((float) Math.round(((fuelFilling4Bean.getAmountReceived() + fuelFilling4Bean.getCreditAvailable()) - fuelFilling4Bean.getNetAmount()) * 100) / 100);
		fuelFilling4Bean.setCreditAvailable((float) Math.round(((fuelFilling4Bean.getCreditAvailable() + fuelFilling4Bean.getAmountReceived())) * 100) / 100);

		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/onChangePaymentPopupAmtReceivedAction", method = RequestMethod.GET)
	public @ResponseBody FuelFilling4Bean onChangePaymentPopupAmtReceivedAction(HttpServletRequest request, HttpServletResponse response, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setPayMentPopupErrMsg(null);
		Float amountReceived = Float.parseFloat(request.getParameter("amountReceived"));
		// check the mode of the payment
		if (fuelFilling4Bean.getPaymentMode().equals(0)) {
			if (fuelFilling4Bean.getNetAmount() > amountReceived) {
				fuelFilling4Bean.setPayMentPopupErrMsg("Amount Received should be greater than or equal to Net Amount");
			}
		} else {
			if (fuelFilling4Bean.getNetAmount() > (amountReceived + fuelFilling4Bean.getCreditAvailable())) {
				fuelFilling4Bean.setPayMentPopupErrMsg("Amount Received + Credit Available amount should be greater than or equal to Net Amount");
			}
		}
		fuelFilling4Bean.setAmountReceived(amountReceived);
		fuelFilling4Bean.setAmountToBeReturned((float) Math.round((amountReceived - fuelFilling4Bean.getNetAmount()) * 100) / 100);
		// set the amount due value to the bean in credit mode
		fuelFilling4Bean.setAmountDue((float) Math.round(((fuelFilling4Bean.getAmountReceived() + fuelFilling4Bean.getCreditAvailable()) - fuelFilling4Bean.getNetAmount()) * 100) / 100);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/onChangePaymentModeRadioBtnAction/{selectedPaymentRadioBtn}", method = RequestMethod.GET)
	public String onChangePaymentModeRadioBtnAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable("selectedPaymentRadioBtn") Integer selectedPaymentRadioBtn) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setPaymentMode(selectedPaymentRadioBtn);
		clear(request, fuelFilling4Bean);
		// gridInfoAction(request, fuelFilling4Bean);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return "fuelFilling4";
	}

	@RequestMapping(value = "/onChangeCreditLimitValueAction/{creditLimitValue:.+}", method = RequestMethod.GET)
	public @ResponseBody FuelFilling4Bean onChangeCreditLimitValueAction(HttpServletRequest request, HttpServletResponse response, ModelMap model, @PathVariable("creditLimitValue") Float creditLimitValue) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setCreditLimit(creditLimitValue);
		fuelFilling4Bean.setCreditAvailable(creditLimitValue);
		model.addAttribute("fuelFilling4Bean", fuelFilling4Bean);
		return fuelFilling4Bean;
	}

	private void gridInfoAction(HttpServletRequest request, FuelFilling4Bean fuelFilling4Bean) {
		if (fuelFilling4Bean.getPaymentMode().equals(0)) {
			String[] grdColumnNames = { "Date", "Previous Reading", "Present Reading", "Distance Traveled", "Fuel Cost", "Fuel Filled", "Bill Amount", "Discounts", "Net Amount", "Payments", "Amount Returned" };
			String[] grdFieldNames = { "date", "previousReading", "presentReading", "distanceTraveled", "fuelCost", "fuelFilled", "billAmount", "discounts", "netAmount", "payments", "amountReturned" };
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
				json.setIsNavigationBarRequired(Boolean.TRUE);
				json.setGridDivId("fuelFilling4GridId");
				json.setGridName("FuelFilling4Grid");
				json.setIsSortingRequired(Boolean.TRUE);
				json.setControllerName("FuelFilling4Controller");
				json.setGridWidth("99%");
				gridColumnsJsonList.add(json);
			}
			fuelFilling4Bean.setGridColumnsJsonList(gridColumnsJsonList);
			// fuelFilling4Bean.setGridDiv(GridDeveloper.developGridAction(null,
			// gridColumnsJsonList, 0));
		} else {
			String[] grdColumnNames = { "Date", "Previous Reading", "Present Reading", "Distance Traveled", "Fuel Cost", "Fuel Filled", "Bill Amount", "Discounts", "Net Amount", "Payments", "Credit Limit", "Credit Availed", "Credit Available" };
			String[] grdFieldNames = { "date", "previousReading", "presentReading", "distanceTraveled", "fuelCost", "fuelFilled", "billAmount", "discounts", "netAmount", "payments", "creditLimit", "creditAvailed", "creditAvailable" };
			String[] grdColumnWidths = { "7%", "8%", "8%", "8%", "8%", "8%", "8%", "8%", "7%", "7%", "7%", "7%", "8%" };
			TypeOfField[] grdColumnTypes = { TypeOfField.DATE, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER,
					TypeOfField.NUMBER, TypeOfField.NUMBER, TypeOfField.NUMBER };
			List<GridColumnsJson> gridColumnsJsonList = new ArrayList<GridColumnsJson>();
			for (int i = 0; i < grdColumnNames.length; i++) {
				GridColumnsJson json = new GridColumnsJson();
				json.setContextPath(request.getContextPath());
				json.setColumnName(grdColumnNames[i]);
				json.setFieldName(grdFieldNames[i]);
				json.setColumnWidth(grdColumnWidths[i]);
				json.setTypeOfField(grdColumnTypes[i]);
				json.setGridWidth("99%");
				json.setIsSortingRequired(Boolean.TRUE);
				json.setIsNavigationBarRequired(Boolean.TRUE);
				json.setGridDivId("fuelFilling4GridId");
				json.setGridName("FuelFilling4Grid");
				json.setControllerName("FuelFilling4Controller");
				gridColumnsJsonList.add(json);
			}
			fuelFilling4Bean.setGridColumnsJsonList(gridColumnsJsonList);
			// fuelFilling4Bean.setGridDiv(GridDeveloper.developGridAction(null,
			// gridColumnsJsonList, 0));
		}
	}

	@RequestMapping(value = "/discountPopupOkAction", method = RequestMethod.POST)
	public @ResponseBody FuelFilling4Bean discountPopupOkAction(HttpServletRequest request, HttpServletResponse response, FuelFilling4Bean bean, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		fuelFilling4Bean.setMaxDiscountAllowed(bean.getMaxDiscountAllowed());
		fuelFilling4Bean.setBillAmountExceeds(bean.getBillAmountExceeds());
		fuelFilling4Bean.setAllowDiscount(bean.getAllowDiscount());
		fuelFilling4Bean.setMonthlyBillAmountExceeds(bean.getMonthlyBillAmountExceeds());
		fuelFilling4Bean.setMonthlyDiscount(bean.getMonthlyDiscount());
		fuelFilling4Bean.setYearlyBillAmountExceeds(bean.getYearlyBillAmountExceeds());
		fuelFilling4Bean.setYearlyDiscount(bean.getYearlyDiscount());
		fuelFilling4Bean.setDiscountBtnDisable(Boolean.TRUE);
		fuelFilling4Bean.setDiscountBtnStyleClass("btn_gray");
		return fuelFilling4Bean;
	}

	@RequestMapping(value = "/onClickFuelFilling4GridNavigationAction/{id}")
	public @ResponseBody String onClickFuelFilling3GridNavigationAction(HttpServletRequest request, HttpServletResponse response, @PathVariable("id") String id, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		Integer count = fuelFilling4Bean.getFuelFilling3GridBean().getCount();
		Integer currentRecord = fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord();
		Integer listSize = fuelFilling4Bean.getFuelFiling4JsonList().size();
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
		fuelFilling4Bean.getFuelFilling3GridBean().setCurrentRecord(offSetValue);
		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = offSetValue; i < ((offSetValue + count) > listSize ? listSize : (offSetValue + count)); i++) {
			if (offSetValue < listSize) {
				fuelFilling3GridList.add(fuelFilling4Bean.getFuelFiling4JsonList().get(i));
			}
		}
		String returnValue = GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling4Bean.getGridColumnsJsonList(), listSize, getCurrentPage(fuelFilling4Bean), fuelFilling4Bean.getFuelFilling3GridBean().getSortedColumnMap());
		fuelFilling4Bean.setGridDiv(returnValue);
		return returnValue;
	}

	public Float getNetAmountAfterDiscount(FuelFilling4Bean fuelFilling4Bean) {
		Float yearlyBillAmount = 0.0f, monthlyBillAmount = 0.0f;
		String[] selectedDateinStringArray = fuelFilling4Bean.getDate().split("/");
		List<FuelFiling3Json> fuelFiling3JsonList = fuelFilling4Bean.getYearWiseRecordsMap().get(selectedDateinStringArray[2]);
		if (fuelFiling3JsonList != null && fuelFiling3JsonList.size() > 0) {
			Map<String, List<FuelFiling3Json>> cashMonthDTOMap = new HashMap<String, List<FuelFiling3Json>>();
			for (FuelFiling3Json json : fuelFiling3JsonList) {
				// This is for yearly-wise
				yearlyBillAmount += json.getBillAmount();
				String[] recordDateInStringArray = json.getDate().split("/");

				if (cashMonthDTOMap.get(recordDateInStringArray[1]) != null) {
					cashMonthDTOMap.get(recordDateInStringArray[1]).add(json);
				} else {
					List<FuelFiling3Json> list = new ArrayList<FuelFiling3Json>();
					list.add(json);
					cashMonthDTOMap.put(recordDateInStringArray[1], list);
				}
			}
			yearlyBillAmount += fuelFilling4Bean.getBillAmount();
			// This is monthly-wise
			if (cashMonthDTOMap.get(selectedDateinStringArray[1]) != null && cashMonthDTOMap.get(selectedDateinStringArray[1]).size() > 0) {
				monthlyBillAmount += fuelFilling4Bean.getBillAmount();
				for (FuelFiling3Json json : cashMonthDTOMap.get(selectedDateinStringArray[1])) {
					monthlyBillAmount += json.getBillAmount();
				}
			}
		}

		Float netAmount = findNetAmountByDiscountsAction(fuelFilling4Bean, yearlyBillAmount, monthlyBillAmount);
		netAmount = (float) Math.round((netAmount) * 100) / 100;
		return netAmount;
	}

	public Float findNetAmountByDiscountsAction(FuelFilling4Bean fuelFilling4Bean, Float yearlyBillAmount, Float monthlyBillAmount) {
		Float totalDiscount = 0.0f;

		if (fuelFilling4Bean.getBillAmount() >= fuelFilling4Bean.getYearlyBillAmountExceeds() || yearlyBillAmount >= fuelFilling4Bean.getYearlyBillAmountExceeds()) {
			totalDiscount += fuelFilling4Bean.getYearlyDiscount();

		}
		if (fuelFilling4Bean.getBillAmount() >= fuelFilling4Bean.getMonthlyBillAmountExceeds() || monthlyBillAmount >= fuelFilling4Bean.getMonthlyBillAmountExceeds()) {
			totalDiscount += fuelFilling4Bean.getMonthlyDiscount();
		}
		if (fuelFilling4Bean.getBillAmount() >= fuelFilling4Bean.getBillAmountExceeds()) {
			totalDiscount += fuelFilling4Bean.getAllowDiscount();
		}

		if (totalDiscount > fuelFilling4Bean.getMaxDiscountAllowed()) {
			totalDiscount = fuelFilling4Bean.getMaxDiscountAllowed();
		}
		fuelFilling4Bean.setTotalDiscount(totalDiscount);
		return (fuelFilling4Bean.getBillAmount() - (fuelFilling4Bean.getBillAmount() * totalDiscount / 100));

	}

	public String getCurrentPage(FuelFilling4Bean fuelFilling4Bean) {
		Integer count = fuelFilling4Bean.getFuelFilling3GridBean().getCount();
		Integer listSize = fuelFilling4Bean.getFuelFiling4JsonList().size();
		Integer offSetValue = fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord();
		String currentRecordPage = listSize == 0 ? "" : "Page " + ((offSetValue / count) + 1) + " Of " + (listSize.equals(0) ? 1 : (listSize % count == 0) ? (listSize / count) : (listSize / count) + 1);
		return currentRecordPage;
	}

	@RequestMapping(value = "/onClickFuelFilling4GridSortingAction/{fieldValue}")
	public @ResponseBody String onClickSortingAction(HttpServletRequest request, HttpServletResponse response, @PathVariable("fieldValue") final String fieldValue, ModelMap model) {
		FuelFilling4Bean fuelFilling4Bean = (FuelFilling4Bean) request.getSession().getAttribute("fuelFilling4Bean");
		final Map<String, Integer> sortingMap = fuelFilling4Bean.getFuelFilling3GridBean().getSortingAscOrDescMap();
		if (sortingMap.get(fieldValue) == null) {
			sortingMap.put(fieldValue, 1);
		} else {
			sortingMap.put(fieldValue, sortingMap.get(fieldValue) + 1);
		}
		Collections.sort((List<FuelFiling4Json>) fuelFilling4Bean.getFuelFiling4JsonList(), new Comparator<FuelFiling4Json>() {

			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public int compare(FuelFiling4Json o1, FuelFiling4Json o2) {
				Field[] fields1 = FuelFiling4Json.class.getSuperclass().getDeclaredFields();
				Field[] fields2 = FuelFiling4Json.class.getDeclaredFields();
				Field[] fields = new Field[(fields1.length + fields2.length)];
				for (int i = 0; i < fields1.length; i++) {
					fields[i] = fields1[i];
				}
				for (int i = 0; i < fields2.length; i++) {
					fields[(fields1.length + i)] = fields2[i];
				}
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
		Integer count = fuelFilling4Bean.getFuelFilling3GridBean().getCount();
		Integer listSize = fuelFilling4Bean.getFuelFiling4JsonList().size();
		Integer offSetValue = fuelFilling4Bean.getFuelFilling3GridBean().getCurrentRecord();
		List<FuelFiling3Json> fuelFilling3GridList = new ArrayList<FuelFiling3Json>();
		for (int i = offSetValue; i < ((offSetValue + count) > listSize ? listSize : (offSetValue + count)); i++) {
			if (offSetValue < listSize) {
				fuelFilling3GridList.add(fuelFilling4Bean.getFuelFiling4JsonList().get(i));
			}
		}
		fuelFilling4Bean.getFuelFilling3GridBean().getSortedColumnMap().clear();
		fuelFilling4Bean.getFuelFilling3GridBean().getSortedColumnMap().put(fieldValue, sortingMap.get(fieldValue));
		String returnValue = GridBuilder.developGridAction(fuelFilling3GridList, fuelFilling4Bean.getGridColumnsJsonList(), fuelFilling4Bean.getFuelFiling4JsonList().size(), getCurrentPage(fuelFilling4Bean), fuelFilling4Bean.getFuelFilling3GridBean()
				.getSortedColumnMap());
		fuelFilling4Bean.setGridDiv(returnValue);
		return returnValue;
	}
}
