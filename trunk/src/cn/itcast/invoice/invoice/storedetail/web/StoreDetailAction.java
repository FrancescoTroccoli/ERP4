package cn.itcast.invoice.invoice.storedetail.web;

import java.util.List;

import cn.itcast.invoice.invoice.storedetail.business.ebi.StoreDetailEbi;
import cn.itcast.invoice.invoice.storedetail.vo.StoreDetailModel;
import cn.itcast.invoice.invoice.storedetail.vo.StoreDetailQueryModel;
import cn.itcast.invoice.util.base.BaseAction;

public class StoreDetailAction extends BaseAction{
	public StoreDetailModel sm = new StoreDetailModel();
	public StoreDetailQueryModel sqm = new StoreDetailQueryModel();

	private StoreDetailEbi storeDetailEbi;
	public void setStoreDetailEbi(StoreDetailEbi storeDetailEbi) {
		this.storeDetailEbi = storeDetailEbi;
	}

	//跳转到列表页面
	public String list(){
		setDataTotal(storeDetailEbi.getCount(sqm));
		List<StoreDetailModel> storeDetailList = storeDetailEbi.getAll(sqm,pageNum,pageCount);
		put("storeDetailList",storeDetailList);
		return LIST;
	}

	//保存/修改
	public String save(){
		if(sm.getUuid()== null){
			storeDetailEbi.save(sm);
		}else{
			storeDetailEbi.update(sm);
		}
		return TO_LIST;
	}

	//跳转到添加/修改页面
	public String input(){
		if(sm.getUuid()!=null){
			sm = storeDetailEbi.get(sm.getUuid());
		}
		return INPUT;
	}

	//删除
	public String delete(){
		storeDetailEbi.delete(sm);
		return TO_LIST;
	}

}
