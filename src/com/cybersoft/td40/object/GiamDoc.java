package com.cybersoft.td40.object;
import java.util.Scanner;

public class GiamDoc extends NhanSu {
	private final int LUONG1NGAY = 300;
	//1. attr
	protected float coPhan;
	
	//2. get,set
	public float getCoPhan() {
		return coPhan;
	}

	public void setCoPhan(float coPhan) {
		this.coPhan = coPhan;
	}
	
	//3. constructor
	public GiamDoc() {
		
	}

	public GiamDoc(String maSo, String hoTen, String sdt, float soNgayLam, float soCoPhan) {
		super(hoTen, maSo, sdt, soNgayLam);
		this.coPhan = soCoPhan;
		
	}
	
	//4. in,out
	@Override
	public void nhap(Scanner scan) {
		super.nhap(scan);
		System.out.println("Nhập số cổ phần: ");
		this.coPhan = Float.parseFloat(scan.nextLine());
	}
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\tSố cổ phần: " + this.getCoPhan() + "\tLương: " + this.luong);
	}
	//5. bussiness
	@Override
	public void tinhLuong() {
		this.luong = this.LUONG1NGAY * this.soNgayLam;//+ this.coPhan * this.doanhThu;
	}
}
