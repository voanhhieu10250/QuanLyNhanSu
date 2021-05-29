package com.cybersoft.td40.object;

public class TruongPhong extends NhanSu{
	private final int LUONG1NGAY = 200;
	// 1. attr
	protected int soNhanVienDuoiQuyen = 0;
	protected final int PHU_CAP = 100;
	
	//2. get,set
	public int getSoNhanVienDuoiQuyen() {
		return soNhanVienDuoiQuyen;
	}
	
	//3. constructor
	public TruongPhong() {
		
	}

	public TruongPhong(String maSo, String hoTen, String sdt, float soNgayLam) {
		super(hoTen, maSo, sdt, soNgayLam);
		
	}

	//4. in,out
	@Override
	public void xuat() {
		super.xuat();
		System.out.print("\tNhân viên dưới quyền: " + this.soNhanVienDuoiQuyen + "\tLương: " + this.luong);
	}
	
	//5. bussiness
	@Override
	public void tinhLuong() {
		this.luong = this.LUONG1NGAY * this.soNgayLam + this.soNhanVienDuoiQuyen * this.PHU_CAP; 
	}
	
	public void tangNhanVien() {
		this.soNhanVienDuoiQuyen++;
	}

	public void giamNhanVien() {
		this.soNhanVienDuoiQuyen--;
	}
}
