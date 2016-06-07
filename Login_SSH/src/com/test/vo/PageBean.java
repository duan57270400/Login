package com.test.vo;

import java.util.ArrayList;
import java.util.List;



import com.test.vo.PostTable;
public class PageBean {

private List list;  //Ҫ���ص�ĳһҳ�ļ�¼�б�
private List detail;  //��ϸ��ҳ���б�
private int allRow; //�ܼ�¼��
private int totalPage;  //��ҳ��
private int currentPage;  //��ǰҳ
private int pageSize;  //ÿҳ�ļ�¼��
private boolean isFirstPage;  //�Ƿ�Ϊ��ǰ��һҳ
private boolean isLastPage;  //�Ƿ�Ϊ���һҳ
private boolean hasPreviousPage;  //�Ƿ���ǰһҳ
private boolean hasNextPage;  //�Ƿ�����һҳ

//Set and get����
//PageBean�еľ��巽��
/**
 * ��ʼ����ҳ��Ϣ
 */
public void init(){
this.isFirstPage = isFirstPage;
this.isLastPage = isLastPage;
this.hasPreviousPage = hasPreviousPage;
this.hasNextPage = hasNextPage;
}
/**
 * ������ҳ��  ��̬����
 * @param pageSize  ÿҳ�ļ�¼��
 * @param allRow  �ܼ�¼��
 * @return ��ҳ��
 */
public static int countTatalPage(final int pageSize,final int allRow){
int toalPage = allRow % pageSize == 0 ? allRow/pageSize : allRow/pageSize + 1;
return toalPage;
}
/**
 * ���㵱ǰҳ��ʼ�ļ�¼
 * @param pageSize ÿҳ��¼��
 * @param currentPage ��ǰ�ڼ�ҳ
 * @return ��ǰҳ��ʼ��¼��
 */
public static int countOffset(final int pageSize,final int currentPage){
 int offset = pageSize * (currentPage - 1);
if(offset<0)
{
	offset = 0;
}


return offset;
}
/**
 * ���㵱ǰҳ����Ϊ0���������URL��û�С�?page = ������1����
 * @param page ����Ĳ���������Ϊ�գ���0  �򷵻�1��
 * @return
 */
public static int countCurrentPage(int page,int totalPage){
 int curpage = (page == 0 ? 1 : page);
if(curpage-1==totalPage)
{
	curpage = totalPage;
}

return curpage;
}

public static List PageDetail(int totalPage)
{
	List list_temp = new ArrayList();
	//�����ϸ��ҳ����1��2��3
	for(int i=1;i<=totalPage;i++)
	{
		list_temp.add(String.valueOf(i));  //����ת�ַ�����
	}
	return list_temp;
}

public List getDetail() {
	return detail;
}
public void setDetail(List detail) {
	this.detail = detail;
}
public List getList() {
	return list;
}
public void setList(List list) {
	this.list = list;
}
public int getAllRow() {
	return allRow;
}
public void setAllRow(int allRow) {
	this.allRow = allRow;
}
public int getTotalPage() {
	return totalPage;
}
public void setTotalPage(int totalPage) {
	this.totalPage = totalPage;
}
public int getCurrentPage() {
	return currentPage;
}
public void setCurrentPage(int currentPage) {
	this.currentPage = currentPage;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public boolean isFirstPage() {
	return isFirstPage;
}
public void setFirstPage(boolean isFirstPage) {
	this.isFirstPage = isFirstPage;
}
public boolean isLastPage() {
	return isLastPage;
}
public void setLastPage(boolean isLastPage) {
	this.isLastPage = isLastPage;
}
public boolean isHasPreviousPage() {
	return hasPreviousPage;
}
public void setHasPreviousPage(boolean hasPreviousPage) {
	this.hasPreviousPage = hasPreviousPage;
}
public boolean isHasNextPage() {
	return hasNextPage;
}
public void setHasNextPage(boolean hasNextPage) {
	this.hasNextPage = hasNextPage;
}  


}