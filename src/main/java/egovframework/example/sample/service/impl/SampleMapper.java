/*
 * Copyright 2011 MOPAS(Ministry of Public Administration and Security).
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

import egovframework.example.sample.service.SampleDefaultVO;
import egovframework.example.sample.service.SampleVO;
import egovframework.rte.psl.dataaccess.mapper.Mapper;

/**
 * sample에 관한 데이터처리 매퍼 클래스
 *
 * @author 표준프레임워크센터
 * @since 2014.01.24
 * @version 1.0
 * @see
 * 
 *      <pre>
 *  == 개정이력(Modification Information) ==
 *
 *          수정일          수정자           수정내용
 *  ----------------    ------------    ---------------------------
 *   2014.01.24        표준프레임워크센터          최초 생성
 *
 *      </pre>
 */
@Mapper("sampleMapper")
public interface SampleMapper {

	/**
	 * 노무비/비용 관련
	 */
	// 특정 조건 검색
	//List<?> specificSelect(SampleDefaultVO searchVO) throws Exception;

	// Insert
	//void insertSample1(SampleVO vo) throws Exception; // 재료비/경비 삽입
	void insertSample1(Map<String,String> hashmap) throws Exception; // 재료비/경비 삽입
	void nmbInsert(SampleVO vo) throws Exception; // 노무비

	// update
	//void updateSample1(SampleVO vo) throws Exception; // 재료비/경비
	void updateSample1(Map<String,String> hashmap) throws Exception; // 재료비/경비
	void nmbUpdate(SampleVO vo) throws Exception; // 노무비

	// delete
	//void deleteSample1(SampleVO vo) throws Exception; // 재료비/경비
	void deleteSample1(Map<String,String> hashmap) throws Exception; // 재료비/경비

	//void nmbDelete(SampleVO vo) throws Exception; // 노무비
	void nmbDelete(Map<String,String> hashmap) throws Exception; // 노무비

	// select
	List<?> selectSampleList1(Map<String,String> hashmap) throws Exception; // 재료비/경비 조회
	//List<?> selectSampleList1(SampleDefaultVO searchVO) throws Exception; // 재료비/경비 조회
	
	List<?> manpowerList(Map<String,String> hashmap) throws Exception; // 노무비 조회
	//List<?> manpowerList(SampleDefaultVO searchVO) throws Exception; // 노무비 조회
	
	List<?> inoutAnsisList(SampleDefaultVO searchVO) throws Exception;  //현황분석
	//List<?> selectNmbList1(SampleDefaultVO searchVO) throws Exception;
	List<?> selectNmbList1(Map<String,String> hashmap) throws Exception;

	

	/**
	 * 프로젝트 관리 프로그램 코드 모음
	 */

	void insertPrt(SampleVO vo) throws Exception;

	void updatePrt(SampleVO vo) throws Exception;

	void deletePrt(SampleVO vo) throws Exception;

	List<?> selectPrtList(SampleDefaultVO searchVO) throws Exception;

	/**
	 * 프로젝트 매입매출 관리 코드 모음
	 */

	List<?> selectPrtNameList(SampleDefaultVO searchVO) throws Exception;

	List<?> selectInoutList(SampleDefaultVO searchVO) throws Exception;

	List<?> selectInoutOne(SampleDefaultVO searchVO) throws Exception;

	void insertInout(SampleVO vo) throws Exception;

	void updateInout(SampleVO vo) throws Exception;

	void deleteInout(SampleVO vo) throws Exception;

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
	void insertSample(SampleVO vo) throws Exception;

	/**
	 * 글을 수정한다.
	 * 
	 * @param vo
	 *            - 수정할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	void updateSample(SampleVO vo) throws Exception;

	/**
	 * 글을 삭제한다.
	 * 
	 * @param vo
	 *            - 삭제할 정보가 담긴 SampleVO
	 * @return void형
	 * @exception Exception
	 */
	void deleteSample(SampleVO vo) throws Exception;

	/**
	 * 글을 조회한다.
	 * 
	 * @param vo
	 *            - 조회할 정보가 담긴 SampleVO
	 * @return 조회한 글
	 * @exception Exception
	 */
	SampleVO selectSample(SampleVO vo) throws Exception;

	/**
	 * 글 목록을 조회한다.
	 * 
	 * @param searchVO
	 *            - 조회할 정보가 담긴 VO
	 * @return 글 목록
	 * @exception Exception
	 */
	List<?> selectSampleList(SampleDefaultVO searchVO) throws Exception;

	/**
	 * 글 총 갯수를 조회한다. @param searchVO - 조회할 정보가 담긴 VO @return 글 총 갯수 @exception
	 */
	int selectSampleListTotCnt(SampleDefaultVO searchVO);

}
