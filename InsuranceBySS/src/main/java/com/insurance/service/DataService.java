package com.insurance.service;

import java.util.List;

import com.insurance.bean.ZipBean;

public interface DataService {
	public List<ZipBean> getList();
	public List<String> getZipList(String zip);
	public List<ZipBean> getZipData(String zip);
}
