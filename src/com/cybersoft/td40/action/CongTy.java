package com.cybersoft.td40.action;
import java.util.ArrayList;
import java.util.Scanner;

import com.cybersoft.td40.object.GiamDoc;
import com.cybersoft.td40.object.NhanSu;
import com.cybersoft.td40.object.NhanVienThuong;
import com.cybersoft.td40.object.TruongPhong;

public class CongTy {
	// 1. attr
	protected String tenCongTy;
	protected String maSoThue;
	protected float doanhThu;
	protected DanhSachNhanSu objDSNS;

	// 2. get,set
	public String getTenCongTy() {
		return tenCongTy;
	}

	public void setTenCongTy(String tenCongTy) {
		this.tenCongTy = tenCongTy;
	}

	public String getMaSoThue() {
		return maSoThue;
	}

	public void setMaSoThue(String maSoThue) {
		this.maSoThue = maSoThue;
	}

	public DanhSachNhanSu getObjDSNS() {
		return objDSNS;
	}

	public void setObjDSNS(DanhSachNhanSu objDSNS) {
		this.objDSNS = objDSNS;
	}

	public float getDoanhThu() {
		return doanhThu;
	}

	public void setDoanhThu(float doanhThu) {
		this.doanhThu = doanhThu;
	}

	// 3. consructor
	public CongTy() {
		this.objDSNS = new DanhSachNhanSu();
	}

	// 4. in,out
	public void nhap(Scanner scan) {
		System.out.println("Nhập tên công ty: ");
		this.tenCongTy = scan.nextLine();
		System.out.println("Nhập mã số thuế: ");
		this.maSoThue = scan.nextLine();
		System.out.println("Nhập doanh thu: ");
		this.doanhThu = Float.parseFloat(scan.nextLine());
	}

	public void xuat() {
		System.out.println("=============================");
		System.out.println(" Tên: " + this.tenCongTy + "\n Mã số thuế: " + this.maSoThue + "\n Doanh Thu: " + this.doanhThu);
		System.out.println("=============================");
		System.out.println("============ Danh sách nhân sự ============");
		this.objDSNS.xuat();
		System.out.println("\n=============================\n");
	}
	// 5. bussiness
	public void dummyData() {
		this.objDSNS.dumyData();
	}
	
	public void inMenu() {
		System.out.println("Chọn loại nhân sự muốn thêm");
		System.out.println("1- Nhân viên thường");
		System.out.println("2- Trưởng phòng");
		System.out.println("3- Giám đốc");
		System.out.println("0- Thoát");
	}

	public void themNhanSu(Scanner scan) {
		boolean flag = true;
		NhanSu ns;
		do {
			inMenu();
			int chon;
			System.out.println("Bạn chọn >>");
			chon = Integer.parseInt(scan.nextLine());
			switch (chon) {
			case 1:
				ns = new NhanVienThuong();
				ns.nhap(scan);
				ns.tinhLuong();
				this.objDSNS.themNhanSu(ns);
				break;
			case 2:
				ns = new TruongPhong();
				ns.nhap(scan);
				ns.tinhLuong();
				this.objDSNS.themNhanSu(ns);
				break;
			case 3:
				ns = new GiamDoc();
				ns.nhap(scan);
				ns.tinhLuong();
				this.objDSNS.themNhanSu(ns);
				break;
			case 0:
				flag = false;
				break;
			default:
				System.out.println("Nhập 0-3 thôi");
			}
		} while (flag);
	}
	
	public void tinhLuong() {
		for(NhanSu ns: this.objDSNS.getDsNhanSu()) {
			ns.tinhLuong();
		}
	}
	
	public void phanBoNhanVienMoi(Scanner scan) {
		ArrayList<NhanVienThuong> listNv = objDSNS.getDsNhanVienThuongChuaDuocPhanBo();
		ArrayList<TruongPhong> listTp = objDSNS.getDsTruongPhong();
		for (NhanVienThuong nv : listNv) {
			System.out.println("============ Phân bổ nhân viên ============");
			nv.xuat();
			System.out.println("\nPhân bổ? (Y/N) ");
			if (scan.nextLine().equalsIgnoreCase("N"))
				continue;
			System.out.println("Danh sách trưởng phòng: ");
			for (TruongPhong tp : listTp)
				tp.xuat();
			System.out.println("\nMã trưởng phòng: ");
			String maTp = scan.nextLine();
			for (TruongPhong tp : listTp)
				if (tp.getMaSo().equalsIgnoreCase(maTp)) {
					nv.setTruongPhong(tp);
					tp.tangNhanVien();
					System.out.println("============ Kết quả ============");
					nv.xuat();
					tp.xuat();
					System.out.println("=================================");
					break;
				}
			
		}
	}
	/* Chức năng phân bổ nhân viên
	 * Bước 1: Duyệt danh sách nhân sự
	 * Bước 2: Kiểm tra có phải nhân viên thường
	 * Bước 3: in mã và tên
	 * Bước 4: Hỏi có muốn chỉ định trưởng phòng quản lý hay không
	 * Bước 5: In danh sách trưởng phòng (mã và tên)
	 * Bước 6: Cho người dùng chọn mã trưởng phòng
	 * Bước 7: Lấy trưởng phòng tương ứng mã vừa nhập
	 * Bước 8: Sét trưởng phòng trong Nhân viên đang duyệt là trưởng phòng bước 7
	 * Bước 9: Tăng số lượng nhân viên dưới quyền cho Trưởng phòng trên
	 * Bước 10: Lập lại bước 2
	 * */
}
