package com.cybersoft.td40.action;
import java.util.ArrayList;

import com.cybersoft.td40.object.GiamDoc;
import com.cybersoft.td40.object.NhanSu;
import com.cybersoft.td40.object.NhanVienThuong;
import com.cybersoft.td40.object.TruongPhong;

public class DanhSachNhanSu {
	//1. attr
	private ArrayList<NhanSu> dsNhanSu;
	//2. get,set

	public ArrayList<NhanSu> getDsNhanSu() {
		return dsNhanSu;
	}

	public void setDaNhanSu(ArrayList<NhanSu> dsNhanSu) {
		this.dsNhanSu = dsNhanSu;
	}
	
	//3. constructor
	public DanhSachNhanSu() {
		this.dsNhanSu = new ArrayList<NhanSu>();
	}
	
	//4. in,out
	public void dumyData() {
		NhanSu ns;
		ns = new NhanVienThuong("1", "bưởi", "090", 28);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("2", "chuối", "091", 22);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("3", "xoài", "092", 26);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("4", "mận", "093", 22);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("5", "cam", "094", 25);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("6", "bom", "095", 21);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("7", "táo", "096", 20);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("8", "nho", "097", 19);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("9", "thơm", "098", 18);
		this.dsNhanSu.add(ns);
		ns = new NhanVienThuong("10", "chanh", "099", 26);
		this.dsNhanSu.add(ns);
		
		ns = new TruongPhong("11", "TP 1", "0981", 12);
		this.dsNhanSu.add(ns);
		ns = new TruongPhong("12", "TP 2", "0982", 12);
		this.dsNhanSu.add(ns);
		ns = new TruongPhong("13", "TP 3", "0983", 12);
		this.dsNhanSu.add(ns);
		ns = new TruongPhong("14", "TP 4", "0984", 12);
		this.dsNhanSu.add(ns);
		ns = new TruongPhong("15", "TP 5", "0985", 12);
		this.dsNhanSu.add(ns);
		
		ns = new GiamDoc("16", "GD 1", "09861", 13, 0.6f);
		this.dsNhanSu.add(ns);
		ns = new GiamDoc("17", "GD 2", "09862", 16, 0.4f);
		this.dsNhanSu.add(ns);
	}
	
	public void xuat() {
		for(NhanSu ns: this.dsNhanSu) {
			ns.xuat();
		}
	}
	//5. bussiness
	public void themNhanSu(NhanSu ns) {
		//validate
		
		//1. kiểm tra null -> nếu null xuất thông báo lỗi
		if (ns == null) {
			System.out.println("Dữ liệu đâu ???");
			return;
		}
		//2. kiểm tra mã số -> xuất thông báo lỗi
		if (ns.getMaSo() == null) {
			System.out.println("Nhân sự không có mã số");
			return;
		} else if (checkDuplicateId(ns.getMaSo())) {
			System.out.println("Mã nhân sự đã tồn tại");
		}
		//3. thêm 
		this.dsNhanSu.add(ns);
		
//		this.xoaNhanSuBangMaSo(null); cái này để check coi nếu truyền null vào hàm xóa coi có lỗi không
	}
	
	public void themNhanSuTuDong(NhanSu ns) {
		//validate
		
		//1. kiểm tra null -> nếu null xuất thông báo lỗi
		if (ns == null) {
			System.out.println("Dữ liệu đâu ???");
			return;
		}
		//2. kiểm tra 
		if (checkDuplicateNhanSu(ns)) {
			System.out.println("Nhân sự đã tồn tại");
			return;
		}
		//3. thêm 
		ns.setMaSo(NhanSu.getMaSoTuDong());
		this.dsNhanSu.add(ns);
	}
	
	public boolean xoaNhanSuBangMaSo(String maSo) {
		if(maSo == null) 
			return false;	
		
		for (NhanSu ns : dsNhanSu) {
			if (ns.getMaSo().equalsIgnoreCase(maSo)) {
				if (ns instanceof NhanVienThuong 
						&& ((NhanVienThuong) ns).getTruongPhong() != null) 
					((NhanVienThuong)ns).getTruongPhong().giamNhanVien();
				
				if (ns instanceof TruongPhong) {
					// xóa liên kết với các nhân viên dưới quyền
					//1. tìm nhân viên trưởng phòng này quản lý
					for (NhanSu nv : dsNhanSu) {
						if (nv instanceof NhanVienThuong) {
							TruongPhong tp = ((NhanVienThuong) nv).getTruongPhong();
							if (tp != null 
									&& tp.getMaSo().equalsIgnoreCase(ns.getMaSo())) {
								//2. xóa liên kết
								((NhanVienThuong) nv).setTruongPhong(null);
							}
						}
					}
				}
				dsNhanSu.remove(ns);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<NhanVienThuong> getDsNhanVienThuong(){
		ArrayList<NhanVienThuong> resultList = new ArrayList<NhanVienThuong>();
		for (NhanSu ns : dsNhanSu)
			if (ns instanceof NhanVienThuong)
				resultList.add((NhanVienThuong)ns);
		return resultList;
	}
	
	public ArrayList<NhanVienThuong> getDsNhanVienThuongChuaDuocPhanBo(){
		ArrayList<NhanVienThuong> resultList = new ArrayList<NhanVienThuong>();
		for (NhanSu ns : dsNhanSu)
			if (ns instanceof NhanVienThuong 
					&& ((NhanVienThuong) ns).getTruongPhong() == null)
				resultList.add((NhanVienThuong)ns);
		return resultList;
	}
	
	private boolean checkDuplicateId(String Id) {
		int maxLength = dsNhanSu.size();
		for (int i = 0; i < maxLength; i++) {
			NhanSu ns = dsNhanSu.get(i);
			if (ns.getMaSo().equalsIgnoreCase(Id))
			return true;
		}
		return false;
	}
	
	public ArrayList<TruongPhong> getDsTruongPhong(){
		ArrayList<TruongPhong> resultList = new ArrayList<TruongPhong>();
		for (NhanSu ns : dsNhanSu)
			if (ns instanceof TruongPhong)
				resultList.add((TruongPhong)ns);
		return resultList;
	}
	
	private boolean checkDuplicateNhanSu(NhanSu ns) {
		for(NhanSu nv : dsNhanSu) {
			if (generateKey(nv).equalsIgnoreCase(generateKey(ns)))
				return true;
		}
		return false;
	}
	
	private String generateKey(NhanSu ns) {
		return ns.getHoTen() + ns.getSdt();
	}
}
