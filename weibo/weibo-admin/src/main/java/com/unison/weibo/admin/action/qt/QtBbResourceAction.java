package com.unison.weibo.admin.action.qt;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.unison.lottery.weibo.data.PageRequest;
import com.unison.lottery.weibo.data.PageResult;
import com.unison.lottery.weibo.data.crawler.service.store.persist.dao.entity.BasketBallMatchPO;
import com.unison.lottery.weibo.data.crawler.service.store.persist.dao.entity.FbMatchBaseInfoPO;
import com.unison.weibo.admin.action.BaseAction;
import com.xhcms.commons.lang.Data;
import com.xhcms.lottery.commons.data.BasketBallMatchData;
import com.xhcms.lottery.commons.persist.service.MatchService;

public class QtBbResourceAction extends BaseAction {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private MatchService matchService;
	
	private PageRequest pageRequest = new PageRequest();
	
	private int page;
	
	private Date from;
	
	private Date to;
	
	private PageResult<BasketBallMatchData> pageResult;
	
	private String dtailId;
	
	private BasketBallMatchPO basketBallMatchPO;
	
	public QtBbResourceAction() {
		pageRequest.setPageSize(5);
	}
	
	@Override
	public String execute() throws Exception {
		List<BasketBallMatchData> lists = matchService.findLQSameDayFromQT(from, to);
		if(lists != null && lists.size() > 0){
			for(BasketBallMatchData ft : lists){
				ft.setMatchId(makeMatchId(ft.getBasketBallMatchPO()));
			}
			pageResult = new PageResult<BasketBallMatchData>();
			pageResult.setResults(lists);
		}
		return SUCCESS;
	}
    /**
     * 球探数据的详情
     * @return
     */
	public String detailQTbasketball(){
		if(StringUtils.isNotBlank(dtailId)){
			BasketBallMatchData ballMatchData = matchService.findLQByQT(dtailId);
			if(ballMatchData != null){
				String dateString = ballMatchData.getBasketBallMatchPO().getExplainContent();
				try {
					ballMatchData.getBasketBallMatchPO().setExplainContent(new String(dateString.getBytes("UTF-8"),"UTF-8"));
				} catch (UnsupportedEncodingException e) {
					e.printStackTrace();
				}
				ballMatchData.setMatchId(makeMatchId(ballMatchData.getBasketBallMatchPO()));
				setData(ballMatchData);
			}else {
				super.setData(Data.failure(null));
			}
		}
		return SUCCESS;
	}
	
	public String  updateQTbasketball(){
		if(matchService.updateLQByQT(basketBallMatchPO)){
			return SUCCESS;
		}
		return null;
	}
	
	public String findDatasBB() throws Exception {
		List<BasketBallMatchData> lists = matchService.findLQFromQT(from, to);
		if(lists != null && lists.size() > 0){
			for(BasketBallMatchData ft : lists){
				ft.setMatchId(makeMatchId(ft.getBasketBallMatchPO()));
			}
			pageResult = new PageResult<BasketBallMatchData>();
			pageResult.setResults(lists);
		}
		return SUCCESS;
	}
	private String makeMatchId(Object qtMatchBaseModel) {
		StringBuilder matchId = new StringBuilder("");
		String jingcaiId = "";
		if (qtMatchBaseModel instanceof FbMatchBaseInfoPO) {
			FbMatchBaseInfoPO qtMatchBaseModel2 = (FbMatchBaseInfoPO) qtMatchBaseModel;
			matchId.append(DateFormateUtil.getNowDate(qtMatchBaseModel2
					.getMatchTime()));
			jingcaiId = qtMatchBaseModel2.getJingcaiId();
		} else if (qtMatchBaseModel instanceof BasketBallMatchPO) {
			BasketBallMatchPO qtMatchBaseModel2 = (BasketBallMatchPO) qtMatchBaseModel;
			matchId.append(DateFormateUtil.getNowDate(qtMatchBaseModel2
					.getMatchTime()));
			jingcaiId = qtMatchBaseModel2.getJingcaiId();
		}
		if (jingcaiId != null) {
			String weekend = jingcaiId.substring(0, jingcaiId.length() - 3);
			String index = jingcaiId.substring(jingcaiId.length() - 3); // 序号，例如周三004指的就是004
			switch (weekend) {
			case "周一":
				weekend = "1";
				break;
			case "周二":
				weekend = "2";
				break;
			case "周三":
				weekend = "3";
				break;
			case "周四":
				weekend = "4";
				break;
			case "周五":
				weekend = "5";
				break;
			case "周六":
				weekend = "6";
				break;
			case "周日":
				weekend = "7";
				break;
			default:
				weekend = "0";
				break;
			}
			matchId.append(weekend);
			matchId.append(index);
		}
		return matchId.toString();
	}
	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}

	public PageRequest getPageRequest() {
		return pageRequest;
	}

	public void setPageRequest(PageRequest pageRequest) {
		this.pageRequest = pageRequest;
	}

	public PageResult<BasketBallMatchData> getPageResult() {
		return pageResult;
	}

	public void setPageResult(PageResult<BasketBallMatchData> pageResult) {
		this.pageResult = pageResult;
	}

	public String getDtailId() {
		return dtailId;
	}

	public void setDtailId(String dtailId) {
		this.dtailId = dtailId;
	}

	public BasketBallMatchPO getBasketBallMatchPO() {
		return basketBallMatchPO;
	}

	public void setBasketBallMatchPO(BasketBallMatchPO basketBallMatchPO) {
		this.basketBallMatchPO = basketBallMatchPO;
	}
	
}