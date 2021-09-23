package com.iu.s4.util;

public class Pager {
	
	//null 받기 위해서 long 대신 reference type Long으로 선언
	private Long pn;
	
	//한 페이지에 출력할 글의 개수 - 10
	private Long perPage;
	
	//한 페이지에 출력할 pn의 개수 - 5
	private Long perBlcok;
	
	//---------------- rowNum : Mapper에서 사용 -----------------
	private Long startRow;
	private Long lastRow;
	
	
	//--------------- startNum, lastNum : jsp에서 사용 ---------
	private Long startNum;
	private Long lastNum;
	
	
	private Long totalPage;
	
	//--------------- 검색 -----------------------------------
	private String kind;
	private String search;
	
	//---------------- rowNum 계산 ----------------------------
	public void makeRow() {
		this.startRow = (this.getPn()-1)*this.perPage+1;
		this.lastRow = this.getPn()*this.getPerPage();
	}
	
	//-------------- startNum, lastNum  : jsp에서 번호 출력 ------
	public void makeNum(Long totalCount) {
		//1. totalCount : 전체 글의 개수
		//2. totalCount로 totalPage 계산 : 전체 페이지 개수
		totalPage = totalCount / this.getPerPage();
		if(totalCount % this.getPerPage() != 0) {
			totalPage++;
		}
		
		//3. totalPage로 totalBlock 계산
		Long totalBlock = totalPage / this.getPerBlcok();
		if(totalPage % this.getPerBlcok() != 0) {
			totalBlock++;
		}

		
		//3-1.
		if(totalPage < this.getPn()) {
			this.setPn(totalPage);
			//this.pn = totalPage;
		}
		
		//4. pn으로 현재 블럭 번호 구하기
		Long curBlock = this.getPn() / this.getPerBlcok();
		if(this.getPn() % this.getPerBlcok() != 0) {
			curBlock++;
		}
		
		//5. curBlock으로 startNum, lastNum 계산
		this.startNum = (curBlock - 1) * this.getPerBlcok()+1;
		this.lastNum = curBlock *this.getPerBlcok();
		
		//6. curBlock이 마지막 block일 때 lastNum 변경
		if(curBlock == totalBlock) {
			this.lastNum = totalPage;
		}
		
	}//makeNum
	
	
	
	//----------------------------- Setter, Getter -------------------------------------
	public Long getPn() {
		if(this.pn == null || this.pn < 1) {
			this.pn = 1L;
		}
		return pn;
	}
	
	public void setPn(Long pn) {
		this.pn = pn;
	}

	public Long getPerPage() {
		if(this.perPage==null || this.perPage==0) {
			this.perPage=10L;
		}
		
		return perPage;
	}

	public void setPerPage(Long perPage) {
		this.perPage = perPage;
	}

	public Long getPerBlcok() {
		this.perBlcok = 5L;
		return perBlcok;
	}

	public void setPerBlcok(Long perBlcok) {
		this.perBlcok = perBlcok;
	}

	public Long getStartRow() {
		return startRow;
	}

	public void setStartRow(Long startRow) {
		this.startRow = startRow;
	}

	public Long getLastRow() {
		return lastRow;
	}

	public void setLastRow(Long lastRow) {
		this.lastRow = lastRow;
	}

	public Long getStartNum() {
		return startNum;
	}

	public void setStartNum(Long startNum) {
		this.startNum = startNum;
	}

	public Long getLastNum() {
		return lastNum;
	}

	public void setLastNum(Long lastNum) {
		this.lastNum = lastNum;
	}

	public Long getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(Long totalPage) {
		this.totalPage = totalPage;
	}

	public String getKind() {
		return kind;
	}

	public void setKind(String kind) {
		this.kind = kind;
	}

	public String getSearch() {
		if(this.search == null) {
			this.search = "";
		}
		
		return search;
	}

	public void setSearch(String search) {
		this.search = search;
	}
	
	
	
	
	
	
}
