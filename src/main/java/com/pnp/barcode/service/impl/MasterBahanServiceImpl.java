package com.pnp.barcode.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pnp.barcode.dao.MasterBahanDao;
import com.pnp.barcode.dao.impl.MasterBahanDaoImpl;
import com.pnp.barcode.model.MasterBahan;
import com.pnp.barcode.service.MasterBahanService;

@Service("masterBahanService")
public class MasterBahanServiceImpl implements MasterBahanService{
	
	private MasterBahanDao masterBahanDao = new MasterBahanDaoImpl();
	
	public List<MasterBahan> getAllMasterBahan() {
		// TODO Auto-generated method stub
		return masterBahanDao.getAllBahan();
	}

	public Long rowCount() {
		// TODO Auto-generated method stub
		return null;
	}

	
	

}
