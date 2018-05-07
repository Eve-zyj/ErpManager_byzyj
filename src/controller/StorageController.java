package controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pojo.Storage;
import service.StorageService;
import tools.Constants;
import tools.PageUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class StorageController {
	@Autowired
	private StorageService storageService;
	//显示页面
	@RequestMapping("/index.html")
	public String showIndex(){
		return "storage";
	}

	//判断商品名称是否存在
	@RequestMapping("/exist.do")
	@ResponseBody
	public Object existName(@RequestParam String commdityName){
		int row = storageService.existName(commdityName);
		System.out.println("======================================"+row);
		if(row!=0){
			return "{\"result\":\"exist\"}";//
		}else{
			return "{\"result\":\"noexist\"}";
		}
	}
	//添加库存
	@RequestMapping("/add.do")
	@ResponseBody
	public Object addDo(@RequestParam String commodityName,@RequestParam String warehouseNo,@RequestParam String supplier,@RequestParam String specifications,@RequestParam String specificationUnit,@RequestParam String number,@RequestParam String Unit,@RequestParam String price,@RequestParam String storagDate,@RequestParam String remarks){

		Date date = new Date();
		int num = 0;
		try {
			num=Integer.parseInt(number);
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		Storage storage = new Storage(warehouseNo,commodityName,supplier,specifications,specificationUnit,num,Unit,price,date,remarks);
		int row = storageService.addStorage(storage);

		if(row==1){
			return "{\"result\":\"ok\",\"warehouseNo\":\""+storage.getWarehouseNo()+"\",\"commodityName\":\""+storage.getCommodityName()+"\"}";//{"":"","":"","":""}
			//return "{\"result\":\"ok\"}";
		}else{
			return "{\"result\":\"no\"}";
		}
	}

	//得到商品编号和当前时间
	@RequestMapping("/num.do")
	@ResponseBody
	public Object numDo(){
		int num = storageService.getCount();//得到商品数量
		num = num +1;//得到下一个要加入库存的商品的id
		String warehouseNo = "";//得到商品编号
		StringBuffer sb = new StringBuffer("TY");
		int numLength= String.valueOf(num).length();//得到编号的长度
		for (int i = numLength; i < 8; i++) {
			sb.append("0");
		}
		warehouseNo=sb+String.valueOf(num);//商品编号
		Date day=new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("============================="+df.format(day));
		String time = df.format(day);
		return "{\"warehouseNo\":\""+warehouseNo+"\",\"storagDate\":\""+time+"\"}";
	}
	//分页
	@RequestMapping("/page.do")
	@ResponseBody
	public ModelAndView getList(ModelAndView modelAndView, PageUtils pageUtils){
		pageUtils.setPageSize(Constants.pageSize);
		pageUtils.setTotalCount(storageService.getCount());
		pageUtils.count();
		pageUtils.setList(storageService.getStorages(pageUtils));
		modelAndView.addObject("page",pageUtils);
		modelAndView.setViewName("list");
		return modelAndView;
	}

	/**
	 * 查看商品信息
	 * @return
	 */
	@RequestMapping("/view.do")
	@ResponseBody
	public Object showView(PageUtils pageUtils){
		Storage storage = storageService.getStorages(pageUtils).get(0);
		System.out.println(storage);
		return JSON.toJSONString(storage);
	}
}
