package com.cybersoft.td40.object;

public class NhanVienThuong extends NhanSu {
	private final int LUONG1NGAY = 100;
	// 1. attr
	protected TruongPhong truongPhong;

	// 2. get,set
	public TruongPhong getTruongPhong() {
		return truongPhong;
	}

	public void setTruongPhong(TruongPhong truongPhong) {
		this.truongPhong = truongPhong;
	}

	// 3. constructor
	public NhanVienThuong() {
		truongPhong = null; // Chưa được quản lý bởi ai
	}

	public NhanVienThuong(String maSo, String hoTen, String sdt, float soNgayLam) {
		super(hoTen, maSo, sdt, soNgayLam);
		// TODO Auto-generated constructor stub
	}

	// 4. in,out
	@Override
	public void xuat() {
		super.xuat();
		if (this.truongPhong != null) {
			System.out.println("\tĐược quản lý bởi: " + this.truongPhong.getHoTen() + "\tMã người QL: "
					+ this.truongPhong.getMaSo() + "\tLương: " + this.luong);
		} else
			System.out.print("\tLương: " + this.luong + "\tChưa được quản lý bởi ai");

	}
	// 5.bussiness
	@Override
	public void tinhLuong() {
		this.luong = this.soNgayLam * LUONG1NGAY;
	}
}
