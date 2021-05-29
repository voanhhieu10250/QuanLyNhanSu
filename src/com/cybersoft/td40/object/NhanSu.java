package com.cybersoft.td40.object;
import java.time.OffsetDateTime;
import java.util.Scanner;

/*
 * Quản lý: nhân sự
 * Người tạo:
 * Ngày tạo:
 * Version: 
 * */
public class NhanSu {
	//1. attr
	protected static int maSoTuTang = 1;
	
	protected String hoTen;
	protected String maSo;
	protected String sdt;
	protected float soNgayLam;
	protected float luong;
	
	public static String getMaSoTuDong() {
		String maSo = "NS";
		maSo = maSo + OffsetDateTime.now().getYear();
		maSo += maSoTuTang++;
		return maSo;
	}
	
	//2. get,set
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getMaSo() {
		return maSo;
	}
	public void setMaSo(String maSo) {
		this.maSo = maSo;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public float getSoNgayLam() {
		return soNgayLam;
	}
	public void setSoNgayLam(float soNgayLam) {
		this.soNgayLam = soNgayLam;
		this.tinhLuong();
	}
	
	
	//3. constructor
	public NhanSu() {
		
	}
	public NhanSu(String hoTen, String maSo, String sdt, float soNgayLam) {
		super();
		this.hoTen = hoTen;
		this.maSo = maSo;
		this.sdt = sdt;
		this.soNgayLam = soNgayLam;
	}
	//4. in,out
	public void nhap(Scanner scan) {
		System.out.println("Mời nhập mã: ");
		this.maSo = scan.nextLine();
		System.out.println("Mời nhập tên: ");
		this.hoTen = scan.nextLine();
		System.out.println("Mời nhập số điện thoại: ");
		this.sdt = scan.nextLine();
		System.out.println("Mời nhập số ngày làm: ");
		this.soNgayLam = Float.parseFloat(scan.nextLine());
	}
	
	public void xuat() {
		System.out.print("\nMã: " + this.maSo + "\tTên: " + this.hoTen + "\tSĐT: " + this.sdt + "\tSố ngày làm: " + this.soNgayLam);
	}
	
	//5. bussiness methods
	public void tinhLuong() {
		
	}
}
