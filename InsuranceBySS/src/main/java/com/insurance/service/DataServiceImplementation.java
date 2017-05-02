package com.insurance.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.insurance.dao.DataDao;
import com.insurance.bean.ZipBean;

public class DataServiceImplementation implements DataService{
	@Autowired  
	 DataDao dataDao;  
	public List<ZipBean> getList() {
		 return dataDao.getList();  
	}
	public List<String> getZipList(String zip) {
		
		return dataDao.getZipList(zip);
	}
	public List<ZipBean> getZipData(String zip) {
		return dataDao.getZipData(zip);
	}

}
