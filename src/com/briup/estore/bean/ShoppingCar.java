package com.briup.estore.bean;

import java.util.HashMap;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
/**
 * 购物车 （订单项）
 * */
public class ShoppingCar {
	// key 商品id value 订单项（商品，数量）
	private Map<Long, Line> map = new HashMap<Long, Line>();
	
	public Map<Long, Line> getMap() {
		return map;
	}
	public void setMap(Map<Long, Line> map) {
		this.map = map;
	}
	/**
	 * 向购物车中添加产品
	 * 先判断购物车中有没有该产品的订单项目，如果有，在数量上做改变，
	 * 如果没有向map中添加
	 * @param line
	 */
	public void add(Line line){
		if(map.containsKey(line.getBook().getId())){
			Line oldline = map.get(line.getBook().getId());
			oldline.setNum(oldline.getNum()+1);
		}else{
			line.setNum(1);
			map.put(line.getBook().getId(), line);
		}
	}
	/**
	 * 删除订单
	 * */
	public void delete(Long bookId){
		map.remove(bookId);
	}
	/**
	 * 获取价钱
	 * */
	public double getCost(){
		Set<Long> keySet = map.keySet();
		Iterator<Long> iter = keySet.iterator();
		double cost = 0.0;
		while(iter.hasNext()){
			Long key = iter.next();
			Line value = map.get(key);
			Integer num = value.getNum();
			double price = value.getBook().getPrice();
			double lineCost = num*price;
			cost += lineCost;
		}
		return cost;
	}
	/**
	 * 获取购物车中所有订单项
	 * List<Line>
	 * */
	public Map<Long, Line> getLines(){
		return map;
	}
	/**
	 * 清空购物车
	 * */
	public void clear(){
		map.clear();
	}
	
}
