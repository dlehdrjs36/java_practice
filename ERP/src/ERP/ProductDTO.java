package ERP;

public class ProductDTO {
	// 상품정보
	int Pkey;
	String Pname;
	String Explanation;
	int B_stock;
	int price;
	
	// 입출고정보
	int SRkey;
	//int Pkey;
	int Store; // 입고
	int Release; // 출고
	//String Storagename; 
	String SR_date; // 입출고한 날짜.
	
	// 재고정보
	//int Pkey;
	//String Storagename;
	int C_stock;
	
	// 창고정보
	String Storagename;
	//String Explanation;

	
	public int getPkey() {
		return Pkey;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public void setPkey(int pkey) {
		Pkey = pkey;
	}

	public String getPname() {
		return Pname;
	}

	public void setPname(String pname) {
		Pname = pname;
	}

	public String getExplanation() {
		return Explanation;
	}

	public void setExplanation(String explanation) {
		Explanation = explanation;
	}

	public int getB_stock() {
		return B_stock;
	}

	public void setB_stock(int b_stock) {
		B_stock = b_stock;
	}

	public int getSRkey() {
		return SRkey;
	}

	public void setSRkey(int sRkey) {
		SRkey = sRkey;
	}

	public int getStore() {
		return Store;
	}

	public void setStore(int store) {
		Store = store;
	}

	public int getRelease() {
		return Release;
	}

	public void setRelease(int release) {
		Release = release;
	}

	public String getSR_date() {
		return SR_date;
	}

	public void setSR_date(String sR_date) {
		SR_date = sR_date;
	}

	public int getC_stock() {
		return C_stock;
	}

	public void setC_stock(int c_stock) {
		C_stock = c_stock;
	}

	public String getStoragename() {
		return Storagename;
	}

	public void setStoragename(String storagename) {
		Storagename = storagename;
	}


}
