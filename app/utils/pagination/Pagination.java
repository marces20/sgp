package utils.pagination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import play.mvc.Controller;
import play.mvc.Http.Request;
import utils.RequestVar;

import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.Page;
import com.avaje.ebean.PagingList;

public class Pagination<T> implements Page<T> {
	private Request request = Controller.request();
	private Integer pageNum;
	private Page<T> page;
	private Integer pageSize = 25;
	private Integer totalRowCount;
	private String sortBy;
	private String sortByDefault;
	private String order;
	private String orderDefault;
	
	public Boolean parcheCountAllFormula = false;
	private Map<String, String> queryMap = new HashMap<String, String>();
	
	public Pagination() {
		for(Entry<String, String[]> entry : request.queryString().entrySet()) {
			queryMap.put(entry.getKey(), entry.getValue()[0]);
		}
	}
	
	public String getNextLink(){
		queryMap.put("pageNum", String.valueOf(this.getPageNum() + 1));
		return getLink(queryMap);
	}
	
	public String getPrevLink(){
		queryMap.put("pageNum",  String.valueOf(this.getPageNum() - 1));
		return getLink(queryMap);
	}
	
	public String getCurrentLink(){
		return getLink(queryMap);
	}
	
	public Map<String, String> getQueryMap(){
		return queryMap;
	}
	
	public Pagination setVar(String var, String value){
		queryMap.put(var, value);
		return this;
	}
	
	private String getLink(Map<String, String> map){
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		for(Entry<String, String> entry : map.entrySet()) {
			params.add(new BasicNameValuePair(entry.getKey(), entry.getValue()));
		}
		return URLEncodedUtils.format(params, "UTF-8");
	}
	
	public void setExpressionList(ExpressionList<T> expressionList){
		this.page = expressionList.orderBy(getSortBy() + " " + getOrder()).findPagingList(this.getPageSize())
	        .setFetchAhead(false)
	        .getPage(this.getPageNum());
		System.out.println("+++++++++ "+getSortBy() + " " + getOrder());

	}
	
	public String getOrder() {
		this.order = request.getQueryString("order");
		if(this.order == null) {
			this.order = this.orderDefault;
		}

		return this.order;
	}

	public void setOrderDefault(String orderDefault) {
		this.orderDefault = orderDefault;
	}
	
	public String getSortBy() {
		this.sortBy = request.getQueryString("sortBy");
		if(this.sortBy == null) {
			this.sortBy = this.sortByDefault;
		} 
		return sortBy;
	}

	public void setSortByDefault(String sortByDefault) {
		this.sortByDefault = sortByDefault;
	}
	
	public Integer getPageNum() {
		String page = request.getQueryString("pageNum");
		try {
			this.pageNum = Integer.parseInt(page);
		} catch (Exception e){
			this.pageNum = 0;
		}
		return pageNum;
	}
	
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getPageSize() {
		String pageSize = request.getQueryString("pageSize");
		try {
			this.pageSize = Integer.parseInt(pageSize);
		} catch (Exception e){}
		return this.pageSize;
	}
	
	public String get(String key) {
		return RequestVar.get(key);
	}
	
	public Page<T> setPage(Page<T> page){
		return page;
	}

	@Override
	public String getDisplayXtoYofZ(String arg0, String arg1) {
		if(parcheCountAllFormula) {
			return (pageSize * pageNum + 1) + " a "+pageSize+" de " + getTotalRowCount();
		}
		return page.getDisplayXtoYofZ(arg0, arg1);
	}

	@Override
	public List<T> getList() {
		return page.getList();
	}

	@Override
	public int getPageIndex() {
		return page.getPageIndex();
	}

	@Override
	public int getTotalPageCount() {
		return page.getTotalPageCount();
	}

	@Override
	public int getTotalRowCount() {
		
		if(parcheCountAllFormula)
			return totalRowCount;
		
		
		try {
		return page.getTotalRowCount();
		} catch (Exception e) {
			return 0;
		}
	}
	
	public void setTotalRowCount(Integer totalRowCount) {
		this.totalRowCount = totalRowCount;
	}

	@Override
	public boolean hasNext() {
		return page.hasNext();
	}

	@Override
	public boolean hasPrev() {
		return page.hasPrev();
	}

	@Override
	public Page<T> next() {
		return page.next();
	}

	@Override
	public Page<T> prev() {
		return page.prev();
	}
	
}
