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

import org.springframework.stereotype.Repository;

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : SampleDAO.java
 * @Description : Sample DAO Class
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

@Repository("sampleDAO")
public class SampleDAO extends EgovAbstractDAO {

	/**
	 * 노무비/비용 코드 모음
	 */
	// ----특정 조건 검색-----
	/*public List<?> specificSelect(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.specificSelect", searchVO);
	}*/

	// ----------추가 insert 코드---------------

	/*// 재료비/경비 추가코드
	public String insertSample1(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.insertSample1", vo);
	}*/
	
	// 재료비/경비 추가코드
	public String insertSample1(Map<String,String> hashmap) throws Exception {
		return (String) insert("sampleDAO.insertSample1", hashmap);
	}

	// 노무비 추가코드
	public String nmbInsert(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.nmbInsert", vo);
	}

	// ---------수정 update 코드-----------------------

	/*// 재료비/경비 업데이트코드
	public void updateSample1(SampleVO vo) throws Exception {
		update("sampleDAO.updateSample1", vo);
	}*/

	// 재료비/경비 업데이트코드
	public void updateSample1(Map<String,String> hashmap) throws Exception {
		update("sampleDAO.updateSample1", hashmap);
	}

	// 노무비 업데이트코드
	public void nmbUpdate(SampleVO vo) throws Exception {
		update("sampleDAO.nmbUpdate", vo);
	}

	// ---------삭제 delete 코드-----------------------

	/*// 재료비/경비 삭제코드
	public void deleteSample1(SampleVO vo) throws Exception {
		delete("sampleDAO.deleteSample1", vo);
	}*/
	
	// 재료비/경비 삭제코드
	public void deleteSample1(Map<String,String> hashmap) throws Exception {
		delete("sampleDAO.deleteSample1", hashmap);
	}

	/*// 노무비 삭제코드
	public void nmbDelete(SampleVO vo) throws Exception {
		delete("sampleDAO.nmbDelete", vo);
	}*/
	
	// 노무비 삭제코드
		public void nmbDelete(Map<String,String> hashmap) throws Exception {
			delete("sampleDAO.nmbDelete", hashmap);
		}

	// ---------조회 select 코드-----------------------

	// 재료비/경비 조회코드
	/*public List<?> selectSampleList1(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectSampleList1", searchVO);
	}*/
	
	public List<?> selectSampleList1(Map<String,String> hashmap) throws Exception {
		return list("sampleDAO.selectSampleList1", hashmap);
	}

	/*// 노무비 조회코드
	public List<?> manpowerList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.manpowerList", searchVO);
	}*/
	
	// 노무비 조회코드
	public List<?> manpowerList(Map<String,String> hashmap) throws Exception {
		return list("sampleDAO.manpowerList", hashmap);
	}
	
	//현황분석
	public List<?> inoutAnsisList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.inoutAnsisList", searchVO);
	}
	
	
	
	//노무비 이름 검색
	/*public List<?> selectNmbList1(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectNmbList1", searchVO);
	}*/
	
	public List<?> selectNmbList1(Map<String,String> hashmap) throws Exception {
		return list("sampleDAO.selectNmbList1", hashmap);
	}
	
	
	
	/**
	 * 프로젝트 관리 프로그램 코드 모음
	 */

	public String insertPrt(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.insertPrt", vo);
	}

	public void updatePrt(SampleVO vo) throws Exception {
		update("sampleDAO.updatePrt", vo);
	}

	public void deletePrt(SampleVO vo) throws Exception {
		delete("sampleDAO.deletePrt", vo);
	}

	public List<?> selectPrtList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectPrtList", searchVO);
	}

	/**
	 * 프로젝트 매입매출 관리 코드 모음
	 */

	public List<?> selectPrtNameList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectPrtNameList", searchVO);
	}

	public List<?> selectInoutList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectInoutList", searchVO);
	}

	public List<?> selectInoutOne(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectInoutOne", searchVO);
	}

	public String insertInout(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.insertInout", vo);
	}

	public void updateInout(SampleVO vo) throws Exception {
		update("sampleDAO.updateInout", vo);
	}

	public void deleteInout(SampleVO vo) throws Exception {
		delete("sampleDAO.deleteInout", vo);
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
	public String insertSample(SampleVO vo) throws Exception {
		return (String) insert("sampleDAO.insertSample", vo);
	}

	/**
	 * 글을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void updateSample(SampleVO vo) throws Exception {
		update("sampleDAO.updateSample", vo);
	}

	/**
	 * 글을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	public void deleteSample(SampleVO vo) throws Exception {
		delete("sampleDAO.deleteSample", vo);
	}

	/**
	 * 글을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	public SampleVO selectSample(SampleVO vo) throws Exception {
		return (SampleVO) select("sampleDAO.selectSample", vo);
	}

	/**
	 * 글 목록을 조회한다.
	 * 
	 * @param searchMap
	 *            - 조회할 정보가 담긴 Map
	 * @return 글 목록
	 * @exception Exception
	 */
	public List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception {
		return list("sampleDAO.selectSampleList", searchVO);
	}

	/**
	 * 글 총 갯수를 조회한다. @param searchMap - 조회할 정보가 담긴 Map @return 글 총 갯수 @exception
	 */
	public int selectSampleListTotCnt(SampleDefaultVO searchVO) {
		return (Integer) select("sampleDAO.selectSampleListTotCnt", searchVO);
	}

}
