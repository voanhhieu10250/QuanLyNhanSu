package com.cybersoft.td40.action;
import java.util.Scanner;

import com.cybersoft.td40.object.NhanSu;
import com.cybersoft.td40.object.NhanVienThuong;

public class XuLy {

	public static void main(String[] args) {
//		CongTy ct = new CongTy();
//		Scanner scan = new Scanner(System.in);
//		ct.dummyData();
//		ct.phanBoNhanVienMoi(scan);
		
//		System.out.println(NhanSu.getMaSoTuDong());
//		System.out.println(NhanSu.getMaSoTuDong());
//		System.out.println(NhanSu.getMaSoTuDong());
//		System.out.println(NhanSu.getMaSoTuDong());
		
		CongTy cty = new CongTy();
		NhanSu ns = new NhanVienThuong("1", "Chè", "098", 28);
		cty.getObjDSNS().themNhanSuTuDong(ns);
		ns = new NhanVienThuong("1", "Bưởi", "115", 28);
		cty.getObjDSNS().themNhanSuTuDong(ns);
		ns = new NhanVienThuong();
		cty.getObjDSNS().themNhanSuTuDong(ns);
		ns = new NhanVienThuong("1", "Bưởi", "", 28);
		cty.getObjDSNS().themNhanSuTuDong(ns);
		cty.xuat();
	}	

}
