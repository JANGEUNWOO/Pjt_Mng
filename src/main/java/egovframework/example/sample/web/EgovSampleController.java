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
package egovframework.example.sample.web;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.cmmn.ria.support.UdDTO;
import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : EgovSampleController.java
 * @Description : EgovSample Controller class
 * @Modification Information @ @
 * 
 * @author
 * @since 2009.02.01
 * @version 1.0
 * @see Copyright (C) 2009 by MOPAS All right reserved.
 */

@Controller
public class EgovSampleController {

	@Resource(name = "sampleService")
	private EgovSampleService sampleService;

	/** EgovPropertyService */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;

	/**
	 * 노무비/비용 관련 코드
	 */

	// ---------------Select---------------
	//현황분석
	@RequestMapping(value = "/miplatform/stsAnSis.do")
	public ModelAndView selectInout(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO, UdDTO ram) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			
			Map<String, String> param=ram.getVariableList();
			udDtoVO.setPjId(param.get("pjId"));
			System.out.println("PjId !! =====================>"+param.get("pjId"));
			//inoutAnsisList
			List sampleList = sampleService.inoutAnsisList(udDtoVO);

			System.out.println("sampleList 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/*// 노무비조회
	@RequestMapping(value = "/miplatform/Manpowerlist.do")
	public ModelAndView selectSampleList4Mi2(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {

			List sampleList = sampleService.manpowerList(udDtoVO);
			
			System.out.println("sampleList 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	// 노무비조회
	@RequestMapping(value = "/miplatform/Manpowerlist.do")
	public ModelAndView selectSampleList4Mi2(UdDTO midto) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			Map<String, String> hashmap=midto.getVariableList();
			List<?> sampleList = sampleService.manpowerList(hashmap);
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}
	
	// 재료비/경비
/*	@RequestMapping(value = "/miplatform/egovSampleList1.do")
	public ModelAndView selectSampleList4Mi1(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			
			List sampleList = sampleService.selectSampleList1(udDtoVO);

			System.out.println("sampleList 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	
	// 재료비/경비
	@RequestMapping(value = "/miplatform/egovSampleList1.do")
	public ModelAndView selectSampleList4Mi1(UdDTO midto) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			Map<String, String> hashmap = midto.getVariableList();
			List<?> sampleList = sampleService.selectSampleList1(hashmap);
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}
	
	
	// 특정조건 조회 노무비
	/*@RequestMapping(value = "/miplatform/selectNmb.do")
	public ModelAndView selectNmbList(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO ,UdDTO ram) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			Map<String, String> param = ram.getVariableList();
			
			udDtoVO.setEmpNm(param.get("empNm"));

			System.out.println("empNm !!==================================>" + param.get("empNm"));
			
			List sampleList = sampleService.selectNmbList1(udDtoVO);

			System.out.println("sampleList 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/

	
	// 특정조건 조회 노무비
	@RequestMapping(value = "/miplatform/selectNmb.do")
	public ModelAndView selectNmbList(UdDTO midto) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			
			Map<String, String> hashmap=midto.getVariableList();
			List<?> sampleList = sampleService.selectNmbList1(hashmap);
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}
	
	// ---------------update---------------

	/*// 재료비/경비
	@RequestMapping(value = "/miplatform/egovSampleUpdate1.do")
	public ModelAndView updateSampleList4Mi1(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.updateSample1((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	// 재료비/경비
	@RequestMapping(value = "/miplatform/egovSampleUpdate1.do")
	public ModelAndView updateSampleList4Mi1(UdDTO midto, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			
			Map<String,String> hashmap=midto.getVariableList();
			sampleService.updateSample1(hashmap);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	// 노무비
	@RequestMapping(value = "/miplatform/manpowerUpdate.do")
	public ModelAndView updateSampleList4Mi2(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.nmbUpdate((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	// ---------------insert---------------

	/*// 재료비/경비
	@RequestMapping(value = "/miplatform/egovSampleInsert1.do")
	public ModelAndView insertSampleList4Mi1(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.insertSample1((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	// 재료비/경비
	@RequestMapping(value = "/miplatform/egovSampleInsert1.do")
	public ModelAndView insertSampleList4Mi1(UdDTO midto, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String,String> hashmap=midto.getVariableList();
			sampleService.insertSample1(hashmap);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	// 노무비
	@RequestMapping(value = "/miplatform/manpowerInsert.do")
	public ModelAndView insertSampleList4Mi2(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.nmbInsert((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	// ---------------Delete---------------

	// 재료비/경비 삭제
/*	@RequestMapping(value = "/miplatform/egovSampleDelete1.do")
	public ModelAndView deleteSampleList4Mi1(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setPjCostId(param.get("selectedId"));
			System.out.println("selectedId ==================================>" + param.get("selectedId"));
			
			sampleService.deleteSample1(sampleVO);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	// 재료비/경비 삭제
	@RequestMapping(value = "/miplatform/egovSampleDelete1.do")
	public ModelAndView deleteSampleList4Mi1(UdDTO miDto) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> hashmap = miDto.getVariableList();
		    sampleService.deleteSample1(hashmap);
						

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

/*	// 노무비삭제
	@RequestMapping(value = "/miplatform/manpowerDelete.do")
	public ModelAndView deleteSampleList4Mi2(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setEmpId(param.get("selectedId"));

			System.out.println("selectedId ==================================>" + param.get("selectedId"));

			sampleService.nmbDelete(sampleVO);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}*/
	
	// 노무비삭제
	@RequestMapping(value = "/miplatform/manpowerDelete.do")
	public ModelAndView deleteSampleList4Mi2(UdDTO miDto) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> hashmap = miDto.getVariableList();
			sampleService.nmbDelete(hashmap);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/**
	 * 프로젝트 관리 프로그램 코드 모음
	 */

	@RequestMapping(value = "/miplatform/prtMngList.do")
	public ModelAndView selectPrtList(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			List sampleList = sampleService.selectPrtList(udDtoVO);
			
			System.out.println("프로젝트 List 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/prtUpdate.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView updatePrt(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		SampleVO realVo = (SampleVO) vo;

		if (realVo.getRealStartDate() == null)
			realVo.setRealStartDate("");
		if (realVo.getRealEndDate() == null)
			realVo.setRealEndDate("");
		if (realVo.getPlanStartDate() == null)
			realVo.setPlanStartDate("");
		if (realVo.getPlanEndDate() == null)
			realVo.setPlanEndDate("");
		if (realVo.getDownPay() == null)
			realVo.setDownPay("");
		if (realVo.getPmNm() == null)
			realVo.setPmNm("");
		if (realVo.getCustNm() == null)
			realVo.setCustNm("");
		if (realVo.getCustStatus() == null)
			realVo.setCustStatus("계획");

		try {
			sampleService.updatePrt(realVo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/prtInsert.do")
	public ModelAndView insertPrt(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.insertPrt((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/prtDelete.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView deletePrt(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setPjId(param.get("selectedId"));

			System.out.println("selectedId ==================================>" + param.get("selectedId"));

			sampleService.deletePrt(sampleVO);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/**
	 * 프로젝트 매입매출 관리 코드 모음
	 */

	@RequestMapping(value = "/miplatform/prtNameList.do")
	public ModelAndView selectPrtNameList(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			List sampleList = sampleService.selectPrtNameList(udDtoVO);

			System.out.println("프로젝트명 List 레코드 카운드는 ==========> " + sampleList.size());

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/prtInoutList.do")
	public ModelAndView selectInoutList(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO, UdDTO baram)
			throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {

			Map<String, String> param = baram.getVariableList();

			udDtoVO.setPjNm(param.get("pjNm"));
			udDtoVO.setInoutCategory(param.get("inoutCategory"));

			List sampleList = sampleService.selectInoutList(udDtoVO);

			System.out.println("프로젝트명 List 레코드 카운드는 ==========> " + sampleList.size());


			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/prtInoutOne.do")
	public ModelAndView selectInoutOne(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO, UdDTO baram)
			throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			Map<String, String> param = baram.getVariableList();

			udDtoVO.setPjInoutId(param.get("pjInoutId"));
			
			List sampleList = sampleService.selectInoutOne(udDtoVO);

			System.out.println("인아웃디테일 레코드 카운드는 ==========> " + sampleList.size());


			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");
			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/inoutInsert.do")
	public ModelAndView insertInout(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.insertInout((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/inoutUpdate.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView updateInout(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		SampleVO realVo = (SampleVO) vo;

		try {
			sampleService.updateInout(realVo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/inoutDelete.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView deleteInout(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setInoutEtc(param.get("etc"));

			System.out.println("etc ==================================>" + param.get("etc"));

			sampleService.deleteInout(sampleVO);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/**
	 * 샘플 코드 모음
	 */

	@RequestMapping(value = "/miplatform/egovSampleList.do")
	public ModelAndView selectSampleList4Mi(@ModelAttribute("searchVO") SampleDefaultVO udDtoVO) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByMap");

		try {
			PaginationInfo paginationInfo = new PaginationInfo();
			paginationInfo.setCurrentPageNo(udDtoVO.getPageIndex());
			paginationInfo.setRecordCountPerPage(udDtoVO.getPageUnit());
			paginationInfo.setPageSize(udDtoVO.getPageSize());

			udDtoVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
			udDtoVO.setLastIndex(paginationInfo.getLastRecordIndex());
			udDtoVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

			List sampleList = sampleService.selectSampleList(udDtoVO);

			System.out.println("sampleList 레코드 카운드는 ==========> " + sampleList.size());
			int totCnt = sampleService.selectSampleListTotCnt(udDtoVO);
			paginationInfo.setTotalRecordCount(totCnt);
			// mav.addAttribute("paginationInfo", paginationInfo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

			mav.addObject("MiDTO", sampleList);

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/**
	 * 
	 * @param miDto
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/miplatform/egovSampleDetail.do")
	public ModelAndView detailSampleList4Mi(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setId(param.get("selectedId"));
			mav.addObject("MiDTO", selectSample(sampleVO, new SampleDefaultVO()));

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/egovSampleDetailDS.do")
	public ModelAndView detailSampleList4MiByDataset(Object vo, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			mav.addObject("MiDTO", selectSample((SampleVO) vo, new SampleDefaultVO()));

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	/**
	 * 
	 * @param miDto
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping(value = "/miplatform/egovSampleUpdate.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView updateSampleList4Mi(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.updateSample((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/egovSampleInsert.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView insertSampleList4Mi(Object vo, Model model, HttpServletRequest request) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			sampleService.insertSample((SampleVO) vo);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/miplatform/egovSampleDelete.do")
	// public ModelAndView updateSampleList4Mi(Object vo, Model model,
	// @ModelAttribute("voInfo") VOInfo4Mi voInfo)
	public ModelAndView deleteSampleList4Mi(UdDTO miDto, Model model) throws Exception {

		ModelAndView mav = new ModelAndView("miplatformViewByVO");

		try {
			Map<String, String> param = miDto.getVariableList();

			SampleVO sampleVO = new SampleVO();
			sampleVO.setId(param.get("selectedId"));

			System.out.println("selectedId ==================================>" + param.get("selectedId"));

			sampleService.deleteSample(sampleVO);

			mav.addObject("MiResultCode", "0");
			mav.addObject("MiResultMsg", "success");

		} catch (Exception e) {
			e.printStackTrace();
			mav.addObject("MiResultCode", "-1");
			mav.addObject("MiResultMsg", e.toString());
		}
		return mav;
	}

	@RequestMapping(value = "/sample/egovSampleList.do")
	public String selectSampleList(@ModelAttribute("searchVO") SampleDefaultVO searchVO, ModelMap model)
			throws Exception {

		/** EgovPropertyService.sample */
		searchVO.setPageUnit(propertiesService.getInt("pageUnit"));
		searchVO.setPageSize(propertiesService.getInt("pageSize"));

		/** pageing */
		PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo(searchVO.getPageIndex());
		paginationInfo.setRecordCountPerPage(searchVO.getPageUnit());
		paginationInfo.setPageSize(searchVO.getPageSize());

		searchVO.setFirstIndex(paginationInfo.getFirstRecordIndex());
		searchVO.setLastIndex(paginationInfo.getLastRecordIndex());
		searchVO.setRecordCountPerPage(paginationInfo.getRecordCountPerPage());

		List sampleList = sampleService.selectSampleList(searchVO);
		model.addAttribute("resultList", sampleList);

		int totCnt = sampleService.selectSampleListTotCnt(searchVO);
		paginationInfo.setTotalRecordCount(totCnt);
		model.addAttribute("paginationInfo", paginationInfo);

		return "/sample/egovSampleList";
	}

	@RequestMapping("/sample/addSampleView.do")
	public String addSampleView(@ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
		model.addAttribute("sampleVO", new SampleVO());
		return "/sample/egovSampleRegister";
	}

	@RequestMapping("/sample/addSample.do")
	public String addSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO,
			SessionStatus status) throws Exception {
		sampleService.insertSample(sampleVO);
		status.setComplete();
		return "forward:/sample/egovSampleList.do";
	}

	@RequestMapping("/sample/updateSampleView.do")
	public String updateSampleView(@RequestParam("selectedId") String id,
			@ModelAttribute("searchVO") SampleDefaultVO searchVO, Model model) throws Exception {
		SampleVO sampleVO = new SampleVO();
		sampleVO.setId(id);
		// 蹂��닔紐낆�� CoC �뿉 �뵲�씪 sampleVO
		model.addAttribute(selectSample(sampleVO, searchVO));
		return "/sample/egovSampleRegister";
	}

	@RequestMapping("/sample/selectSample.do")
	public @ModelAttribute("sampleVO") SampleVO selectSample(SampleVO sampleVO,
			@ModelAttribute("searchVO") SampleDefaultVO searchVO) throws Exception {
		return sampleService.selectSample(sampleVO);
	}

	@RequestMapping("/sample/updateSample.do")
	public String updateSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO,
			SessionStatus status) throws Exception {
		sampleService.updateSample(sampleVO);
		status.setComplete();
		return "forward:/sample/egovSampleList.do";
	}

	@RequestMapping("/sample/deleteSample.do")
	public String deleteSample(SampleVO sampleVO, @ModelAttribute("searchVO") SampleDefaultVO searchVO,
			SessionStatus status) throws Exception {
		sampleService.deleteSample(sampleVO);
		status.setComplete();
		return "forward:/sample/egovSampleList.do";
	}

}
