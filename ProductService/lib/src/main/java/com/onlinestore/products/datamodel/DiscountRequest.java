package com.onlinestore.products.datamodel;

import java.util.Map;

//"productId" : 1,
//"strategyName": "BuyOneGetOne"
// "params" : {
//	"productId" : 2
//}

public class DiscountRequest {

	private long productId;

	private String strategyName;

	private Map<String, Object> strategyParams;

	/**
	 * @return the productId
	 */
	public long getProductId() {
		return productId;
	}

	/**
	 * @param productId
	 *            the productId to set
	 */
	public void setProductId(long productId) {
		this.productId = productId;
	}

	/**
	 * @return the strategyName
	 */
	public String getStrategyName() {
		return strategyName;
	}

	/**
	 * @param strategyName
	 *            the strategyName to set
	 */
	public void setStrategyName(String strategyName) {
		this.strategyName = strategyName;
	}

	/**
	 * @return the strategyParams
	 */
	public Map<String, Object> getStrategyParams() {
		return strategyParams;
	}

	/**
	 * @param strategyParams
	 *            the strategyParams to set
	 */
	public void setStrategyParams(Map<String, Object> strategyParams) {
		this.strategyParams = strategyParams;
	}

}
