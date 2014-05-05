package com.you.junit;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;
import com.you.DBUtil.SQLUtil;
import com.you.bean.ChuanGanData;
import com.you.bean.ChuanGanModel;
import com.you.bean.ControlModel;

public class Test1 {

//	@Test
//	public void test() {
//		SQLUtil sql = new SQLUtil();
//		sql.getAll();
//	}

	@Test
	public void test1(){
		
		
		SQLUtil sql = new SQLUtil();
//		ArrayList<ChuanGanData> c = (ArrayList<ChuanGanData>)sql.getLastChuanGanDataById(16);
//		System.out.println(c.get(0).getYanWu());
		ArrayList<ChuanGanModel> al1 = (ArrayList)sql.getChuanGanModel();
		for(int i=0;i<al1.size();i++){
 			
			
	 			ChuanGanData  cgd = (ChuanGanData)SQLUtil.getLastChuanGanDataById(SQLUtil.getChuanGanModel().get(i).getChuanGanId()).get(0);
	 			System.out.println(cgd.getYanWu());
	}
}
}
