package com.mkyong.common;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mkyong.stock.bo.StockBo;
import com.mkyong.stock.model.Stock;

public class App 
{
    public static void main( String[] args )
    {
    	ApplicationContext appContext = 
    		new ClassPathXmlApplicationContext("spring/config/BeanLocations.xml");
	
    	StockBo stockBo = (StockBo)appContext.getBean("stockBo");
    	
    	/** insert **/
		System.out.println("***** 1111 *******");
		Stock stock = new Stock();
		stock.setStockId(new Long("1"));
    	stock.setStockCode("7668");
    	stock.setStockName("HAIO");
		System.out.println("***** 2222 *******");
		System.out.println(stock.toString());
		stockBo.save(stock);
		System.out.println("***** 3333 *******");
    	
    	/** select **/
    	Stock stock2 = stockBo.findByStockCode("7668");
    	System.out.println(stock2);
    	
    	/** update **/
    	stock2.setStockName("HAIO-1");
    	stockBo.update(stock2);
    	
    	/** delete **/
    	//stockBo.delete(stock2);
    	
    	System.out.println("Done");
    }
}
