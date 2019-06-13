package com.Luo.bean;

public class Supply {
    private String warehouseId;

    private String shopId;

    private String comId;

    private Integer supplyNum;
    
    private Warehouse warehouse;
    
    private Shop shop;
    
    private Commodity commodity;
    
    

    public Warehouse getWarehouse() {
		return warehouse;
	}

	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Commodity getCommodity() {
		return commodity;
	}

	public void setCommodity(Commodity commodity) {
		this.commodity = commodity;
	}

	public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId == null ? null : shopId.trim();
    }

    public String getComId() {
        return comId;
    }

    public void setComId(String comId) {
        this.comId = comId == null ? null : comId.trim();
    }

    public Integer getSupplyNum() {
        return supplyNum;
    }

    public void setSupplyNum(Integer supplyNum) {
        this.supplyNum = supplyNum;
    }
}