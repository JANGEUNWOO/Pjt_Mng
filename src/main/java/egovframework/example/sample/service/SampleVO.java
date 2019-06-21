/*
 * Copyright 2008-2009 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package egovframework.example.sample.service;

/**
 * @Class Name : SampleVO.java
 * @Description : SampleVO Class
 * @Modification Information
 * @ @ 수정일 수정자 수정내용 @ --------- --------- ------------------------------- @
 *   2009.03.16 최초생성
 *
 * @author 개발프레임웍크 실행환경 개발팀
 * @since 2009. 03.16
 * @version 1.0
 * @see
 *
 * 		Copyright (C) by MOPAS All right reserved.
 */
public class SampleVO extends SampleDefaultVO {

	private static final long serialVersionUID = 1L;

	// 노무비
	private String empId;
	private String empNm;
	private String manMonth;
	private String startDate;
	private String endDate;

	// 재료비/경비
	private String pjCostId;
	private String costDays;
	private String costCategory;
	private String costPrice;
	private String costEtc;
	private String costBranch;

	/**
	 * 프로젝트 관리 프로그램 코드 모음
	 */

	/** 프로젝트 ID */
	private String pjId;

	/** 프로젝트명 */
	private String pjNm;

	/** PM */
	private String pmNm;

	/** 계획 시작/종료일 */
	private String planStartDate;
	private String planEndDate;

	/** 실제 시작/종료일 */
	private String realStartDate;
	private String realEndDate;

	/** 계약금 */
	private String downPay;

	/** 계약처 */
	private String custNm;

	/** 계약상태 */
	private String custStatus;

	/**
	 * 프로젝트 매입매출 관리 코드 모음
	 */

	/** 매입매출ID */
	private String pjInoutId;

	/** 구분 */
	private String inoutCategory;

	/** 매입/매출일 */
	private String inoutDays;

	/** 거래처 */
	private String inoutCustNm;

	/** 계약금액 */
	private String inoutPrice;

	/** 기타 */
	private String inoutEtc;

	/**
	 * 샘플 코드 모음
	 */

	/** 아이디 */
	private String id;

	/** 이름 */
	private String name;

	/** 내용 */
	private String description;

	/** 사용여부 */
	private String useYn;

	/** 등록자 */
	private String regUser;

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public String getManMonth() {
		return manMonth;
	}

	public void setManmonth(String manMonth) {
		this.manMonth = manMonth;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public String getPjCostId() {
		return pjCostId;
	}

	public void setPjCostId(String pjCostId) {
		this.pjCostId = pjCostId;
	}

	public String getCostDays() {
		return costDays;
	}

	public void setCostDays(String costDays) {
		this.costDays = costDays;
	}

	public String getCostCategory() {
		return costCategory;
	}

	public void setCostCategory(String costCategory) {
		this.costCategory = costCategory;
	}

	public String getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(String costPrice) {
		this.costPrice = costPrice;
	}

	public String getCostEtc() {
		return costEtc;
	}

	public void setCostEtc(String costEtc) {
		this.costEtc = costEtc;
	}

	public String getCostBranch() {
		return costBranch;
	}

	public void setCostBranch(String costBranch) {
		this.costBranch = costBranch;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUseYn() {
		return useYn;
	}

	public void setUseYn(String useYn) {
		this.useYn = useYn;
	}

	public String getRegUser() {
		return regUser;
	}

	public void setRegUser(String regUser) {
		this.regUser = regUser;
	}

	public String getPjId() {
		return pjId;
	}

	public void setPjId(String pjId) {
		this.pjId = pjId;
	}

	public String getPjNm() {
		return pjNm;
	}

	public void setPjNm(String pjNm) {
		this.pjNm = pjNm;
	}

	public String getPmNm() {
		return pmNm;
	}

	public void setPmNm(String pmNm) {
		this.pmNm = pmNm;
	}

	public String getPlanStartDate() {
		return planStartDate;
	}

	public void setPlanStartDate(String planStartDate) {
		this.planStartDate = planStartDate;
	}

	public String getPlanEndDate() {
		return planEndDate;
	}

	public void setPlanEndDate(String planEndDate) {
		this.planEndDate = planEndDate;
	}

	public String getRealStartDate() {
		return realStartDate;
	}

	public void setRealStartDate(String realStartDate) {
		this.realStartDate = realStartDate;
	}

	public String getRealEndDate() {
		return realEndDate;
	}

	public void setRealEndDate(String realEndDate) {
		this.realEndDate = realEndDate;
	}

	public String getDownPay() {
		return downPay;
	}

	public void setDownPay(String downPay) {
		this.downPay = downPay;
	}

	public String getCustNm() {
		return custNm;
	}

	public void setCustNm(String custNm) {
		this.custNm = custNm;
	}

	public String getCustStatus() {
		return custStatus;
	}

	public void setCustStatus(String custStatus) {
		this.custStatus = custStatus;
	}

	public String getPjInoutId() {
		return pjInoutId;
	}

	public void setPjInoutId(String pjInoutId) {
		this.pjInoutId = pjInoutId;
	}

	public String getInoutCategory() {
		return inoutCategory;
	}

	public void setInoutCategory(String inoutCategory) {
		this.inoutCategory = inoutCategory;
	}

	public String getInoutDays() {
		return inoutDays;
	}

	public void setInoutDays(String inoutDays) {
		this.inoutDays = inoutDays;
	}

	public String getInoutCustNm() {
		return inoutCustNm;
	}

	public void setInoutCustNm(String inoutCustNm) {
		this.inoutCustNm = inoutCustNm;
	}

	public String getInoutPrice() {
		return inoutPrice;
	}

	public void setInoutPrice(String inoutPrice) {
		this.inoutPrice = inoutPrice;
	}

	public String getInoutEtc() {
		return inoutEtc;
	}

	public void setInoutEtc(String inoutEtc) {
		this.inoutEtc = inoutEtc;
	}

}
