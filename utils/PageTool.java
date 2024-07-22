/**
 * 
 */
package com.ujiuye.utils;

/** 
* @Title: PageTool.java
* @author: yanbo.deng
* @date: 2019��9��18�� ����10:00:41
* @Description:
* ������������totalCount ��ѯ���ݿ�õ� select count(*) from user
* ��ҳ����totalPages ����ÿҳ�������ܼ�¼���������
* ÿҳ��ʾ������pageSize 
* ��ǰ�ڼ�ҳ��currentPage ҳ�洫�ݹ���
* ��һҳ��prePage
* ��һҳ��nextPage
* ��ʼ�±꣺startIndex
*/
public class PageTool {
	/*
	 * ��ǰҳ�������������ҳ�洫�ݹ������������ݿ���ͨ�����������ݼ������
	 */
	public PageTool(String currentPage, int totalCount) {
		this.totalCount = totalCount;//��¼��������ҳ���ѯ�󴫵ݹ���
		initCurrentPage(currentPage);//����ǰҳ�븳ֵ
		pageSize=5;//ÿҳ��ʾ�����̶�Ϊ5�����޸�
		initTotalPages();//��ʼ����ҳ��
		initStartIndex();//����ÿҳ��ʼ�±� 
		initPrePage();//��һҳ
		initNextPage();//��һҳ		
	}
	private int pageSize;//ÿҳ����������
	private int currentPage;//��ǰҳ��
	private int totalCount;//����������
	private int totalPages;//��ҳ��
	private int prePage;//��һҳ
	private int nextPage;//��һҳ
	private int startIndex;//��ʼ�±�
	public int getPageSize() {
		return pageSize;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public int getTotalPages() {
		return totalPages;
	}
	public int getPrePage() {
		return prePage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public int getStartIndex() {
		return startIndex;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public void setTotalPages(int totalPages) {
		this.totalPages = totalPages;
	}
	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	public void setStartIndex(int startIndex) {
		this.startIndex = startIndex;
	}
	
	private void initStartIndex(){
		this.startIndex=(currentPage-1)*pageSize;
	}
	
	private  void  initPrePage() {
		if (currentPage==1) {
			this.prePage=1;
		}else {
			this.prePage=currentPage-1;
		}
	}
	
	private void initNextPage() {
		if (currentPage==totalPages) {
			this.nextPage=totalPages;
		}else {
			this.nextPage=currentPage+1;
		}
	}
	
	/*
	 *��ʼ����ǰҳ�룺����һ�ν�����ʾ�б�ҳ��ʱcurrentPage��û��ֵ�ģ�������Ҫ�����ʼֵ
	 *����������Ǵ�ҳ�洫�ݹ�����
	 */
	private void initCurrentPage(String currentPage) {
		if (currentPage==null||"".equals(currentPage)) {
			this.currentPage=1;
		}else {
			this.currentPage=Integer.valueOf(currentPage);
		}
	}
	//��ʼ����ҳ��
	private void initTotalPages() {
		this.totalPages=(totalCount%pageSize==0)?(totalCount/pageSize):(totalCount/pageSize+1);
	}

}
