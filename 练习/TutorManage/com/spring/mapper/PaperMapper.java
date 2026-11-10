package com.spring.mapper;

import java.util.List;
import java.util.Map;

public interface PaperMapper {
	
	/*	 
     *   <p>【显示论文题目状态为1信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    List<Map<String, Object>> showPaperTitle(Map<String, Object> param);
    /*	 
     *   <p>【显示论文题目信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    List<Map<String, Object>> showPaperTitleStudent(Map<String, Object> param);
	   /*   
     *   <p>【更新论文】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void updatePaperTitle(Map<String, Object> param);
    /*   
     *   <p>【修改学生自拟的论文题目】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void updatePaperSubmit(Map<String, Object> param);
   

    /*   
     *   <p>【新增论文】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    
    void addPaperTitle(Map<String, Object> param);
    /*   
     *   <p>【学生自拟题目并添加】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    
    void addPaperTitleByStu(Map<String, Object> param);
    /*   
     *   <p>【删除学生自拟的论文题目】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    
    void deletePaperByStu(Map<String, Object> param);
    /*   
     *   <p>【撤销提交教师发布的论文题目】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    
    void deletePaperByTea(Map<String, Object> param);
    /*   
     *   <p>【查询学生与论文题目】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    
    List<Map<String, Object>> showStudentAndTitle(Map<String, Object> param);
    /*   
     *   <p>【学生选择教师发布的题目】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    void submitPaperByTeaRelease(Map<String, Object> param);
    /*   
     *   <p>【更新题目状态】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void changeTitleState(Map<String, Object> param);
    
    /*   
     *   <p>【显示个人论文题目】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    Map<String, Object> showPaperTitleById(Map<String, Object> param);
    
    /*   
     *   <p>【根据论文题目显示论文相关信息】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    Map<String, Object> showPaperInfoByTitle(Map<String, Object> param);
    
    /*   
     *   <p>【查询sid是否存在】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     
    Map<String, Object> showSid(Map<String, Object> param);
    */
    /*   
     *   <p>【删除sid】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    void deleteSid(Map<String, Object> param);
    /*   
     *   <p>【根据paperid显示sid】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
   
    Map<String, Object> showSidByPaperId(Map<String, Object> param);
     */
    /*  
     *   <p>【校验题目是否存在】</p>
     *
     * @author  曾彬利 
     *
     * @param param
     * @return
     */
    int countPaper(Map<String, Object> param);
    /*  
     *   <p>【查询所有导师发布的论文题目信息】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    List<Map<String,Object>> selectTeaReleasePaper(Map<String, Object> param);
    /*  
     *   <p>【导师查询所有与自己相关的论文题目信息】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    List<Map<String,Object>> selectPaperTitleByTea(Map<String, Object> param);
    /*  
     *   <p>【导师删除发布的论文】</p>
     *
     * @author  崔玉龙
     *
     * @param param
     * @return
     */
    void tea_deletePaper(Map<String, Object> param);
    
}
