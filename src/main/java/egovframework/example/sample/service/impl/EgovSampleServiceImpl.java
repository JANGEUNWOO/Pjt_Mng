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
package egovframework.example.sample.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import egovframework.example.sample.service.EgovSampleService;
import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;

/**
 * @Class Name : EgovSampleServiceImpl.java
 * @Description : Sample Business Implement Class
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

@Service("sampleService")
public class EgovSampleServiceImpl extends EgovAbstractServiceImpl implements EgovSampleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(EgovSampleServiceImpl.class);

	/** SampleDAO */
	// TODO ibatis 사용
	@Resource(name = "sampleDAO")
	private SampleDAO sampleDAO;
	// TODO mybatis 사용
	// @Resource(name="sampleMapper")
	// private SampleMapper sampleDAO;

	/** ID Generation */
	@Resource(name = "egovIdGnrService")
	private EgovIdGnrService egovIdGnrService;

	// 특정조건 검색
	/*
	 * @Override public List<?> specificSelect(SampleDefaultVO searchVO) throws
	 * Exception { return sampleDAO.specificSelect(searchVO); }
	 */

	/*// 재료비/경비 insert
	@Override
	public String insertSample1(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		//** ID Generation Service *//*
		String id = egovIdGnrService.getNextStringId();

		LOGGER.debug(vo.toString());
		//
		sampleDAO.insertSample1(vo);
		return id;
	}*/
	
	// 재료비/경비 insert
	@Override
	public String insertSample1(Map<String,String> hashmap) throws Exception {
		LOGGER.debug(hashmap.toString());

		//** ID Generation Service *//*
		String id = egovIdGnrService.getNextStringId();

		LOGGER.debug(hashmap.toString());
		//
		sampleDAO.insertSample1(hashmap);
		return id;
	}

	// 노무비 insert
	@Override
	public String nmbInsert(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();

		LOGGER.debug(vo.toString());
		//
		sampleDAO.nmbInsert(vo);
		return id;
	}

	// ------------업데이트 코드 -----------

	/*// 재료비/경비 업데이트
	@Override
	public void updateSample1(SampleVO vo) throws Exception {
		sampleDAO.updateSample1(vo);
	}*/
	
	// 재료비/경비 업데이트
	@Override
	public void updateSample1(Map<String,String> hashmap) throws Exception {
		sampleDAO.updateSample1(hashmap);
	}

	// 노무비 업데이트
	@Override
	public void nmbUpdate(SampleVO vo) throws Exception {
		sampleDAO.nmbUpdate(vo);
	}

	// ------------삭제코드-------------

	/*// 재료비/경비 삭제
	@Override
	public void deleteSample1(SampleVO vo) throws Exception {
		sampleDAO.deleteSample1(vo);
	}*/
	
	// 재료비/경비 삭제
	@Override
	public void deleteSample1(Map<String, String> hashmap) throws Exception {
		sampleDAO.deleteSample1(hashmap);
	}

	// 노무비 삭제
	@Override
	public void nmbDelete(Map<String, String> hashmap) throws Exception {
		sampleDAO.nmbDelete(hashmap);
	}

	// -------------Select 조회 코드-------------
	// 재료비/경비 조회
	/*
	 * @Override public List<?> selectSampleList1(SampleDefaultVO searchVO) throws
	 * Exception { return sampleDAO.selectSampleList1(searchVO); }
	 */
	// 재료비/경비 조회
	@Override
	public List<?> selectSampleList1(Map<String, String> hashmap) throws Exception {
		return sampleDAO.selectSampleList1(hashmap);
	}

	/*// 노무비 조회
	@Override
	public List<?> manpowerList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.manpowerList(searchVO);
	}*/

	// 노무비 조회
	@Override
	public List<?> manpowerList(Map<String, String> hashmap) throws Exception {
		return sampleDAO.manpowerList(hashmap);
	}

	// 현황분석 조회
	@Override
	public List<?> inoutAnsisList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.inoutAnsisList(searchVO);
	}

	/*
	 * @Override public List<?> selectNmbList1(SampleDefaultVO searchVO) throws
	 * Exception { return sampleDAO.selectNmbList1(searchVO); }
	 */

	@Override
	public List<?> selectNmbList1(Map<String, String> hashmap) throws Exception {
		return sampleDAO.selectNmbList1(hashmap);
	}

	/**
	 * 프로젝트 관리 프로그램 코드 모음
	 */

	@Override
	public String insertPrt(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		LOGGER.debug(vo.toString());

		sampleDAO.insertPrt(vo);
		return id;
	}

	@Override
	public void updatePrt(SampleVO vo) throws Exception {
		sampleDAO.updatePrt(vo);
	}

	@Override
	public void deletePrt(SampleVO vo) throws Exception {
		sampleDAO.deletePrt(vo);
	}

	@Override
	public List<?> selectPrtList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectPrtList(searchVO);
	}

	/**
	 * 프로젝트 매입매출 관리 코드 모음
	 */

	@Override
	public List<?> selectPrtNameList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectPrtNameList(searchVO);
	}

	@Override
	public List<?> selectInoutList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectInoutList(searchVO);
	}

	@Override
	public List<?> selectInoutOne(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectInoutOne(searchVO);
	}

	@Override
	public String insertInout(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		LOGGER.debug(vo.toString());

		sampleDAO.insertInout(vo);
		return id;
	}

	@Override
	public void deleteInout(SampleVO vo) throws Exception {
		sampleDAO.deleteInout(vo);
	}

	@Override
	public void updateInout(SampleVO vo) throws Exception {
		sampleDAO.updateInout(vo);
	}

	/**
	 * 샘플 코드 모음
	 */

	/**
	 * 글을 등록한다.
	 * 
	 * @param vo
	 *            - 등록할 정보가 담긴 SampleVO
	 * @return 등록 결과
	 * @exception Exception
	 */
	@Override
	public String insertSample(SampleVO vo) throws Exception {
		LOGGER.debug(vo.toString());

		/** ID Generation Service */
		String id = egovIdGnrService.getNextStringId();
		vo.setId(id);
		LOGGER.debug(vo.toString());

		sampleDAO.insertSample(vo);
		return id;
	}

	/**
	 * 글을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void updateSample(SampleVO vo) throws Exception {
		sampleDAO.updateSample(vo);
	}

	/**
	 * 글을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	@Override
	public void deleteSample(SampleVO vo) throws Exception {
		sampleDAO.deleteSample(vo);
	}

	/**
	 * 글을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	@Override
	public SampleVO selectSample(SampleVO vo) throws Exception {
		SampleVO resultVO = sampleDAO.selectSample(vo);
		if (resultVO == null)
			throw processException("info.nodata.msg");
		return resultVO;
	}

	/**
	 * 글 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	@Override
	public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception {
		return sampleDAO.selectSampleList(searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다. @param searchVO - 조회할 정보가 담긴 VO @return 글 총 갯수 @exception
	 */
	@Override
	public int selectSampleListTotCnt(SampleDefaultVO searchVO) {
		return sampleDAO.selectSampleListTotCnt(searchVO);
	}

}
